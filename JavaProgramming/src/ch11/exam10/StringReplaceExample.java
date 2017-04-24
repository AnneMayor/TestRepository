package ch11.exam10;

public class StringReplaceExample {

	public static void main(String[] args) {
		String oldStr = "Java is Object Oriented. It contains lots of API";
		String newStr = oldStr.replace("Java", "ÀÚ¹Ù");
		System.out.println(oldStr);
		System.out.println(newStr);
	}
}