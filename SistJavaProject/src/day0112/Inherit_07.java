package day0112;

//부모
class School
{
	
	public static final String SCHOOLNAME="쌍용고등학교";
	private String schoolAddr;
	private int countStu;
	private int countTeacher;
	
	//디폴트 생성자
	public School() {
		this ("강남구 역삼동",120,10);//초기화를 위해 명시적 생성자 호출
		
	}
	//명시적 생성자
	public School (String saddr,int cntstu,int cntteaher) {
		this.schoolAddr=saddr;
		this.countStu=cntstu;
		this.countTeacher=cntteaher;
	}
	//setter getter
	public String getSchoolAddr() {
		return schoolAddr;
	}
	public void setSchoolAddr(String schoolAddr) {
		this.schoolAddr = schoolAddr;
	}
	public int getCountStu() {
		return countStu;
	}
	public void setCountStu(int countStu) {
		this.countStu = countStu;
	}
	public int getCountTeacher() {
		return countTeacher;
	}
	public void setCountTeacher(int countTeacher) {
		this.countTeacher = countTeacher;
	}
	
	//메서드 
	public void writeData() {
		System.out.println("학교주소:"+this.schoolAddr);
		System.out.println("학생수: "+this.countStu+",선생님수:"+this.countTeacher);
	
	}
}
//자식
class Student extends School
{
	private String stuName;
	private int grade;
	
	public Student() {
		
	}
	
	public Student(String sAddr, int cntStu, int cntTea, String stuname, int gra)
	{
		super(sAddr,cntStu,cntTea);
		this.stuName=stuname;
		this.grade=gra;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	//재정의메서드
	@Override
	public void writeData() {
		// TODO Auto-generated method stub
		super.writeData();
		
		System.out.println("학생명: "+stuName);
		System.out.println("학년: "+grade+"학년");
	}
	
}

/////////////////
public class Inherit_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
