package ch08.exam01;

// 상수에 static final, 메소드에 public static 이런거 붙이면...혼난다...알았제?굳이 붙힌다면 public정도!근데 이렇게 하니까 에러가...?Why?
public interface Manual {
	// Field
	public String COMPANY = "삼성전자";
	public int MAX_SPEED = 150;
	public int MIN_SPEED = 0;
	
	//Method
	void turnOn(); //Body없다...
	void turnOff();
	void setSpeed(int speed);
	int getSpeed();
	void run();	
}
