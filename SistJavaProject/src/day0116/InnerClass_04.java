package day0116;

import day0116.OuterObj.innerobj;

class OuterObj//외부클래스(클래스안 클래스 존재)
{
	public void disp()
	{
		System.out.println("외부클래스의 disp메서드");
		System.out.println("외부에서 내부클래스의 write 메서드 호출");
		
		innerobj inobj=new innerobj();
		inobj.write();
	}
	
	class innerobj//내부클래스
	{
		public void write()
		{
			System.out.println("내부클래스의 write메서드");
		}
	}
}

///////////////////////////
public class InnerClass_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OuterObj outObj=new OuterObj();
		outObj.disp();
		System.out.println("=========================");
		
		//내부클래스는 외부통해서만 생성가능
		OuterObj.innerobj obj=new OuterObj().new innerobj();
		
		OuterObj.innerobj obj1=outObj.new innerobj();
		obj1.write();
	}

}
