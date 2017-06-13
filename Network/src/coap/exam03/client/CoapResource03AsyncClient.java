package coap.exam03.client;

import java.io.IOException;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

public class CoapResource03AsyncClient {

  private CoapClient coapClient;

  public CoapResource03AsyncClient() {
    coapClient = new CoapClient();
//    coapClient.useCONs(); // default!(지금은 둘 중 아무거나 해도 문제가 없음.)
    coapClient.useNONs();
  }

  public void get(int angle) {
    // 여기에 들어가야할 정보: IP, 포트번호, 리소스 식별이름
    String queryString = "kind=ultrasonicsensor&angle=" + angle;
    coapClient.setURI("coap://192.168.3.46/resource02?" + queryString);
    // 비동기방식
    coapClient.get(new CoapHandler() {
      @Override
      public void onLoad(CoapResponse response) {
        if (response.getCode() == CoAP.ResponseCode.CONTENT) {
          String text = response.getResponseText();
          System.out.println(angle + "각도 거리:" + text);
        }
      }

      @Override
      public void onError() {
      }
    });
  }

  public void post(int angle) {
    // 여기에 들어가야할 정보: IP, 포트번호, 리소스 식별이름(queryString은 앞으로 안씀. Json형식으로 이제부터 쓴다!
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("kind", "ultrasonicsensor");
    jsonObject.put("angle", angle);
    String json = jsonObject.toString();
//    System.out.println(json);
//    String queryString = "kind=ultrasonicsensor&angle=" + angle;
    coapClient.setURI("coap://192.168.3.46/resource02");

    coapClient.post(new CoapHandler() {
      @Override
      public void onLoad(CoapResponse response) {
        if (response.getCode() == CoAP.ResponseCode.CONTENT) {
          String text = response.getResponseText();
          System.out.println(angle + "각도 거리:" + text);
        }
      }

      @Override
      public void onError() {
      }
    }, json, MediaTypeRegistry.APPLICATION_JSON);
  }

  public void shutDown() {
    coapClient.shutdown();
  }

  public static void main(String... args) throws IOException, InterruptedException {
    CoapResource03AsyncClient client = new CoapResource03AsyncClient();
    for (int i = 0; i <= 180; i += 10) {
      client.post(i);
      Thread.sleep(1000);
    }
    System.in.read();
    client.shutDown();
  }
}