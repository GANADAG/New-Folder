package day0110;

import java.util.Scanner;

public class ArraySearchName_3 {

	public static void main(String[] args) {
		// 
		
		String [] names= {"김다나","정다나","우다나","김미리","장우리","김지영","윤지윤"};
		
		boolean flag;
		Scanner sc=new Scanner(System.in);
		String name;
		
		while(true)
		{
			System.out.println("친구 이름을 입력하세요");
			     name=sc.nextLine();
			     
			     //q입력시 종료
			     
			 if(name.equalsIgnoreCase("q"))    
			 {
				 System.out.println("프로그램종료");
				 break;
			 }
			 flag=false;
			 
			     for(int i=0;i<names.length;i++)
			     {
			    	 if(name.equals(
			    			 names[i]))
			    	 {
			    		 flag=true;
			    		 System.out.println(i+1+" 번째에서 검색된");
			    	 }
			     }
			     
			     if(!flag)
			    	 System.out.println(name+" 님은 데이터에 없음");
			     
		}
			
		
		
	}

}
