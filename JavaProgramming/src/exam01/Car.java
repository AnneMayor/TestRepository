package exam01;

public class Car {
	// Field(대부분 영어 소문자로 시작)
	String company;// 필드에선 값을 할당해주지 않아도 문제 없음.값을 줄 필요는 없으나 디폴트 값이 있다면 할당.
	int speed;
	String color;// 특정 값을 할당하면 기본적으로 객체 생성할 때 필요한 데이터값이라고 보면 됨.
	boolean airbag;

	// Constructor
	Car() { //()안에는 외부 필드값을 입력받아 객체를 생성하려는 목적으로 생성.
		// ...
		/*
		 * 자동차를 비유로 들면, 옵션을 여기에다 입력해서 나만의 커스터마이징한 자동차를 만드는 역할을 함.
		 * 여긴 객체를 만들 때 객체를 어떻게 만들어야 한다는 내용이 들어감. 
		 * 이게 없으면 객체 생성이 아예 불가능.
		 * 컴파일러가 클래스에 생성자 넣어주지 않으면 자동으로 만들어줌.
		 * 컴파일러에 의해 생성되는 생성자 = 기본생성자
		 */
		System.out.println("Car 객체 생성");
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
