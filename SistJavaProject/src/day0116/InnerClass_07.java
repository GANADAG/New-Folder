package day0116;

class OuterObject
{
	int a=10;
	static int b=20;
	
	class InnerObject
	{
		int c=30;
		
		public void Write()
		{
			System.out.println("외부 인스턴스 변수 a="+a);
			System.out.println("외부 정적변수 b="+b);
			System.out.println("내부 인스턴스 변수 c="+c);
		}
	}
	
	static class InnerObject2
	{ //내부클래스에서 멤버를static으로 선언하고 싶으면 내부클래스 타입을 static을 붙여준다
		int d=40;
		static int e=50;
		
		public void write2()
		{
			//System.out.println("외부 인스턴스 변수 a="+a); //외부일반변수 접근안됨
			System.out.println("외부 정적변수 b="+b);
			System.out.println("내부 일반변수 d="+d);
			//System.out.println("내부 정적변수 c="+c);
		}
	}
}

public class InnerClass_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OuterObject.InnerObject inobj=new OuterObject().new InnerObject();
		inobj.Write();
		
		// OuterObject.InnerObject2 inobj2=new OuterObject()
	
	}

}
