package day0111;


//객체의속성: 인스턴스 변수 객체의동작: 클래서의 메서드
//Object: 객체(실제로 존재하는 사물,이름,나이..)(핸드폰 자동차..)
//class: 객체를 정의,객체를 생성하기 위해 존재(설계도..)
//Inatance: 클래스에서 만들어진 객체를 그 클래스의 인스턴스(각각의 물건..텀블러)
//static: 정적메소드/공용으로 사용(약수터...)
//private 단어을 접근하기 위해 setter/matter로 변형

class Person
{	//인스턴스변수 (스타틱이 없음으로)
	private String name;
	private int age;
	private String phone;
	private String water;
	
	//명시적생성자

	
	//setter getter
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWater() {
		return water;
	}
	public void setWater(String water) {
		this.water = water;
	}
	
}
/////////////////////////////////////
public class ObjectReview_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Person p1=new Person();
		// p1.name="홍길동" ; private인스턴스변수는 생성을 해도 변수에 접근안됨
		p1.setName("김민정");
		p1.setAge(22);
		p1.setPhone("아이폰");
		p1.setWater("삼다수");
		
		String name=p1.getName();
		int age=p1.getAge();
		String phone=p1.getPhone();
		String Water=p1.getWater();
		
		System.out.println("[개인신상정보]");
		System.out.println(name);
		System.out.println(age);
		System.out.println(phone);
		System.out.println(Water);
		
	
		
	}

}
