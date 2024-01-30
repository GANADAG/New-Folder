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
	////////////////////////insert
	public void insertData()
	{
		String name=addForm.tfName.getText();//작성한 이름을 가지고옴
		String java=addForm.tfJava.getText();//작성한 이름을 가지고옴
		String jsp=addForm.tfJsp.getText();//작성한 이름을 가지고옴
		String spring=addForm.tfSpring.getText();//작성한 이름을 가지고옴
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
			System.out.println("del");
		}
		else if(ob==btnUpdate)
		{
			System.out.println("update");
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingJdbcScore("학생성적관리DB");
	}

}
