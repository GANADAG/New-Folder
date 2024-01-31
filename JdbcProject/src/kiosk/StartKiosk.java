package kiosk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class StartKiosk extends JFrame implements ActionListener {
	Container cp;
	JButton btn1;
	JLabel lbl, lbl1, lbl2;

	Icon icon1 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\메인라면.png");
	Icon icon2 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\할아버지2.gif");
	
	Ramyen ramyen = new Ramyen();

	public StartKiosk(String title) {
		super(title);

		// 시작위치,너비,높이
		this.setBounds(200, 10, 970, 700);
		// 배경색
		// this.getContentPane().setBackground(Color.CYAN); //static 상수를 이용한 색상
		this.getContentPane().setBackground(new Color(240, 220, 200)); // RGB 컬러

		initDesign();
		// 프레임에 보이게
		this.setVisible(true);

	}

	public void initDesign() {

		btn1 = new JButton("Order Here");

		btn1.setFocusPainted(false);
		btn1.setBorderPainted(false);
		btn1.setForeground(Color.DARK_GRAY);
		btn1.setFont(btn1.getFont().deriveFont(20f));
		btn1.setBackground(new Color(200, 200, 110));
		btn1.setMargin(new java.awt.Insets(10, 30, 10, 30));

		this.add(btn1, BorderLayout.SOUTH);

		lbl = new JLabel("Welcome To Lamyen House", icon2, JLabel.CENTER);
		lbl.setBounds(0, 180, 970, 100);
		// lbl.setBorder(new TitledBorder("songleeson"));
		lbl.setBackground(new Color(230, 230, 200));
		lbl.setFont(lbl.getFont().deriveFont(22f));
		// lbl.setOpaque(true);

		this.add(lbl);

		lbl2 = new JLabel("", icon1, JLabel.CENTER);
		lbl2.setBounds(10, 150, 200, 30);
		lbl2.setOpaque(true);
		this.add(lbl2);

		btn1.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==btn1) {
			this.setVisible(false);
			ramyen.setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StartKiosk("LamyenKiosk");

	}

}