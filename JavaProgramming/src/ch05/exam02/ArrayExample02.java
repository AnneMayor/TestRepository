package ch05.exam02;

public class ArrayExample02 {
	public static void main(String[] args) {
		int[] v2 = {10, 20, 30}; //�迭�� ���� ���� �����Ͽ� �迭 ����.
		int[] v1 = new int[] {10,20,30}; //�̰� �� �� ����...�� �������� �޾Ƶ鿩��!
		/*v1 = { 80, 90, 87 }; �����Ϸ��� �迭���̸� ���� �˰� �迭����. ���� �̷��� �����ϸ�
		 *  ������ ����. �迭�� �����ϰ� ���� �Ҵ��ų ���� ����.
		 */
		int result1 = sum(v1);
		int result2 = sum(v2);
		int result3 = sum(new int[] {10, 20, 30});
		//sum( {10, 20, 30}); �̰͵� �տ� �ּ� ó���� ������ ����.�Լ����� ���� ���� ������ ���� �ϰ� �迭�� �� ������ ���Խ�ų �� ����! 
		//�迭�� ���̸� �� �� �ִ� �迭�� �迭������ �����Ͽ� ��ü�� ������ �� ����.
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		}
	public static int sum(int[] args) {
		int sum = 0;
		for(int i = 0; i < args.length; i++) {
			sum += args[i]; //�̰� ������ 1��! sum = sum + args[i] ��� ������ 2��. ���� ������ ���� ������ �� ������ �̰� �����Ϸ� ���ɿ� ���� �ӵ��� �ٸ�.
			//JAVA�� �����Ϸ��� ���� ǥ���� ��� sum += args[i]�� �ν�. ����, �ӵ� ���� ����...
		}
		
		return sum;
	}
}
