package ch08.exam01;

// ����� static final, �޼ҵ忡 public static �̷��� ���̸�...ȥ����...�˾���?���� �����ٸ� public����!�ٵ� �̷��� �ϴϱ� ������...?Why?
public interface Manual {
	// Field
	public String COMPANY = "�Ｚ����";
	public int MAX_SPEED = 150;
	public int MIN_SPEED = 0;
	
	//Method
	void turnOn(); //Body����...
	void turnOff();
	void setSpeed(int speed);
	int getSpeed();
	void run();	
}
