package day0119;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SwingRadioCheck_02 extends JFrame implements ActionListener{

	Container cp;
	JRadioButton[]rb=new JRadioButton[4];//하나만 선택하고 싶을때
	JCheckBox[]cb=new JCheckBox[4];
	Color[] Colors= {Color.RED,Color.GREEN,Color.BLUE,Color.DARK_GRAY};
	JLabel lblMessage;
	
	public  SwingRadioCheck_02(String title){
		super(title);
		cp=this.getContentPane();

		this.setBounds(300, 100, 400, 400);
		cp.setBackground(new Color(255,255,200));

		initDesign();
		this.setVisible(true);
	}
	public void initDesign() 
	{
		//상단패널 보더로 감싼 4개의 라디오버튼
		String[]str1= {"red","Green","Blue","Dark_Gray"};//상단에 뜨는글자
		JPanel pTop=new JPanel();
		pTop.setBorder(new TitledBorder("글자색"));
		
		this.add(pTop,BorderLayout.NORTH);	//this.add("North",pTop);
		
		//라디오 하나만 선택되도록 하려면 그룹을 지어줘야함
		//라디오 버튼에 대한 계산
		ButtonGroup bg=new ButtonGroup();
		
		for(int i=0;i<rb.length;i++)
		{
			rb[i]=new JRadioButton(str1[i],i==2?true:false);//처음에 체크되어있는 디폴트값 넣어주기,라디오 버튼생성(텍스트,기본체크)
			pTop.add(rb[i]); //탑패널에 추가
			bg.add(rb[i]);	//버튼그룹에 추가
			rb[i].addActionListener(this);
		}
		//가운데 라벨
		lblMessage=new JLabel("안녕하세요 즐거운 금요일",JLabel.CENTER);
		this.add("Center",lblMessage);
		lblMessage.setBorder(new LineBorder(Color.RED,2));//테두리 라인굵기
		
		//하단패널에 보더로감싼 4개의 체크박스 만들기
		JPanel pBottom=new JPanel();
		pBottom.setBorder(new TitledBorder("가능언어"));
		this.add("South",pBottom);
		
		String[] str2= {"자바","오라클","HTML","JSP"};
		
		for(int i=0;i<cb.length;i++)
		{
			cb[i]=new JCheckBox(str2[i]);
			cb[i].addActionListener(this);
			pBottom.add(cb[i]);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		
		//라디오버튼 호출처리,메세지출력이 컬러별로 출력되도록
		for(int i=0;i<rb.length;i++)
		{
			if(ob==rb[i])
			{
				lblMessage.setForeground(Colors[i]);
				lblMessage.setFont(new Font("",Font.BOLD,22));
				
			}
		}
		//체크박스 호출처리(다중선택:자바 JSP)
		String msg="";
		
		for(int i=0;i<cb.length;i++)
		{
			if(cb[i].isSelected()==true)
			{
				msg+=cb[i].getText()+" ";
			}
		}
		
		lblMessage.setText(msg);
		lblMessage.setFont(new Font("",Font.BOLD,22));
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingRadioCheck_02("스윙 라디오 체크박스");
	}
	
}
