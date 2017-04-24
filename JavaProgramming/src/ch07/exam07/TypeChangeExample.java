package ch07.exam07;

public class TypeChangeExample {

	public static void main(String[] args) {
		Tire tire1 = new Tire();
		NormalTire tire2 = new NormalTire();
		SnowTire tire3 = new SnowTire();
		
		// 자동타입변환
		tire1 = tire2; 
		tire1 = tire3;
		
		// 강제타입변환
		tire2 = (NormalTire) tire1;
		tire3 = (SnowTire) tire1;
	}
	
	// Static 타입 명심. Main이 static이니 이걸 절대 잊지말자.
	static void run(Tire tire) {
		
	}
}
