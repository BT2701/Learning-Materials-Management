package View.HomePage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends JFrame{
//	components
	private JPanel pnNorth,pnCenter,pnSouth, pnWest,pnEast;		//container
	private JPanel pnNorthContent,pnNorthProcess,pnNorthContentIcon,pnNorthContentTittle,pnNorthContentUser; //North
	private JPanel pnWestContent,pnWesthandle; //west
	private JPanel pnCenterContent;	//center
	
	private JLabel lbNorthIcon, lbTittle, lbUserIcon,lbUserName,lbProcessHome,lbProcessFunc,lbProcessHandle;	//north
	private JLabel lbMemberIcon,lbMemberTittle, lbDeviceIcon, lbDeviceTittle, lbHandleIcon, lbHandleTittle, lbStatisticIcon, lbStatisticTittle;  //west
	private JLabel lbLoginIcon, lbLoginTittle; 
	
//	styles
	
	public HomePage () {
		setSize(1400, 800);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		initComponent();
		styles();
		events();
		setVisible(true);	
	}
	public void initComponent() {
//		content of north panel
		pnNorthContent=new JPanel();
		pnNorthContent.setLayout(new BorderLayout());
		pnNorthContent.add(pnNorthContentIcon,BorderLayout.WEST);
		pnNorthContent.add(pnNorthContentTittle,BorderLayout.CENTER);
		pnNorthContent.add(pnNorthContentUser,BorderLayout.EAST);
		
//		process of north panel
		pnNorthProcess=new JPanel();
		pnNorthProcess.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		pnNorthProcess.add(lbProcessHome);
		pnNorthProcess.add(lbProcessFunc);
		pnNorthProcess.add(lbProcessHandle);
		
//		content of west panel
		
//		south of west panel
		
//		north panel
		pnNorth=new JPanel();
		pnNorth.setLayout(new BorderLayout());
		pnNorth.add(pnNorthContent,BorderLayout.CENTER);
		pnNorth.add(pnNorthProcess,BorderLayout.SOUTH);
		
//		west panel
		pnWest=new JPanel();
		pnWest.setLayout(new BorderLayout());
		pnWest.add(pnWestContent,BorderLayout.CENTER);
		pnWest.add(pnWesthandle,BorderLayout.SOUTH);
		
//		center panel
		pnCenter=new JPanel();
		pnCenter.setLayout(new BorderLayout());
		pnCenter.add(pnCenterContent,BorderLayout.CENTER);
		
		
//		frame
		this.setLayout(new BorderLayout(5,5));
		this.add(pnNorth,BorderLayout.NORTH);
		this.add(pnWest,BorderLayout.WEST);
		this.add(pnCenter,BorderLayout.CENTER);
	}
	public void events() {
		
	}
	public void styles() {
		
	}
}
