package day0111;

class MyInfo
{ 
	private String name;
	private String mbti;
	private int age;
	
	public MyInfo(String name,String mbti,int age)
	{
		this.name=name;
		this.mbti=mbti;
		this.age=age;		
	}
	
	public static void showTitle()
	{
		System.out.println("이름\tmbti\t나이");
		System.out.println("==================");
	}
	public void showInfo()
	{
		System.out.println(name+"\t"+mbti+"\t"+age+"세");
	}
	
}

public class QuizArrObTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyInfo[]myinfo= {
				new MyInfo("이효리","entj",36),
				new MyInfo("이영자","entj",36),
				new MyInfo("이효리","entj",36)
		};
		
		MyInfo.showTitle();
		for(MyInfo info:myinfo)
			info.showInfo();
		

	}

}
