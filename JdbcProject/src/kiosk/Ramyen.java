package kiosk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import OrcleDb.DbConnect;

public class Ramyen extends JFrame implements ActionListener {

	DbConnect db = new DbConnect();

	Container cp;
	JPanel topPanel, centerPanel, bottomPanel;
	JButton[] topBtn = new JButton[4];
	String[] btnStr = { "라면", "토핑", "음료수", "원산지"};
	JButton[] bottomBtn = new JButton[4];
	String[] bottomStr = { "결제할금액", "담은메뉴", "전체취소", "결제하기" };

	JLabel[] menuImage = new JLabel[18];
	JButton[] menuGetBtn = new JButton[18];
	JLabel[] lblMenu = new JLabel[18];
	JLabel[] lblPrice = new JLabel[18];
	String[] strMenu = { "신라면", "너구리", "진라면 순한맛", "진라면 매운맛", "안성탕면", "무파마", "열라면", "진짬뽕", "튀김우동", "사리곰탕", "불닭볶음면",
			"팔도비빔면", "공기밥", "군만두", "떡", "김치", "콜라", "사이다", };
	int[] price = { 3000, 3000, 2500, 2500, 2500, 3000, 3000, 3500, 2500, 2500, 2000, 2000, 1000, 3500, 1500, 0, 2000,
			2000 };

	Font font = new Font("맑은 고딕", Font.BOLD, 12);

	int[] totalPrice = new int[menuGetBtn.length];
	final int[] clickCount = new int[menuGetBtn.length]; // 각 버튼의 클릭 횟수를 저장하는 배열
	AtomicInteger sum = new AtomicInteger(0);
	int index;

	ImageIcon icon1 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\신라면.png");
	ImageIcon icon2 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\너구리.png");
	ImageIcon icon3 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\진라면순한맛.png");
	ImageIcon icon4 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\진라면매운맛.png");
	ImageIcon icon5 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\안성탕면.png");
	ImageIcon icon6 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\무파마.png");
	ImageIcon icon7 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\열라면.png");
	ImageIcon icon8 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\진짬뽕.png");
	ImageIcon icon9 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\튀김우동.png");
	ImageIcon icon10 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\사리곰탕.png");
	ImageIcon icon11 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\불닭볶음면.png");
	ImageIcon icon12 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\팔도비빔면.png");
	ImageIcon icon13 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\공기밥.png");
	ImageIcon icon14 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\군만두.png");
	ImageIcon icon15 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\떡.png");
	ImageIcon icon16 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\김치.png");
	ImageIcon icon17 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\콜라.png");
	ImageIcon icon18 = new ImageIcon("C:\\Users\\dlw08\\OneDrive\\바탕 화면\\123\\사이다.png");

	PayFrame payframe = new PayFrame("결제수단 선택창");
	Paying paying = new Paying("결제중입니다. 잠시만 기다려주세요.");

	public Ramyen() {
		super("라면 목록");
		cp = this.getContentPane();
		this.setBounds(200, 10, 970, 700);
		cp.setBackground(Color.CYAN);
		firstFrame();
		//this.setVisible(true);

	}

	public void firstFrame() {

		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(500, 50));
		topPanel.setBackground(new Color(255, 204, 182));
		this.add(topPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setBackground(new Color(255, 255, 181));
		this.add(centerPanel, BorderLayout.CENTER);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(500, 50));
		bottomPanel.setBackground(new Color(255, 204, 182));
		this.add(bottomPanel, BorderLayout.SOUTH);

		// topPanel에 버튼넣기
		for (int i = 0; i < topBtn.length; i++) {
			topBtn[i] = new JButton(btnStr[i]);

			topBtn[i].setBackground(new Color(200, 200, 110));
			topBtn[i].setFont(font);

			topPanel.add(topBtn[i]);

		}

		menuImage[0] = new JLabel(icon1);
		menuImage[1] = new JLabel(icon2);
		menuImage[2] = new JLabel(icon3);
		menuImage[3] = new JLabel(icon4);
		menuImage[4] = new JLabel(icon5);
		menuImage[5] = new JLabel(icon6);
		menuImage[6] = new JLabel(icon7);
		menuImage[7] = new JLabel(icon8);
		menuImage[8] = new JLabel(icon9);
		menuImage[9] = new JLabel(icon10);
		menuImage[10] = new JLabel(icon11);
		menuImage[11] = new JLabel(icon12);
		menuImage[12] = new JLabel(icon13);
		menuImage[13] = new JLabel(icon14);
		menuImage[14] = new JLabel(icon15);
		menuImage[15] = new JLabel(icon16);
		menuImage[16] = new JLabel(icon17);
		menuImage[17] = new JLabel(icon18);

		for (int i = 0; i < menuImage.length; i++) {

			lblMenu[i] = new JLabel(strMenu[i], JLabel.CENTER);
			lblMenu[i].setFont(font);

			lblPrice[i] = new JLabel(price[i] + "원", JLabel.CENTER);
			lblPrice[i].setFont(font);

			menuGetBtn[i] = new JButton("담기");
			menuGetBtn[i].setFont(font);

			if (i < 6) {
				menuImage[i].setBounds((i * 160) + 25, 0, 100, 100);
				lblMenu[i].setBounds((i * 160) + 25, 100, 100, 20);
				lblPrice[i].setBounds((i * 160) + 25, 120, 100, 20);
				menuGetBtn[i].setBounds((i * 160) + 25, 140, 100, 20);

			} else if (i < 12) {
				menuImage[i].setBounds((i - 6) * 160 + 25, 200, 100, 100);
				lblMenu[i].setBounds((i - 6) * 160 + 25, 300, 100, 20);
				lblPrice[i].setBounds((i - 6) * 160 + 25, 320, 100, 20);
				menuGetBtn[i].setBounds((i - 6) * 160 + 25, 340, 100, 20);
			} else {
				menuImage[i].setBounds((i - 12) * 160 + 25, 400, 100, 100);
				lblMenu[i].setBounds((i - 12) * 160 + 25, 500, 100, 20);
				lblPrice[i].setBounds((i - 12) * 160 + 25, 520, 100, 20);
				menuGetBtn[i].setBounds((i - 12) * 160 + 25, 540, 100, 20);
			}
			menuImage[i].setBackground(Color.WHITE);

			menuGetBtn[i].setBackground(new Color(212, 240, 240));

			centerPanel.add(menuImage[i]);
			centerPanel.add(lblMenu[i]);
			centerPanel.add(lblPrice[i]);
			centerPanel.add(menuGetBtn[i]);

		}

		for (int i = 0; i < bottomBtn.length; i++) {
			bottomBtn[i] = new JButton(bottomStr[i]);
			bottomBtn[i].setBackground(new Color(200, 200, 110));
			bottomBtn[i].setFont(font);

			bottomPanel.add(bottomBtn[i]);

		}

		topBtn[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object ob = e.getSource();
				if (ob == topBtn[0]) {
					String[] columnNames = { "라면 이름", "브랜드", "칼로리(단위:Kcal)" };
					Object[][] data = { { "신라면", "농심", 500 }, { "너구리", "농심", 495 }, { "진라면(매운맛)", "오뚜기", 500 },
							{ "진라면(순한맛)", "오뚜기", 500 }, { "안성탕면", "농심", 525 }, { "무파마", "농심", 510 },
							{ "열라면", "오뚜기", 510 }, { "진짬뽕", "오뚜기", 500 }, { "튀김우동", "농심", 495 }, { "사리곰탕", "농심", 475 },
							{ "불닭볶음면", "삼양", 530 }, { "팔도비빔면", "팔도", 525 } };

					JTable table = new JTable(data, columnNames);
					JScrollPane scrollPane = new JScrollPane(table);

					JOptionPane.showMessageDialog(null, scrollPane, "라면 정보", JOptionPane.PLAIN_MESSAGE);
				}

			}
		});

		topBtn[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object ob = e.getSource();
				if (ob == topBtn[1]) {

					Font customFont = new Font("맑은 고딕", Font.PLAIN, 12);

					String title = "셀프코너!";
					String message = "물과 반찬은 셀프입니다.";

					JLabel label = new JLabel(message);
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setFont(customFont); // 글꼴 설정 적용

					JOptionPane.showMessageDialog(null, label, title, JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		topBtn[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object ob = e.getSource();
				if (ob == topBtn[2]) {

					Font customFont = new Font("맑은 고딕", Font.PLAIN, 12);
					String title = "리뷰는 사랑입니다!";
					String message = "네이버 리뷰 작성 시 음료수 서비스!!!";

					JLabel label = new JLabel(message);
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setFont(customFont); // 글꼴 설정 적용

					JOptionPane.showMessageDialog(null, label, title, JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		topBtn[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object ob = e.getSource();
				if (ob == topBtn[3]) {
					Font customFont = new Font("SansSerif", Font.PLAIN, 12);
					String title = "원산지 표지판";
					String message = "<html>쌀: 국내산<br>배추: 국내산<br>고춧가루: 국내산<br>깍두기: 국내산<br>단무지: 중국산<br>그외: 국내산</html>";

					JLabel label = new JLabel(message);
					label.setFont(customFont); // 글꼴 설정 적용

					JOptionPane.showMessageDialog(null, label, title, JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		for (int i = 0; i < menuGetBtn.length; i++) {

			menuGetBtn[i].addActionListener(this);
		}

		bottomBtn[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object ob = e.getSource();
				if (ob == bottomBtn[0]) {

					Font customFont = new Font("맑은 고딕", Font.PLAIN, 12);

					String message = "결제 금액: " + sum.get() + "원";

					JLabel label = new JLabel(message);
					label.setFont(customFont); // 글꼴 설정 적용

					JOptionPane.showMessageDialog(null, label, "결제 금액 확인", JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});

		bottomBtn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// totalPrice 배열을 0으로 초기화
				for (int i = 0; i < menuGetBtn.length; i++) {
					totalPrice[i] = 0;
				}

				// clickCount 배열도 필요에 따라 0으로 초기화할 수 있습니다.
				// clickCount 배열을 0으로 초기화
				for (int i = 0; i < menuGetBtn.length; i++) {
					clickCount[i] = 0;
				}

				sum.set(0); // sum 업데이트
				Object ob = e.getSource();
				if (ob == bottomBtn[2]) {

					Font customFont = new Font("맑은 고딕", Font.PLAIN, 12);

					String message = "전체취소되었습니다.";

					JLabel label = new JLabel(message);
					label.setFont(customFont); // 글꼴 설정 적용

					JOptionPane.showMessageDialog(null, label, "전체취소", JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		bottomBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 테이블에 표시할 데이터를 저장할 리스트
				List<String[]> tableData = new ArrayList<>();

				// 테이블 헤더
				String[] headers = { "상품명", "가격", "수량", "금액" };

				// totalPrice의 합계 계산
				int currentSum = 0;

				for (int i = 0; i < menuGetBtn.length; i++) {
					int selectedPrice = price[i]; // 상품 가격 가져오기
					int quantity = clickCount[i]; // 수량 가져오기
					int amount = selectedPrice * quantity; // 금액 계산

					if (quantity > 0) { // 수량이 0보다 큰 경우에만 테이블에 추가
						// 테이블 데이터 배열에 값 저장
						String[] rowData = new String[4];
						rowData[0] = strMenu[i]; // 상품명 저장
						rowData[1] = String.valueOf(selectedPrice); // 가격 저장
						rowData[2] = String.valueOf(quantity); // 수량 저장
						rowData[3] = String.valueOf(amount); // 금액 저장

						tableData.add(rowData);

						currentSum += amount; // 합계 계산
					}
				}

				// 테이블 생성
				Object[][] tableArray = tableData.toArray(new Object[0][]);
				JTable table = new JTable(tableArray, headers);
				table.setPreferredScrollableViewportSize(new Dimension(400, 200)); // 테이블 크기 조정

				// 총합 금액 표시를 위한 라벨 생성
				JLabel totalLabel = new JLabel("총 금액: " + currentSum + "원");
				totalLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
				totalLabel.setHorizontalAlignment(SwingConstants.CENTER);

				// 테이블을 포함한 컴포넌트 패널 생성
				JPanel panel = new JPanel(new BorderLayout());
				panel.add(totalLabel, BorderLayout.NORTH); // 라벨을 위로 올림
				panel.add(new JScrollPane(table), BorderLayout.CENTER);

				// 팝업창 생성
				JOptionPane.showMessageDialog(null, panel, "주문 내역", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		bottomBtn[3].addActionListener(this);
		paying.btn1.addActionListener(this);
		payframe.cardBtn.addActionListener(this);
		payframe.cashBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == bottomBtn[3]) {
			payframe.setVisible(true);
			this.setVisible(false);
		} else if (ob == paying.btn1) {
			JOptionPane.showMessageDialog(null, "주문이 완료되었습니다. 이용해주셔서 감사합니다.", "결제완료", JOptionPane.WARNING_MESSAGE);
			paying.setVisible(false);
			insertData();
			

			
		} else if (ob == payframe.cardBtn) {
			paying.setVisible(true);
			payframe.setVisible(false);

		} else if (ob == payframe.cashBtn) {
			JOptionPane.showMessageDialog(null, "현금은 카운터에서 결제가능합니다.", "양해부탁드립니다.", JOptionPane.WARNING_MESSAGE);
		}
		for (int i = 0; i < menuGetBtn.length; i++) {
			if (ob == menuGetBtn[i]) {
				index = i;
				clickCount[index]++; // 해당 버튼의 클릭 횟수 증가
				int selectedPrice = price[index]; // 클릭된 버튼의 가격 가져오기

				// 클릭한 횟수만큼 가격을 누적하여 totalPrice에 저장
				totalPrice[index] = selectedPrice * clickCount[index];

				// totalPrice의 합계 계산
				int currentSum = 0;
				for (int j = 0; j < menuGetBtn.length; j++) {
					currentSum += totalPrice[j];

				}
				sum.set(currentSum); // sum 업데이트

				Font customFont = new Font("맑은 고딕", Font.PLAIN, 12);
				String title = "상품추가";
				String message = "[" + strMenu[index] + "]" + " 상품을 담았습니다.";

				JLabel label = new JLabel(message);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(customFont); // 글꼴 설정 적용
				JOptionPane.showMessageDialog(null, label, title, JOptionPane.PLAIN_MESSAGE);
			}

		}

	}

	public void insertData() {

		for (int i = 0; i < menuGetBtn.length; i++) {

			Connection conn = db.getOracle();
			PreparedStatement pstmt = null;
			index = i;

			String sql = "insert into ramen values (seq_ramen.nextval, ?, ?, ?, ?, sysdate)";

			conn = db.getOracle();

			try {
				pstmt = conn.prepareStatement(sql);
				if(clickCount[index]==0) {
					continue;
				}
				pstmt.setString(1, strMenu[index]);
				pstmt.setInt(2, clickCount[index]);
				pstmt.setInt(3, price[index]);
				pstmt.setInt(4, totalPrice[index]);
				pstmt.executeUpdate();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}
		}
	}

	public static void main(String[] args) {

		Ramyen ra = new Ramyen();
		ra.insertData();
		// System.out.println();

		// SecondFrame sf = new SecondFrame();
	}

}
