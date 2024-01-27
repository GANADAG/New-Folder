package day0112;

abstract //Abstract 추상클래스
//추상클래스는 new로 생성못함
//abstract메서드는 abstract클래스에서만 존재할수있다
//abstract 클래스는 일반메서드 추상메서드 둘 다 포함가능

class Fruit{
	public static final String MESSAGE="오늘은 추상클래스 배우는날";
	
	//일반메서드
	public void showTitle() {
		System.out.println("일반메서드 입니다");
	}

	//추상메서드
  abstract public void showMessage();
  
}
///////////////////////////////
class Apple extends Fruit{
	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println(Fruit.MESSAGE);
		System.out.println("Apple_Messa"
				+ "ge");
	}
}
////////////////////////////////////
class Banana extends Fruit{
	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println("Orange_Message");
	}
}
public class Abstract_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//다형성출력(부모로 선언,자식으로 생성)_장점은 변수가 하나
		//부모클래스명 변수명=new 자식클래스명
		Fruit fruit;
		
		fruit=new Apple();
		fruit.showMessage();
		fruit.showTitle();
		
		fruit=new Banana();
		fruit.showMessage();
		fruit.showTitle();
		
		/*추상클래스 생성불가 
		Fruit fr=new Fruit*/

	}

}
