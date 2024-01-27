package day0111;

//1.this: 객체생성후 메모리에 생성된 자기자신의 인스턴스를 의미
//인스턴스 변수와 로컬변수명이 동일한경우에 this.인스턴스변수명
//2.생성자에서 다른오버로딩생성자를 호출하는 경우..this():반드시 생성자의 첫라인
class test
{
   private String name;
   private int grade;
   
	//생성자
   public test(String name)
   {
	   this(name,4);
   }
   public test(String name,int grade) 
   {
	   this.name=name;
	   this.grade=grade;
   }
   //getter메서드
   public String getName() 
   {
	   return name;
   }
   public int getGrade() 
   {
	   return grade;
   }
   
}

public class ThisEx_03 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
	}

}
