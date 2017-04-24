package ch11.exam11;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("hong, kim, lee, woo", ",");
		int countTokens = st.countTokens();
		for(int i = 1; i <= countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		System.out.println();
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken(",");
			System.out.println(token);
		}
		
	}

}
