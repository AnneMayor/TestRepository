package coap.sensingcar.server;

import coap.exam04.server.*;
import coap.exam02.server.*;
import coap.exam01.server.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;

public class CoapResourceServer {
  private CoapServer coapServer;
  // 포트번호를 준다면 기본포트번호를 바꾸는 코드(다시 한번 말하지만 이건 안주는게 좋다. 그래야 개방형 장치가 됨. 폐쇄형 장치는 ㄴㄴ)
  public CoapResourceServer() throws Exception {
    coapServer = new CoapServer();
    // server IP는 라즈베리 이외에 현재 안테나도 있기에 inet코드 없으면 무작위로 둘 중 아무거나 연결된다.
    InetSocketAddress isk = new InetSocketAddress("192.168.3.46", 5683);
    coapServer.addEndpoint(new CoapEndpoint(isk));
    coapServer.add(new CoapResource01());
    coapServer.add(new CoapResource02());
    coapServer.add(new CoapResource03());
    coapServer.add(new CoapResource04());
    coapServer.add(new CoapResource05());
    coapServer.add(new CoapResource06());
    // 서버 시작
    coapServer.start();
  }
  
  // 서버 중지 및 완전삭제
  public void shutDown() {
    coapServer.stop();
    coapServer.destroy();
  }
  
  public static void main(String...args) throws IOException, Exception {
    CoapResourceServer server = new CoapResourceServer();
    // CoAP server의 기본포트: 5683(이걸 바꾸면 서버에 연결되는 장치마다 포트번호를 바꿔줘야한다.)
    System.out.println("CoAP server is listening on port 5683");
    System.in.read();
    server.shutDown();
  }
}