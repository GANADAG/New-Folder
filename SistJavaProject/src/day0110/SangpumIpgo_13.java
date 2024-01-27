package day0110;

class Ipgo{
	private String sangName; //private 접근 제한자: 개인적인 것으로 외부에서 사용될 수 없기 때문에 변환해줌
	private int Price;
	
	//setter메서드
	public void setName(String name)
	{
		this.sangName=name;
	}
	public void setprice(int price)
	{
		this.Price=price;
	}
	//getter메서드
	public String getName()
	{
		return sangName;
	}
	public int getPrice()
	{
		return Price;
	}
}

public class SangpumIpgo_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ipgo ipgo1=new Ipgo();
		ipgo1.setName("애플워치");	
		ipgo1.setprice(580000);

		String name1=ipgo1.getName();
		int price1=ipgo1.getPrice();
		
		
		Ipgo ipgo2=new Ipgo();
		ipgo2.setName("에어팟");	
		ipgo2.setprice(210000);

		String name2=ipgo2.getName();
		int price2=ipgo2.getPrice();
		
		System.out.println(name1+","+price1+"원");
		System.out.println(name2+","+price2+"원");
		

		
	}

}
