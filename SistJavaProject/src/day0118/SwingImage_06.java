package day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingImage_06 extends JFrame implements ActionListener{
	
	Container cp;
	JButton btn1,btn2,btn3,btn4,btn5;
	
	//이미지 아이콘 가져오기
	ImageIcon icon1=new ImageIcon("C:\\sist0403\\Swingimage\\LEFT.GIF");
	ImageIcon icon2=new ImageIcon("C:\\sist0403\\Swingimage\\leftDown.gif");
	ImageIcon icon3=new ImageIcon("C:\\sist0403\\Swingimage\\chick.gif");
	ImageIcon icon4=new ImageIcon("C:\\sist0403\\Swingimage\\an08.gif");
	
	public SwingImage_06 (String title) {
		super(title);
		cp=this.getContentPane();
		

		this.setBounds(300, 100, 300, 300);
		cp.setBackground(new Color(255,255,200));
		
		initDesign();
		
		this.setVisible(true);
	}
	public void initDesign() 
	{
		//2행2열
		this.setLayout(new GridLayout(2,2));
		btn1 = new JButton("hello",icon1);
		btn1.setHorizontalTextPosition(JButton.CENTER);//텍스트가로위치
		btn1.setVerticalTextPosition(JButton.BOTTOM);//텍스트 세로위치
		this.add(btn1);
		
		btn1.setRolloverIcon(icon2);//마우스 올렸을때 보이는부분
		btn1.setPressedIcon(icon3);//클릭했을때 보이는부분
		
		//버튼2
		btn2=new JButton(icon4);
		this.add(btn2);
		
		//버튼3
		btn3=new JButton("스윙버튼");
		this.add(btn3);
		
		//버튼4
		btn4=new JButton("안녕,icon5");
		this.add(btn4);
		
		//오버라이드 생성 후 작성해야함 addActionListener실행 연결되어있다고 알려주는거
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		
		
			
	}
	//implements actionlistenser 생성후 overide
	//화면 버튼클릭했을때 나오는 부분
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btn1)
			JOptionPane.showMessageDialog(this,"안녕");
		else if(ob==btn2)
			JOptionPane.showMessageDialog(this,"2");
		else if(ob==btn3)
			JOptionPane.showMessageDialog(this,"3");
		else if(ob==btn4)
			JOptionPane.showMessageDialog(this,"4");
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingImage_06("이미지버튼");
	}

		
	

}
