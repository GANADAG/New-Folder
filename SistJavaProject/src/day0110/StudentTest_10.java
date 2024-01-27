package day0110;

public class StudentTest_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu1=new Student();
		Student stu2=new Student();
		Student stu3=new Student();
		
		stu1.stuName="이효리";
		stu1.stuAge=22;
		
		stu2.stuName="이상순";
	    stu2.stuAge=30;
				
		Student.schooLName="쌍용고등학교";
		
		
		System.out.println("**클래스 멤버값 출력");
		System.out.println("학교명: "+Student.schooLName);
		System.out.println("**학생1정보**");
        System.out.println("이름: "+stu1.stuName+"\n나이: "+stu1.stuAge+" 입니다");
		

	}

}
