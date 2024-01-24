import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 0;
		
		while(true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine();
			
			if (cmd.equals("article write")) {
				lastArticleId++;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				
				System.out.printf("%d번 게시물이 생성되었습니다\n", lastArticleId);
			}
			
			if (cmd.equals("exit")) {
				break;
			}
		}
		
		sc.close();
		
		System.out.println("== 프로그램 종료 ==");
	}
}
