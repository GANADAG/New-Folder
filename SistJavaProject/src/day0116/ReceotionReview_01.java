package day0116;

public class ReceotionReview_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("안녕하세요");
		System.out.println("5초뒤에 저는 갑니다");
		
		try {
			Thread.sleep(5000);//3초=3000
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //Thread.sleep(3000);작성 후 try catch 클릭하여 생성
		}
		
		System.out.println("잘가!!!");
	}

}
