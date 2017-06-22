package sensingcar.coap.server;

import java.net.InetSocketAddress;
import java.util.logging.Level;
import org.eclipse.californium.core.CaliforniumLogger;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.scandium.ScandiumLogger;
import org.slf4j.Logger;
import sensingcar.coap.server.resource.BackTireResource;
import sensingcar.coap.server.resource.BuzzerResource;
import sensingcar.coap.server.resource.CameraResource;
import sensingcar.coap.server.resource.FrontTireResource;
import sensingcar.coap.server.resource.GasSensorResource;
import sensingcar.coap.server.resource.LaserEmitterResource;
import sensingcar.coap.server.resource.LcdResource;
import sensingcar.coap.server.resource.PhotoResistorSensorResource;
import sensingcar.coap.server.resource.RGBLedResource;
import sensingcar.coap.server.resource.ThermistorSensorResource;
import sensingcar.coap.server.resource.TrackingSensorResource;
import sensingcar.coap.server.resource.UltrasonicSensorResource;

public class CoapResourceServer {

  private CoapServer coapServer;

  private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CoapResourceServer.class);

  //static block(califonium의 자체 로그 출력 금지)
  static {
    CaliforniumLogger.initialize();
    CaliforniumLogger.setLevel(Level.OFF);
    ScandiumLogger.initialize();
    ScandiumLogger.setLevel(Level.OFF);
  }

  public CoapResourceServer() throws Exception {
    coapServer = new CoapServer();
    InetSocketAddress isk1 = new InetSocketAddress("192.168.3.46", 5683);
    InetSocketAddress isk2 = new InetSocketAddress("localhost", 5683);
    coapServer.addEndpoint(new CoapEndpoint(isk1));
    coapServer.addEndpoint(new CoapEndpoint(isk2));
    coapServer.add(new BackTireResource());
    coapServer.add(new FrontTireResource());
    coapServer.add(new BuzzerResource());
    coapServer.add(new LaserEmitterResource());
    coapServer.add(new CameraResource());
    coapServer.add(new RGBLedResource());
    coapServer.add(new LcdResource());
    coapServer.add(new UltrasonicSensorResource());
    coapServer.add(new ThermistorSensorResource());
    coapServer.add(new PhotoResistorSensorResource());
    coapServer.add(new TrackingSensorResource());
    coapServer.add(new GasSensorResource());
  }

  public void start() {
    coapServer.start();
  }

  public void stop() {
    coapServer.stop();
    coapServer.destroy();
  }
}