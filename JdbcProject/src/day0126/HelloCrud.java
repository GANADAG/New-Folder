package day0126;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import OrcleDb.DbConnect;
import oracle.jdbc.util.ThreadSafeCache;

public class HelloCrud {

	DbConnect db = new DbConnect();

	public void insert() {
		Scanner sc = new Scanner(System.in);
		String name, addr;
		String sql = "";
		System.out.println("이름을 입력하세요");
		name = sc.nextLine();

		System.out.println("주소를 입력하세요");
		addr = sc.nextLine();

		sql = "insert into hello values (seq1.nextval,'" + name + "','" + addr + "',sysdate)";
		System.out.println(sql);

		// 1.db연결
		Connection conn = null;
		// 2.statement연결
		Statement stmt = null;// sql문 객체 전송에 필요한 API

		conn = db.getOracle();

		try {
			stmt = conn.createStatement();

			// 3.sql문 실행
			stmt.execute(sql);
			System.out.println("**데이타 추가됨**");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}

	}

	public void select() {
		System.out.println("시퀀스\t이름\t주소\t가입날짜");
		System.out.println("-----------------------------------");

		String sql = "select * from hello order by num";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			// 2개이상 while 1개 if
			while (rs.next()) {
				System.out.println(rs.getInt("num") + "\t" + rs.getString("name") + "\t" + rs.getString("addr") + "\t"
						+ rs.getString("sdate"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
	}

	public void delete() {
		// 삭제할 번호 입력 후 삭제
		Scanner sc = new Scanner(System.in);
		String num;
		String sql = "";

		System.out.println("삭제할 번호 입력");
		num = sc.nextLine();

		sql = "delete from hello where num=" + num;
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

	// 수정하려는 데이타 조회
	public boolean getOnedata(String num)// 인자값
	{
		boolean flag = false;// num에 해당하는 데이타가 있으면 true,없으면 false

		String sql = "select * from hello where num=" + num;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next())
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
		return flag;
	}

	// 수정단계
	public void update() {
		// 수정할 시퀀스를 입력 후 이름,주소 입력
		Scanner sc = new Scanner(System.in);
		String num, name, addr;

		System.out.println("수정할 번호를 입력");
		num = sc.nextLine();

		if (!getOnedata(num))// if(!this.getOnedata(num))
		{
			System.out.println("해당번호는 존재하지 않습니다");
			return;// 메서드종료
		}

		System.out.println("수정할 이름으로 변경하세요");
		name = sc.nextLine();
		System.out.println("수정할 주소로 변경하세요");
		addr = sc.nextLine();

		String sql = "update hello set name='" + name + "',addr='" + addr + "'where num=" + num;
		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();

			int a = stmt.executeUpdate(sql);

			if (a == 0)
				System.out.println("수정할 데이타가 존재하지 않습니다");
			else
				System.out.println("***수정되었습니다***");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloCrud hello = new HelloCrud();

		Scanner sc = new Scanner(System.in);
		int n = 0;

		while (true) {
			System.out.println("**hello db 연습**");
			System.out.println("1.insert 2.select 3.delete 4.update 9.exit");

			n = Integer.parseInt(sc.nextLine());

			if (n == 1) {
				hello.insert();
			} else if (n == 2) {
				hello.select();
			} else if (n == 3) {
				hello.delete();
			} else if (n == 4) {
				hello.update();
			} else if (n == 9) {
				System.out.println("종료합니다");
				break;
			}
		}

	}

}
