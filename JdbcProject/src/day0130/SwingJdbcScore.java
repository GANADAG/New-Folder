/*package day0130;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import OrcleDb.DbConnect;
public class SwingJdbcScore extends JFrame implements ActionListener{
	
	DbConnect db=new DbConnect();
	Container cp;
	
	//추가삭제를 해야 할 일이 있을때
	DefaultTableModel model;
	JTable table;
	JButton btnAdd,btnDel,btnUpdate;
	
	AddStuInfo addForm=new AddStuInfo("성적추가");
	UpdateStuInfo updateForm=new UpdateStuInfo("수정");
	
	//생성자1
	public SwingJdbcScore(String title) {
		// TODO Auto-generated constructor stub
		
		super(title);
		cp=this.getContentPane();
		this.setBounds(200, 100, 400, 300);
		cp.setBackground(new Color(255,255,100));
		initDesign();
		this.setVisible(true);
	}
	///////////테이블에 출력하는 메서드
	//오버라이드 후 4
	public void tableWrite()
	{
		//테이블초기화
		model.setRowCount(0);//테이블에 하나도 없다
		
		//db연결
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;//조회,출력하는.. 테이블을 그대로 가져오는것 //업데이트에는 필요없음
		
		String sql="select * from stuinfom order by num";
		
		conn=db.getOracle();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//데이터불러오기
			while(rs.next())
			{	//배열과는다름 //컬렉션 객체를 통해서 무한대로 추가시켜줌
				Vector<String> data=new Vector<String>();
				
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("ban"));
				data.add(rs.getString("java"));
				data.add(rs.getString("jsp"));
				data.add(rs.getString("spring"));
				data.add(rs.getString("total"));
				data.add(rs.getString("average"));
				
				//테이블에 추가 .. 열대로 한꺼번에 추가 되게끔..데이터가 더이상 없을때까지
				model.addRow(data);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	////////////////////////insert7
	public void insertData()
	{
		String name=addForm.tfName.getText();//작성한 이름을 가지고옴
		String java=addForm.tfJava.getText();
		String jsp=addForm.tfJsp.getText();
		String spring=addForm.tfSpring.getText();
		String ban=(String)addForm.cbBan.getSelectedItem();
	
		int tot=Integer.parseInt(java)+Integer.parseInt(jsp)+Integer.parseInt(spring);
		double avg=tot/3.0;
		String sql="insert into stuinfom values(seq1.nextval,?,?,?,?,?,?,?)";
		
		//db연결,sql문전송 
		Connection conn=db.getOracle();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//물음표 순서대로 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, java);
			pstmt.setString(3, jsp);
			pstmt.setString(4, spring);
			pstmt.setInt(5, tot);
			pstmt.setDouble(6, avg);
			pstmt.setString(7, ban);
			//업데이트
			pstmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	////////////////////8delete
	public void deleteData(String num)
	{
		String sql="delete from stuinfom where num="+num;
		
		//sql문 실행 후 해당번호가 없으면 메세지 삭제되면 tableWrite()호출
		Connection conn=db.getOracle();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			int a=pstmt.executeUpdate();
			
			if(a==0)
				JOptionPane.showMessageDialog(this, "없는 데이타 번호입니다");
			else
				tableWrite();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			db.dbClose(pstmt, conn);
		}
		
	}
	//디자인2
	public void initDesign() 
	{
		String []title= {"번호","이름","반","Java","Jsp","Spring","총점","평균"};
		//테이블 만들어 올림
		model=new DefaultTableModel(title,0);//수정 삭제 필요시 작성부분
		table=new JTable(model);
		this.add("Center", new JScrollPane(table));
		//테이블에 db데이타 출력부분
		this.tableWrite();
		
		//버튼3개 올릴 패널
		JPanel pBottom=new JPanel();
		this.add("North",pBottom);
		
		//추가버튼 만들기 액션대상
		btnAdd=new JButton("추가");
		btnAdd.addActionListener(this);//임ㅍ
		pBottom.add(btnAdd);
		
		//추가폼에 있는 추가버튼에 액션 추가
		addForm.btnAdd.addActionListener(this);
		
		//수정폼에 있는 수정버튼에 액션추가
		updateForm.btnMod.addActionListener(this);
		
		btnDel=new JButton("삭제");
		btnDel.addActionListener(this);
		pBottom.add(btnDel);
		
		btnUpdate=new JButton("수정");
		btnUpdate.addActionListener(this);
		pBottom.add(btnUpdate);
	}
	//3
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		
		if(ob==btnAdd)
		{//실제 코드는 여기서
			//System.out.println("add");
			addForm.setVisible(true);//에드폼이 보여지도록 	
		}
		else if(ob==addForm.btnAdd)//학생추가폼의 버튼이벤트
		{
			//입력하는 데이타를 읽어서 db추가
			insertData();//db에 들어간거 확인
			
			//테이블 다시 출력
			this.tableWrite();
			
			//초기화 하면서 추가폼은 사라지게
			addForm.tfName.setText("");
			addForm.tfJava.setText("");
			addForm.tfJsp.setText("");
			addForm.tfSpring.setText("");
			
			addForm.setVisible(false);
		}	
		else if(ob==btnDel)
		{
			//System.out.println("del");
			//다이얼로그 입력창
			String num=JOptionPane.showInputDialog("삭제할 시퀀스를 입력하세요");
             //삭제메서트 호출
			deleteData(num);
			
		}
		else if(ob==btnUpdate)
		{
			//System.out.println("update");
			String num=JOptionPane.showInputDialog("수정할 시퀀스를 입력해 주세요");
			
			String sql="select * from stuinfo where num="+num;
			
			Connection conn=db.getOracle();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				updateForm.tfName.setText(rs.getString("name"));
				updateForm.tfJava.setText(rs.getString("java"));
				updateForm.tfJsp.setText(rs.getString("jsp"));
				updateForm.tfSpring.setText(rs.getString("spring"));
				updateForm.cbBan.setSelectedItem(ob);;
			}
			}catch(SQLException e1) {
				e1.addSuppressed(e1);
			}finally {
				db.dbClose(pstmt, conn);
			}
		
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingJdbcScore("학생성적관리DB");
	}

}*/

package day0130;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import OrcleDb.DbConnect;

public class SwingJdbcScore extends JFrame implements ActionListener {

	DbConnect db = new DbConnect();
	Container cp;

	DefaultTableModel model;
	JTable table;
	JButton btnAdd, btnDel, btnUpdate;

	AddStuInfo addForm = new AddStuInfo("성적추가");
	UpdateStuInfo updateForm = new UpdateStuInfo("데이타 수정");

	// 생성자
	public SwingJdbcScore(String title) {

		super(title);
		cp = this.getContentPane();
		this.setBounds(300, 100, 400, 300);
		cp.setBackground(new Color(255, 255, 200));
		initDesign();
		this.setVisible(true);
	}

	/////////////////////////////// 테이블에 출력하는 메서드
	public void tableWrite() {
		// 테이블초기화
		model.setRowCount(0);

		// db연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from stuinfom order by num";

		conn = db.getOracle();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<String> data = new Vector<String>();

				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("ban"));
				data.add(rs.getString("java"));
				data.add(rs.getString("jsp"));
				data.add(rs.getString("spring"));
				data.add(rs.getString("total"));
				data.add(rs.getString("average"));

				// 테이블에 추가
				model.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

	}

	/////////////////////////////// insert
	public void insertData() {
		String name = addForm.tfName.getText();
		String java = addForm.tfJava.getText();
		String jsp = addForm.tfJsp.getText();
		String spring = addForm.tfSpring.getText();
		String ban = (String) addForm.cbBan.getSelectedItem();

		int tot = Integer.parseInt(java) + Integer.parseInt(jsp) + Integer.parseInt(spring);
		double avg = tot / 3.0;

		String sql = "insert into stuinfom values(seq1.nextval,?,?,?,?,?,?,?)";

		// db연결.sql문전송
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			// ?순서대로 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, java);
			pstmt.setString(3, jsp);
			pstmt.setString(4, spring);
			pstmt.setInt(5, tot);
			pstmt.setDouble(6, avg);
			pstmt.setString(7, ban);

			// 업데이트
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	////////////////////////// delete
	public void deleteData(String num) {
		String sql = "delete from stuinfom where num=" + num;

		// sql문 실행후 해당번호가 없으면 메세지 삭제되면 tableWrite()호출
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			int a = pstmt.executeUpdate();

			if (a == 0)
				JOptionPane.showMessageDialog(this, "없는 데이타 번호입니다");
			else
				tableWrite();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	//////////////////////////////update
	public void updateData()
	{
		String num=updateForm.num;//보이지 않는 넘버값추가 인서트와 차이점
		
		String name = updateForm.tfName.getText();
		String java = updateForm.tfJava.getText();
		String jsp = updateForm.tfJsp.getText();
		String spring = updateForm.tfSpring.getText();
		String ban = (String) updateForm.cbBan.getSelectedItem();
		
		int tot = Integer.parseInt(java) + Integer.parseInt(jsp) + Integer.parseInt(spring);
		double avg = tot / 3.0;
		
		String sql="update stuinfom set name=?,java=?,jsp=?,spring=?,total="+tot+",average="+avg+",ban=? where num=?";
		System.out.println(sql);
		//db연결
		Connection conn=db.getOracle();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?차례대로 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, java);
			pstmt.setString(3, jsp);
			pstmt.setString(4, spring);
			pstmt.setString(5, ban);
			pstmt.setString(6, num);
			
			//업데이트
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	////////////////////////////////// 디자인
	public void initDesign() {
		String[] title = { "번호", "이름", "반", "Java", "Jsp", "Spring", "총점", "평균" };

		model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		this.add("Center", new JScrollPane(table));

		// 테이블에 db데이타 출력
		tableWrite();

		// 버튼3개 올릴 패널
		JPanel pTop = new JPanel();
		this.add("North", pTop);

		// 추가버튼
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pTop.add(btnAdd);

		// 추가폼에 있는 추가버튼에 액션 추가
		addForm.btnAdd.addActionListener(this);

		// 수정폼에 있는 수정버튼에 액션추가
		updateForm.btnMod.addActionListener(this);

		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		pTop.add(btnDel);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pTop.add(btnUpdate);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();

		if (ob == btnAdd) {
			// System.out.println("add");
			addForm.setVisible(true);

		} else if (ob == addForm.btnAdd) // 학생추가폼의 버튼이벤트
		{
			// 입력하는 데이타를 읽어서 db추가
			insertData(); // db에 들어간거 확인

			// 테이블 다시 출력
			this.tableWrite();

			// 초기화 하면서 추가폼은 사라지게
			addForm.tfName.setText("");
			addForm.tfJava.setText("");
			addForm.tfJsp.setText("");
			addForm.tfSpring.setText("");

			addForm.setVisible(false);
		}

		else if (ob == btnDel) {
			// System.out.println("del");
			// 다이얼로그 입력창
			String num = JOptionPane.showInputDialog("삭제할 시퀀스를 입력해 주세요");

			// 삭제메서드 호출
			deleteData(num);

		} else if (ob == btnUpdate) {
			// System.out.println("update");
			String num = JOptionPane.showInputDialog("수정할 시퀀스를 입력해 주세요");

			String sql = "select * from stuinfom where num=" + num;

			Connection conn = db.getOracle();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				// 데이타 하나 조회 if
				if (rs.next()) {
					updateForm.num = num;
					updateForm.tfName.setText(rs.getString("name"));
					updateForm.tfJava.setText(rs.getString("java"));
					updateForm.tfJsp.setText(rs.getString("jsp"));
					updateForm.tfSpring.setText(rs.getString("spring"));
					updateForm.cbBan.setSelectedItem(rs.getString("ban"));

					updateForm.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(this,"해당번호는 없는 번호입니다");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				db.dbClose(rs, pstmt, conn);
			}
		}else if(ob==updateForm.btnMod)//수정폼의 수정버튼
		{
			updateData();
			tableWrite();
			updateForm.setVisible(false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new SwingJdbcScore("학생성적관리DB");
	}

}
