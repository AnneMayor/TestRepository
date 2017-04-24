package exam04;

public class CarExample {

	public static void main(String[] args) {
		Car c1 = new Car("2017-08-12", "Gray");
		
		c1.engine.start();
		c1.engine.stop();
		//Dashboard의 메소드 호출
		c1.dashboard.display(60);
		//Tire의 필드값 읽기
		System.out.println(c1.tires[0].direction);
		//Tire의 메소드 호출
		c1.tires[2].roll();
		//Car의 메소드 호출
		c1.start();
		
		//------------------------------------------------------------------------------------------------------------
		//Tire 부품 교체 -> 객체 지향 프로그래밍은 중간에 값을 교체할 수 있음. 그게 장점.
		c1.tires[1] = new Tire("새 앞뒤 타이어");//이건 좀 괜찮은 소스군...잘 알아두자!
		c1.run();
		
		
		
	}

}
