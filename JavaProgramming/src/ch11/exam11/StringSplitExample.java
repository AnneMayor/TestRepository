package ch11.exam11;

public class StringSplitExample {

	public static void main(String[] args) {
		String text = "ȫ�浿&�̼�ȫ, �ڿ���, ���ڹ�-Dahye Anne Lee";
		
		String[] names = text.split("&|,|-");
		
		for(String name : names) {
			System.out.println(name);
		}
	}

}