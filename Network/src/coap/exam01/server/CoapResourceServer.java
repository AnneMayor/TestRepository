package coap.exam01.server;

import org.eclipse.californium.core.CoapServer;

public class CoapResourceServer {
  private CoapServer coapServer;
  // 포트번호를 준다면 기본포트번호를 바꾸는 코드(다시 한번 말하지만 이건 안주는게 좋다. 그래야 개방형 장치가 됨. 폐쇄형 장치는 ㄴㄴ)
  public CoapResourceServer() {
    coapServer = new CoapServer();
    coapServer.add(new CoapResource01());
    // 서버 시작
    coapServer.start();
  }
  
  // 서버 중지 및 완전삭제
  public void shutDown() {
    coapServer.stop();
    coapServer.destroy();
  }
  
  public static void main(String...args) {
    CoapResourceServer server = new CoapResourceServer();
    // CoAP server의 기본포트: 5683(이걸 바꾸면 서버에 연결되는 장치마다 포트번호를 바꿔줘야한다.)
    System.out.println("CoAP server is listening on port 5683");
  }
}
