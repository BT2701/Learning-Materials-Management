package View.ThongKe;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import View.Styles.Styles;

public class StatisticView extends JPanel{
//	components
	private JButton btnCountMember, btnCountDevice, btnCountDeviceCurrent, btnHandle;
	
//	styles
	private Styles style= new Styles();
	
//	icon
	final ImageIcon member=new ImageIcon(new ImageIcon(getClass().getResource("/View/images/btnmember.png")).getImage()
			.getScaledInstance(700, 350, Image.SCALE_SMOOTH));
	final ImageIcon device=new ImageIcon(new ImageIcon(getClass().getResource("/View/images/btndevice.png")).getImage()
			.getScaledInstance(700, 350, Image.SCALE_SMOOTH));
	final ImageIcon current=new ImageIcon(new ImageIcon(getClass().getResource("/View/images/btncurrent.png")).getImage()
			.getScaledInstance(700, 350, Image.SCALE_SMOOTH));
	final ImageIcon handle=new ImageIcon(new ImageIcon(getClass().getResource("/View/images/btnhandle.png")).getImage()
			.getScaledInstance(700, 350, Image.SCALE_SMOOTH));
	
	final ImageIcon member1=new ImageIcon(new ImageIcon(getClass().getResource("/View/images/btnmemberhover.png")).getImage()
			.getScaledInstance(700, 350, Image.SCALE_SMOOTH));
	final ImageIcon device1=new ImageIcon(new ImageIcon(getClass().getResource("/View/images/btndevicehover.png")).getImage()
			.getScaledInstance(700, 350, Image.SCALE_SMOOTH));
	final ImageIcon current1=new ImageIcon(new ImageIcon(getClass().getResource("/View/images/btncurrenthover.png")).getImage()
			.getScaledInstance(700, 350, Image.SCALE_SMOOTH));
	final ImageIcon handle1=new ImageIcon(new ImageIcon(getClass().getResource("/View/images/btnhandlehover.png")).getImage()
			.getScaledInstance(700, 350, Image.SCALE_SMOOTH));
	
	
	public StatisticView() {
		initComponents();
	}
	private void initComponents() {
		btnCountMember=new JButton("Số lượng thành viên vào khu học tập");
		btnCountMember.setIcon(member1);
		btnCountMember.setFocusPainted(false);
		btnCountMember.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnCountMember.setFont(style.getSgUI15b());
		btnCountMember.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hover(btnCountMember, member, member1);
		pressed(btnCountMember);
		
		
		btnCountDeviceCurrent=new JButton("Số lượng thiết bị đang được mượn");
		btnCountDeviceCurrent.setIcon(current1);
		btnCountDeviceCurrent.setFocusPainted(false);
		btnCountDeviceCurrent.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnCountDeviceCurrent.setFont(style.getSgUI15b());
		btnCountDeviceCurrent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hover(btnCountDeviceCurrent, current, current1);
		pressed(btnCountDeviceCurrent);
		
		
		btnCountDevice= new JButton("Số lượng thiết bị đã được mượn");
		btnCountDevice.setIcon(device1);
		btnCountDevice.setFocusPainted(false);
		btnCountDevice.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnCountDevice.setFont(style.getSgUI15b());
		btnCountDevice.setBackground(Color.red);
		btnCountDevice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hover(btnCountDevice, device, device1);
		pressed(btnCountDevice);
		
		
		btnHandle= new JButton("Thống kê vi phạm");
		btnHandle.setIcon(handle1);
		btnHandle.setFocusPainted(false);
		btnHandle.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnHandle.setFont(style.getSgUI15b());
		btnHandle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hover(btnHandle, handle, handle1);
		pressed(btnHandle);
		
		
		
//		container
		this.setLayout(new GridLayout(2, 2,10,10));
		this.setBackground(Color.white);
		this.add(btnCountMember);
		this.add(btnCountDevice);
		this.add(btnCountDeviceCurrent);
		this.add(btnHandle);
	}
	public void hover(final JButton btn, final ImageIcon hover, final ImageIcon exit) {
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btn.setIcon(hover);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				btn.setIcon(exit);

			}
		});
		
	}
	public void pressed(final JButton btn) {
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btnCountMember) {
					new FormStatistic(1);
				}
				else if(e.getSource()==btnCountDevice) {
					new FormStatistic(2);
				}
				else if(e.getSource()==btnCountDeviceCurrent) {
					new FormStatistic(3);
				}
				else if(e.getSource()==btnHandle) {
					new FormStatistic(4);
				}
			}
		});
	}

}
