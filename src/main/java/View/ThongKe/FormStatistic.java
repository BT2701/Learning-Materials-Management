package View.ThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import View.Styles.Styles;

public class FormStatistic extends JDialog {
//	styles
	Styles style = new Styles();

//	MEMBER
	private JPanel pnTop, pnBot, pnTopContent, pnTopCBB, pnBotContent, pnBotCBB, pnBotDepartment, pnBotBranch;
	private ChartPanel pnChartTime, pnChartDepartment, pnChartBranch;
	private JFreeChart chartTime, chartDepartment, chartBranch;
	private JComboBox<String> cbbTop;

//	DEVICE
	private JPanel pnDeviceContent, pnDeviceCbb;
	private JComboBox<String> cbbYear, cbbMonth;
	private JFreeChart chartDevice;
	private ChartPanel pnChartDevice;

//	HANDLE
	private JPanel pnHandleTop, pnHandleBot, pnHandleBotNorth, pnHandleBotContent, pnHandleDone, pnHandleUnDone,
			pnHandleFee;
	private JFreeChart chartHandle;
	private ChartPanel pnChartHandle;
	private JLabel lbTxtHandleDone, lbTxtHandleUnDone, lbTxtHandleFee, lbHandleDone, lbHandleUnDone, lbHandleFee;

	public FormStatistic(int option) {
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		switch (option) {
			case 1:
				initComponentsMember();
				break;
			case 2:
				initComponentsDevice();
				break;
			case 3:
				initComponentsCurrent();
				break;
			case 4:
				initComponentsHandle();
				break;
		}

		setVisible(true);
	}

	public void initComponentsMember() {
//		subcomponent

		cbbTop = new JComboBox<String>();
		cbbTop.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		cbbTop.setBackground(Color.white);
		cbbTop.setFont(style.getSgUI13b());
		cbbTop.setPreferredSize(new Dimension(100, 30));
		cbbTop.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(style.getLineCB());
				return basicComboPopup;
			}
		});
		cbbTop.setBorder(style.getMatteBorderCB());
		rendererCbb(cbbTop,1);

		cbbYear = new JComboBox<String>();
		cbbYear.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		cbbYear.setBackground(Color.white);
		cbbYear.setFont(style.getSgUI13b());
		cbbYear.setPreferredSize(new Dimension(100, 30));
		cbbYear.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(style.getLineCB());
				return basicComboPopup;
			}
		});
		cbbYear.setBorder(style.getMatteBorderCB());
		rendererCbb(cbbYear, 3);
		
		cbbMonth = new JComboBox<String>();
		cbbMonth.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		cbbMonth.setBackground(Color.white);
		cbbMonth.setFont(style.getSgUI13b());
		cbbMonth.setPreferredSize(new Dimension(100, 30));
		cbbMonth.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(style.getLineCB());
				return basicComboPopup;
			}
		});
		cbbMonth.setBorder(style.getMatteBorderCB());
		rendererCbb(cbbMonth, 2);

//		chart
		chartTime = ChartFactory.createLineChart("Lượng sinh viên vào khu học liệu theo thời gian", "Month", "value",
				createDatasetTime(2024));

		chartBranch = ChartFactory.createBarChart("Theo ngành", "Branch", "value", createDatasetBranch(2024));

		chartDepartment = ChartFactory.createBarChart("Theo khoa", "Department", "value",
				createDatasetDepartment(2024));

//		chart pn
		pnChartBranch = new ChartPanel(chartBranch);
		pnChartBranch.setPreferredSize(new Dimension(450, 200));

		pnChartDepartment = new ChartPanel(chartDepartment);
		pnChartDepartment.setPreferredSize(new Dimension(450, 200));

		pnChartTime = new ChartPanel(chartTime);
		pnChartTime.setPreferredSize(new Dimension(900, 350));

//		topcontent
		pnTopContent = new JPanel();
		pnTopContent.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnTopContent.add(pnChartTime);

//		topcbb
		pnTopCBB = new JPanel();
		pnTopCBB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnTopCBB.add(cbbTop);

//		top
		pnTop = new JPanel();
		pnTop.setLayout(new BorderLayout());
		pnTop.add(pnTopContent, BorderLayout.CENTER);
		pnTop.add(pnTopCBB, BorderLayout.SOUTH);

//		botdepartment
		pnBotDepartment = new JPanel();
		pnBotDepartment.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		pnBotDepartment.add(pnChartDepartment);

//		botbranch
		pnBotBranch = new JPanel();
		pnBotBranch.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		pnBotBranch.add(pnChartBranch);

//		botcontent
		pnBotContent = new JPanel();
		pnBotContent.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
		pnBotContent.add(pnBotDepartment);
		pnBotContent.add(pnBotBranch);

//		botcbb
		pnBotCBB = new JPanel();
		pnBotCBB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		pnBotCBB.add(cbbYear);
		pnBotCBB.add(cbbMonth);

//		bot
		pnBot = new JPanel();
		pnBot.setLayout(new BorderLayout());
		pnBot.add(pnBotContent, BorderLayout.CENTER);
		pnBot.add(pnBotCBB, BorderLayout.SOUTH);

//		container
		this.setLayout(new BorderLayout());
		this.add(pnTop, BorderLayout.CENTER);
		this.add(pnBot, BorderLayout.SOUTH);
	}

	public void initComponentsDevice() {
//		subcomponent
		chartDevice = ChartFactory.createBarChart("Thống kê thiết bị được mượn", "Thiết bị", "Số lượng",
				createDatasetDevice(2024, 2));

		cbbYear = new JComboBox<String>();
		cbbMonth = new JComboBox<String>();

		pnChartDevice = new ChartPanel(chartDevice);

//		pn device
		pnDeviceContent = new JPanel();
		pnDeviceContent.setLayout(new BorderLayout());
		pnDeviceContent.add(pnChartDevice, BorderLayout.CENTER);

//		pn cbb
		pnDeviceCbb = new JPanel();
		pnDeviceCbb.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		pnDeviceCbb.add(cbbYear);
		pnDeviceCbb.add(cbbMonth);

		this.setLayout(new BorderLayout());
		this.add(pnDeviceContent, BorderLayout.CENTER);
		this.add(pnDeviceCbb, BorderLayout.SOUTH);

	}

	public void initComponentsCurrent() {
//		subcomponent
		chartDevice = ChartFactory.createBarChart("Thống kê thiết bị đang được mượn", "Thiết bị", "Số lượng",
				createDatasetCurrent(2024, 2));

		cbbYear = new JComboBox<String>();
		cbbMonth = new JComboBox<String>();

		pnChartDevice = new ChartPanel(chartDevice);

//		pn device
		pnDeviceContent = new JPanel();
		pnDeviceContent.setLayout(new BorderLayout());
		pnDeviceContent.add(pnChartDevice, BorderLayout.CENTER);

//		pn cbb
		pnDeviceCbb = new JPanel();
		pnDeviceCbb.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		pnDeviceCbb.add(cbbYear);
		pnDeviceCbb.add(cbbMonth);

		this.setLayout(new BorderLayout());
		this.add(pnDeviceContent, BorderLayout.CENTER);
		this.add(pnDeviceCbb, BorderLayout.SOUTH);

	}

	public void initComponentsHandle() {

		chartHandle = ChartFactory.createBarChart("Thống kê vi phạm", "Tên vi phạm", "Số lượng",
				createDatasetHandle(2024, 2));

		cbbYear = new JComboBox<String>();
		cbbMonth = new JComboBox<String>();

		lbHandleDone = new JLabel();

		lbHandleFee = new JLabel();

		lbHandleUnDone = new JLabel();

		lbTxtHandleDone = new JLabel("Đã được xử lý:");

		lbTxtHandleFee = new JLabel("Số tiền bồi thường:");

		lbTxtHandleUnDone = new JLabel("Chưa được xử lý: ");

		pnChartHandle = new ChartPanel(chartHandle);
//		top
		pnHandleTop = new JPanel();
		pnHandleTop.setLayout(new BorderLayout());
		pnHandleTop.add(pnChartHandle, BorderLayout.CENTER);

//		bot north
		pnHandleBotNorth = new JPanel();
		pnHandleBotNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		pnHandleBotNorth.add(cbbYear);
		pnHandleBotNorth.add(cbbMonth);

//		bot content component
		pnHandleDone = new JPanel();
		pnHandleDone.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		pnHandleDone.add(lbTxtHandleDone);
		pnHandleDone.add(lbHandleDone);

		pnHandleUnDone = new JPanel();
		pnHandleUnDone.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		pnHandleUnDone.add(lbTxtHandleUnDone);
		pnHandleUnDone.add(lbHandleUnDone);

		pnHandleFee = new JPanel();
		pnHandleFee.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		pnHandleFee.add(lbTxtHandleFee);
		pnHandleFee.add(lbHandleFee);

//		bot content
		pnHandleBotContent = new JPanel();
		pnHandleBotContent.setLayout(new BoxLayout(pnHandleBotContent, BoxLayout.Y_AXIS));
		pnHandleBotContent.add(pnHandleDone);
		pnHandleBotContent.add(pnHandleUnDone);
		pnHandleBotContent.add(pnHandleFee);

//		bot
		pnHandleBot = new JPanel();
		pnHandleBot.setLayout(new BorderLayout());
		pnHandleBot.add(pnHandleBotNorth, BorderLayout.NORTH);
		pnHandleBot.add(pnHandleBotContent, BorderLayout.CENTER);

//		container
		this.setLayout(new BorderLayout());
		this.add(pnHandleTop, BorderLayout.CENTER);
		this.add(pnHandleBot, BorderLayout.SOUTH);

	}

//	Member
	private DefaultCategoryDataset createDatasetTime(int year) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < 12; i++) {
			dataset.addValue(i, "Students", (i + 1)+"");
		}
		return dataset;
	}

	private DefaultCategoryDataset createDatasetBranch(int year) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// Insert data for each department
		dataset.addValue(50, "Computer Science", "CS");
		dataset.addValue(30, "Electrical Engineering", "EE");
		dataset.addValue(40, "Mechanical Engineering", "ME");
		dataset.addValue(25, "Civil Engineering", "CE");
		dataset.addValue(35, "Chemical Engineering", "ChemE");

		return dataset;
	}

	private DefaultCategoryDataset createDatasetDepartment(int year) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// Insert data for each department
		dataset.addValue(50, "Computer Science", "CS");
		dataset.addValue(30, "Electrical Engineering", "EE");
		dataset.addValue(40, "Mechanical Engineering", "ME");
		dataset.addValue(25, "Civil Engineering", "CE");
		dataset.addValue(35, "Chemical Engineering", "ChemE");

		return dataset;
	}

	public void rendererCbb(JComboBox<String> cbb, int option) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		switch (option) {
			case 1: // cbb năm
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				for (int i = year; i > year - 5; i--) {
					model.addElement("Năm " + i);
				}
				break;
			case 2:// cbb tháng
				for (int i = 1; i < 13; i++) {
					model.addElement("Tháng "+i);
				}
				break;
			case 3:// cbb đặc biệt
				model.addElement("Tất cả");
				Calendar calendar1 = Calendar.getInstance();
				int year1 = calendar1.get(Calendar.YEAR);
				for (int i = year1; i > year1 - 5; i--) {
					model.addElement("Năm " + i);
				}
				break;
		}

		cbb.setModel(model);
	}

//	DEVICE
	private DefaultCategoryDataset createDatasetDevice(int year, int month) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(50, "Computer Science", "CS");
		dataset.addValue(30, "Electrical Engineering", "EE");
		dataset.addValue(40, "Mechanical Engineering", "ME");
		dataset.addValue(25, "Civil Engineering", "CE");
		dataset.addValue(35, "Chemical Engineering", "ChemE");
		return dataset;
	}

//	CURRENT
	private DefaultCategoryDataset createDatasetCurrent(int year, int month) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(50, "Computer Science", "CS");
		dataset.addValue(30, "Electrical Engineering", "EE");
		dataset.addValue(40, "Mechanical Engineering", "ME");
		dataset.addValue(25, "Civil Engineering", "CE");
		dataset.addValue(35, "Chemical Engineering", "ChemE");
		return dataset;
	}

//	HANDLE
	private DefaultCategoryDataset createDatasetHandle(int year, int month) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(50, "Computer Science", "CS");
		dataset.addValue(30, "Electrical Engineering", "EE");
		dataset.addValue(40, "Mechanical Engineering", "ME");
		dataset.addValue(25, "Civil Engineering", "CE");
		dataset.addValue(35, "Chemical Engineering", "ChemE");
		return dataset;
	}
}
