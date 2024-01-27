package day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEvent_07 extends JFrame
{
	
	Container cp;
	JButton btn1,btn2; 
	
	
	public SwingEvent_07 (String title)
	{
		super(title);
		
		cp=this.getContentPane();
		
		this.setBounds(300, 100, 300, 300);
		cp.setBackground(new Color(255,255,200));
		initdisign();
		this.setVisible(true);
	}
	
	public void initdisign() 
	{
		//flow레이아웃으로 버튼 2개생성
		//버튼색상 그레이로 변경,버튼색상
		this.setLayout(new FlowLayout());
		
		btn1=new JButton("버튼색상 그레이로 변경");
		btn2=new JButton("버튼색상 그린으로 변경");
		
		this.add(btn1);
		this.add(btn2);
		
		//버튼1생성 및 이벤트진행(익명내부클래스)
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//1첫번째방법.getContentPane().setBackground(Color.GRAY);
				cp.setBackground(Color.GRAY);//2.
		
	 btn2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cp.setBackground(Color.GREEN);
		}
	});
				
			}
		});
		
		
	}

	public static void main(String[] args) 
	{
		
		new  SwingEvent_07("버튼이벤트");
	}

}
