package mqtt.exam02;

import java.util.Scanner;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Device1Example {

  public static void main(String[] args) throws MqttException {
    Device device = new Device("device1");
    device.subscribe();

    Scanner sc = new Scanner(System.in, "UTF-8");
    while (true) {
      System.out.print("input message or q(quit): ");
      String text = sc.nextLine();
      if (text.equals("q")) {
        break;
      } else {
        device.publish("device2", text);
      }
    }
    device.close();
  }
}
