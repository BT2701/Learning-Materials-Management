/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.ThietBi;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import View.ThietBi.CustomTableRender;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import Controller.ThietBiCTL;
import Model.ThietBiModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class DeviceView extends javax.swing.JPanel {

	// FORMAT
	private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
	private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
	private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
	private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
	private Font sgUI13I = new Font("Segoe UI", Font.ITALIC, 13);
	private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
	private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
	private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
	private Font fontTittle = new Font("Tahoma", Font.BOLD, 25);
	private Font fontSubTittle = new Font("Tahoma", Font.BOLD, 20);
	private Font fontTable = new Font("Segoe UI", Font.BOLD, 13);
	private DecimalFormat dcf = new DecimalFormat("###,###");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Color btnoldColor = new Color(52, 152, 219);
	private Color texfieldColor = new Color(45, 52, 54);
	private String colorTableCode = "#dee9fc";
	private Font buttonFont = new Font("Segoe UI", Font.BOLD, 15);
	MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
	LineBorder lineCB = new LineBorder(Color.white);
	MatteBorder matteBorderCBDark = new MatteBorder(2, 2, 2, 2, Color.decode("#919191"));
	MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
	MatteBorder borderTxtDark = new MatteBorder(2, 2, 2, 2, Color.decode("#919191"));
	EmptyBorder emptyBorderTxt = new EmptyBorder(0, 7, 0, 7);
	EmptyBorder emptyBorderCB = new EmptyBorder(0, 7, 0, 0);

	ThietBiCTL thietBiCTL = new ThietBiCTL();

	String selectedOptionSearch = "All";

	public DeviceView() {
		initComponents();
		event();
	}

	public void event() {
		loadDataTable();

		// set sự kiện tìm kiếm có sự thay đổi trong text field tim kiem
		jtfTimKiem.getDocument().addDocumentListener(documentListenerSearch);

	}

	DocumentListener documentListenerSearch = new DocumentListener() {
		@Override
		public void insertUpdate(DocumentEvent e) {
			performSearch();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			performSearch();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
		}
	};

	DocumentListener documentListenerId = new DocumentListener() {
		@Override
		public void insertUpdate(DocumentEvent e) {
			getNewestId();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			getNewestId();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
		}
	};

	public void loadDataTable() {
		DefaultTableModel model = (DefaultTableModel) jTableThietBi.getModel();
		model.setRowCount(0); // Xóa dữ liệu hiện tại của bảng

		model.setColumnIdentifiers(new Object[] { "ID", "Tên thiết bị", "Mô tả thiết bị" });

		for (ThietBiModel thietBiModel : thietBiCTL.getList()) {
			model.addRow(new Object[] { thietBiModel.getMaTB(), thietBiModel.getTenTB(), thietBiModel.getMoTaTB() });
		}

		TableCellRenderer renderer = new CustomTableRender();

		for (int i = 0; i < jTableThietBi.getColumnCount(); i++) {
			jTableThietBi.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
	}

	public void performSearch() {

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTableThietBi.getModel());
		jTableThietBi.setRowSorter(rowSorter);

		String text = jtfTimKiem.getText();

		List<RowFilter<Object, Object>> filters = new ArrayList<>();

		if (text.trim().length() > 0) {
			switch (selectedOptionSearch) {
				case "All":
					filters.add(RowFilter.regexFilter("(?i)" + text));
					break;
				case "ID":
					filters.add(RowFilter.regexFilter("(?i)" + text, 0));
					break;
				case "Tên thiết bị":
					filters.add(RowFilter.regexFilter("(?i)" + text, 1));
					break;
				case "Mô tả thiết bị":
					filters.add(RowFilter.regexFilter("(?i)" + text, 2));
					break;
			}
		}

		RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);
		rowSorter.setRowFilter(combinedFilter);
	}

	public void getNewestId() {
		String text = jtfDialogTen.getText();
		String[] words = text.split("\\s+");

		ArrayList<ThietBiModel> list = new ArrayList<>();

		int id = 0;

		switch (words[0]) {
			case "Micro": {
				list = thietBiCTL.getListById("1");
				if (list.isEmpty())
					id = 100001;

			}
				break;
			case "Máy": {
				if (words.length >= 2) {
					if ("chiếu".equals(words[1])) {
						list = thietBiCTL.getListById("2");
						if (list.isEmpty())
							id = 200001;

					} else if ("ảnh".equals(words[1])) {
						list = thietBiCTL.getListById("3");
						if (list.isEmpty())
							id = 300001;

					}
				}

			}
				break;
			case "Cassette": {
				list = thietBiCTL.getListById("4");
				if (list.isEmpty())
					id = 400001;

			}
				break;
			case "Tivi": {
				list = thietBiCTL.getListById("5");
				if (list.isEmpty())
					id = 500001;

			}
				break;
			case "Quạt": {
				if (words.length >= 2) {
					if ("đứng".equals(words[1])) {
						list = thietBiCTL.getListById("6");
						if (list.isEmpty())
							id = 600001;
					}
				}
			}
				break;
			default:
				list = null;
				break;
		}

		if (list != null) {
			if (id == 0) {
				if (!list.isEmpty()) {
					int len = list.size();
					id = list.get(len - 1).getMaTB() + 1;
					jtfDialogID.setText(id + "");
				} else
					jtfDialogID.setText("");
			} else
				jtfDialogID.setText(id + "");

		} else
			jtfDialogID.setText("");

	}

	public void refresh() {
		jtfTimKiem.setText("");
		jcbTimKiem.setSelectedItem("All");
		jTableThietBi.clearSelection();

		loadDataTable();
	}

	public void resetDialogTXS() {
		jtfDialogID.setText("");
		jtfDialogTen.setText("");
		jtfDialogMoTa.setText("");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jDialogTXS = new javax.swing.JDialog();
		jpnDialogHeader = new javax.swing.JPanel();
		jlbDialogHeader = new javax.swing.JLabel();
		jpnDialogContent = new javax.swing.JPanel();
		jlbDialogID = new javax.swing.JLabel();
		jlbDialogTen = new javax.swing.JLabel();
		jtfDialogTen = new javax.swing.JTextField();
		jlbDialogMoTa = new javax.swing.JLabel();
		jtfDialogMoTa = new javax.swing.JTextField();
		jpnDialogID = new javax.swing.JPanel();
		jtfDialogID = new javax.swing.JTextField();
		jcbDialogLoaiId = new javax.swing.JComboBox<>();
		jpnDialogFooter = new javax.swing.JPanel();
		btnXacNhan = new javax.swing.JButton();
		btnHuy = new javax.swing.JButton();
		jpnHeader = new javax.swing.JPanel();
		jlbHeader = new javax.swing.JLabel();
		jpnTopContent = new javax.swing.JPanel();
		jlbTimKiem = new javax.swing.JLabel();
		jtfTimKiem = new javax.swing.JTextField();
		jcbTimKiem = new javax.swing.JComboBox<>();
		jpnContent = new javax.swing.JPanel();
		jScrollTable = new javax.swing.JScrollPane();
		jTableThietBi = new javax.swing.JTable();
		jpnFooter = new javax.swing.JPanel();
		btnThem = new javax.swing.JButton();
		btnSua = new javax.swing.JButton();
		btnXoa = new javax.swing.JButton();
		btnXoaNhieu = new javax.swing.JButton();
		btnNhapExcel = new javax.swing.JButton();
		btnRefresh = new javax.swing.JButton();

		jDialogTXS.setMinimumSize(new java.awt.Dimension(500, 300));
		jDialogTXS.setModal(true);
		jDialogTXS.getContentPane()
				.setLayout(new javax.swing.BoxLayout(jDialogTXS.getContentPane(), javax.swing.BoxLayout.Y_AXIS));

		jpnDialogHeader.setBackground(new java.awt.Color(102, 204, 255));
		jpnDialogHeader.setLayout(new java.awt.BorderLayout());

		jlbDialogHeader.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
		jlbDialogHeader.setText("Thông tin thiết bị");
		jlbDialogHeader.setPreferredSize(new java.awt.Dimension(500, 50));
		jlbDialogHeader.setHorizontalAlignment(JLabel.CENTER);
		jpnDialogHeader.add(jlbDialogHeader, java.awt.BorderLayout.CENTER);

		jDialogTXS.getContentPane().add(jpnDialogHeader);

		jpnDialogContent.setBackground(new java.awt.Color(255, 255, 255));
		jpnDialogContent.setPreferredSize(new java.awt.Dimension(500, 200));
		java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
		jPanel3Layout.columnWidths = new int[] { 0, 30, 0, 30, 0, 30, 0 };
		jPanel3Layout.rowHeights = new int[] { 0, 5, 0, 5, 0 };
		jpnDialogContent.setLayout(jPanel3Layout);

		jlbDialogID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jlbDialogID.setText("ID");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jpnDialogContent.add(jlbDialogID, gridBagConstraints);

		jlbDialogTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jlbDialogTen.setText("Tên thiết bị");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jpnDialogContent.add(jlbDialogTen, gridBagConstraints);

		jtfDialogTen.setPreferredSize(new java.awt.Dimension(200, 30));
		jtfDialogTen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtfDialogTenActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		jpnDialogContent.add(jtfDialogTen, gridBagConstraints);

		jlbDialogMoTa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jlbDialogMoTa.setText("Mô tả thiết bị");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jpnDialogContent.add(jlbDialogMoTa, gridBagConstraints);

		jtfDialogMoTa.setPreferredSize(new java.awt.Dimension(200, 30));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 4;
		jpnDialogContent.add(jtfDialogMoTa, gridBagConstraints);

		jpnDialogID.setBackground(new java.awt.Color(255, 255, 255));

		jtfDialogID.setEnabled(false);
		jtfDialogID.setPreferredSize(new java.awt.Dimension(200, 30));
		jtfDialogID.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtfDialogIDActionPerformed(evt);
			}
		});
		jpnDialogID.add(jtfDialogID);

		jcbDialogLoaiId.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		jcbDialogLoaiId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Micro", "2 - Máy chiếu",
				"3 - Máy ảnh", "4 - Cassette", "5 - Tivi", "6 - Quạt đứng" }));
		jcbDialogLoaiId.setPreferredSize(new java.awt.Dimension(200, 30));
		jcbDialogLoaiId.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jcbDialogLoaiId.setBackground(Color.WHITE);
		jcbDialogLoaiId.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		jcbDialogLoaiId.setBackground(Color.white);
		// jcbDialogLoaiId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		jcbDialogLoaiId.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(new LineBorder(Color.white));
				return basicComboPopup;
			}
		});
		jpnDialogID.add(jcbDialogLoaiId);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		jpnDialogContent.add(jpnDialogID, gridBagConstraints);

		jDialogTXS.getContentPane().add(jpnDialogContent);

		jpnDialogFooter.setBackground(new java.awt.Color(255, 255, 255));
		jpnDialogFooter.setPreferredSize(new java.awt.Dimension(500, 60));

		btnXacNhan.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/View/images/xacnhan_icon.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnXacNhan.setText("Xác nhận");
		btnXacNhan.setFont(buttonFont);
		btnXacNhan.setBackground(Color.decode("#ebf2fc"));
		btnXacNhan.setBorder(new EmptyBorder(8, 12, 8, 12));
		btnXacNhan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXacNhanActionPerformed(evt);
			}
		});
		jpnDialogFooter.add(btnXacNhan);

		btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/cancel button.png"))); // NOI18N
		btnHuy.setText("Hủy");
		btnHuy.setFont(buttonFont);
		btnHuy.setBackground(Color.decode("#ebf2fc"));
		btnHuy.setBorder(new EmptyBorder(8, 12, 8, 12));
		btnHuy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHuy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHuyActionPerformed(evt);
			}
		});
		jpnDialogFooter.add(btnHuy);

		jDialogTXS.getContentPane().add(jpnDialogFooter);

		setBackground(new java.awt.Color(255, 255, 255));
		setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

		jpnHeader.setBackground(new java.awt.Color(153, 204, 255));
		jpnHeader.setPreferredSize(new java.awt.Dimension(993, 50));
		jpnHeader.setLayout(new java.awt.BorderLayout());

		jlbHeader.setBackground(new java.awt.Color(153, 204, 255));
		jlbHeader.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
		jlbHeader.setText("Quản lý thiết bị");
		jlbHeader.setToolTipText("");
		jlbHeader.setPreferredSize(new java.awt.Dimension(37, 30));
		jlbHeader.setHorizontalAlignment(JLabel.CENTER);
		jpnHeader.add(jlbHeader, java.awt.BorderLayout.CENTER);

		add(jpnHeader);

		jpnTopContent.setBackground(new java.awt.Color(255, 255, 255));
		jpnTopContent.setPreferredSize(new java.awt.Dimension(993, 60));
		java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15);
		flowLayout1.setAlignOnBaseline(true);
		jpnTopContent.setLayout(flowLayout1);

		jlbTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jlbTimKiem.setText("Tìm kiếm");
		jpnTopContent.add(jlbTimKiem);

		jtfTimKiem.setPreferredSize(new java.awt.Dimension(200, 30));
		jtfTimKiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtfTimKiemActionPerformed(evt);
			}
		});
		jpnTopContent.add(jtfTimKiem);

		jcbTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		jcbTimKiem.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "ID", "Tên thiết bị", "Mô tả thiết bị" }));
		jcbTimKiem.setPreferredSize(new java.awt.Dimension(200, 30));
		jcbTimKiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jcbTimKiem.setBackground(Color.WHITE);
		jcbTimKiem.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		jcbTimKiem.setBackground(Color.white);
		// jcbTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		jcbTimKiem.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(new LineBorder(Color.white));
				return basicComboPopup;
			}
		});
		jcbTimKiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jcbTimKiemActionPerformed(evt);
			}
		});
		jpnTopContent.add(jcbTimKiem);

		add(jpnTopContent);

		jpnContent.setBackground(new java.awt.Color(255, 255, 255));
		jpnContent.setPreferredSize(new java.awt.Dimension(993, 600));
		jpnContent.setLayout(new java.awt.BorderLayout());

		jTableThietBi.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Title 1", "Title 2", "Title 3" }));
		jTableThietBi.setShowGrid(false);
		jTableThietBi.setDefaultEditor(Object.class, null);

		jTableThietBi.setBackground(Color.WHITE);
		jTableThietBi.setBorder(null);
		jTableThietBi.setRowHeight(35);
		jTableThietBi.setFont(new Font("Segoe UI", Font.BOLD, 13)); // Thiết lập font cho các dòng trong bảng
		jTableThietBi.setShowGrid(false);
		jTableThietBi.setRowHeight(35);

		jTableThietBi.getTableHeader().setPreferredSize(new Dimension(1, 30));
		jTableThietBi.getTableHeader().setFont(fontTable);
		Font headerFont = new Font("Segoe UI", Font.BOLD, 15);
		jTableThietBi.getTableHeader().setFont(headerFont);
		jTableThietBi.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTableThietBi.getTableHeader().setBackground(Color.decode(colorTableCode));

		// jTableThietBi.getColumnModel().getColumn(0).setPreferredWidth(50);
		jScrollTable.setViewportView(jTableThietBi);

		jScrollTable.getViewport().setBackground(Color.WHITE);

		jpnContent.add(jScrollTable, java.awt.BorderLayout.CENTER);

		add(jpnContent);

		jpnFooter.setBackground(new java.awt.Color(255, 255, 255));
		jpnFooter.setPreferredSize(new java.awt.Dimension(993, 60));
		jpnFooter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 15));

		btnThem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/View/images/add_icon.png")).getImage()
				.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnThem.setText("Thêm");
		btnThem.setFont(buttonFont);
		btnThem.setBackground(Color.decode("#ebf2fc"));
		btnThem.setBorder(new EmptyBorder(8, 12, 8, 12));
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemActionPerformed(evt);
			}
		});
		jpnFooter.add(btnThem);

		btnSua.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/View/images/edit_icon.png")).getImage()
				.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnSua.setText("Sửa");
		btnSua.setFont(buttonFont);
		btnSua.setBackground(Color.decode("#ebf2fc"));
		btnSua.setBorder(new EmptyBorder(8, 12, 8, 12));
		btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaActionPerformed(evt);
			}
		});
		jpnFooter.add(btnSua);

		btnXoa.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/View/images/delete_icon.png")).getImage()
				.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnXoa.setText("Xóa");
		btnXoa.setFont(buttonFont);
		btnXoa.setBackground(Color.decode("#ebf2fc"));
		btnXoa.setBorder(new EmptyBorder(8, 12, 8, 12));
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaActionPerformed(evt);
			}
		});
		jpnFooter.add(btnXoa);

		btnXoaNhieu.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/View/images/delete_icon.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnXoaNhieu.setText("Xóa nhiều");
		btnXoaNhieu.setFont(buttonFont);
		btnXoaNhieu.setBackground(Color.decode("#ebf2fc"));
		btnXoaNhieu.setBorder(new EmptyBorder(8, 12, 8, 12));
		btnXoaNhieu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoaNhieu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaNhieuActionPerformed(evt);
			}
		});
		jpnFooter.add(btnXoaNhieu);

		btnNhapExcel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/View/images/importExcel_icon.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnNhapExcel.setText("Nhập file Excel");
		btnNhapExcel.setFont(buttonFont);
		btnNhapExcel.setBackground(Color.decode("#ebf2fc"));
		btnNhapExcel.setBorder(new EmptyBorder(8, 12, 8, 12));
		btnNhapExcel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNhapExcel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNhapExcelActionPerformed(evt);
			}
		});
		jpnFooter.add(btnNhapExcel);

		btnRefresh.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/View/images/refresh_icon.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		btnRefresh.setText("Refresh");
		btnRefresh.setFont(buttonFont);
		btnRefresh.setBackground(Color.decode("#ebf2fc"));
		btnRefresh.setBorder(new EmptyBorder(8, 12, 8, 12));
		btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefresh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRefreshActionPerformed(evt);
			}
		});
		jpnFooter.add(btnRefresh);

		add(jpnFooter);
	}// </editor-fold>//GEN-END:initComponents

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
		// TODO add your handling code here:
		resetDialogTXS();

		jtfDialogTen.getDocument().addDocumentListener(documentListenerId);

		jtfDialogID.setVisible(true);
		jcbDialogLoaiId.setVisible(false);

		jlbDialogID.setText("ID");
		btnXacNhan.setText("Xác nhận");

		jDialogTXS.setLocationRelativeTo(null);
		jDialogTXS.setVisible(true);
	}// GEN-LAST:event_btnThemActionPerformed

	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaActionPerformed
		// TODO add your handling code here:
		if (jTableThietBi.getSelectedRow() != -1) {
			int option = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không?", "Xác nhận xóa",
					JOptionPane.YES_NO_OPTION);

			if (option == JOptionPane.YES_OPTION) {
				int id = (int) jTableThietBi.getValueAt(jTableThietBi.getSelectedRow(), 0);

				JOptionPane.showMessageDialog(this, thietBiCTL.deleteModel(id), "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				loadDataTable();
			}
		} else
			JOptionPane.showMessageDialog(this, "Vui lòng chọn thiết bị bạn cần xóa", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
	}// GEN-LAST:event_btnXoaActionPerformed

	private void btnNhapExcelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNhapExcelActionPerformed
		// TODO add your handling code here:
		JFileChooser fileChooser = new JFileChooser();

		// Chỉ cho phép người dùng chọn file có đuôi là .xlsx
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx");
		fileChooser.setFileFilter(filter);

		// Hiển thị hộp thoại chọn file
		int result = fileChooser.showOpenDialog(null);

		// Kiểm tra xem người dùng đã chọn file hay chưa
		if (result == JFileChooser.APPROVE_OPTION) {
			// Lấy địa chỉ file đã chọn
			File selectedFile = fileChooser.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();

			try {
				FileInputStream file = new FileInputStream(filePath);

				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheetAt(0);

				Iterator<Row> rowIterator = sheet.iterator();
				rowIterator.next(); // Skip header row

				DataFormatter dataFormatter = new DataFormatter();

				ArrayList<ThietBiModel> list = new ArrayList<>();

				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					Cell cell1 = row.getCell(0);
					Cell cell2 = row.getCell(1);
					Cell cell3 = row.getCell(2);

					String value1 = dataFormatter.formatCellValue(cell1);
					String value2 = dataFormatter.formatCellValue(cell2);
					String value3 = dataFormatter.formatCellValue(cell3);

					int id = Integer.parseInt(value1);

					ThietBiModel thietBiModel = new ThietBiModel(id, value2, value3);

					list.add(thietBiModel);
				}

				JOptionPane.showMessageDialog(this, thietBiCTL.addListModel(list), "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);

				workbook.close();
				file.close();
				loadDataTable();
			} catch (IOException | NumberFormatException e) {
			}
		}
	}// GEN-LAST:event_btnNhapExcelActionPerformed

	private void btnXoaNhieuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaNhieuActionPerformed
		// TODO add your handling code here:
		resetDialogTXS();

		jtfDialogTen.getDocument().removeDocumentListener(documentListenerId);

		jtfDialogID.setVisible(false);
		jcbDialogLoaiId.setVisible(true);

		btnXacNhan.setText("Xóa");
		jlbDialogID.setText("Loại thiết bị");

		jDialogTXS.setLocationRelativeTo(null);
		jDialogTXS.setVisible(true);

	}// GEN-LAST:event_btnXoaNhieuActionPerformed

	private void jtfDialogTenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtfDialogTenActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jtfDialogTenActionPerformed

	private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyActionPerformed
		// TODO add your handling code here:
		jDialogTXS.setVisible(false);
	}// GEN-LAST:event_btnHuyActionPerformed

	private void jtfDialogIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtfDialogIDActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jtfDialogIDActionPerformed

	private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXacNhanActionPerformed
		// TODO add your handling code here:
		String ten = jtfDialogTen.getText();
		String moTa = jtfDialogMoTa.getText();

		if ("Xác nhận".equals(btnXacNhan.getText())) {
			String id = jtfDialogID.getText();
			if (id.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Bạn nhập sai định dạng tên thiết bị", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				int ID = Integer.parseInt(id);
				ThietBiModel thietBiModel = thietBiCTL.getModel(ID);

				if (thietBiModel != null) {
					thietBiModel.setTenTB(ten);
					thietBiModel.setMoTaTB(moTa);

					JOptionPane.showMessageDialog(this, thietBiCTL.updateModel(thietBiModel), "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					ThietBiModel thietBi = new ThietBiModel(ID, ten, moTa);
					JOptionPane.showMessageDialog(this, thietBiCTL.addModel(thietBi), "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				}

				jDialogTXS.setVisible(false);
			}
		} else {
			ArrayList<ThietBiModel> list = new ArrayList<>();
			ArrayList<ThietBiModel> listDelete = new ArrayList<>();

			String selectedItem = (String) jcbDialogLoaiId.getSelectedItem();

			switch (selectedItem) {
				case "1 - Micro":
					list = thietBiCTL.getListById("1");
					break;
				case "2 - Máy chiếu":
					list = thietBiCTL.getListById("2");
					break;
				case "3 - Máy ảnh":
					list = thietBiCTL.getListById("3");
					break;
				case "4 - Cassette":
					list = thietBiCTL.getListById("4");
					break;
				case "5 - Tivi":
					list = thietBiCTL.getListById("5");
					break;
				case "6 - Quạt đứng":
					list = thietBiCTL.getListById("6");
					break;
			}

			for (ThietBiModel thietBiModel : list) {
				if (thietBiModel.getTenTB().contains(ten))
					if (thietBiModel.getMoTaTB().contains(moTa))
						listDelete.add(thietBiModel);
			}

			int option = JOptionPane.showConfirmDialog(this,
					"Bạn chắc chắn muốn xóa " + listDelete.size() + " thiết bị không?", "Xác nhận xóa",
					JOptionPane.YES_NO_OPTION);

			if (option == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, thietBiCTL.deleteListModel(listDelete), "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				jDialogTXS.setVisible(false);
			}

		}

		loadDataTable();

	}// GEN-LAST:event_btnXacNhanActionPerformed

	private void jtfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtfTimKiemActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jtfTimKiemActionPerformed

	private void jcbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jcbTimKiemActionPerformed
		// TODO add your handling code here:
		selectedOptionSearch = (String) jcbTimKiem.getSelectedItem();
		performSearch();
	}// GEN-LAST:event_jcbTimKiemActionPerformed

	private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRefreshActionPerformed
		// TODO add your handling code here:
		refresh();
	}// GEN-LAST:event_btnRefreshActionPerformed

	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
		// TODO add your handling code here:
		if (jTableThietBi.getSelectedRow() != -1) {
			int id = (int) jTableThietBi.getValueAt(jTableThietBi.getSelectedRow(), 0);
			String ten = (String) jTableThietBi.getValueAt(jTableThietBi.getSelectedRow(), 1);
			String moTa = (String) jTableThietBi.getValueAt(jTableThietBi.getSelectedRow(), 2);

			jtfDialogTen.getDocument().removeDocumentListener(documentListenerId);

			jtfDialogID.setText(id + "");
			jtfDialogTen.setText(ten);
			jtfDialogMoTa.setText(moTa);

			jtfDialogID.setVisible(true);
			jcbDialogLoaiId.setVisible(false);

			btnXacNhan.setText("Xác nhận");
			jlbDialogID.setText("ID");

			jDialogTXS.setLocationRelativeTo(null);
			jDialogTXS.setVisible(true);

		} else
			JOptionPane.showMessageDialog(this, "Vui lòng chọn thiết bị bạn cần sửa", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);

	}// GEN-LAST:event_btnSuaActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnHuy;
	private javax.swing.JButton btnNhapExcel;
	private javax.swing.JButton btnRefresh;
	private javax.swing.JButton btnSua;
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnXacNhan;
	private javax.swing.JButton btnXoa;
	private javax.swing.JButton btnXoaNhieu;
	private javax.swing.JDialog jDialogTXS;
	private javax.swing.JScrollPane jScrollTable;
	private javax.swing.JTable jTableThietBi;
	private javax.swing.JComboBox<String> jcbDialogLoaiId;
	private javax.swing.JComboBox<String> jcbTimKiem;
	private javax.swing.JLabel jlbDialogHeader;
	private javax.swing.JLabel jlbDialogID;
	private javax.swing.JLabel jlbDialogMoTa;
	private javax.swing.JLabel jlbDialogTen;
	private javax.swing.JLabel jlbHeader;
	private javax.swing.JLabel jlbTimKiem;
	private javax.swing.JPanel jpnContent;
	private javax.swing.JPanel jpnDialogContent;
	private javax.swing.JPanel jpnDialogFooter;
	private javax.swing.JPanel jpnDialogHeader;
	private javax.swing.JPanel jpnDialogID;
	private javax.swing.JPanel jpnFooter;
	private javax.swing.JPanel jpnHeader;
	private javax.swing.JPanel jpnTopContent;
	private javax.swing.JTextField jtfDialogID;
	private javax.swing.JTextField jtfDialogMoTa;
	private javax.swing.JTextField jtfDialogTen;
	private javax.swing.JTextField jtfTimKiem;
	// End of variables declaration//GEN-END:variables
}
