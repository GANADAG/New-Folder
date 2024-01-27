package day0109;

import java.util.Scanner;

public class Quiz_16 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

    	/*
    	 * Q.두수 x,y를 입력후 x의 y승_for문을 이용해서 구하시오(x를 y횟수만큼 곱하는것)
    	 * 
    	 * 두수 입력
    	 * 3   3
    	 * 3의3승은 27입니다
    	 * 
    	 */
		
		Scanner sc = new Scanner(System.in);
		int x,y,result=1;
		
		System.out.println("두수를 입력하세요");
		x=sc.nextInt();
		y=sc.nextInt();
		
		for(int i=1;i<=y;i++)
				result*=x;
		System.out.println(x+" 의"+ y+"승은 "+result+" 입니다");
		
		quiz3(); quiz1();
    }
	
	public static void quiz3() 
	{
		/*
		 * 1~100
		 * 
		 */
		int eusm=0; //짝수
		int osum=0; //홀수
		
		
	}
	
	public static void quiz1() 
	{
		/*
		 * 
		 */
		
	}

	
	
	
	
	
	
	}

    


