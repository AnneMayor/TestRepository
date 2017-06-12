package coap.exam02.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

public class CoapResource02Client {

  private CoapClient coapClient;

  public CoapResource02Client() {
    coapClient = new CoapClient();
    coapClient.useNONs();
  }

  public String get(int angle) {
    // 여기에 들어가야할 정보: IP, 포트번호, 리소스 식별이름
    String queryString = "kind=ultrasonicsensor&angle=" + angle;
    coapClient.setURI("coap://192.168.3.46/resource02?" + queryString);
    // 동기방식(server-client)
    CoapResponse response = coapClient.get();
    // payload가 실려있는 응답일 경우(정상적으로 연결된 경우)
    if (response == null) {
      return get(angle);
    } else {
      if (response.getCode() == CoAP.ResponseCode.CONTENT) {
        return response.getResponseText();
      } else {
        return get(angle);
      }
    }
  }

  public String post(int angle) {
    // 여기에 들어가야할 정보: IP, 포트번호, 리소스 식별이름(queryString은 앞으로 안씀. Json형식으로 이제부터 쓴다!
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("kind", "ultrasonicsensor");
    jsonObject.put("angle", angle);
    String json = jsonObject.toString();
//    System.out.println(json);
//    String queryString = "kind=ultrasonicsensor&angle=" + angle;
    coapClient.setURI("coap://192.168.3.46/resource02");
    // 동기방식(server-client)
    CoapResponse response = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
    // payload가 실려있는 응답일 경우(정상적으로 연결된 경우)
    if (response == null) {
      return get(angle);
    } else {
      if (response.getCode() == CoAP.ResponseCode.CONTENT) {
        return response.getResponseText();
      } else {
        return get(angle);
      }
    }
  }

  public void shutDown() {
    coapClient.shutdown();
  }

  public static void main(String... args) {
    CoapResource02Client client = new CoapResource02Client();
    for (int i = 0; i <= 140; i += 10) {
      String text = client.post(i);
      System.out.println("거리: " + text);
    }
    client.shutDown();
  }
}
