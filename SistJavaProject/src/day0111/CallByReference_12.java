package day0111;

class MyCar1{
	String carName;
	int carPrice;
	String carColor;
}

public class CallByReference_12 {

	public static void dataIn(MyCar1 car1)
	{
		car1.carName="미니쿠퍼";
		car1.carPrice=42000000;
		car1.carColor="화이트";				
	}
	
	public static void dataOut(MyCar1 car1)
	{
		System.out.println("차종명: "+car1.carName);
		System.out.println("차량가격: "+car1.carPrice);
		System.out.println("색상: "+car1.carColor);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyCar1 car=new MyCar1();
		
		//두 메서드 다 주소가 전달되므로 결국 메인의 car변수에 
		dataIn(car);
		dataOut(car);

	}

}
