package ch11.exam10;

public class StringIndexOfExample {

	public static void main(String[] args) {
		String subject = "C++";
		
		
		String search = "";
		if(!search.equals("")) {
			int location = subject.indexOf(search);
			System.out.println(location);
		}
		
		if(subject.contains("C++")) {
			System.out.println("You shoud change your class");
		}
		
		int location = subject.indexOf("Java");
		System.out.println(location);
		
		if(location != 0) {
			System.out.println("This is not a Java programming class");
		} else {
			System.out.println("This is a Java Programming class");
		}
	}
}