package coap.exam05.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.Request;

public class Coap2CoapClient {
  
  private CoapClient coapClient;
  
  public Coap2CoapClient() {
    coapClient = new CoapClient();
  }
  
  public String coap2coap() {
    // Proxy 접근 주소
    coapClient.setURI("coap://192.168.3.46/coap2coap");
    // Forward되는 리소스의 통신방법
    Request request = new Request(CoAP.Code.GET);
    // Forward되는 리소스의 URI
    request.getOptions().setProxyUri("coap://localhost/resource01");
    //request.getOptions().setProxyScheme(scheme);
    //통신
    CoapResponse response = coapClient.advanced(request);
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
    Coap2CoapClient client = new Coap2CoapClient();
    String text = client.coap2coap();
    System.out.println(text);
    client.shutDown();
  }
}