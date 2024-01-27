package day0116;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* **과일입고목록**
 * 번호  과일명  수량   단가    총금액
 * 1    바나나  10   2000  20000원
 * 2    포도   20   15000
 * 아보카도,30,3500
 * 토마토,15,8000
 * 오렌지,12,4000
 */

public class Quiz_15 {
	
	public static void fileRead()
	{
		String fName="C:\\sist0403\\file\\fruit.txt";
		FileReader fr=null;//메서드에서는 자동초기화안되기 때문에 null
		BufferedReader br=null;//읽을파일이 필요
		int i=0;
		
        
        
        
	 try//멀티캐치 
	 {
		fr=new FileReader(fName);
		br=new BufferedReader(fr);
		
		System.out.println("\t**과일입고목록**");
		System.out.println("번호\t과일명\t수량\t단가\t총금액");
		System.out.println("=================================");
		
		br.readLine();
		
		while(true)
		{
			String s=br.readLine();//한줄씩읽어옴
			i++;
			
			//종료
			if(s==null)
				break;
			
			/*
			 * 분리방법 풀이1(토크나이저)
			 * Stringtokenizer st=new Stringtokenizer(s,",");
			 * 
			 * 배열의 갯수만큼 반복해서 출력
			 * int su=Integer.parseInt(st.nextToken().trim());
			 * int dan=Integer.parseInt(st.nextToken().trim());
			 * int total=su*dan;
			 * 
			 */
		
			
			
			//분리방법 풀이2
			String [] data=s.split(",");
			int tot=Integer.parseInt(data[1])*Integer.parseInt(data[2]);
			
			//출력
			System.out.println(i+"\t"+data[0]+"\t"+data[1]+"\t"+data[2]+"\t"+tot);
			
			
		}
		
		
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
		// TODO: handle exception
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileRead();
	}

}
