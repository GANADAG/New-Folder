package day0115;

import java.io.IOException;
import java.io.InputStream;

//Strem:바이트단위로 처리
//Writer,reader:대부분 문자단위로 처리
//BufferReader :해당클래스는 스트림으로부터 데이터를 읽어올 때 한줄씩 읽을 수 잇는 resgline()
//BufferWriter : flush()메소드를 호출해서 버퍼의 내용을 전송하는 작업이 추가로 필요
public class IoExcep_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputStream is=System.in;//콘솔에서 읽기위한(입력받기위한) 노드스트림
		int a=0;
		
		System.out.println("한글자 입력");
		try {
			a=is.read(); //1바이트 읽는것..리턴값은 아스키코드..한글못읽는다(1바이트 이므로)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("오류: "+e.getMessage());
			
		}
		System.out.println("**3초뒤에 출력**");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("입력값: "+(char)a);
	}
	
}
