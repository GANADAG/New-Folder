package day0111;

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

class Emp
{
	private String sName;
	private int gPay; //기본급
	private int fSu;  //가족수
	private int tSu;  //오버타임수
	
	//명시적 생성자 하는법 -??
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getgPay() {
		return gPay;
	}
	public void setgPay(int gPay) {
		this.gPay = gPay;
	}
	public int getfSu() {
		return fSu;
	}
	public void setfSu(int fSu) {
		this.fSu = fSu;
	}
	public int gettSu() {
		return tSu;
	}
	public void settSu(int tSu) {
		this.tSu = tSu;
	}
	
	//가족수당
	public int getFamilySudang()
	{
		int n=0; //메서드에서는 자동초기화가 되지 않으므로 0으로표시
		if(fSu>=2) {
			n=100000;
		} else {
			n=(fSu*50000);
		}
		
		return n;
	}

	//시간수당
	
	public int getTimeSudang() {
		int n= 0;
		
		if(tSu>=10) {
			n=300000;
		} else {
			n=(tSu*30000);
		}
		
		return n;
	}
	
	//총급여 
	public int getTotalpay() {
		int n=gPay+getFamilySudang()+getTimeSudang();
		return n;
	}
	
	//제목출력
	public static void showTitle() {
	      System.out.println("**쌍용 01월 직원 급여현황**");
	      System.out.println();
	      System.out.println("사원명\t기본급\t자녀수\t초과근무시간\t가족수당\t시간수당\t총급여");

	      System.out.println("================================================");
}

public class SawonInstanceScanner_014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

}
