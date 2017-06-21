package sensingcar;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sensingcar.coap.server.CoapResourceServer;

public class SensingCar {

  private static final Logger LOGGER = LoggerFactory.getLogger(SensingCar.class);
  private CoapResourceServer coapResourceServer;
  
  
  public SensingCar() throws Exception {
    coapResourceServer = new CoapResourceServer();
  }
  public void start() {
    LOGGER.info("execution");
    coapResourceServer.start();
    System.out.println("SensingCar start...");
  }

  public void stop() {
    LOGGER.info("execution");
    coapResourceServer.stop();
    System.out.println("SensingCar stop...");
  }

  public static void main(String[] args) throws Exception {

    SensingCar sensingCar = new SensingCar();
    sensingCar.start();
    System.out.print("input command('q' to quit): ");
    Scanner sc = new Scanner(System.in);
    String command = sc.nextLine();
    if (command.equals("q")) {
      sensingCar.stop();
    }
  }
}