package coap.sensingcar.client;

import java.io.IOException;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;

public class CoapResource06Client {

  private CoapClient client;
  private CoapObserveRelation coapObserveRelation;

  public CoapResource06Client() {
    client = new CoapClient();
  }

  public void observe() {
    client.setURI("coap://192.168.3.46/resource06");
    coapObserveRelation = client.observe(new CoapHandler() {
      @Override
      public void onLoad(CoapResponse response) {
          String text = response.getResponseText();
          System.out.println(text);
      }

      @Override
      public void onError() {
      }
    });
  }

  public static void main(String... args) throws IOException {
    CoapResource06Client client = new CoapResource06Client();
    client.observe();
    System.in.read();
  }
}
