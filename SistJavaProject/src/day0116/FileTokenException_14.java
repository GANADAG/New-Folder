package day0116;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class FileTokenException_14 {
	
	public static void fileRead()
	{
		String fName="C:\\sist0403\\file\\info.txt";
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(fName);
			br=new BufferedReader(fr);
			
			System.out.println("**파일읽기결과**");
			System.out.println("이름\t주소\t나이");
			System.out.println("=========================");
			
			br.readLine();
			while(true)
			{
				String s=br.readLine();
				
				//종료
				if(s==null)
					break;
				/*split으로 분리/배열갯수만큼 출력 ;풀이1
				String[]data=s.split(",");
				System.out.println(data[0]+"\t"+data[1]+"\t"+data[2]);*/
				
				//풀이2
				StringTokenizer st=new StringTokenizer(s, ",");
				System.out.println(st.nextToken()+"\t"+st.nextToken()+"\t"+st.nextToken()+"세");
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) //String s=br.readLine();에 파일이 없을수도 있다는거에 대한 방지
		{
			// TODO: handle exception
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
			
		}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileRead();
	}

}
