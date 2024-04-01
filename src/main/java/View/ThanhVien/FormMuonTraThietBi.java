/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.ThanhVien;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

/**
 *
 * @author phamv
 */
public class FormMuonTraThietBi extends javax.swing.JDialog {

    /**
     * Creates new form FormMuonTraThietBij
     */
    public FormMuonTraThietBi() {
    	setSize(450, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		setTitle("Mượn trả");
		setIconImage(new ImageIcon(getClass().getResource("/View/images/material.png")).getImage());
//        super(parent, modal);
        initComponents();
        initMyComponents();
        setVisible(true);
    }

    private void initMyComponents() {
        jlTitle.setFont(sgUI15b); // NOI18N
        jlTitle.setForeground(new Color(255, 255, 255));

        jlThanhVien.setFont(sgUI13b); // NOI18N

        jlThietBi.setFont(sgUI13b); // NOI18N

        btnMuon.setName("btnMuon"); // NOI18N
        btnMuon.setFont(sgUI13b);
        btnMuon.setFocusPainted(false);
        btnMuon.setBorderPainted(false);
        btnMuon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMuon.setPreferredSize(new java.awt.Dimension(100, 23));
        btnMuon.setBackground(Color.decode("#7ed6df"));

        btnTra.setFont(sgUI13b);
        btnTra.setFocusPainted(false);
        btnTra.setBorderPainted(false);
        btnTra.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnTra.setPreferredSize(new java.awt.Dimension(100, 23));
        btnTra.setBackground(Color.decode("#7ed6df"));

        btnLamMoi.setFont(sgUI13b);
        btnLamMoi.setFocusPainted(false);
        btnLamMoi.setBorderPainted(false);
        btnLamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(100, 23));
        btnLamMoi.setBackground(Color.decode("#7ed6df"));

        btnHuy.setFont(sgUI13b);
        btnHuy.setFocusPainted(false);
        btnHuy.setBorderPainted(false);
        btnHuy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHuy.setPreferredSize(new java.awt.Dimension(100, 23));
        btnHuy.setBackground(Color.decode("#7ed6df"));

        cbThanhVien.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbThanhVien.setBackground(Color.white);
        cbThanhVien.setFont(sgUI13b);
        cbThanhVien.setPreferredSize(new Dimension(100, 30));
        cbThanhVien.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });

        cbThietBi.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbThietBi.setBackground(Color.white);
        cbThietBi.setFont(sgUI13b);
        cbThietBi.setPreferredSize(new Dimension(100, 30));
        cbThietBi.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHeader = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        jpContent = new javax.swing.JPanel();
        jlThanhVien = new javax.swing.JLabel();
        jlThietBi = new javax.swing.JLabel();
        btnMuon = new javax.swing.JButton();
        btnTra = new javax.swing.JButton();
        cbThanhVien = new javax.swing.JComboBox<>();
        cbThietBi = new javax.swing.JComboBox<>();
        btnLamMoi = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();


        jpHeader.setBackground(new java.awt.Color(15, 145, 232));
        jpHeader.setPreferredSize(new java.awt.Dimension(400, 50));
        jpHeader.setLayout(new java.awt.BorderLayout());

        jlTitle.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jlTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitle.setText("Mượn Trả Thiết Bị");
        jlTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jpHeader.add(jlTitle, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpHeader, java.awt.BorderLayout.PAGE_START);
        jpHeader.getAccessibleContext().setAccessibleName("jpHeader");

        jlThanhVien.setText("Thành viên ");

        jlThietBi.setText("Thiết bị ");

        btnMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/borow_icon.png"))); // NOI18N
        btnMuon.setText("Mượn");
        btnMuon.setName("btnMuon"); // NOI18N
        btnMuon.setPreferredSize(new java.awt.Dimension(76, 23));
        btnMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuonActionPerformed(evt);
            }
        });

        btnTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/trathietbi_icon.jpg"))); // NOI18N
        btnTra.setText("Trả");
        btnTra.setPreferredSize(new java.awt.Dimension(76, 23));
        btnTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraActionPerformed(evt);
            }
        });

        cbThanhVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbThietBi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/Refresh_icon.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.setMaximumSize(new java.awt.Dimension(72, 23));
        btnLamMoi.setMinimumSize(new java.awt.Dimension(72, 23));

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/comeback_icon.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setPreferredSize(new java.awt.Dimension(76, 23));

        javax.swing.GroupLayout jpContentLayout = new javax.swing.GroupLayout(jpContent);
        jpContent.setLayout(jpContentLayout);
        jpContentLayout.setHorizontalGroup(
            jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContentLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpContentLayout.createSequentialGroup()
                        .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71))
                    .addGroup(jpContentLayout.createSequentialGroup()
                        .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlThanhVien)
                            .addComponent(jlThietBi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))))
        );
        jpContentLayout.setVerticalGroup(
            jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContentLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlThanhVien)
                    .addComponent(cbThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlThietBi)
                    .addComponent(cbThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        getContentPane().add(jpContent, java.awt.BorderLayout.CENTER);

      
    }// </editor-fold>//GEN-END:initComponents

    private void btnMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMuonActionPerformed

    private void btnTraActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTraActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnTraActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMuonTraThietBi.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMuonTraThietBi.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMuonTraThietBi.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMuonTraThietBi.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the dialog */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnMuon;
    private javax.swing.JButton btnTra;
    private javax.swing.JComboBox<String> cbThanhVien;
    private javax.swing.JComboBox<String> cbThietBi;
    private javax.swing.JLabel jlThanhVien;
    private javax.swing.JLabel jlThietBi;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JPanel jpContent;
    private javax.swing.JPanel jpHeader;
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

    // Custom font adn color - end
}
