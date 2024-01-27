package day0119;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SwingTable extends JFrame{
	
	Container cp; 
	
	JTable table;//행과열이 있는 형태/다중배열
	JLabel lblTitle,lblOut;
	
	public SwingTable(String title) 
	{
		super(title);

		cp=this.getContentPane();

		initDesign();
		this.setBounds(300, 100, 600, 300);
		cp.setBackground(new Color(255,255,200));
		this.setVisible(true);
	}
	
	public void initDesign() //다중배열 행과열 만들어주기
	{
		String [][] data= {
				{"송혜교","서울","010-222-3333"},
				{"박보영","부산","010-888-9999"},
				{"이효리","인천","010-888-6666"}
		};
		String []title= {"이름","주소","연락처"};
		
		lblTitle=new JLabel("제이라벨 연습",JLabel.CENTER);
		lblOut=new JLabel("결과출력하는곳",JLabel.CENTER);
		
		table=new JTable(data, title);
		JScrollPane pane=new JScrollPane(table);
		
		//테이블에 마우스 이벤트 추가
		table.addMouseListener(new TableEvent());//테이블 다중상속
		
		this.add("North",lblTitle);
		this.add("Center",pane);
		this.add("South",lblOut);
		
	}
	//내부클래스 생성 //마우스클릭드를 만들기 위함
	class TableEvent extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseClicked(e);
			
			//System.out.println("테이블출력");
			//선택한 행번호 얻기
			int rowNum=table.getSelectedRow();
			
			//JOptionPane.showMessageDialog(SwingTable.this,"행번호: "+rowNum);
			String str="이름: "+table.getValueAt(rowNum,0)
							+",주소:"+table.getValueAt(rowNum,1)
							+",핸드폰: "+table.getValueAt(rowNum,2);
			lblOut.setText(str);
		
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new SwingTable ("스윙테이블");
			
	}

}
