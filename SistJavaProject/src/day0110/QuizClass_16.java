package day0110;

class Mart
{    
	private String sangpum;
	int su;
	int dan;
	static String SHOPNANE="롯데마트";
	
	
	//setter메서드
	public void setsangpum(String sangpum)
	{
		this.sangpum=sangpum;
	}
	
	//getter메서드
		public String getsangpum()
		{
			return sangpum;
		}
}

public class QuizClass_16 {
	

	
	//sangpum은 메서가 아니면 다른클래스에서 접근불가
	
	/*
	 * 생성후 초기값 준 후 출력하시오
	 * ***롯데마트 입고물품***	
	 * =======================
	 * 상품명:초코파이
	 * 수량:10개
	 * 가격:4500원
	 * =======================
	 * 상품명:엄마손파이
	 * 수량:5개
	 * 가격:2500원
	 * 
	 */
	 

	public static void main(String[] args) 
	
	{
		Mart m1=new Mart();
		m1.setsangpum("엄마손파이");
		m1.su=10;
		m1.dan=4500;
		
		Mart m2=new Mart();
		m2.setsangpum("초코파이");
		m2.su=5;
		m2.dan=5500;
		
		System.out.println("***"+Mart.SHOPNANE+"입고상품***");
		System.out.println("상품명: "+m1.getsangpum());
		System.out.println("수량: "+m1.su);
		System.out.println("가격: "+m1.dan);
		System.out.println("==========================");
		System.out.println("상품명: "+m2.getsangpum());
		System.out.println("수량: "+m2.su);
		System.out.println("가격: "+m2.dan);
		
		

	}

}
