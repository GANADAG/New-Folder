package day0116;

class Outer
{
	String name="이현주";
	int age=20;
	//member 내부1
	class Inner1//내부클래스에서는 외부클래스의 멤버변수사용 가능하다
	{
		public void disp()
		{
			System.out.println("**이너1 내부클래스");
			System.out.println("이름: "+name+"나이: "+age);
		}
	}
	//member 내부1
	class Inner2
	{
		public void disp2()
		{
			System.out.println("**이너2 내부클래스");
			System.out.println("이름: "+name+"나이: "+age);
	}
	//외부클래스의 메서드
		public void write()
		{
			//외부메서드에서 내부틀래스 선언
			Inner1 in1=new Inner1();
			in1.disp();
			
			Inner2 in2=new Inner2();
			in2.disp2();
		}
}
public class InnerObj_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//외부생성
		Outer out=new Outer();
		out.write();
		
		System.out.println("================================");
		
		System.out.println("다른클래스에서 외부통하지 않고 직접 내부클래스 메서드 호출하고 싶다면??");
		
		Outer.Inner1 in1=new Outer().new Inner1();
		in1.disp();
		
		Outer.Inner2 in2=out.new Inner2();
		in2.disp2();
	}

}
public void write() 
{
	// TODO Auto-generated method stub
	
}
}
