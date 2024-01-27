package day0118;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Quiz extends JFrame implements ActionListener {

	Container cp;
	JButton[] btn = new JButton[5];
	String[] btnLabel = { "Pink", "black", "white","Gray","Yellow" };
	Color[] btnColors = { Color.PINK, Color.BLACK,Color.WHITE,Color.GRAY,Color.yellow };
	JLabel label1;
	public Quiz(String title) {

		super(title);
		cp=this.getContentPane();
		initDesign();
		this.setBounds(300, 100, 600, 300);
		cp.setBackground(new Color(255,255,200));



		this.setVisible(true);
	}
	public void initDesign() 
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		
		this.add(panel, BorderLayout.NORTH);
		
		for (int i = 0; i < btn.length; i++) 
		{
			
			btn[i] = new JButton(btnLabel[i]);
			
			btn[i].setBackground(btnColors[i]);
			
			panel.add(btn[i]);
			btn[i].addActionListener(this);
		}
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object ob = e.getSource();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Quiz("안녕하세요");
	}
	

}
