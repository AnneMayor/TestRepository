package ch11.exam14;

import java.util.Arrays;
import java.util.Collections;

public class SortExample {

	public static void main(String[] args) {
		String[] name = { "ȫ�浿", "�ڹμ�", "Dahye" };
		
		// ������������ ����
		Arrays.sort(name);
		System.out.println(Arrays.toString(name));
		
		// ������������ ����
		Arrays.sort(name, Collections.reverseOrder());
		System.out.println(Arrays.toString(name));
	}
}