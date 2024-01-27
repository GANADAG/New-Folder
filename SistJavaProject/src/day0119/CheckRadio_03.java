package day0119;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class CheckRadio_03 extends JFrame implements ActionListener,ItemListener{
	Container cp;
	JCheckBox[]cbHobby=new JCheckBox[4];
	JCheckBox cbDriver;
	JCheckBox cbBold;
	JButton btnHobby;
	JLabel lblResult;

	public CheckRadio_03(String title) {
		super(title);
		
		cp=this.getContentPane();

		this.setBounds(300, 100, 400, 300);
		cp.setBackground(new Color(255,255,200));

		initDesign();

		this.setVisible(true);
		
	}
	public void initDesign()
	{
		this.setLayout(null);//원하는곳에 지정
		
		cbDriver=new JCheckBox("운전면허");
		cbDriver.setBounds(20,20,100,30);
		cbDriver.setOpaque(false);
		cbDriver.addItemListener(this);//아이템리스너 이벤트 핸들러와 연결되는 객체임을 표시
		this.add(cbDriver);
		
		//글꼴굵게 체크박스
		cbBold=new JCheckBox("글씨굵게");
		cbBold.setBounds(20, 60, 100, 30);
		cbBold.setOpaque(false);
		cbBold.addItemListener(this);
		this.add(cbBold);
				
		lblResult=new JLabel("Have a Nice Day",JLabel.CENTER);
		lblResult.setBounds(20, 200, 300, 50);
		lblResult.setBorder(new LineBorder(Color.GREEN,5));
		this.add(lblResult);
		
		
		
		
		//취미체크박스
		String[]hobbys= {"여행","게임","영화","코딩"};
		int xpos=20;
		
		for(int i=0;i<cbHobby.length;i++)
		{
			cbHobby[i]=new JCheckBox(hobbys[i]);
			cbHobby[i].setBounds(xpos, 80, 80, 30);
			cbHobby[i].setOpaque(false);
			this.add(cbHobby[i]);
			xpos+=80;
		}
		//글씨굵게 체크박스
		
		
		
		//버튼
		btnHobby=new JButton("나의취미출력");
		btnHobby.setBounds(60, 140, 200, 30);
		this.add(btnHobby);
		
		btnHobby.addActionListener(this);//버튼에 이벤트 추가		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		
		if(ob==btnHobby)
		{
			String s="나의취미는 ";
			int select=0;
			
			for(int i=0;i<cbHobby.length;i++)
			{
				if(cbHobby[i].isSelected())
				{
					select++;
					s+="["+cbHobby[i].getText()+"]";
					
				}
			}
			if(select==0)
				s+=" 없어요";
			else
				s+= " 입니다";
			
			//라벨에출력
			lblResult.setText(s);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new CheckRadio_03 ("체크박스3");
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		//체크박스 오버로딩
		Object ob=e.getSource();
		
		if(ob==cbDriver)
		{
			String s="체크상태: "+cbDriver.isSelected()+" ,텍스트: "+cbDriver.getText();
			lblResult.setText(s);
		}else if(ob==cbBold)
		{
			if(cbBold.isSelected())//체크했을때 나오는 값에 따라 정해짐
				lblResult.setFont(new Font("",Font.BOLD,20));
			else
				lblResult.setFont(new Font("", Font.PLAIN,13));
		}
	}


}
