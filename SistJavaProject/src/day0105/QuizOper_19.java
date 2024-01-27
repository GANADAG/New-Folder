package day0105;

import java.util.Scanner;

public class QuizOper_19 {

	public static void main(String[] args) {
		/*
		 * (평가는 90점 이상은 참잘함! 80점 이상은 좀 더 노력하세요~~ 80점 미만은 불합격)
		 * 이름을 입력하세요
		 * 손흥민
		 * 국,영,수 점수를 입력하세요
		 * 88
		 * 99
		 * 77
		 * 
		 * ==========================
		 * [손흥민 님의 기말고사 성적]
		 * 총점: **점
		 * 평균: **.*점
		 * 평가: 좀 더 노력하세요
		 */
		
		Scanner sc=new Scanner(System.in);
		
		String name,msg; // msg; 평가
		int score,eng,math,tot;
		double vv;// vv;총점
		
		System.out.println("이름을 입력하세요");
		name=sc.nextLine();
		System.out.println("국,영,수 점수를 입력하세요");
		score=sc.nextInt();
		eng=sc.nextInt();
		math=sc.nextInt();
		
		tot=score+eng+math;
		vv=tot/3;
		
		
		if(score>=90)
			msg="참잘함";
		else if(score>=80)
			msg="좀 더 노력하세요";
		else
			msg="불합격";
		
		System.out.println("===================");
		System.out.println("[손흥민 님의 기말고사 성적]");
		System.out.println("총점:"+tot+" 점");
		System.out.printf("평균:%.1f점",vv);
		
		
		System.out.println("\n평가: "+msg);
		
	}


}
