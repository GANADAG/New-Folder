package day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingBtnEvent_05 extends JFrame implements ActionListener{
	
	Container cp;
	JButton btn1,btn2;
	
	public SwingBtnEvent_05(String Title) {
		// TODO Auto-generated constructor stub
		super(Title);
		cp=this.getContentPane();
		
		this.setBounds(300, 100, 300, 300);
		cp.setBackground(new Color(255,255,200));
		
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign() 
	{
		this.setLayout(new FlowLayout());
		
		btn1=new JButton("1");
		btn2=new JButton("2");
		
		//버튼색상
		btn1.setBackground(Color.PINK);
		btn2.setBackground(Color.ORANGE);
		//글자색상
		btn1.setForeground(Color.BLACK);
		btn2.setForeground(Color.BLACK);
		
		//이벤트객체
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		//이벤트객체 this add와 연결 
		this.add(btn1);//컴포넌트
		this.add(btn2);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btn1)
			JOptionPane.showMessageDialog(this,"클릭");
		else if(ob==btn2)
			JOptionPane.showMessageDialog(this,"클릭");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingBtnEvent_05("버튼이벤트5");
	}



}
