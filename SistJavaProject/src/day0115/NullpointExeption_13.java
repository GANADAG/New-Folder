package day0115;

import java.util.Date;

public class NullpointExeption_13 {
	
	//날짜에 관한건 유틸
	Date date;//new date로 생성해야함
	
	public void write()
	{
		int y,m,d;
		
		try {
		y=date.getYear()-1900;
		m=date.getMonth()+1;//월에는 플러스일
		d=date.getDate();
		System.out.println(y+"년"+m+"월"+d+"일 입니다");
	        }catch(Exception e) 
		{
			//e.printStackTrace();
	        	System.out.println("객체생성을안함"+e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NullpointExeption_13 nullex=new NullpointExeption_13();
		nullex.write();
		System.out.println("프로그램 정상종료");
		
	}

}
