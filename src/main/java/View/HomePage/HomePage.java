package View.HomePage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame {
//	components
	private JPanel pnNorth, pnCenter, pnSouth, pnWest, pnEast; // container
	private JPanel pnNorthContent, pnNorthProcess, pnNorthContentTittle, pnNorthContentUser; // North
	private JPanel pnWestContent, pnWesthandle; // west
	private JPanel pnCenterContent; // center

	private JLabel lbTittle, lbUserName, lbProcessHome, lbProcessFunc, lbProcessHandle; // north
	private ArrayList<JPanel> listPanel; // west
	private JButton btnHomePage, btnMember, btnDevice, btnHandle, btnStatistic; // west
	private ArrayList<JButton> listbtn;
	private JButton btnLogin;

//	styles 
	private Font sgUI15 = new Font("Segoe UI", Font.PLAIN, 15);
	private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
	private Font sgUI16b = new Font("Segoe UI", Font.BOLD, 16);
	private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
	private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);
	private Font tNR18b = new Font("Times New Roman", Font.BOLD, 18);

	private Color mainColor = Color.decode("#dff9fb");

	public HomePage() {
		setSize(1400, 800);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Phần mềm quản lý học liệu");
		setIconImage(new ImageIcon(getClass().getResource("/View/images/material.png")).getImage());
		initComponent();
		styles();
		events();
		setVisible(true);
	}

	public void initComponent() {
//		sub components

		lbProcessFunc = new JLabel();

		lbProcessHandle = new JLabel();

		lbProcessHome = new JLabel("Home");

		lbTittle = new JLabel("Learning Materials Management");
		ImageIcon iconLogo = new ImageIcon(new ImageIcon(getClass().getResource("/View/images/material.png")).getImage()
				.getScaledInstance(80, 50, Image.SCALE_SMOOTH));
		lbTittle.setIcon(iconLogo);

		ImageIcon usericon = new ImageIcon(new ImageIcon(getClass().getResource("/View/images/user.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		lbUserName = new JLabel("Nguyễn Văn A");
		lbUserName.setIcon(usericon);

		ImageIcon deviceicon = new ImageIcon(new ImageIcon(getClass().getResource("/View/images/device.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnDevice = new JButton("Quản lý thiết bị");
		btnDevice.setIcon(deviceicon);

		ImageIcon handleicon = new ImageIcon(new ImageIcon(getClass().getResource("/View/images/handle.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnHandle = new JButton("Quản lý vi phạm");
		btnHandle.setIcon(handleicon);

		ImageIcon homeicon = new ImageIcon(new ImageIcon(getClass().getResource("/View/images/home1.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnHomePage = new JButton("Trang chủ");
		btnHomePage.setIcon(homeicon);

		ImageIcon loginicon = new ImageIcon(new ImageIcon(getClass().getResource("/View/images/login.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnLogin = new JButton("Đăng nhập");
		btnLogin.setIcon(loginicon);

		ImageIcon membericon = new ImageIcon(new ImageIcon(getClass().getResource("/View/images/member.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnMember = new JButton("Quản lý thành viên");
		btnMember.setIcon(membericon);

		ImageIcon statisticicon = new ImageIcon(new ImageIcon(getClass().getResource("/View/images/statistic1.png"))
				.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnStatistic = new JButton("Thống kê");
		btnStatistic.setIcon(statisticicon);

		listbtn = new ArrayList<>();
		listbtn.add(btnHomePage);
		listbtn.add(btnMember);
		listbtn.add(btnDevice);
		listbtn.add(btnHandle);
		listbtn.add(btnStatistic);

//		of north content

		pnNorthContentTittle = new JPanel();
		pnNorthContentTittle.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		pnNorthContentTittle.add(lbTittle);

		pnNorthContentUser = new JPanel();
		pnNorthContentUser.setLayout(new FlowLayout(FlowLayout.RIGHT, 20,10));
		pnNorthContentUser.add(lbUserName);

//		content of north panel
		pnNorthContent = new JPanel();
		pnNorthContent.setLayout(new BorderLayout());
		pnNorthContent.add(pnNorthContentTittle, BorderLayout.CENTER);
		pnNorthContent.add(pnNorthContentUser, BorderLayout.EAST);

//		process of north panel
		pnNorthProcess = new JPanel();
		pnNorthProcess.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		pnNorthProcess.add(lbProcessHome);
		pnNorthProcess.add(lbProcessFunc);
		pnNorthProcess.add(lbProcessHandle);

//		content of west panel
		pnWestContent = new JPanel();
		pnWestContent.setLayout(new BoxLayout(pnWestContent, BoxLayout.Y_AXIS));
		listPanel = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			pnWestContent.add(listbtn.get(i));
		}
//		

//		south of west panel
		pnWesthandle = new JPanel();
		pnWesthandle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		pnWesthandle.add(btnLogin);

//		content of center panel
		pnCenterContent = new JPanel();

//		north panel
		pnNorth = new JPanel();
		pnNorth.setLayout(new BorderLayout());
		pnNorth.add(pnNorthContent, BorderLayout.CENTER);
		pnNorth.add(pnNorthProcess, BorderLayout.SOUTH);

//		west panel
		pnWest = new JPanel();
		pnWest.setLayout(new BorderLayout());
		pnWest.add(pnWestContent, BorderLayout.CENTER);
		pnWest.add(pnWesthandle, BorderLayout.SOUTH);

//		center panel
		pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout(5, 5));
		pnCenter.add(pnCenterContent, BorderLayout.CENTER);

//		frame
		this.setLayout(new BorderLayout());
		this.add(pnNorth, BorderLayout.NORTH);
		this.add(pnWest, BorderLayout.WEST);
		this.add(pnCenter, BorderLayout.CENTER);
	}

	public void events() {

	}

	public void styles() {
		for (JButton x : listbtn) {
			x.setFocusPainted(false);
			x.setBorder(new EmptyBorder(10, 10, 10, 10));
			x.setPreferredSize(new Dimension(200, 45));
			x.setMaximumSize(new Dimension(200, 45));
			x.setFont(sgUI15b);
			x.setHorizontalAlignment(SwingConstants.LEFT);
			x.setBackground(mainColor);
			x.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			hoverBtn(x,0);
		}

		btnLogin.setBackground(Color.decode("#7ed6df"));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnLogin.setFont(sgUI15b);
		btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hoverBtn(btnLogin, 1);

		lbTittle.setFont(tNR18b);
		lbProcessFunc.setFont(sgUI15);
		lbProcessFunc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbProcessHandle.setFont(sgUI15);
		lbProcessHandle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbProcessHome.setFont(sgUI15b);
		lbProcessHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbUserName.setFont(sgUI16b);
		lbUserName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hoverLb(lbUserName);
		hoverLb(lbProcessFunc);
		hoverLb(lbProcessHandle);
		hoverLb(lbProcessHome);

		pnCenter.setBackground(Color.white);
		pnNorth.setBackground(mainColor);
		pnNorthContent.setBackground(mainColor);
		pnNorthContentTittle.setBackground(mainColor);
		pnNorthContentUser.setBackground(mainColor);
		pnNorthProcess.setBackground(Color.decode("#c7ecee"));
		pnWest.setBackground(mainColor);
		pnWestContent.setBackground(mainColor);
		pnWesthandle.setBackground(mainColor);
	}

	public void hoverBtn(final JButton btn, int option) {
		if(option ==1) {
			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {

					btn.setBackground(Color.decode("#95afc0"));

				}

				@Override
				public void mouseExited(MouseEvent e) {

					btn.setBackground(Color.decode("#7ed6df"));

				}
			});
		}
		else {
			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {

					btn.setBackground(Color.decode("#95afc0"));

				}

				@Override
				public void mouseExited(MouseEvent e) {

					btn.setBackground(mainColor);

				}
			});
		}

	}
	public void hoverLb(final JLabel lb) {
		lb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lb.setForeground(Color.decode("#95afc0"));

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lb.setForeground(Color.black);

			}
		});
	}
//	public void setDisplayContent() {
//        pnContent.removeAll();
//        pnContent.revalidate();
//        pnContent.repaint();
//        pnContent.setLayout(new BorderLayout());
//        switch (menu) {
//            case 0:
//                JPanel a = new PanelHome(getWidth(),getHeight());
//                pnContent.setLayout(new BorderLayout());
//                pnContent.add(a, BorderLayout.CENTER);
//                break;
//            case 1:
//                pnContent.add(pnPhong, BorderLayout.CENTER);
//                break;
//            case 4:
//                pnContent.add(pnKhachHang, BorderLayout.CENTER);
//                break;
//            case 3:
//                pnContent.add(pnNhanVien, BorderLayout.CENTER);
//                break;
//            case 2:
//                pnContent.add(pnDichVu, BorderLayout.CENTER);
//                break;
//            case 5:
//                pnContent.add(pnHoaDon, BorderLayout.CENTER);
//                break;
//            case 6:
//                pnContent.add(pnThongKe,BorderLayout.CENTER);
//                break;
//        }
//    }

}
