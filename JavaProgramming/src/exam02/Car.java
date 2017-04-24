package exam02;

public class Car {
	// Field(대부분 영어 소문자로 시작)
	String company;// 필드에선 값을 할당해주지 않아도 문제 없음.값을 줄 필요는 없으나 디폴트 값이 있다면 할당.
	int speed;
	String color;// 특정 값을 할당하면 기본적으로 객체 생성할 때 필요한 데이터값이라고 보면 됨.
	boolean airbag;

	// Constructor
	Car() {
		this("Hyundae", null, false); //나의 생성자, 나의 또다른 생성자를 호출해달라!
	}
	
	Car(String color, boolean airbag) {
		this("Hyundae", color, airbag);//중복코드 제거
	}
	//생성자 오버로딩: 클래스 안에 생성자를 여러 개 선언.
	//오버라이딩은 상속과 연관

	Car(String company, String color, boolean airbag) {
		this.company = company;
		this.color = color;
		this.airbag = airbag;
	}
	// Method
	void run() {
		System.out.println("현재 " + speed + "km/h로 주행");
	}

	void stop() {
		System.out.println("정지");
		speed = 0;
	}
}
