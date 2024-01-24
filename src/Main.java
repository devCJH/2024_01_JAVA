import java.util.Scanner;

class Main {
	
	static int in;
	
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine();
			
			System.out.println(cmd);
			
			if (cmd.equals("exit")) {
				break;
			}
		}
		
		sc.close();
		
		System.out.println("== 프로그램 종료 ==");
	}
}
