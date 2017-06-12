package coap.exam01.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;

public class CoapResource01Client {
  private CoapClient coapClient;
  
  public CoapResource01Client() {
    coapClient = new CoapClient();
  }
  
  public String get() {
    // 여기에 들어가야할 정보: IP, 포트번호, 리소스 식별이름
    coapClient.setURI("coap://192.168.3.46/resource01");
    // 동기방식(server-client)
    CoapResponse response = coapClient.get();
    // payload가 실려있는 응답일 경우(정상적으로 연결된 경우)
    if(response.getCode() == CoAP.ResponseCode.CONTENT) {
      return response.getResponseText();
    } else {
      return null;
    }
  }
  
  public void shutDown() {
    coapClient.shutdown();
  }
  
  public static void main(String...args) {
    CoapResource01Client client = new CoapResource01Client();
    String text = client.get();
    System.out.println(text);
    client.shutDown();
  }
}