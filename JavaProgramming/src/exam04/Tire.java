package exam04;

public class Tire {
	//Field
	String direction;
	
	//Constructor
	Tire(String direction) {
		this.direction = direction;
	}
	//여기서 컴파일러는 우리가 하나라도 생성자  만들어내면 자동으로 기본생성자 만들어주지 않음.
	
	//Method
	void roll() {
		System.out.println(direction + "바퀴가 돌아감");	
	}
}
