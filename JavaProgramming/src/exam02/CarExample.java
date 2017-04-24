package exam02;

public class CarExample {

	public static void main(String[] args) {
		//객체 생성 코드
		Car c1 = new Car();//new 다음엔 생성자가 옴. 이 생성자를 사용하기 위해서 위치정보를 할당해주었음.	
		//객체 필드값 읽기
		System.out.println(c1.company);//객체 필드로 접근하는 방법
		System.out.println(c1.speed);//값을 대입하지 않아도 이미 객체에서 변수는 메모리에 생성되어있음.
		//객체가 생성되면서 자동으로 필드가 생성.이것이 변수와 다른 점.
		System.out.println(c1.color);
		System.out.println(c1.airbag); //배열은 객체!
		
		Car c2 = new Car("White", true);
		System.out.println(c2.company);//객체 필드로 접근하는 방법
		System.out.println(c2.speed);//값을 대입하지 않아도 이미 객체에서 변수는 메모리에 생성되어있음.
		//객체가 생성되면서 자동으로 필드가 생성.이것이 변수와 다른 점.
		System.out.println(c2.color);
		System.out.println(c2.airbag); //배열은 객체!
		
		c2 = new Car("Blue", false);
	}

}
