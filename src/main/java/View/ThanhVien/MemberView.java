package View.ThanhVien;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.JTableHeader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author phamv
 */
public class MemberView extends javax.swing.JPanel {

    /**
     * Creates new form MemberView
     */
    public MemberView() {
    	this.setLayout(new BorderLayout());
        initComponents();
        initMyComponents();
    }
    
    
    //VÌ DÙNG TOOL ĐỂ TẠO GIAO DIỆN NÊN CÓ VÀI CHỖ CẦN PHẢI CUSTOM LẠI, 
    //ĐÓ LÀ LÍ DO CÓ FUNCTION NÀY
    private void initMyComponents(){
        JLHeader.setFont(fontTittle); 
        JLHeader.setForeground(new java.awt.Color(255, 255, 255));
        
        txtTimKiem.setFont(sgUI13p);
        txtTimKiem.setForeground(texfieldColor);
        txtTimKiem.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        
        
        btnTimKiem.setFont(sgUI13b); // NOI18N
        btnTimKiem.setForeground(Color.black);
        btnTimKiem.setFocusPainted(false);
        btnTimKiem.setBorderPainted(false);
        btnTimKiem.setBackground(Color.decode("#7ed6df"));
       
        
        
        JTableHeader header = jTable2.getTableHeader();
        header.setPreferredSize(new java.awt.Dimension(header.getWidth(), 30)); // Customize the header height here
        header.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 13)); // Customize the font here
        header.setBackground(new Color(15, 145, 232));
        header.setForeground(new Color(255, 255, 255)); // Set the text color here
        
        btnThem.setFont(sgUI13b);
        btnThem.setFocusPainted(false);
        btnThem.setBorderPainted(false);
        btnThem.setBackground(Color.decode("#7ed6df"));
        
        
        btnKhuVucHocTap.setFont(sgUI13b);
        btnKhuVucHocTap.setFocusPainted(false);
        btnKhuVucHocTap.setBorderPainted(false); 
        btnKhuVucHocTap.setBackground(Color.decode("#7ed6df"));
        
        
        btnCanhBaoViPham.setFont(sgUI13b);
        btnCanhBaoViPham.setFocusPainted(false);
        btnCanhBaoViPham.setBorderPainted(false);
        btnCanhBaoViPham.setBackground(Color.decode("#7ed6df"));
        
        btnXoa.setFont(sgUI13b);
        btnXoa.setFocusPainted(false);
        btnXoa.setBorderPainted(false); 
        btnXoa.setBackground(Color.decode("#7ed6df"));
        
        
        btnCapNhat.setFont(sgUI13b);
        btnCapNhat.setFocusPainted(false);
        btnCapNhat.setBorderPainted(false);
        btnCapNhat.setBackground(Color.decode("#7ed6df"));
       
        
        btnMuonTraThietBi.setFont(sgUI13b);
        btnMuonTraThietBi.setFocusPainted(false);
        btnMuonTraThietBi.setBorderPainted(false);
        btnMuonTraThietBi.setBackground(Color.decode("#7ed6df"));
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPHeader = new javax.swing.JPanel();
        JLHeader = new javax.swing.JLabel();
        JPMainContent = new javax.swing.JPanel();
        JPContainSearchOperation = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        JPContainOperation = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnKhuVucHocTap = new javax.swing.JButton();
        btnCanhBaoViPham = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnMuonTraThietBi = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(225, 500));
        setName("JFQLTV"); // NOI18N

        JPHeader.setBackground(new java.awt.Color(15, 145, 232));
        JPHeader.setPreferredSize(new java.awt.Dimension(300, 80));
        JPHeader.setLayout(new java.awt.BorderLayout());

        JLHeader.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JLHeader.setForeground(new java.awt.Color(255, 255, 255));
        JLHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLHeader.setText("Quản Lý Thành Viên");
        JLHeader.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JLHeader.setPreferredSize(new java.awt.Dimension(341, 50));
        JPHeader.add(JLHeader, java.awt.BorderLayout.CENTER);

        add(JPHeader, java.awt.BorderLayout.NORTH);

        JPMainContent.setLayout(new java.awt.BorderLayout());

        JPContainSearchOperation.setBackground(new java.awt.Color(255, 255, 255));
        JPContainSearchOperation.setAutoscrolls(true);
        JPContainSearchOperation.setPreferredSize(new java.awt.Dimension(752, 100));

        txtTimKiem.setText("Nhập từ khóa...");
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(15, 145, 232));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/search_icon.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout JPContainSearchOperationLayout = new javax.swing.GroupLayout(JPContainSearchOperation);
        JPContainSearchOperation.setLayout(JPContainSearchOperationLayout);
        JPContainSearchOperationLayout.setHorizontalGroup(
            JPContainSearchOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPContainSearchOperationLayout.createSequentialGroup()
                .addContainerGap(416, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        JPContainSearchOperationLayout.setVerticalGroup(
            JPContainSearchOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPContainSearchOperationLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(JPContainSearchOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        JPMainContent.add(JPContainSearchOperation, java.awt.BorderLayout.PAGE_START);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ và Tên", "Khoa", "Ngành", "Số điện thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        JPMainContent.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(JPMainContent, java.awt.BorderLayout.CENTER);

        JPContainOperation.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/add_icon.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnKhuVucHocTap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/khuvuchoctap_icon.png"))); // NOI18N
        btnKhuVucHocTap.setText("Khu Vực Học Tập");
        btnKhuVucHocTap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhuVucHocTap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuVucHocTapActionPerformed(evt);
            }
        });

        btnCanhBaoViPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/canhbao_icon.jpg"))); // NOI18N
        btnCanhBaoViPham.setText("Cảnh Báo Vi Phạm");
        btnCanhBaoViPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCanhBaoViPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanhBaoViPhamActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/delete_icon.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/edit_icon.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnMuonTraThietBi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/borow_icon.png"))); // NOI18N
        btnMuonTraThietBi.setText("Mượn Trả Thiết Bị");
        btnMuonTraThietBi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMuonTraThietBi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuonTraThietBiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPContainOperationLayout = new javax.swing.GroupLayout(JPContainOperation);
        JPContainOperation.setLayout(JPContainOperationLayout);
        JPContainOperationLayout.setHorizontalGroup(
            JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPContainOperationLayout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhuVucHocTap, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCanhBaoViPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMuonTraThietBi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        JPContainOperationLayout.setVerticalGroup(
            JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPContainOperationLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMuonTraThietBi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnKhuVucHocTap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCanhBaoViPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnThem.getAccessibleContext().setAccessibleName("btnThem");

        add(JPContainOperation, java.awt.BorderLayout.SOUTH);

    }// </editor-fold>//GEN-END:initComponents

   
    // MỞ JDIALOG THÊM THÀNH VIÊN KHI CLICK VÀO NÚT "Thêm"
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String[] options = { "Thông qua form nhập ", "Thông qua file excel" };
        int userChoice = JOptionPane.showOptionDialog(null,
                "Chọn cách thêm thành viên",
                "Select Option",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (userChoice == 0) {
            // user chọn thêm thông qua form
            new FormThemCapNhatThanhVien("Thêm Thành Viên");
        } else {
            // user chọn thêm thông qua
        }

    }

    // MỞ JDIALOG CẬP NHẬT THÔNG TIN THÀNH VIÊN KHI CLICK VÀO NÚT "Cập Nhật"
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {
        new FormThemCapNhatThanhVien("Cập Nhật Thông Tin Thành Viên");
    }

    // MỞ JDIALOG KHU VỰC HỌC TẬP KHI CLICK VÀO NÚT "Khu Vực Học Tập"
    private void btnKhuVucHocTapActionPerformed(java.awt.event.ActionEvent evt) {
        new FormKhuVucHocTap();
    }

    // MỞ JDIALOG MƯỢN TRẢ THIẾT BỊ KHI CLICK VÀO NÚT "Mượn Trả Thiết Bị"
    private void btnMuonTraThietBiActionPerformed(java.awt.event.ActionEvent evt) {
        new FormMuonTraThietBi();
    }

    // MỞ JDIALOG CẢNH BẢO VI PHẠM KHI CLICK VÀO NÚT "Mượn Trả Thiết Bị"
    private void btnCanhBaoViPhamActionPerformed(java.awt.event.ActionEvent evt) {
        new FormCanhBaoViPham();
    }

    // XÓA PLACEHODER CỦA TEXTFIELD TÌM KIẾM
    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {
        if (txtTimKiem.getText().equals("Nhập từ khóa...")) {
            txtTimKiem.setText("");
        }
    }
    
    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {
        
        if (txtTimKiem.getText().isEmpty()) {
            txtTimKiem.setText("Nhập từ khóa...");
        }
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        String[] options = { "Xóa nhiều thành viên", "Xóa một thành viên" };
        int userChoice = JOptionPane.showOptionDialog(null,
                "Chọn cách xóa thành viên",
                "Select Option",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (userChoice == 0) {
            // user chọn thêm thông qua form
            new FormThemCapNhatThanhVien("Xóa Nhiều Thành Viên");
              
        } else {
            // user chọn thêm thông qua
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLHeader;
    private javax.swing.JPanel JPContainOperation;
    private javax.swing.JPanel JPContainSearchOperation;
    private javax.swing.JPanel JPHeader;
    private javax.swing.JPanel JPMainContent;
    private javax.swing.JButton btnCanhBaoViPham;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnKhuVucHocTap;
    private javax.swing.JButton btnMuonTraThietBi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    // Custom font and color - start
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font sgUI13p = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font tNR13i = new Font("Times New Roman", Font.ITALIC, 13);
    private Font fontTittle = new Font("Tahoma", Font.BOLD, 25);
    private Font fontSubTittle = new Font("Tahoma", Font.BOLD, 20);
    private Font fontTable = new Font("Segoe UI", Font.BOLD, 13);
    private DecimalFormat dcf = new DecimalFormat("###,###");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Color btnoldColor = new Color(52, 152, 219);
    private Color texfieldColor = new Color(45, 52, 54);
    private MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    private LineBorder lineCB = new LineBorder(Color.white);
    private MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    // Custom font adn color - end
}
