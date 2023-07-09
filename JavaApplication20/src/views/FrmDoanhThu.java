package views;

/**
 *
 * @author Ngọc Thanh
 */
public class FrmDoanhThu extends javax.swing.JFrame {

    public FrmDoanhThu() {
        initComponents();
        this.setTitle("Doanh thu của cửa hàng");
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboThoiGian = new javax.swing.JComboBox<>();
        cboBieuDo = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnBieuDo = new javax.swing.JButton();
        pnNgay = new javax.swing.JPanel();
        txtNgayThanhToan = new com.toedter.calendar.JDateChooser();
        pnThang = new javax.swing.JPanel();
        cboThang = new javax.swing.JComboBox<>();
        pnTuan = new javax.swing.JPanel();
        cboTuan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboThoiGian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tuần", "Tháng" }));
        cboThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThoiGianActionPerformed(evt);
            }
        });
        getContentPane().add(cboThoiGian, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 12, 120, 30));

        cboBieuDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tổng doanh thu", "Tỉ lệ đơn hàng" }));
        cboBieuDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBieuDoActionPerformed(evt);
            }
        });
        getContentPane().add(cboBieuDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 12, 148, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 195, 960, 260));

        btnBieuDo.setText("Xem biểu đồ");
        getContentPane().add(btnBieuDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 118, 31));

        pnNgay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNgayThanhToan.setDateFormatString("yyyy-MM-dd");
        pnNgay.add(txtNgayThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        getContentPane().add(pnNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 210, 70));

        pnThang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
        pnThang.add(cboThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        getContentPane().add(pnThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, 70));

        pnTuan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboTuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tuần 1", "Tuần 2", "Tuần 3", "Tuần 4", "Các ngày còn lại" }));
        cboTuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTuanActionPerformed(evt);
            }
        });
        pnTuan.add(cboTuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        getContentPane().add(pnTuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void cboThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThoiGianActionPerformed
        
    }//GEN-LAST:event_cboThoiGianActionPerformed


    private void cboBieuDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBieuDoActionPerformed

    }//GEN-LAST:event_cboBieuDoActionPerformed

    private void cboTuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTuanActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDoanhThu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBieuDo;
    private javax.swing.JComboBox<String> cboBieuDo;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JComboBox<String> cboThoiGian;
    private javax.swing.JComboBox<String> cboTuan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnNgay;
    private javax.swing.JPanel pnThang;
    private javax.swing.JPanel pnTuan;
    private com.toedter.calendar.JDateChooser txtNgayThanhToan;
    // End of variables declaration//GEN-END:variables
}
