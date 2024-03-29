package day0116;

public class ExceptionReview_02 {

	public static void process()
	{
		int[] arr= {1,3,9,7};//0부터 arr까지 작을때까지
		
		for(int i=0;i<=arr.length;i++)
		{
			try {
				System.out.println(arr[i]);
			}
		catch (Exception e) {
			System.out.println("오류메세지 1: "+e.getMessage());
		}
		}
	}
	//throws: 던지다 //호출(입력)하는 곳으로 던져줌
	//익셉션 처리를 직접하지 않고 호출하는 곳으로 해당 메서드를(익셉션)을 던진다
	public static void process2() throws NumberFormatException 
	{
		String a="12a";
		String b="30";
		int sum=0;
		
		sum=Integer.parseInt(a)+Integer.parseInt(b);
		System.out.println("두수의 합은"+sum);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		process();

		try {
		process2();
		}catch(NumberFormatException e) {
			System.out.println("예외처리를 메인에서 했어요"+e.getMessage());
		}//정상종료가 되는지 확인해야함
		
		System.out.println("***정상종료***");
	}

}
