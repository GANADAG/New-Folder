package day0126;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.text.html.CSS;

import OrcleDb.DbConnect;

public class QuizStuInfo {

	DbConnect db = new DbConnect();

	public void insert() {
		Scanner sc = new Scanner(System.in);
		String s_name, s_gender, s_hp,s_age;
		
		String sql = "";

		System.out.println("학생명을 입력하세요");
		s_name = sc.nextLine();

		System.out.println("성별을 입력하세요");
		s_gender = sc.nextLine();

		System.out.println("나이를 입력하세요");
		s_age = sc.nextLine();

		System.out.println("연락처를 입력하세요");
		s_hp = sc.nextLine();
		

		sql = "insert into stuinfo values (seq_info.nextval,'" + s_name + "','" + s_gender + "','"+ s_age +"','"+s_hp+"',sysdate)";
		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);

			System.out.println("**데이터 추가**");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		System.out.println(sql);
	}

//////////////////////////////////////////////////////////////////////////
	public void select() {
		System.out.println("시퀀스\t학생명\t성별\t나이\t연락처\t가입날짜");
		System.out.println("-----------------------------------");

		String sql = "select * from stuinfo order by num";

		Connection conn = null;//db연결하는거 도와줌
		Statement stmt = null;//db명령 내리기 위함//쿼리 작업을 실행하기 위한 객체
		ResultSet rs = null;//db결과값을 반환,저장 //select의 결과를 저장하는 객체 

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("num") + "\t" + rs.getString("s_name") + "\t" + rs.getString("s_gender")
						+ "\t" + rs.getString("s_age") + "\t" + rs.getString("s_hp") + rs.getString("guipday") );

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
	}

/////////////////////////////////////////////////////////////////////////
	public void delete() {
		Scanner sc = new Scanner(System.in);
		String num;
		String sql = "";

		System.out.println("삭제할 번호 입력");
		num = sc.nextLine();

		sql = "delete from stuinfo where num=" + num;
		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();

			int a = stmt.executeUpdate(sql);// 성공한 레코드의 갯수

			// 없는 번호 입력시 실제 삭제가 안되므로 0이 반환
			if (a == 0)
				System.out.println("없는 데이타 번호입니다");
			else
				System.out.println("***삭제되었습니다***");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}

	}
	////////////수정 할 데이터 조회
	public boolean getOnedata(String num)
	{
		boolean flag = false;
		
		String sql = "select * from Stuinfo where num=" + num;
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		conn=db.getOracle();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			if(rs.next())
				flag = true;
			else
				flag=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
		return flag;
		
	}
	///////////////////////////////////////////////
	public void update() {
		
		Scanner sc = new Scanner(System.in);
		String num,s_name, s_gender, s_hp,s_age;
		
		System.out.println("수정할 번호 입력하세요");
		num=sc.nextLine();
		

		if (!getOnedata(num))// if(!this.getOnedata(num))
		{
			System.out.println("해당번호는 존재하지 않습니다");
			return;// 메서드종료
		}
		
		System.out.println("수정할 이름 입력");
		s_name=sc.nextLine();
		System.out.println("수정할 성별 입력");
		s_gender=sc.nextLine();
		System.out.println("수정할 핸드폰 번호 입력");
		s_hp=sc.nextLine();
		System.out.println("수정할 나이 입력");
		s_age=sc.nextLine();
		
		String sql ="update Stuinfo set s_name='"+s_name+"',s_gender='"+s_gender+"',s_hp='"+s_hp+"'s_age='"+s_age+"'where num="+num;
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=db.getOracle();
		try {
			stmt=conn.createStatement();
			
			int a=stmt.executeUpdate(sql);
			
			if(a==0)
				System.out.println("수정할 데이터없음");
			else
				System.out.println("수정완료!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizStuInfo stuinfo = new QuizStuInfo();

		Scanner sc = new Scanner(System.in);
		int n = 0;

		while (true) {
			System.out.println("**db연습**");
			System.out.println("1.insert 2.select 3.delete 4.update 5.search 9.exit");

			n = Integer.parseInt(sc.nextLine());

			if (n == 1){
				stuinfo.insert();
			}else if (n == 2) {
				stuinfo.select();
			}else if (n == 3) {
				stuinfo.delete();
			}else if(n==4) {
				stuinfo.update();
			}else if (n==9) {
			System.out.println("종료");
			break;
			}
		}
	}

}
