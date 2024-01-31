package day0131;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//ActionListener 생성 후 actionPerformed 생성해야함
public class ShopMain extends JFrame implements ActionListener {

	JButton btnAdd, btnDel, btnUpdate, btnList;

	public ShopMain() {
		// TODO Auto-generated constructor stub
		super("shopMain");
		this.setBounds(200, 100, 400, 400);
		initDesign();
		this.setVisible(true);
	}

	public void initDesign() {
		this.setLayout(new GridLayout(2, 2));
		btnAdd = new JButton("상품추가");
		btnDel = new JButton("상품삭제");
		btnUpdate = new JButton("상품수정");
		btnList = new JButton("상품목록");

		this.add(btnAdd);
		this.add(btnDel);
		this.add(btnUpdate);
		this.add(btnList);

		// 이벤트
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnList.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();

		if (ob == btnAdd) {
			//System.out.println("add");
			ShopAddForm add=new ShopAddForm();
		} else if (ob == btnDel) {
			System.out.println("del");
		} else if (ob == btnUpdate) {
			System.out.println("update");
		} else if (ob == btnList) {
			System.out.println("list");
			ShopListForm listForm=new ShopListForm();		
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ShopMain();
	}

}
