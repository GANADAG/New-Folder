package kiosk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Paying extends JFrame {

	Container cp;
	JLabel lbl1, lbl2, lbl3, lbl4, lbl5;
	JButton btn1;
	

	Icon icon1 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\paying.png");

	public Paying(String title) {
		super(title);

		cp = this.getContentPane();

		this.setBounds(200, 10, 970, 700);
		cp.setBackground(new Color(255, 204, 182));

		initDesign();

		// this.setVisible(true);
	}

	public void initDesign()

	{
		btn1 = new JButton("PAY");
		btn1.setBounds(350, 510, 200, 50);
		cp.add(btn1);
		btn1.setBackground(new Color(198, 219, 218));

		this.setLayout(null);

		lbl1 = new JLabel("Lamyen House house", JLabel.CENTER);
		lbl1.setBounds(100, 100, 100, 100);
		// lbl1.setBackground(Color.GRAY);
		// lbl1.setOpaque(true);
		this.add(lbl1);

		lbl2 = new JLabel("", JLabel.CENTER);
		lbl1.setBounds(350, 150, 200, 40);
		lbl1.setOpaque(true);
		this.add(lbl2);

		lbl3 = new JLabel("'Order completed'", icon1, JLabel.CENTER);
		lbl3.setBounds(300, 200, 300, 300);
		lbl3.setBorder(new TitledBorder("LeeSon"));
		this.add(lbl3);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");

		lbl4 = new JLabel(sdf.format(new Date()), JLabel.CENTER);
		lbl4.setBounds(350, 500, 200, 200);
		lbl4.setBackground(new Color(200, 200, 110));
		this.add(lbl4);

		lbl5 = new JLabel("카드삽입후, PAY 버튼을 눌러주세요.");
		lbl5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lbl5.setBounds(350, 50, 200, 50);
		lbl5.setForeground(Color.BLUE);
		lbl5.setOpaque(false);
		this.add(lbl5);

		

	}

	

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * new Paying("LamyenKiosk"); }
	 */

}