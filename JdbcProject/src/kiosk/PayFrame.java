package kiosk;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PayFrame extends JFrame {
	
	Container cp;
	JButton cardBtn, cashBtn;
	ImageIcon icon1 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\젊은이.png");
	ImageIcon icon2 = new ImageIcon("C:\\Users\\ssoo9\\OneDrive\\바탕 화면\\123\\서비스.png");
	JLabel lblimage1, lblimage2;
	Paying paying = new Paying("결제중입니다. 잠시만 기다려주세요.");
	
	public PayFrame(String title) {
		super(title);
		cp = this.getContentPane();
		this.setBounds(500, 300, 300, 300);
		cp.setBackground(Color.GREEN);
		initDesign();
		//this.setVisible(true);
		
	}
	
	
	
	public void initDesign() {
		
		this.setLayout(null);
		cardBtn = new JButton("카드결제");
		cashBtn = new JButton("현금결제");
		
		cardBtn.setBounds(30, 200,100, 30);
		cashBtn.setBounds(160, 200,100, 30);
		cardBtn.setBackground(Color.CYAN);
		cashBtn.setBackground(Color.CYAN);
		
		Font font = new Font("맑은 고딕", Font.PLAIN, 12);
		cardBtn.setFont(font);
		cashBtn.setFont(font);
		
		this.add(cardBtn);
		this.add(cashBtn);
		
		lblimage1 = new JLabel(icon1);
		lblimage2 = new JLabel(icon2);
		
		
		lblimage1.setBounds(0,50,200,200);
		lblimage2.setBounds(100,0,200,200);
		this.add(lblimage1);
		this.add(lblimage2);
		
		
		
		
		
		
	}
	



	/*public static void main(String[] args) {
		new PayFrame("결제창");

	} */

}
