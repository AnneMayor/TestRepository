package mqtt.exam01;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttSubscriber {

  private MqttClient mqttClient;
  private MqttCallback mqttCallback = new MqttCallback() {
    @Override
    public void connectionLost(Throwable thrwbl) {
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
      String text = new String(mm.getPayload());
      System.out.println("messageArrived:" + text);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
    }

  };

  public MqttSubscriber() throws MqttException {
    // Mqtt Client 생성(여기서 실제로 tcp 연결도 된 상태임)
    mqttClient = new MqttClient("tcp://192.168.3.11:1883", MqttClient.generateClientId());
    // 통신 결과에 따라 실행할 콜백 객체 생성
    mqttClient.setCallback(mqttCallback);
    mqttClient.connect();
  }

  public void subscribe() throws MqttException {
    // 지정한 토픽의 구독자로 신청
    mqttClient.subscribe("/devices/device1/temperature");
  }

  public void shudDown() throws MqttException {
    // MQTT 브로커와 연결 해제
    mqttClient.disconnect();
    // MQTT 클라이언트가 사용한 리소스(메모리 등) 해제        
    mqttClient.close();
  }

  public static void main(String... args) throws Exception {
    
    MqttSubscriber subscriber = new MqttSubscriber();
    // 구독자로 신청
    subscriber.subscribe();
    System.out.println("Start subscriber...");

    // 프로그램이 종료되지않게 멈춤
    System.out.println("Press any key to quit...");
    System.in.read();

    // 클라이언트 종료
    subscriber.shudDown();

  }
}