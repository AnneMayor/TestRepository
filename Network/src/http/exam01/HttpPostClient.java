package http.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class HttpPostClient {

  public static void main(String... args) throws IOException {
    // 3.5 version과 4.0 version이 다름. 3.5 version에선 HttpClient 이렇게 사용함.
    // 여기서 비동기는 없고 Thread 써서 비동기처럼 쓰기
    CloseableHttpClient httpClient = HttpClients.createDefault();
    try {
      HttpPost httpPost = new HttpPost("http://192.168.3.128:8080/IoTWebProgramming/http/exam01");

      List<NameValuePair> params = new ArrayList<>();
      params.add(new BasicNameValuePair("thermistor", String.valueOf(25)));
      params.add(new BasicNameValuePair("photoResistor", String.valueOf(200)));
      HttpEntity reqEntity = new UrlEncodedFormEntity(params, Charset.forName("UTF-8"));
      httpPost.setEntity(reqEntity);

      CloseableHttpResponse response = httpClient.execute(httpPost);

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
            System.out.println("thermistor: " + thermistor);
            System.out.println("photoResistor: " + photoResistor);
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
