package coap.exam04.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;

public class CoapResource03Client {

  private CoapClient coapClient;
  private CoapObserveRelation coapObserveRelation;

  public CoapResource03Client() {
    coapClient = new CoapClient();
  }

  public void observe() {
    coapClient.setURI("coap://192.168.3.46/resource03");
    coapObserveRelation = coapClient.observe(new CoapHandler() {
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

  public void shutDown() {
    coapObserveRelation.proactiveCancel();
    coapClient.shutdown();
  }

  public static void main(String... args) throws Exception {
    CoapResource03Client client = new CoapResource03Client();
    client.observe();
    System.in.read();
  }
}
