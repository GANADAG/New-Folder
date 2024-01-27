package day0118;

import java.awt.Color;

import javax.swing.JFrame;

//상속이 기본
public class SwingGibon_01 extends JFrame{

	public SwingGibon_01(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		//**기본프레임**
		
		//1.시작위치,너비,높이 setBounds
		this.setBounds(500, 100, 300, 300);
		//2.배경색
		//윈도우에 있는 또하나의 필름같은것을 얻음으로써 =색상지정 가능 
		//this.getContentPane().setBackground(Color.BLACK);//스타틱색상
		this.getContentPane().setBackground(new Color(188,240,207));//rgb컬러
		
		//3.프레임에 보이게 setVisible
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingGibon_01("스윙기본");
	}

}
