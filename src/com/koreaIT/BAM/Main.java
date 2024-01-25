package com.koreaIT.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.BAM.util.Util;
import com.koreaIT.BAM.vo.Article;

class Main {
	
	static int lastArticleId;
	static List<Article> articles;
	
	static {
		articles = new ArrayList<>();
		lastArticleId = 0;
	}
	
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		
		makeTestData();
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();
			
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			
			if (cmd.equals("exit")) {
				break;
			}
			
			if (cmd.equals("article write")) {
				lastArticleId++;
				String title = null;
				String body = null;
				
				while (true) {
					System.out.printf("제목 : ");
					title = sc.nextLine().trim();
					
					if (title.length() == 0) {
						System.out.println("제목을 입력해주세요");
						continue;
					}
					
					while (true) {
						System.out.printf("내용 : ");
						body = sc.nextLine().trim();
						
						if (body.length() == 0) {
							System.out.println("내용을 입력해주세요");
							continue;
						}
						break;
					}
					break;
				}
				
				Article article = new Article(lastArticleId, Util.getDateStr(), Util.getDateStr(), title, body);
				
				articles.add(article);
				
				System.out.printf("%d번 게시물이 생성되었습니다\n", lastArticleId);
				
			} else if (cmd.equals("article list")) {
				
				if (articles.size() == 0) {
					System.out.println("게시물이 존재하지 않습니다");
					continue;
				}
				
				System.out.println("번호	|	제목	|		작성일	");
				
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d	|	%s	|	%s\n", article.id, article.title, article.regDate);
				}
				
			} else if (cmd.startsWith("article detail ")) {
				
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				Article foundArticle = null;
				
				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}
				
				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("작성일 : %s\n", foundArticle.regDate);
				System.out.printf("수정일 : %s\n", foundArticle.updateDate);
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.body);
				
			} else if (cmd.startsWith("article modify ")) {
				
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				Article foundArticle = null;
				
				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}
				
				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("수정할 내용 : ");
				String body = sc.nextLine().trim();
				
				foundArticle.title = title;
				foundArticle.body = body;
				foundArticle.updateDate = Util.getDateStr();
				
				System.out.printf("%d번 게시물을 수정했습니다\n", id);
				
			} else if (cmd.startsWith("article delete ")) {
				
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				Article foundArticle = null;
				
				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}
				
				articles.remove(foundArticle);
				
				System.out.printf("%d번 게시물을 삭제했습니다\n", id);
				
			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}
		
		sc.close();
		
		System.out.println("== 프로그램 종료 ==");
	}

	private static void makeTestData() {
		articles.add(new Article(++lastArticleId, Util.getDateStr(), Util.getDateStr(), "테스트1", "테스트1"));
		articles.add(new Article(++lastArticleId, Util.getDateStr(), Util.getDateStr(), "테스트2", "테스트2"));
		articles.add(new Article(++lastArticleId, Util.getDateStr(), Util.getDateStr(), "테스트3", "테스트3"));
	}
}








