package exam09;

public class Member {
	
	String name;
	final String ssn; //�ʵ尪�� �ѹ� �ο������� ���� �ȹٲܰŴٶ�� �����ϴ� ��
	static final String NATION = "�ѱ�";
	
	
	Member(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
}
