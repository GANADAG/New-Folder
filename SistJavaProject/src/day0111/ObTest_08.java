package day0111;

class score{
	
	private String stuName;
	private int java;
	private int oracle;
	
	public static final String TITLE="2023년도 기말고사";//상수는 스트링앞 파이널이 붙음

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getOracle() {
		return oracle;
	}

	public void setOracle(int oracle) {
		this.oracle = oracle;
	}

	public static String getTitle() {
		return TITLE;
	}
     
	//추가할 메서드
	//합계
	public int getTot()
	{	
		int t=java+oracle;
		return t;
	}
	
	public double getAvg()
	{
		double d=getTot()/2.0;
		return d;
	}

}

public class ObTest_08 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 
		score s1=new score();
		s1.setStuName("박지선");
		s1.setJava(90);
		s1.setOracle(88);
		
		int tot=s1.getTot();
		double avg=s1.getAvg();
		
		System.out.println("**score클래스");
		
		System.out.println();
		
		
	}

}
