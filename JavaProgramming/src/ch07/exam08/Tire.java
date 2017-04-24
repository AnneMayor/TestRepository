package ch07.exam08;

public abstract class Tire {
	Tire tire;
	
	int diameter;
	
	
	Tire() {
		System.out.println("Tire 객체 생성");
	}
	
	abstract void roll();
	
	/*
	void roll() { 여기를 body라고 한다.
		// 이 메소드는 실행 내용이 있는 것으로 완전한 클래스임.
		// 재정의 안해도 컴파일 에러 발생X.
	}
	*/
	
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
	public int getDiameter() {
		return diameter;
	}
}
