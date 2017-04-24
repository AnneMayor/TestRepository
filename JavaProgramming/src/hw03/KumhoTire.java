package hw03;

public class KumhoTire extends Tire {
	
	KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println("��ȣŸ�̾� ����: " + (maxRotation-accumulatedRotation) + "ȸ");
			return true;
		} else 
			System.out.println("*** " + location + " ��ȣŸ�̾� ��ũ ***");
		return false;
	}
}
