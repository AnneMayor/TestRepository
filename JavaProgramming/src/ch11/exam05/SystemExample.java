package ch11.exam05;
// 보안과 관련된 내용
public class SystemExample {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				if(status != 54321) {
					throw new SecurityException(); // 실행예외이기에 try-catch 없어도 문제 없음.
				}
				System.out.println("checkExit");
			}
		});
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
			if(i == 5) {
				try {
				System.exit(54321);
				} catch(SecurityException e){
					// 예외가 발생해도 무시하고 프로그램 초기 for문으로 돌아감.
				}
			}
		}
	}
}