package ch11.exam11;

public class StringSplitExample {

	public static void main(String[] args) {
		String text = "È«±æµ¿&ÀÌ¼öÈ«, ¹Ú¿¬¼ö, ±èÀÚ¹Ù-Dahye Anne Lee";
		
		String[] names = text.split("&|,|-");
		
		for(String name : names) {
			System.out.println(name);
		}
	}

}
