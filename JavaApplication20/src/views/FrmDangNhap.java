package views;

import domainmodels.NhanVien;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import repositorys.GuiNhanVien;
import repositorys.NhanVienRepository;
import services.GuiQLNhanVien;
import services.QLNhanVienService;
import viewmodels.QLNhanVien;

public class FrmDangNhap extends javax.swing.JFrame {

    private GuiNhanVien guiNhanVien;
    private GuiQLNhanVien guiQLNhanVien;

    public FrmDangNhap() {
        initComponents();
        txtusername.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtpassword.setBackground(new java.awt.Color(0, 0, 0, 1));
        this.guiNhanVien = new NhanVienRepository();
        this.guiQLNhanVien = new QLNhanVienService();
        txtpassword.setEchoChar((char) 8226);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblThoat = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        disable = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        chkHienThi = new javax.swing.JCheckBox();
        lblQuenMatKhau = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 221, 213));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 340, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 440));

        jPanel2.setBackground(new java.awt.Color(228, 221, 213));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblThoat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(255, 255, 255));
        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat.setText("X");
        lblThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
        });
        jPanel2.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 40, 29));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(158, 8, 10));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Đăng Nhập");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 350, 41));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(158, 8, 10));
        jLabel5.setText("Tên đăng nhập");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 341, -1));

        txtusername.setFont(txtusername.getFont().deriveFont(txtusername.getFont().getSize()+2f));
        txtusername.setForeground(new java.awt.Color(158, 8, 10));
        txtusername.setBorder(null);
        txtusername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtusernameMouseClicked(evt);
            }
        });
        txtusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusernameKeyPressed(evt);
            }
        });
        jPanel2.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 140, 280, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_________________________________________");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 147, 290, 39));

        jLabel7.setBackground(new java.awt.Color(255, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_20px_1.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 40, 39));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(158, 8, 10));
        jLabel8.setText("Mật khẩu");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 341, -1));

        txtpassword.setFont(txtpassword.getFont().deriveFont(txtpassword.getFont().getSize()+2f));
        txtpassword.setForeground(new java.awt.Color(158, 8, 10));
        txtpassword.setBorder(null);
        txtpassword.setCaretColor(new java.awt.Color(255, 255, 255));
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });
        jPanel2.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 280, 30));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("_________________________________________");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 216, 290, 40));

        disable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_invisible_20px_1.png"))); // NOI18N
        disable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disableMouseClicked(evt);
            }
        });
        jPanel2.add(disable, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 216, 40, 40));

        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_eye_20px_1.png"))); // NOI18N
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 216, 40, 40));

        chkHienThi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkHienThi.setForeground(new java.awt.Color(158, 8, 10));
        chkHienThi.setText("Hiển Thị");
        chkHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHienThiActionPerformed(evt);
            }
        });
        jPanel2.add(chkHienThi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 90, -1));

        lblQuenMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblQuenMatKhau.setForeground(new java.awt.Color(158, 8, 10));
        lblQuenMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQuenMatKhau.setText("Quên mật khẩu ?");
        lblQuenMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseClicked(evt);
            }
        });
        jPanel2.add(lblQuenMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 261, 130, 27));

        btnDangNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(158, 8, 10));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jPanel2.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 330, 330, 40));

        jLabel4.setFont(new java.awt.Font("Lao Sangam MN", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Design by Nhom 999 ®");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 200, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 430, 440));

        setSize(new java.awt.Dimension(731, 435));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        txtpassword.setEchoChar((char) 8226);
        disable.setVisible(true);
        disable.setEnabled(true);
        show.setEnabled(false);
        show.setEnabled(false);
    }//GEN-LAST:event_showMouseClicked

    private void disableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disableMouseClicked
        txtpassword.setEchoChar((char) 0);
        disable.setVisible(false);
        disable.setEnabled(false);
        show.setEnabled(true);
        show.setEnabled(true);
    }//GEN-LAST:event_disableMouseClicked

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn thoát chương trình", "Thoát", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(this, "Suy nghĩ kỹ nhen");
        }
    }//GEN-LAST:event_lblThoatMouseClicked

    private void chkHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHienThiActionPerformed
        if (chkHienThi.isSelected()) {
            txtpassword.setEchoChar((char) 0);
        } else {
            txtpassword.setEchoChar((char) 8226);
        }
        txtpassword.grabFocus();
    }//GEN-LAST:event_chkHienThiActionPerformed

    private void txtusernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtpassword.grabFocus();
        }
    }//GEN-LAST:event_txtusernameKeyPressed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.DangNhap();
        }
    }//GEN-LAST:event_txtpasswordKeyPressed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        this.DangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void lblQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseClicked
        this.dispose();
        new FrmQuenMatKhau(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_lblQuenMatKhauMouseClicked

    private void txtusernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusernameMouseClicked
        txtusername.setText("");
    }//GEN-LAST:event_txtusernameMouseClicked

    private NhanVien getNhanVien() {
        String sdt = txtusername.getText();
        String matKhau = new String(txtpassword.getPassword());
        if (sdt.isEmpty() || matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống. Xin kiểm tra lại");
            txtusername.grabFocus();
            return null;
        }
        NhanVien nv = this.guiNhanVien.GetSDTNhanVien(sdt);
        if (nv == null) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đăng nhập không hợp lệ. Xin kiểm tra lại");
            txtusername.grabFocus();
            return null;
        }

        if (nv.getMatKhau().equalsIgnoreCase(matKhau) == false) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không hợp lệ. Xin kiểm tra lại");
            txtpassword.grabFocus();
            return null;
        }
        return nv;
    }

    private void DangNhap() {
        NhanVien nv = this.getNhanVien();
        if (nv != null) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
            this.dispose();
            FrmMainUi.nhanVien = this.guiQLNhanVien.GetSDTNhanVien(nv.getSoDienThoai());
            new FrmMainUi().setVisible(true);
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JCheckBox chkHienThi;
    private javax.swing.JLabel disable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblQuenMatKhau;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel show;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
