package day0119;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class JTable_05 extends JFrame{
	Container cp;
	JTable tb1,tb2,tb3;
	JTextArea area;

	public JTable_05(String title) {
		super(title);
		cp=this.getContentPane();

		this.setBounds(300, 100, 600, 300);
		cp.setBackground(new Color(255,255,200));

		initDesign();
		this.setVisible(true);
	}
	public void initDesign()
	{
		//2행2열의 grid레이아웃
		this.setLayout(new GridLayout(2, 2, 5, 5));
		
		//1번째 tb은 행,열만 지정
		tb1=new JTable(5,4);
		this.add(new JScrollPane(tb1));//테이블스크롤
		
		//2 tb_생성할때 데이타 넣기
		String [] title1= {"이름","나이","주소"};
		String[][]data1= {{"유라","22","경기"},{"수민","21","부산"},{"기루","23","인천"}};
		
		tb2=new JTable(data1,title1);
		this.add(new JScrollPane(tb2));//JScroll에 넣어서 추가해야할 제목이라 스크롤바가 나타남 
		
		//3 DefaultTableModel을 이용해서 생성(나중에 추가 삭제가 가능하다)
		DefaultTableModel model1=new DefaultTableModel(data1,title1);
		tb3=new JTable(model1);
		this.add(new JScrollPane(tb3));
		
		//추가가능한지 확인
		String[]addData1= {"현재","33","서울시"};
		model1.addRow(addData1);
		
		//이번엔 벡터 생성 후 추가
		Vector<String> addData2=new Vector<String>();
		addData2.add("유재석");
		addData2.add("33");
		addData2.add("제주");
		model1.addRow(addData2);
				
		//area//텍스트
		area=new JTextArea();
		this.add(new JScrollPane(area));
		
		//jTable과 model메서드 확인
		int rowCount=tb3.getRowCount();
		area.append("tb3의 행갯수: "+rowCount+"\n");
		
		int rowCount2=model1.getRowCount();
		area.append("tb3의 행갯수: "+rowCount+"\n");
		
		int columnCount=tb3.getColumnCount();
		area.append("tb3의 열갯수:"+columnCount+"\n");
		
		area.append("1행 1열의 값: "+tb3.getValueAt(1,1)+"\n");
		area.append("3행 2열의 값: "+tb3.getValueAt(1,1)+"\n");
		
		//tb3 마우스클릭이벤트를 추가해서 area에 출력
		tb3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	// TODO Auto-generated method stub
		    	super.mouseClicked(e);
		   
			//클릭한 행번호 얻기
			int row=tb3.getSelectedRow();
			//클릭한 열번호 얻기
			int col=tb3.getSelectedColumn();
			
			//해당 앱,열에 있는 데이타를 업어서 area에 출력
			area.append(row+","+col+"==>"+tb3.getValueAt(row,col)+"\n");
		    }
		});
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JTable_05("스윙테이블");
	}

}
