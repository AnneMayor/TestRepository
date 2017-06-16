package mqtt.exam01;

import java.util.Date;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttPublisher {

  private MqttClient mqttClient;
  private MqttCallback mqttCallback = new MqttCallback() {
    @Override
    public void connectionLost(Throwable thrwbl) {
    }
    

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
    }
    // 현재 이 익명객체가 만들어진 클래스가 publisher이기에 아래 메소드만 실행됨. 
    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
      System.out.println("deliveryComplete: " + new Date());
    }
  
  };

  public MqttPublisher() throws MqttException {
    // Mqtt Client 생성
    mqttClient = new MqttClient("tcp://192.168.3.128:1883", MqttClient.generateClientId());
    // 통신 결과에 따라 실행할 콜백 객체 생성
    mqttClient.setCallback(mqttCallback);
    // MQTT 브로커와 연결하기
    mqttClient.connect();
  }

  public void publish(String text) throws MqttException {
    // MQTT 브로커로 보내는 메시지 생성
    MqttMessage message = new MqttMessage(text.getBytes());
    // MQTT 브로커로 메시지 보내기(토픽은 없으면 자동으로 생성됨.)
    mqttClient.publish("/devices/device1/temperature", message);
  }
  
  public void shudDown() throws MqttException {
    // MQTT 브로커와 연결 해제
    mqttClient.disconnect();
    // MQTT 클라이언트가 사용한 리소스(메모리 등) 해제        
    mqttClient.close();
  }
  public static void main(String... args) throws Exception {
    MqttPublisher publisher = new MqttPublisher();
    // 매 1초 단위로 온도 메시지를 보냄
    for(int i = 1; i <= 5; i++) {
      publisher.publish("Temperature: " + i);
      Thread.sleep(1000);
    }
    // MQTT 클라이언트 종료
    publisher.shudDown();
  }
}
