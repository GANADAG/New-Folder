package day0129;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import OrcleDb.DbConnect;

public class SawonMember {

	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);

	// 1.입력단계

	public void insertMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		System.out.println("사원 이름을 입력하세요");
		String s_name = sc.nextLine();
		System.out.println("부서를 입력하세요");
		String buseo = sc.nextLine();
		System.out.println("직급을 입력하세요");
		String position = sc.nextLine();
		System.out.println("성별을 입력하세요");
		String gender = sc.nextLine();
		System.out.println("월급을 입력하세요");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("보너스를 입력하세요");
		int bonus = Integer.parseInt(sc.nextLine());

		String sql = "insert into sawonmember values(seq1.nextval,?,?,?,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, s_name);
			pstmt.setString(2, buseo);
			pstmt.setString(3, position);
			pstmt.setString(4, gender);
			pstmt.setInt(5, pay);
			pstmt.setInt(6, bonus);

			int n = pstmt.executeUpdate();

			if (n == 1)
				System.out.println("**insert성공**");
			else
				System.out.println("**insert실패**");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

////////////////////////////////////////////////////////////////////////////////
	// 2.출력단계
	public void writeMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawonmember order by s_no asc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			System.out.println("번호\t이름\t부서\t직급\t성별\t월급\t보너스\t날짜");
			System.out.println("==========================================================");

			while (rs.next()) {
				System.out.println(rs.getString("s_no") + "\t" + rs.getString("s_name") + "\t" + rs.getString("buseo")
						+ "\t" + rs.getString("position") + "\t" + rs.getString("gender") + "\t" + rs.getInt("pay")
						+ "\t" + rs.getInt("bonus") + "\t" + rs.getDate("ipsaday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
////////////////////////////////////////////////////////////////////////////////
	// 3.삭제단계

	public void deleteMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		System.out.println("삭제할 번호를 입력하세요");
		int s_no = Integer.parseInt(sc.nextLine());

		String sql = "delete from sawonmember where s_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s_no);

			int n = pstmt.executeUpdate();

			if (n == 1)
				System.out.println("사원정보 삭제 완료!!");
			else
				System.out.println("사원정보 삭제 실패!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

////////////////////////////////////////////////////////////////////////////////
	// 4.수정단계
	public boolean isOneData(String s_no) {
		boolean bool = false;

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawonmember where s_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_no);
			rs = pstmt.executeQuery();

			if (rs.next())
				bool = true;
			else
				bool = false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return bool;
	}

	//
	public void updateMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		System.out.println("수정할 번호를 입력하세요");
		String s_no = sc.nextLine();

		if (!this.isOneData(s_no)) {
			System.out.println("*해당번호는 존재하지 않습니다");
			return;
		}

		System.out.println("수정할 사원명 입력");
		String s_name = sc.nextLine();
		System.out.println("수정할 부서명 입력");
		String buseo = sc.nextLine();
		System.out.println("수정할 직급 입력");
		String position = sc.nextLine();
		System.out.println("수정할 성별 입력");
		String gender = sc.nextLine();
		System.out.println("수정할 월급 입력");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 보너스 입력");
		int bonus = Integer.parseInt(sc.nextLine());

		String sql = "update sawonmember set s_name=?,buseo=?,position=?,gender=?,pay=?,bonus=? where s_no=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, s_name);
			pstmt.setString(2, buseo);
			pstmt.setString(3, position);
			pstmt.setString(4, gender);
			pstmt.setInt(5, pay);
			pstmt.setInt(6, bonus);
			pstmt.setString(7, s_no);

			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

////////////////////////////////////////////////////////////////////////////////
	public void searchName() {
		System.out.println("검색할 이름을 입력하세요");
		String sawon = sc.nextLine();

		String sql = "select s_no,s_name,buseo,position,gender,pay,bonus from sawonmember where s_name like ?";

		System.out.println("번호\t이름\t부서\t직급\t성별\t월급\t보너스");

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + sawon + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("s_no") + "\t" + rs.getString("s_name") + "\t" + rs.getString("buseo")
						+ "\t" + rs.getString("position") + "\t" + rs.getString("gender") + "\t" + rs.getInt("pay")
						+ "\t" + rs.getInt("bonus"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SawonMember member = new SawonMember();
		Scanner sc = new Scanner(System.in);

		int n;

		while (true) {
			System.out.println("=======================Sawon Member=======================");
			System.out.println("1.사원정보 2.전체사원출력 3.사원정보삭제 4.사원정보수정 5.이름검색 9.시스템종료");

			System.out.println("선택할 항목은? ==>");
			n = Integer.parseInt(sc.nextLine());

			if (n == 1) {
				member.insertMember();
			}
			if (n == 2) {
				member.writeMember();
			}
			if (n == 3) {
				member.deleteMember();
			}
			if (n == 4) {
				member.updateMember();
			}
			if (n == 5) {
				member.searchName();
			}else if (n == 9) {

				System.out.println("*프로그램종료*");
				break;
			}

		}
	}

}
