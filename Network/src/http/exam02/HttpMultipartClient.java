package http.exam02;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

public class HttpMultipartClient {

  public static void main(String... args) throws IOException {
    String title = "title";
    StringBody titleBody = new StringBody(title, ContentType.create("text/plain", Charset.forName("UTF-8")));

    String content = "content";
    StringBody contentBody = new StringBody(content, ContentType.create("text/plain", Charset.forName("UTF-8")));

    File attach = new File("C:/Temp/사막.jpg");
    FileBody attachBody = new FileBody(attach, ContentType.create("image/jpeg"));

    HttpPost httpPost = new HttpPost("http://192.168.3.128:8080/IoTWebProgramming/http/exam02");

    MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
    // 문자 파트
    multipartEntityBuilder.addPart("title", titleBody);
    multipartEntityBuilder.addPart("content", contentBody);
    // 파일 파트
    multipartEntityBuilder.setCharset(Charset.forName("UTF-8")); // 파일 이름이 한글이 포함되어 있을 경우
    multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE); // 브라우저가 파일을 보내는 방식과 동일하게 함.
    multipartEntityBuilder.addPart("attach", attachBody);
    // 멀티파트 인코딩된 본문 얻기
    HttpEntity reqEntity = multipartEntityBuilder.build();
    httpPost.setEntity(reqEntity);
    CloseableHttpClient httpClient = HttpClients.createDefault();
    try {
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
            String restitle = jsonObject.getString("title");
            String rescontent = jsonObject.getString("content");
            String originalfilename = jsonObject.getString("originalfilename");
            String savedfilename = jsonObject.getString("savedfilename");
            String filecontent = jsonObject.getString("filecontent");
            System.out.println("resTitle: " + restitle);
            System.out.println("resContent: " + rescontent);
            System.out.println("originalfilename: " + originalfilename);
            System.out.println("savedfilename: " + savedfilename);
            System.out.println("filecontent: " + filecontent);
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