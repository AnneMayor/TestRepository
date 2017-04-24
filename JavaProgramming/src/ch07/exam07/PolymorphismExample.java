package ch07.exam07;

public class PolymorphismExample {

	public static void main(String[] args) {
		Tire tire1 = new Tire();
		NormalTire tire2 = new NormalTire();
		SnowTire tire3 = new SnowTire();
		
		
		
		// 매개변수 자동 형변환
		run(tire2);
		run(tire3); 
	
	}
	
	// Static 타입 명심. Main이 static이니 이걸 절대 잊지말자.
	static void run(Tire tire) {
		tire.roll();
	}
}
