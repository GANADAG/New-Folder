package day0111;

import java.util.Scanner;

/*
 * 모든 멤버는 private
 * Emp :사원
 * sName :사원명
 * gPay :기본급
 * fSu :가족수
 * tSu:오버타임시간
 * 
 * setter/getter 생성
 * 
 * getFamilysudang():가족수당=가족수*50000(단 2인이상은 무조ㅅ건 10만원)
 * 
 * getTimeSudang():시간수당=초과시간*3000(단 10시간 이상은 30만원으로 통일)
 * 
 * getTotalPay():실수령액=기본급+가족수당+시간수당
 * ===================================================
 * 메인에서는 인원수 입력후 해당사원에 이름,기본급,가족수,시간수 입력받아 출력
 *
 * [직원1월급여]
 * 사원명 기본급 자녀수 초과근무시간 가족수당 시간수당 총급여
 * ===================================================
 * 
 */
/*class Emp{
	private String sName;
	private int gpay;
	private int fsu;
	private int tSu;
	
	//시간수당

	
	
	
	
	
	
	
		//가족수당
		if(tsu>=10)
			n=300000;
		else
			n=tSu*30000
		return n;
	}
	//총급여
	public int getTotalpay()
	{
		int n=gPay+this.ge
				}
}
    //제목
public class SawonInstanceScanner_14 {
	
	public static void writeEmp(Emp[] emp)
	{
		//제목부터 출력
		emp.showTitle();
		for (Emp e:emp)
			System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new scanner(System.in);
		int inwon;
		Emp[]emp
		
		System.out.println("입력할 직원수는?");
		inwon=Integer.parseInt(sc.nextLine());
		
		//배열할당
		emp=new Emp[inwon];
		
		//인원수만큼 데이타 입력
		for(int i=0;i<inwon;i++)
		{
			emp[i]=new Emp();
			
			System.out.println("이름");
			String name=sc.nextLine();
			System.out.println("기본급?");
		    int pay=Integer.parseInt(sc.nextLine());
		    System.out.println("자녀수입력");
			int fs=Integer.parseInt(sc.nextLine());
			System.out.println("초과근무시간");
			int ts=Integer.parseInt(sc.nextLine());
			
			//setter로 emp클래스에 데이타 넣기
			emp[i].setsName(name);
			emp[i].setgPay(pay);
			emp[i].setfSu(fs);
			emp[i].settSu(ts);
			
			System.out.println();
			
			}
		
		//출력
		writeEmp(emp);
		
	}

}*/
