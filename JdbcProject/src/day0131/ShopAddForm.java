package day0131;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ShopAddForm extends JFrame implements ActionListener{

	// TODO Auto-generated constructor stub
	JTextField tfSang, tfsu, tfDan;
	JLabel lblPhoto;
	String imageName;
	JButton btnImage, btnInsert;

	// db모델 생성
	ShopDbModel model = new ShopDbModel();
	// 내부클래스
	PhotoDraw photoDraw = new PhotoDraw();

	public ShopAddForm() {
		// TODO Auto-generated constructor stub
		super("추가폼");
		this.setBounds(200, 100, 400, 400);
		initDesign();
		this.setVisible(true);
	}

	public void initDesign() {
		
		this.setLayout(null);
		
		JLabel lbl1=new JLabel("상품명");
		lbl1.setBounds(30, 10, 60, 30);
		this.add(lbl1);
		
		tfSang=new JTextField();
		tfSang.setBounds(110,10,100,30);
		this.add(tfSang);
		
		
		JLabel lbl2=new JLabel("사진선택");
		lbl2.setBounds(30, 60, 60, 30);
		this.add(lbl2);
		
		btnImage=new JButton("사진선택");
		btnImage.setBounds(110,60,100,30);
		this.add(btnImage);
		btnImage.addActionListener(this);
		
		//이미지추가
		photoDraw.setBounds(250,10,80,90);
		this.add(photoDraw);
		
		//이미지명
		lblPhoto=new JLabel("이미지명");
		lblPhoto.setBorder(new LineBorder(Color.PINK));
		lblPhoto.setBounds(20,120,300,30);
		this.add(lblPhoto);
		
		//수량
		JLabel lbl3=new JLabel("수량");
		lbl3.setBounds(30,150,50,30);
		this.add(lbl3);
		
		tfsu=new JTextField();
		tfsu.setBounds(110,150,50,30);
		this.add(tfsu);
		
		//단가
		JLabel lbl4=new JLabel("단가");
		lbl4.setBounds(30,190,70,30);
		this.add(lbl4);
		
		tfDan=new JTextField();
		tfDan.setBounds(110,190,70,30);
		this.add(tfDan);
		
		//db추가버튼
		btnInsert=new JButton("db추가");
		btnInsert.setBounds(150, 240, 100, 30);
		btnInsert.addActionListener(this);
		this.add(btnInsert);
	}

	// 내부클래스 ..이미지삽입
	class PhotoDraw extends Canvas {
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			if(imageName!=null)
			{
				Image image=new ImageIcon(imageName).getImage();
				g.drawImage(image, 10, 10, 60, 70,this);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	//사진불러오가
		Object ob=e.getSource();
		
		if(ob==btnImage)
		{
			FileDialog dlg=new FileDialog(this, "이미지 가져오기",FileDialog.LOAD);
			dlg.setVisible(true);
			
			//취소누르면 메서드 종료
			if(dlg.getDirectory()==null)
				return;
			//이미지명 얻기
			imageName=dlg.getDirectory()+dlg.getFile();
			
			//라벨에 이미지명 출력
			lblPhoto.setText(imageName);
			
			//이미지출력
			photoDraw.repaint();
		}
		else if(ob==btnInsert)
		{
			//shoDto생성
			ShopDto dto=new ShopDto();
			
			//dtodp 4개의 데이터를 넣는다
			dto.setSangpum(tfSang.getText());
			dto.setPhoto(imageName);
			dto.setSu(Integer.parseInt(tfsu.getText()));
			dto.setDan(Integer.parseInt(tfDan.getText()));
			
			//db모델에서 insert메서드 호출
			model.insertShop(dto);
			
			this.setVisible(false);
		}
	}
	
	
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 화면확인용
	//	new ShopAddForm();
	//}

}
