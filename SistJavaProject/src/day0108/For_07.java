package day0108;

public class For_07 {

	public static void main(String[] args) {
		//whil문과 for문 비교
		
		int i=10;
		
		while(i>=0)
		{
			System.out.print(i--+" "); //(print in은 세로로 출력)
		}
		System.out.println();
		
		System.out.println("**for문으로 10~0출력**");
		for(int a=10;a>=0;a--)
		{
			System.out.print(a+"   ");
			
			System.out.println();
			
			System.out.println("** for문 1~10 종료**");
			for(int a1=1;a1<=10;a1++)
			System.out.print(a1+"  ");
			System.out.println("종료");
			
			System.out.println("** while문 1~10 종료**");
			int n=1;
			while(true)
			{
				System.out.print(n++ +"  ");
				if(n>10)
					break;
				
			}
			System.out.println("종료");
		}
		
		System.out.println("**for문 1,4,7,10**");
		for(int b=1;b<=10;b+=3)
		{
			System.out.print(b+"   ");
		}

		System.out.println();
		
		System.out.println("**for문 5,4,3,2,1**");
		for(int c=5;c>=1;c--)
		{
			System.out.print(c+"   ");
		}
		
		
		System.out.println("**while문 5,4,3,2,1**");
		int z=5;
		while(z>0)
		{
			System.out.print(z--+"   ");
		}
		
		System.out.println("** for문 HelloJava를 5번 반복**");
		
		int s=1;
		for(;s<=5;s++)
		{
			System.out.print("HelloJava"+"   ");
		}
		
	}

}
