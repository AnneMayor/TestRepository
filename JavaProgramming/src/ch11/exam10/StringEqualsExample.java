package ch11.exam10;

public class StringEqualsExample {

	public static void main(String[] args) {
		String name1 = new String("Dahye Lee");
		String name2 = new String("Dahye Lee");
		
		if(name1 == name2) {
			System.out.println("같은 객체입니다.");
		} else {
			System.out.println("다른 객체입니다.");
		}
		
		if(name1.equals(name2)) {
			System.out.println("같은 내용입니다.");
		} else {
			System.out.println("다른 내용입니다.");
		}
	}
}