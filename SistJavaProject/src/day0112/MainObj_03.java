package day0112;

//부모클래스의 멤버를 자식클래스가 선언없이 사용가능하다
//프라이빗은 같은 패키지여도 상속 못 받는다
//자바는 단일 상속만 가능
//상속 extend라는 키워드로 표현 
//class 자식클래스 extends 부모클래스

public class MainObj_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SubObj_03 sub=new SubObj_03("김선호",22,"강남구");
		sub.writeData();
	}

}
