package day0119;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingLabelRandom_01  extends JFrame implements ActionListener{

	Container cp;
	JLabel[] lblLabel=new JLabel[9];//9개의 주소 할당
	String[] str= {"샌드위치","햄버거","콜라","스프라이트","요거트","스파게티","피자","고르곤졸라","리조또"};
	JButton btn;

	public SwingLabelRandom_01 (String title) { 
		super(title);
		
		cp=this.getContentPane();

		this.setBounds(300, 100, 400, 400);
		cp.setBackground(new Color(255,255,200));
		initDisign();
		this.setVisible(true);
	}
	public void initDisign() 
	{
		//패널을 프레임 센터에 추가/화면
		Panel pCenter=new Panel(new GridLayout(3, 3));//행 나누기 3행3열
		this.add(pCenter,BorderLayout.CENTER);//화면안 화면 가운데위치
		
		//라벨을 패널에 추가
		for(int i=0;i<lblLabel.length;i++)
		{
			lblLabel[i]=new JLabel(str[i],JLabel.CENTER);//글씨를 가운데위치
			
			//초깃값이 랜덤컬러 설정
			int r=(int)(Math.random()*256);
			int g=(int)(Math.random()*256);
			int b=(int)(Math.random()*256);
			lblLabel[i].setBackground(new Color(r,g,b));
		
			//패널에 라벨추가/ pCenter=패널
			pCenter.add(lblLabel[i]);
			//글꼴변경
			lblLabel[i].setFont(new Font("궁서체", Font.BOLD, 15));
			//투명도 설정
			lblLabel[i].setOpaque(true);
		}
		
		//프레임 하단에 버튼 생성 후 추가
		btn=new JButton("라벨색상변경");
		//버튼에 이벤트 추가..하단에 위치하도록 넣기
		this.add(btn,BorderLayout.SOUTH);
		//오버라이드 후 이벤트추가해주기
		btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<lblLabel.length;i++)
		{	//rgb랜덤 컬러 구하기공식
			//rgb컬러는 0~255사이의 색 R,G,B
			int r=(int)(Math.random()*256);
			int g=(int)(Math.random()*256);
			int b=(int)(Math.random()*256);
			lblLabel[i].setBackground(new Color(r,g,b));
			//라벨색상변경 클릭시 랜덤 컬러발생
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new SwingLabelRandom_01("랜덤컬러생성");
	}

}
