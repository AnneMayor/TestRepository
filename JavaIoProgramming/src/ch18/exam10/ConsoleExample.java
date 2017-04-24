// 콘솔창에 문자열 입력하는 방법
package ch18.exam10;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleExample {

    public static void main(String... args) throws IOException {

        //how1 -> 요건 응용할 곳이 많으니 잘 알아두자!
        InputStream is = System.in;
        // int keycode = is.read(); -> 한번에 하나밖에 읽지 못하므로 이렇게 코딩하면 컴파일 에러
        byte[] keycodes = new byte[100];
        int readBytes = is.read(keycodes);
        System.out.println(Arrays.toString(keycodes));
        String str = new String(keycodes, 0, readBytes - 2);
        System.out.println(str);
        
        //how2 -> 사실 이걸 제일 많이 사용할 것이다...ㅎㅎㅎ
        Scanner scanner = new Scanner(System.in);
        String str2 = scanner.nextLine();
        System.out.println(str2);
        
        //how3
        Console console = System.console();
        String str3 = console.readLine();
        System.out.println(str3);
    }
}