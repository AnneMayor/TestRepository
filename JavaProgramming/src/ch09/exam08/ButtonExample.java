package ch09.exam08;

import ch09.exam08.Button.OnClickListener;
public class ButtonExample {
	public static void main(String[] args) {
		Button button = new Button();
		button.setOnClickListner(new OnClickListener() {
			public void onClick() {
				System.out.println("������ �����մϴ�");
			}
		});
		button.touch();
	}
}