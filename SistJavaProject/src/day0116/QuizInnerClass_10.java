/*package day0116;

import java.util.Scanner;

class SawonOuter{

    private String sawonName;
    private int gibonpay,familySu,timeSu;
    
    public void process()
    {
    	//데이터출력
    	InputInner inner=new InputInner();
    	input.inputData();
    	//결과출력
    	SudangInner output=new SudangInner();
    	out.put
    }
    
}*/
/*class InputInner
{
	public void inputData() {
		Scanner sc=new Scanner(System.in);
		System.out.println("사원명입력");
		sawonName=sc.nextLine();
		System.out.println("기본급?");
		gibonpay=sc.nextInt();
		System.out.println("초과시간은?");
		timeSu=sc.nextInt();
		System.out.println("가족수는?");
		familySu=sc.nextInt();
	}
}

class SudangInner
{
	public int getTimeSudang()
	{
		return timeSu*30000;
	}
	
	public int getFamilySudang()
		if(familySu<=4)
			return 200000;
		else
			return 300000;
	public int getTex()
	{
		return(int)(gibonPay*0.03);//형변환
	}
	public int getTotalpay()
	{
		return gibonpay+getFamilySudang()+getTimeSudang()-getTex();
	}
	public void writeSawonData()
	{
		System.out.println("사원명\t기본급\t초과근무시간\t가족수\t시간수당\t세금\t총급여");
		System.out.println(sawonName+"\t+gibonpay+"\t"+timesu+"\t"+familysu+"\t+getTimeSudang+"\t+ge");
	}
//////////////////////
public class QuizInnerClass_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//방법1:내부클래스를 외부클래스 통해서 생성 후 메서드 호출
		SawonOuter sawon=new SawonOuter();
		
		SawonOuter.Input
	}//방법2:외부클래스의 멤버에서 내부클래스의 멤버를 호출후 메인에서는 외부클래스생성 외부메서드 호출
		SawonOuter sawon=new SawonOuter();
		sawon.process();
}*/
