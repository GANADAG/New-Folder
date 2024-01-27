package day0112;

/*
 * [쌍용매장 입고상품]
 * 
 * 번호  상품명    가격    색상
 * ====================
 * 1   요가매트  25000   핑크
 * 2   아령     30000  블랙
 * 3   레깅스   45000   베이지
 * 4   나시    22000   화이트
 * 
 */
/* class Shop
{
	private String sName;
	private int sPrice;
	private String sColor;
	
	private static int no; 
	static String shopName="쌍용";
}

	public Shop(String name,int price,String,color)
	{
		this.sName=name;
		this.sPrice=price;
		this.sColor=color;		
	}
	//제목
	public static void showTitle()
	{
		System.out.println("["+shopName+"매장 입고상품");
		System.out.println();
		System.out.println("번호\t상품명\t가격\t색상");
	}
	public void 

public class ArrReview_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shop[]shop= {
				new Shop("요가매트",25000,"pink"),
				new Shop("아령",24000,"black"),
				new Shop("레깅스",25000,"pink"),
				new Shop("나시",25000,"pink"),
		};
		
		Shop.showtitle();
		for(Shop s:shop)
			s.showSangpums();
		
		
		
	}

}

	*/