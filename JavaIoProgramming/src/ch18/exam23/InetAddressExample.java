package ch18.exam23;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String...args) throws UnknownHostException {
        InetAddress ia = InetAddress.getLocalHost();
        String address = ia.getHostAddress();
        System.out.println(address);
        
        InetAddress iaNaver = InetAddress.getByName("www.naver.com");
        String addressNaver = iaNaver.getHostAddress();
        System.out.println(addressNaver);
        System.out.println("--------------------------------------------------------------------------------------------");
        InetAddress[] iaNaverAll = InetAddress.getAllByName("KOSA-L3-17");
        System.out.println(iaNaverAll.length);
        for(InetAddress i : iaNaverAll) {
            System.out.println(i.getHostAddress());
        }
    }
}
