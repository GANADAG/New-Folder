package day0112;

class Food
{
	private String foodName;
	private int fPrice;
	
	static int no;//메뉴 뒤 숫자++
	
	//명시적생성자(2개)
	public Food(String name,int price)
	{
		this.foodName=name;
		this.fPrice=price;
	}	
	//한번에 출력 가능한 출력문 생성 
	public void getFood()
	{
		no++;
		
		System.out.println("[메뉴_"+no+"]");
		System.out.println("음식명: "+foodName);
		System.out.println("가격: "+fPrice);
		System.out.println("======================");
	}
	
}

//////////////////////////
public class ArrReview_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//첫번째 출력방법
		Food food1=new Food("마르게리따 피자",12000);
				food1.getFood();
		Food food2=new Food("까르보나라",15000);
				food2.getFood();
		Food food3=new Food("샐러드",16000);
				food3.getFood();
		
		/*두번째
		Food[] food =new Food[3];
		
		food[0]=new Food("마르게리따 피자",15000);
		food[0]=new Food("마르게리따 피자",15000);
		food[0]=new Food("마르게리따 피자",15000);
	
		for(int i=0;i<food.length;i++)
		{
			food[i].getFood();
		}*/
				
		/*세번째
		 for(Food f:food)
		{
			f.getFood();
		}*/
	}

}
