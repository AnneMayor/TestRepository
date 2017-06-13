package coap.exam04.client;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

public class CoapResource04SendDataClient {

  private CoapClient coapClient;

  public CoapResource04SendDataClient() {
    coapClient = new CoapClient();
  }

  public void post() throws InterruptedException {
    coapClient.setURI("coap://192.168.3.46/resource04");
    Random random = new Random();
    while (true) {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("value", random.nextInt(50));
      String json = jsonObject.toString();
      coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
      Thread.sleep(1000);
    }
  }

  public void shutDown() {
    coapClient.shutdown();
  }

  public static void main(String... args) throws Exception {
    CoapResource04SendDataClient client = new CoapResource04SendDataClient();
    client.post();
    client.shutDown();
  }
}
