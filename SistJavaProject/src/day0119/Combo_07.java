package day0119;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Combo_07 extends JFrame implements ActionListener,ItemListener{
	
	Container cp; 
	JComboBox<String> combo;
	String[]names= {"박나래","전현무","덱스","기안"};
	JTextField tfName;
	JButton btnAdd,btnDel;
	JLabel lblResult;
	
	int idx=-1;//멤버변수는 0을 자동초기화 되는데 0번 삭제를 막기위해서
	
	public Combo_07 (String title) 
	{
		super(title);
		cp=this.getContentPane();

		this.setBounds(300, 100, 400, 400);
		cp.setBackground(new Color(255,255,200));

		initDesign();
		this.setVisible(true);
	}

	public void initDesign()
	{
		this.setLayout(null);
		
		combo=new JComboBox<String>(names);
		combo.setBounds(30,30,100,30);
		this.add(combo);
		
		tfName=new JTextField();
		tfName.setBounds(30,90,80,30);
		this.add(tfName);
		
		btnAdd=new JButton("추가");
		btnAdd.setBounds(150,90,80,30);
		this.add(btnAdd);
		
		btnDel=new JButton("삭제");
		btnDel.setBounds(205, 90, 80, 30);
		this.add(btnDel);
		
		lblResult=new JLabel("Result",JLabel.CENTER);
		lblResult.setBorder(new LineBorder(Color.BLACK,8));
		lblResult.setBounds(20,200,350,60);
		this.add(lblResult);
		
		//이벤트
		combo.addItemListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
	}
	
	public void actionPerformed(ItemEvent e) {
		// TODO Auto-generated method stub
	
		Object ob=e.getSource();
		
		if(ob==btnAdd){
			String text=tfName.getText().trim();
			
			if(text.length()==0) {
			JOptionPane	.showMessageDialog(this, "이름을 입력 후 추가버튼 눌러주세요");
			}
		else {
			combo.addItem(text);//콤보에 추가
			tfName.setText("");//입력값초기화
			lblResult.setText("해당항목을 삭제했습니다");
		}
		}else if(ob==btnDel){
			if(idx==-1)
			{
				JOptionPane.showMessageDialog(this, "삭제할 항목을 선택 후 삭제해주세요");
			}else {
				combo.removeItemAt(idx);
				lblResult.setText("해당항목을 삭제했습니다");
			}
		}
	}

	public void itemStateChanged (ActionEvent e) {
		// TODO Auto-generated method stub
		idx=combo.getSelectedIndex();
		String item=(String)combo.getSelectedItem();
		
		lblResult.setText(idx+"번 인덱스의"+item+"선택됨");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Combo_07 ("콤보문제");
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
