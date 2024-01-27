package day0116;

abstract class Abstobj
{
	abstract public void dataIn();
	abstract public void dataout();
}
//////////////////////////////////
class SubAbst extends Abstobj
{

	@Override
	public void dataIn() {
		// TODO Auto-generated method stub
		System.out.println("상속 데이타입력");
	}

	@Override
	public void dataout() {
		// TODO Auto-generated method stub
		System.out.println("상속 데이타출력");
	}
	
}
//////////////////////////////////
public class AnonyMous_09 {
	
	//익명내부클래스
		Abstobj ab1=new Abstobj() {
			
			@Override
			public void dataout() {
				// TODO Auto-generated method stub
				System.out.println("익명내부클래스 출력");
			}
			
			@Override
			public void dataIn() {
				// TODO Auto-generated method stub
				System.out.println("익명내부클래스 입력");
			}
		};
		SubAbst sub=new SubAbst();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnonyMous_09 an=new AnonyMous_09();
		//익명내부클래스
		an.ab1.dataIn();
		an.ab1.dataout();
		
		//상속받은 클래스
		/*SubAbst sub=new SubAbst();
		sub.dataIn();
		sub.dataout();*/
		an.sub.dataIn();
		an.sub.dataout();
		
	
	
	}

}
