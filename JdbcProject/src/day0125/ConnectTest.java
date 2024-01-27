package day0125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTest {

	// 오라클 url변수처리
	static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	public void connectSawon() {
		Connection conn = null;
		Statement stmt = null; // 오라클의
		ResultSet rs = null; // 오라클의 테이블을 읽고서 레코드를 불러옴

		String sql = "select * from sawon order by num";

		try {
			conn = DriverManager.getConnection(URL, "teacher", "a1234");

			stmt = conn.createStatement();// sql문을 전달해주는 메서드
			rs = stmt.executeQuery(sql);// "select * from sawon order by num";

			// sql 여러줄을 가져올 때 while문으로 가져온다
			// (rs.next()): 다음 데이터로 이동하면서 true반환, 더 이상 데이터가 없으면 false반환
			while (rs.next()) {
				// db로부터 데이터 가져오기
				int num = rs.getInt("num");
				// int num=rs.getInt(1);
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				int pay = rs.getInt("pay");

				System.out.println(num + "\t" + name + "\t" + gender + "\t" + buseo + "\t" + pay);
			}

			System.out.println("오라클 드라이버 연결 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("오라클 연결실패");
			// 
			// JRE폴더 오른쪽 버튼 클릭 후
			// build path-> configure build path 클릭 후 폴더 선택해서 업로드
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	
	public void connectshop() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select idx,c.num,sangpum,color,cnt,guipday from shop s,cart2 c where s.num=c.num";
		try {
			conn = DriverManager.getConnection(URL, "teacher", "a1234");
			System.out.println("오라클성공");

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("장바구니 리스트");
			System.out.println("주문번호\t상품번호\t상품명\t색상\t구입갯수\t구입날짜");
			while (rs.next()) {
				int idx = rs.getInt("idx");
				int num = rs.getInt("num");
				String sang = rs.getString("sangpum");
				String color = rs.getString("color");
				int cnt = rs.getInt("cnt");
				String guipday=rs.getString("guipday");

				System.out.println(idx + "\t" + num + "\t" + sang + "\t" + color + "\t" + cnt+"\t"+guipday);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("오라클실패");
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
///////////////////////////////////////////////////////////////////////////////////////
	public void sawonRead()
	{
		//부서별 인원수 평균급여 구하기
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select buseo,count(*) cnt,round(avg(pay),0) pay from sawon group by buseo";
	
		
		try {
			
				conn=DriverManager.getConnection(URL,"teacher","a1234");
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
			
				System.out.println("\t[부서별 평균 인원 및 급여]");
				System.out.println();
				System.out.println("부서명\t인원수\t평균급여");
				System.out.println();
				while(rs.next())
				{
					String buseo=rs.getNString("buseo");
					int count=rs.getInt("cnt");
					int pay=rs.getInt("pay");
					
					System.out.println(buseo+"\t"+count+"명\t"+pay+"원");
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectTest ct = new ConnectTest();
		ct.connectSawon();
		//ct.connectshop();
		//ct.sawonRead();
	}

}
