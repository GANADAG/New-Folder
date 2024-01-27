package day0118;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SwingArrEvent_08 extends JFrame implements ActionListener {

	Container cp;
	JButton[] btn = new JButton[6];
	String[] btnLabel = { "Red", "Green", "Blue", "Magenta", "Gray", "Yellow" };
	Color[] btnColors = { Color.PINK, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.GRAY, Color.YELLOW };

	public SwingArrEvent_08(String title) {
		super(title);
		cp = this.getContentPane();

		this.setBounds(300, 100, 600, 300);
		cp.setBackground(new Color(255, 255, 200));
		initDesign();
		this.setVisible(true);
	}

	// 디자인단계
	public void initDesign() {
		// panel은 기본이 flowlayout
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);

		this.add(panel, BorderLayout.NORTH);// 프에임의 상단에 패널배치

		// 버튼생성
		for (int i = 0; i < btn.length; i++) {
			// 버튼 6개생성
			btn[i] = new JButton(btnLabel[i]);
			// 버튼6개에 각가의 버튼색상변경(btnColors)
			btn[i].setBackground(btnColors[i]);
			// panel에 버튼6개 추가
			panel.add(btn[i]);

			// 오버라이드 후 버튼 6개의 이벤트추가
			btn[i].addActionListener(this);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ob = e.getSource();
		
		for (int i = 0; i < btn.length; i++) 
		{
			if (ob == btn[i])
			{   
				// 각각의 버튼을 누르면 프레임의 배경색 변경
				cp.setBackground(btnColors[i]);
				//창제목변경 (Color:Red..)
				this.setTitle("Color: "+btnLabel[i]);
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingArrEvent_08("배열버튼 이벤트");
	}

}
