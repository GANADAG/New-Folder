package day0112;

import java.util.Scanner;
/*
//추상부모클래스
abstract class Board{
	
	public abstract void play();
}
/////////////////////////////////////////
class Insert extends Board{
	
}
//////////////////////////////////////
class Select extends Board{
	
}
/////////////////////////////////
class Update extends Update{
	
}
////////////////////////////////
class Delete extends delete{
	
}
////////////////////////////////
public class Abstract_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Board board = new Board(); //추상클래스 new로 생성못함
		
		Scanner sc=new Scanner(System.in);
		int num;
		Insert board=null;//부모클래스선언
		
		while(true)
		{
			System.out.println("1.쓰기 2.조회 3.수정 4.삭제");
			num=sc.nextInt();
			
			switch(num)
			{
			case 1:
				board=new Insert();
				break;
			case 2:
				board=new Select();
				break;
			case 3:
				board=new Update();
				break;
			case 4:
				board=new Delete();
				break;
			default:
				System.out.println("종료합니다");
				System.exit(0);//강제종료
			}
		}
		
		
		
		
	}

}*/
