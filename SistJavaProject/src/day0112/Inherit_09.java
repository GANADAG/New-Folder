package day0112;

//부모클래스
class Color{
	
	public static void hello() 
	{
		System.out.println("안녕하세요");
	}
}
/////////////////////////////////
class Red extends Color{
	
	public void process()
	{
		System.out.println("나의 차는 빨강색이야");
	}
	
}
///////////////////////////////////
class Blue extends Color{
	
	public static void process()
	{
		System.out.println("나의 차는 파랑색이야");
	}
	
}


////////////////////////////
class Pink extends Color{
	
	public static void process()
	{
		System.out.println("나의 차는 핑크색이야");
	}
	
}
///////////////////////////////////
public class Inherit_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//자식클래스 extends 부모
		System.out.println("1.Red로 선언하고 Red로 생성한 경우");
		Red red = new Red();
		red.hello();
		red.process();
		
		System.out.println("2.Blue로 선언하고 Blue로 생성한 경우");
		Blue blue = new Blue();
		Blue.hello();
		Blue.process();
		
		System.out.println("3.Pink로 선언하고 Pink로 생성한 경우");
		Pink pink = new Pink();
		Pink.hello();
		Pink.process();
		
		//부모로 선언하고 자식클래스로 생성
		//부모가 가지고있는 메소드 호출 ok
		//메서드가 오버라이드 된 경우 호출ok
		//부모한텐 없고 자식만 갖고있는 경우 메서드 호출안됨
		Color color;
		color=new Red();
		
		color.hello();
		//color.process 호출안됨
		
		
	}

}
