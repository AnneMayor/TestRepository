package exam01;

public class CarExample {

	public static void main(String[] args) {
		//객체 생성 코드
		Car c1 = new Car();//new 다음엔 생성자가 옴. 이 생성자를 사용하기 위해서 위치정보를 할당해주었음.
		
		//객체 메소드 호출
		c1.run();
		
		//객체 필드값 읽기
		System.out.println(c1.company);//객체 필드로 접근하는 방법
		System.out.println(c1.speed);//값을 대입하지 않아도 이미 객체에서 변수는 메모리에 생성되어있음.
		//객체가 생성되면서 자동으로 필드가 생성.이것이 변수와 다른 점.
		System.out.println(c1.color);
		System.out.println(c1.airbag); //배열은 객체!
		
		c1.speed = 100;//변수를 먼저 선언해주어야 그 뒤 코드에 변환값 적용됨.
		c1.run();
		c1.color ="White";
		System.out.println(c1.color);
		
		/*----------------------------------------------------------------------------------------------------------*/
		
		Car c2 = new Car();
		System.out.println(c2.company);
		System.out.println(c2.speed);
		System.out.println(c2.color);
		System.out.println(c2.airbag);
		//객체가 다르면 데이터가 다르게 저장됨. 설계도인 클래스 초기값이 여기선 출력된다.
	}

}
