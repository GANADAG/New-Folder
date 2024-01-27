package day0105;

import java.util.Scanner;

public class QuizOPer_20 {

	public static void main(String[] args) {
		/* 
		 * 상품명: 키보드
		 * 수량: 5
		 * 가격: 20000
		 * 
		 * ==========================
		 * **5개이상 구매시 10% 할인됩니다
		 * 키보드 5개는 총 90000원 입니다
		 * 할인된금액: 10000원
		 */

		Scanner sc=new Scanner(System.in);
		
		String name;
		int num,price,tot,per;
		
		System.out.println("상품명");
		name=sc.nextLine();
		System.out.println("수량");
		num=sc.nextInt();
		System.out.println("가격");
		price=sc.nextInt();
		
		System.out.println("==================");
		
		System.out.println("**5개이상 구매시 10% 할인됩니다");
		
		
		tot=num*price;
		
		if(num>=5)
			
			tot=tot/10*9;
		System.out.printf("%s %d개는 총%d원입니다",name,num,tot);
		
		per=tot/10;
		System.out.println("\n할인된금액"+per);
			
	
		
		
	}

}
