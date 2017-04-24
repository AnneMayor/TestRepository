package ch11.exam15;

import java.util.Arrays;
import java.util.Collections;

public class SortExample {

	public static void main(String[] args) {
		String[] name = { "ȫ�浿", "�ڹμ�", "Dahye" };

		// ������������ ����
		// sort() �޼ҵ�� compareTo() �޼ҵ� ���ϰ��� �������� ������.
		Arrays.sort(name);
		System.out.println(Arrays.toString(name));

		// ������������ ����
		Arrays.sort(name, Collections.reverseOrder());
		System.out.println(Arrays.toString(name));

		Member[] members = { new Member("ȫ�浿", 15), new Member("�ڹμ�", 18), new Member("Dahye", 20) };
		// Comparable com = new Member("ȫ�浿"); -> member�� ����ϰų� �����ؾ���.

		Arrays.sort(members);
		System.out.println(Arrays.toString(members));

		Arrays.sort(members, Collections.reverseOrder());
		System.out.println(Arrays.toString(members));
	}
}