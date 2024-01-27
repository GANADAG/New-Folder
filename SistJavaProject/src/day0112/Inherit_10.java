package day0112;

//부모
class Work{
	
	public void goodmorning()
	{
		System.out.println("안녕하세요");
	}
	public void process()
	{
		System.out.println("아무것도 안하고 있음");
	}
}
//////////////////////////////////////
class Food1 extends Work
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		//super.process();
		System.out.println("***음식담당****");
	}
}
//////////////////////////////////
class clean extends Work
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("노래담당");
	}
}
//////////////////////////////////////
class Sing extends Work
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("청소담당");
	}
}





public class Inherit_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다형성
		//부모클래스 선언하고 자식클래스로 생성하는 경우
		Work work=null;//선언
		
		work=new Food1();
		work.goodmorning();
		work.process();
		System.out.println();
		
		work=new clean();
		work.goodmorning();
		work.process();
		System.out.println();
		
		work=new Sing();
		work.goodmorning();
		work.process();
		System.out.println();
		
		
	}

}
