/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.ThanhVien;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import Controller.ThanhVienCTL;
import Model.ThanhVienModel;

/**
 *
 * @author phamv
 */
public class FormThemCapNhatThanhVien extends javax.swing.JDialog {
    ThanhVienCTL tvCtl = new ThanhVienCTL();
    ThanhVienModel oldThanhVien = null;
    private String[] nganhList = {"", "Giáo dục tiểu học", "Quản trị kinh doanh", "Quản lý giáo ", "Khoa học máy tính", "Khoa học dữ liệu", "Khoa học môi trường", "Khoa học xã hội"};
    private String[] khoaList = {"", "GDTH", "TLH", "QTKD", "CNTT", "VL", "MT", "XH"};
    String titleForm;
    /**
     * Creates new form FormThemThanhVien
     */
    public FormThemCapNhatThanhVien(String titleForm) {
        this.titleForm = titleForm;
    	setSize(450, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		setTitle("Xử lý");
		setIconImage(new ImageIcon(getClass().getResource("/View/images/material.png")).getImage());
//        super(parent, modal);
        initComponents();
        initMyComponents(titleForm);
        changeComponentForDiffForm(titleForm);
        setVisible(true);
       
    }

    public FormThemCapNhatThanhVien(String titleForm, int idOfoldThanhVien) {
        this.oldThanhVien = tvCtl.getModel(idOfoldThanhVien);
        this.titleForm = titleForm;
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setTitle("Xử lý");
        setIconImage(new ImageIcon(getClass().getResource("/View/images/material.png")).getImage());
        initComponents();
        initMyComponents(titleForm);
        changeComponentForDiffForm(titleForm);
        setVisible(true);
    }

    private void changeComponentForDiffForm(String titleForm){
//        if(titleForm == "Xóa Nhiều Thành Viên"){
//            txtThanhVien.setVisible(true);
//            lbThanhVien.setVisible(true);
//        }
//        else{
//            txtThanhVien.setVisible(false);
//            lbThanhVien.setVisible(false);
//        }
        if(titleForm.equals("Cập Nhật Thông Tin Thành Viên")) {
            txtMaTV.setEditable(false);
            txtMaTV.setText(Integer.toString(oldThanhVien.getMaTV()));

            txtSdt.setText(oldThanhVien.getSdt());
            txtHoTen.setText(oldThanhVien.getHoTen());
            cbKhoa.addItem(oldThanhVien.getKhoa());
            cbKhoa.setSelectedItem(oldThanhVien.getKhoa());
            cbNganh.addItem(oldThanhVien.getNganh());
            cbNganh.setSelectedItem(oldThanhVien.getNganh());
        }
    }
    
    private void initMyComponents(String titleForm){
        title.setText(titleForm);
        title.setFont(sgUI15b);
        lbHoTen.setFont(sgUI13b); // NOI18N
        lbMaTV.setFont(sgUI13b); // NOI18N
        lbKhoa.setFont(sgUI13b); // NOI18N 
        lbNganh.setFont(sgUI13b); // NOI18N
        lbSdt.setFont(sgUI13b); // NOI18N
        lbThanhVien.setFont(sgUI13b); // NOI18N
        lbThanhVien.setVisible(false);
        txtSdt.setPreferredSize(new Dimension(200, 30));
        txtSdt.setFont(sgUI13p);
        // txtSdt.setBorder(BorderFactory.createCompoundBorder(borderTxt, new
        // EmptyBorder(0, 3, 0, 3)));
        txtSdt.setForeground(Color.black);
        
        btnXacNhan.setFont(sgUI13b);
        btnXacNhan.setFocusPainted(false);
        btnXacNhan.setBorderPainted(false);
        btnXacNhan.setPreferredSize(new java.awt.Dimension(100, 23));
        btnXacNhan.setBackground(Color.decode("#7ed6df"));

        // Xử lý sự kiện khi nhấn nút Xác Nhận
        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Trích xuất dữ liệu từ các trường và combobox
                String maTVStr = txtMaTV.getText();
                if (maTVStr.isEmpty() && !titleForm.equals("Xóa Nhiều Thành Viên")) {
                    JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Vui lòng nhập mã thành viên!");
                    return;
                }

                int maTV;
                try {
                    if(titleForm.equals("Xóa Nhiều Thành Viên") && maTVStr.isEmpty()) {
                        maTV = 0;
                    } else {
                        maTV = Integer.parseInt(maTVStr);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Mã thành viên phải là một số nguyên!");
                    return;
                }

                String hoTen = txtHoTen.getText();
                String sdt = txtSdt.getText();
                String khoa = (String) cbKhoa.getSelectedItem();
                String nganh = (String) cbNganh.getSelectedItem();
                ThanhVienModel thanhvien = tvCtl.getModel(maTV);

                if(!titleForm.equals("Xóa Nhiều Thành Viên")) {
                    if((khoa == null || khoa.isEmpty()) || (nganh == null || nganh.isEmpty()) || hoTen.isEmpty() || sdt.isEmpty()) {
                        JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Vui lòng nhập đầy đủ các trường!");
                        return;
                    }
                }

                if (titleForm.equals("Thêm Thành Viên")) {
                    // Kiểm tra xem đối tượng đã tồn tại trong cơ sở dữ liệu chưa
                    if (thanhvien != null) {
                        JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Thành viên đã tồn tại!");
                        return;
                    }

                    // Thêm dữ liệu vào cơ sở dữ liệu
                    tvCtl.addModel(new ThanhVienModel(maTV, hoTen, khoa, nganh, sdt, "", ""));

                    // Xóa dữ liệu sau khi thêm thành công
                    txtMaTV.setText("");
                    txtHoTen.setText("");
                    txtSdt.setText("");
                    cbKhoa.setSelectedIndex(0);
                    cbNganh.setSelectedIndex(0);

                    // Hiển thị thông báo thành công (có thể thêm)
                    JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Thêm thành viên thành công!");
                    setVisible(false);
                } else if (titleForm.equals("Cập Nhật Thông Tin Thành Viên")) {
                    if (thanhvien == null) {
                        JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Thành viên chưa tồn tại!");
                        return;
                    }
                    ThanhVienModel updatedThanhvien = new ThanhVienModel(maTV, hoTen, khoa, nganh, sdt, "", "");
                    tvCtl.updateModel(updatedThanhvien);

                    txtMaTV.setText("");
                    txtHoTen.setText("");
                    txtSdt.setText("");
                    cbKhoa.setSelectedIndex(0);
                    cbNganh.setSelectedIndex(0);

                    JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Cập Nhật thành viên thành công!");
                    setVisible(false);
                } else if (titleForm.equals("Xóa Nhiều Thành Viên")) {
                    if(maTV == 0 && hoTen.isEmpty() && (khoa != null && khoa.isEmpty()) && (nganh != null && nganh.isEmpty()) && sdt.isEmpty()) {
                        JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Nhập 1 trong những điều kiện để xóa !");
                        return;
                    }
                    String queryToDelete = "";
                    if(maTV != 0) {
                        String query = "MaTV = '" + maTV + "'";
                        queryToDelete += !queryToDelete.isEmpty() ? " and " + query : query;
                    }
                    if(!hoTen.isEmpty()) {
                        String query = "HoTen = '" + hoTen + "'";
                        queryToDelete += !queryToDelete.isEmpty() ? " and " + query : query;
                    }
                    if (khoa != null && !khoa.isEmpty()) {
                        String query = "Khoa = '" + khoa + "'";
                        queryToDelete += !queryToDelete.isEmpty() ? " and " + query : query;
                    }
                    if(nganh != null && !nganh.isEmpty()) {
                        String query = "Nganh = '" + nganh + "'";
                        queryToDelete += !queryToDelete.isEmpty() ? " and " + query : query;
                    }
                    if(!sdt.isEmpty()) {
                        String query = "Sdt = '" + sdt + "'";
                        queryToDelete += !queryToDelete.isEmpty() ? " and " + query : query;
                    }

                    tvCtl.deleteMultipleModelByCondition(queryToDelete);
//                    JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Xóa nhiều thành viên thành công! " + queryToDelete + "--123");

                    txtMaTV.setText("");
                    txtHoTen.setText("");
                    txtSdt.setText("");
                    cbKhoa.setSelectedIndex(0);
                    cbNganh.setSelectedIndex(0);

                    JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Xóa nhiều thành viên thành công!");
                    setVisible(false);
                }
            }
        });
        
        btnHuy.setFont(sgUI13b);
        btnHuy.setFocusPainted(false);
        btnHuy.setBorderPainted(false);
        btnHuy.setPreferredSize(new java.awt.Dimension(100, 23));
        btnHuy.setBackground(Color.decode("#7ed6df"));
        
        
        btnLamMoi.setFont(sgUI13b);
        btnLamMoi.setFocusPainted(false);
        btnLamMoi.setBorderPainted(false);
        btnLamMoi.setPreferredSize(new java.awt.Dimension(100, 23));
        btnLamMoi.setBackground(Color.decode("#7ed6df"));
        
        txtHoTen.setPreferredSize(new Dimension(200, 30));
        txtHoTen.setFont(sgUI13p);
        txtHoTen.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtHoTen.setForeground(Color.black);

        txtMaTV.setPreferredSize(new Dimension(200, 30));
        txtMaTV.setFont(sgUI13p);
        txtMaTV.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtMaTV.setForeground(Color.black);
        
        txtSdt.setPreferredSize(new Dimension(200, 30));
        txtSdt.setFont(sgUI13p);
        txtSdt.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtSdt.setForeground(Color.black);
        
        txtThanhVien.setPreferredSize(new Dimension(200, 30));
        txtThanhVien.setFont(sgUI13p);
        txtThanhVien.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtThanhVien.setForeground(Color.black);
        txtThanhVien.setVisible(false);
        
        cbKhoa.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbKhoa.setBackground(Color.white);
        cbKhoa.setFont(sgUI13b);
        cbKhoa.setPreferredSize(new Dimension(100, 30));
        cbKhoa.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });

        cbNganh.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbNganh.setBackground(Color.white);
        cbNganh.setFont(sgUI13b);
        cbNganh.setPreferredSize(new Dimension(100, 30));
        cbNganh.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        lbHoTen = new javax.swing.JLabel();
        lbMaTV = new javax.swing.JLabel();
        lbKhoa = new javax.swing.JLabel();
        lbNganh = new javax.swing.JLabel();
        lbSdt = new javax.swing.JLabel();
        btnXacNhan = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        txtHoTen = new javax.swing.JTextField();
        txtMaTV = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        cbKhoa = new javax.swing.JComboBox<>();
        cbNganh = new javax.swing.JComboBox<>();
        btnHuy = new javax.swing.JButton();
        lbThanhVien = new javax.swing.JLabel();
        txtThanhVien = new javax.swing.JTextField();

        

        header.setBackground(new java.awt.Color(15, 145, 232));
        header.setPreferredSize(new java.awt.Dimension(400, 50));
        header.setLayout(new java.awt.BorderLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("title");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        header.add(title, java.awt.BorderLayout.CENTER);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        lbMaTV.setText("Mã thành viên");

        lbHoTen.setText("Họ và Tên");

        lbKhoa.setText("Khoa");

        lbNganh.setText("Ngành");

        lbSdt.setText("Số điện thoại");

        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/xacnhan_icon.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/Refresh_icon.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(khoaList));

        cbNganh.setModel(new javax.swing.DefaultComboBoxModel<>(nganhList));

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/comeback_icon.png"))); // NOI18N
        btnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuy.setLabel("Hủy");

        lbThanhVien.setText("Thành Viên");

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbKhoa)
                    .addComponent(lbNganh)
                    .addComponent(btnXacNhan)
                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbMaTV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbHoTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSdt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbThanhVien))
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(cbNganh, 0, 189, Short.MAX_VALUE)
                            .addComponent(cbKhoa, 0, 189, Short.MAX_VALUE)
                            .addComponent(txtMaTV, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtThanhVien)))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnLamMoi)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbThanhVien))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(txtMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(lbMaTV))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHoTen))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbKhoa))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNganh)
                    .addComponent(cbNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSdt)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan)
                    .addComponent(btnHuy)
                    .addComponent(btnLamMoi))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(content, java.awt.BorderLayout.CENTER);


    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormThemCapNhatThanhVien.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThemCapNhatThanhVien.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThemCapNhatThanhVien.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThemCapNhatThanhVien.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JComboBox<String> cbKhoa;
    private javax.swing.JComboBox<String> cbNganh;
    private javax.swing.JPanel content;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lbMaTV;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbKhoa;
    private javax.swing.JLabel lbNganh;
    private javax.swing.JLabel lbSdt;
    private javax.swing.JLabel lbThanhVien;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtMaTV;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtThanhVien;
    // End of variables declaration//GEN-END:variables

    // Custom font and color -start
    private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13p = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
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
