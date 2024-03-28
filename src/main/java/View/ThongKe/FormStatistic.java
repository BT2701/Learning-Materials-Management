package View.ThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import View.Styles.Styles;

public class FormStatistic extends JDialog {
//	styles
	Styles style=new Styles();
	
//	MEMBER
	private JPanel pnTop, pnBot, pnTopContent, pnTopCBB, pnBotContent, pnBotCBB, pnBotDepartment, pnBotBranch;
	private ChartPanel pnChartTime, pnChartDepartment, pnChartBranch;
	private JFreeChart chartTime, chartDepartment, chartBranch;
	private JComboBox<String> cbbTop, cbbBot;

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
		
		cbbTop=new JComboBox<String>();
		
		cbbBot=new JComboBox<String>();
		

//		chart
		chartTime= ChartFactory.createLineChart(
                "Lượng sinh viên vào khu học liệu theo thời gian",
                "Month",
                "value",
                createDatasetTime(2024)
        );
		
		chartBranch = ChartFactory.createBarChart(
                "Theo ngành",
                "Branch",
                "value",
                createDatasetBranch(2024)
        );
		
		chartDepartment = ChartFactory.createBarChart(
                "Theo khoa",
                "Department",
                "value",
                createDatasetDepartment(2024)
        );
		
//		chart pn
		pnChartBranch=new ChartPanel(chartBranch);
		pnChartBranch.setPreferredSize(new Dimension(450, 200));
		
		pnChartDepartment=new ChartPanel(chartDepartment);
		pnChartDepartment.setPreferredSize(new Dimension(450, 200));
		
		pnChartTime=new ChartPanel(chartTime);
		pnChartTime.setPreferredSize(new Dimension(900, 350));
		
//		topcontent
		pnTopContent=new JPanel();
		pnTopContent.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		pnTopContent.add(pnChartTime);
		
//		topcbb
		pnTopCBB=new JPanel();
		pnTopCBB.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		pnTopCBB.add(cbbTop);
		
//		top
		pnTop=new JPanel();
		pnTop.setLayout(new BorderLayout());
		pnTop.add(pnTopContent,BorderLayout.CENTER);
		pnTop.add(pnTopCBB,BorderLayout.SOUTH);
		
//		botdepartment
		pnBotDepartment=new JPanel();
		pnBotDepartment.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		pnBotDepartment.add(pnChartDepartment);
		
//		botbranch
		pnBotBranch=new JPanel();
		pnBotBranch.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		pnBotBranch.add(pnChartBranch);
		
//		botcontent
		pnBotContent=new JPanel();
		pnBotContent.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		pnBotContent.add(pnBotDepartment);
		pnBotContent.add(pnBotBranch);
		
//		botcbb
		pnBotCBB=new JPanel();
		pnBotCBB.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		pnBotCBB.add(cbbBot);
		
//		bot
		pnBot=new JPanel();
		pnBot.setLayout(new BorderLayout());
		pnBot.add(pnBotContent,BorderLayout.CENTER);
		pnBot.add(pnBotCBB,BorderLayout.SOUTH);
		
		
//		container
		this.setLayout(new BorderLayout());
		this.add(pnTop,BorderLayout.CENTER);
		this.add(pnBot,BorderLayout.SOUTH);
	}

	public void initComponentsDevice() {
		this.setLayout(new BorderLayout());
		JPanel temPanel = new JPanel();
		this.add(temPanel);
		temPanel.setBackground(Color.white);
		this.add(temPanel, BorderLayout.CENTER);
	}

	public void initComponentsCurrent() {
		this.setLayout(new BorderLayout());
		JPanel temPanel = new JPanel();
		this.add(temPanel);
		temPanel.setBackground(Color.blue);
		this.add(temPanel, BorderLayout.CENTER);
	}

	public void initComponentsHandle() {
		this.setLayout(new BorderLayout());
		JPanel temPanel = new JPanel();
		this.add(temPanel);
		temPanel.setBackground(Color.green);
		this.add(temPanel, BorderLayout.CENTER);
	}

//	Member
	private DefaultCategoryDataset createDatasetTime(int year) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i=0;i<12;i++) {
			dataset.addValue(i, "Students", ""+i+1);
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
}
