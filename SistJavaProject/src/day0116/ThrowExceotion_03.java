package day0116;

import java.util.Scanner;

//Throw: 강제예외발생
class UserException extends Exception
{
	public UserException (String msg) {
		super(msg);//excption을 상속받은 후 정식메세지로 등록
	}
}

public class ThrowExceotion_03 {
	
	public static void process()throws UserException
	{
		Scanner sc=new Scanner(System.in);
		int age=0;
		
		//나이가 10~59가 아니면 UserException 강제발생하게 만들기
		System.out.println("나이를 입력해주세요");
		age=sc.nextInt();
		
		if(age<10 || age>=60)
			throw new UserException("우리모임의 나이는 10~59세 입니다");
		else
			System.out.println("당신은"+age+"세 이므로 멤버로 등록이 가능합니다");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//process(); //강제발생
		
		try {
			process();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
