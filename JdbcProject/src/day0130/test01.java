package day0130;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import OrcleDb.DbConnect;

/*public class test01 extends JFrame implements ActionListener{
	
	DbConnect db=new DbConnect();
	Container cp;
	
	JTable table;
	JButton btnAdd,btnDel,btnUpdate;
	
	DefaultTableModel model;
	
	
	
	public test01(String title)
	{
		super(title);
		cp=this.getContentPane();
		this.setBounds(100, 100, 400, 300);
		cp.setBackground(new Color(255,255,200));
		
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		String []title= {"번호","이름","반","Java","jsp","Spring","총점","평균"};
		
		model=new DefaultTableModel(title,0);
		table=new JTable(model);
		this.add("Center",new JScrollPane(table));
		
		JPanel pTop=new JPanel();
		this.add("North",pTop);
		
		btnAdd=new JButton("추가");
		btnAdd.addActionListener(this);
		pTop.add(btnAdd);
		
	
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test01("학생성적관리");
	}

}*/
