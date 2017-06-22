package sensingcar.coap.server.resource;

import hardware.lcd.LCD1602;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LcdResource extends CoapResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(LcdResource.class);
  private LCD1602 lcd;
  private String currLine0;
  private String currLine1;

  public LcdResource() throws Exception {
    super("lcd");
    lcd = new LCD1602(0x27);
    setText("RPi-13-02", getIPaddress());
  }

  private void setText(String line1, String line2) {
    lcd.clear();
    lcd.write(0, 0, line1);
    lcd.write(1, 0, line2);
    currLine0 = line1;
    currLine1 = line2;
  }

  public String getIPaddress() throws Exception {
    String wlan0 = "";
    Enumeration<NetworkInterface> niEnum = NetworkInterface.getNetworkInterfaces();
    while (niEnum.hasMoreElements()) {
      NetworkInterface ni = niEnum.nextElement();
      String displayName = ni.getDisplayName();
      if (displayName.equals("wlan0")) {
        Enumeration<InetAddress> iaEnum = ni.getInetAddresses();
        while (iaEnum.hasMoreElements()) {
          InetAddress ia = iaEnum.nextElement();
          if (ia instanceof Inet4Address) {
            wlan0 = ia.getHostAddress();
          }
        }
      }
    }
    return wlan0;
  }

  @Override
  public void handleGET(CoapExchange exchange) {

  }

  @Override
  public void handlePOST(CoapExchange exchange) {
    // { "command":"change", "line0":"xxx", "line1":"xxx" }
    // {"command":"status"}
    try {
      String reqJson = exchange.getRequestText();
      JSONObject reqJsonObject = new JSONObject(reqJson);
      String command = reqJsonObject.getString("command");
      if (command.equals("change")) {
        String line0 = reqJsonObject.getString("line0");
        String line1 = reqJsonObject.getString("line1");
        setText(line0, line1);
      } else if (command.equals("status")) {

      }
      JSONObject rsjsonObject = new JSONObject();
      rsjsonObject.put("result", "success");
      rsjsonObject.put("line0", currLine0);
      rsjsonObject.put("line1", currLine1);
      String rsjson = rsjsonObject.toString();
      exchange.respond(rsjson);
    } catch (Exception e) {
      LOGGER.info(e.toString());
      JSONObject rsjsonObject = new JSONObject();
      rsjsonObject.put("result", "fail");
      String rsjson = rsjsonObject.toString();
      exchange.respond(rsjson);
    }
  }
}