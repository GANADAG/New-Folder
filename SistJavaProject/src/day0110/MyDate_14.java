package day0110;

class MyDate
{
	private int year;
	private int month;
	private int day;
	
	//디폴트생성자
	
	//명시적생성자_생성과 동시에 초기화
	public MyDate(int y,int m,int d)
	{	
		
	}
	
	//setter
	public void setYear(int y)
	{
		this.year=y;
	}
	public void setMonth(int m)
	{
		month=m;
	}
	public void setDay(int d)
	{
		day=d;
	}
	
	
	//getter
	public int getYear()
	{
		return year;
	}
	public int getMonth()
	{
		return month;
	}
	public int getDay()
	{
		return day;
	}
	
}

//////////////////////////////////
public class MyDate_14 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
      MyDate m=new MyDate(2024,01,10);
      
      //???
      

	}
 }
