package day0105;

import java.util.Scanner;

public class keyBoardin_01 {

	public static void main(String[] args) {
		// 이름,핸드폰번호,주소 입력 후 출력
		//1.임포트
		Scanner sc=new Scanner(System.in);
		
		//2.변수선언
		String name,hp,addr;
		
		//3입력
		System.out.println("이름을 입력하세요");
		name=sc.nextLine();
		
		System.out.println("핸드폰 번호는?");
		hp=sc.nextLine();
		
		System.out.println("주소는?");
		addr=sc.nextLine();
		
		//4.최종출력
		System.out.println("==========================");
		System.out.println("\t[입력결과]");
		System.out.println("이름: "+name+" 님");
		System.out.println("핸드폰: "+hp);
		System.out.println("주소: "+addr);
		
	}

}
