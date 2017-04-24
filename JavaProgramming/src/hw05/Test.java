package hw05;

import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		String name = "ÀÌ´ÙÇý Â¯";
		name.trim();
		StringTokenizer strtoken = new StringTokenizer(name, " ");
		String result = strtoken.nextToken();
		System.out.println(result);
	}

}
