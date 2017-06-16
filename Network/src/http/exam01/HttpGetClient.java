package http.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

public class HttpGetClient {

  public static void main(String... args) throws IOException {
    // 3.5 version과 4.0 version이 다름. 3.5 version에선 HttpClient 이렇게 사용함.
    CloseableHttpClient httpClient = HttpClients.createDefault();
    try {
      URIBuilder uriBuilder = new URIBuilder("http://192.168.3.128:8080/IoTWebProgramming/http/exam01");
      uriBuilder.setParameter("thermistor", String.valueOf(25));
      uriBuilder.setParameter("photoResistor", String.valueOf(200));
      
      // 이건 GET방식일 때 가능. 만약 POST방식이라고 한다면 HttpPost이렇게 써줘야 함.
      HttpGet httpGet = new HttpGet(uriBuilder.build());
      // 응답이 올 때까지 대기함. 이건 동기방식.(http 시작행, 헤더행, 본문행 요렇게 존재)
      CloseableHttpResponse response = httpClient.execute(httpGet);
      
      try {

        HttpEntity resEntity = response.getEntity();

        // body 안에 내용이 있냐없냐 검사.
        if (resEntity != null) {
          InputStream is = resEntity.getContent();
          try {
            // 바이트 단위로 읽는 것보다 String 단위로 읽기 위해서 Reader를 써줌.
            InputStreamReader isr = new InputStreamReader(is);
            // 속도도 빠르고 한 행씩 읽을 수 있기에 BufferedReader 써줌.
            BufferedReader br = new BufferedReader(isr);
            String json = "";
            while (true) {
              String data = br.readLine();
              if (data == null) {
                break;
              }
              json += data;
            }
            // json파일 파싱을 위해 이렇게 써줌.
            JSONObject jsonObject = new JSONObject(json);
            double thermistor = jsonObject.getDouble("thermistor");
            double photoResistor = jsonObject.getDouble("photoResistor");
            System.out.println("thermistor" + thermistor);
            System.out.println("photoResistor" + photoResistor);
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            is.close();
          }
        }
      } finally {
        response.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      httpClient.close();
    }
  }
}