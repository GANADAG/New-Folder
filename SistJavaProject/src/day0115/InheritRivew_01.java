package day0115;

// interface 상수와 추상메서드만 존재가능
	interface InterAA{
		public void play();
	}
	//////////////////////////
	interface InterBB 
	{
		public void draw();
	}
	class InterImple_01 implements InterAA,InterBB
	{

		@Override
		public void draw() {
			// TODO Auto-generated method stub
			System.out.println("나는 그림을 그린다");
		}

		@Override
		public void play() {
			// TODO Auto-generated method stub
			System.out.println("나는 게임을 한다");
		}
		
	}
//////////////////////////////////////////////
public class InheritRivew_01 {
//전역변수(자동초기화 가능)
	public static void main(String[] args) {
		// 지역변수
		
		InterImple_01 impl=new InterImple_01();
		impl.draw();
		impl.play();
		
		System.out.println("**다형성으로 출력**");
		/*InterAA aa=new in InterImple_01();
		aa.play();
		
		InterBB aa=new in InterImple_01();
		aa.play();*/
		
	}

}
