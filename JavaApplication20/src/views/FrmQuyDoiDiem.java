/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.GuiQLQuyDoiDiem;
import services.QLQuyDoiDiemService;
import viewmodels.QLQuyDoiDiem;

/**
 *
 * @author Ngọc Thanh
 */
public class FrmQuyDoiDiem extends javax.swing.JDialog {

    private GuiQLQuyDoiDiem guiDiem;
    private List<QLQuyDoiDiem> lstDiem;
    public static String chucVu;
    private DefaultTableModel model;

    public FrmQuyDoiDiem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.guiDiem = new QLQuyDoiDiemService();

        model = (DefaultTableModel) tblBang.getModel();
        tblBang.setModel(model);

        this.setLocationRelativeTo(null);
        this.setTitle("Cấu hình điểm");
        this.loadTable();

        if (chucVu.equalsIgnoreCase("nhân viên") == false) {
            this.pnCapNhat.setVisible(true);
        } else {
            this.pnCapNhat.setVisible(false);
        }
        this.loadFill(0);
    }

    private void loadTable() {
        model.setRowCount(0);
        this.lstDiem = this.guiDiem.getAll();

        int stt = 1;
        for (QLQuyDoiDiem diem : lstDiem) {
            String trangThai = "Tiền quy ra điểm";
            if (diem.getTrangThai() == -1) {
                trangThai = "Điểm quy ra tiền";
            }
            model.addRow(new Object[]{stt++, diem.getSoDiem(), diem.getSoTien(), trangThai});
        }
    }

    private void loadFill(int i) {
        if (model.getValueAt(i, 3).toString().equalsIgnoreCase("tiền quy ra điểm")) {
            txtSoTienCanDoi.setText(model.getValueAt(i, 2).toString());
            txtSoDiemTuongUng.setText(model.getValueAt(i, 1).toString());
            txtSoDiemCanDoi.setText("");
            txtSoTienTuongUng.setText("");
        } else {
            txtSoDiemCanDoi.setText(model.getValueAt(i, 1).toString());
            txtSoTienTuongUng.setText(model.getValueAt(i, 2).toString());
            txtSoTienCanDoi.setText("");
            txtSoDiemTuongUng.setText("");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnTienQuyDiem = new javax.swing.JPanel();
        txtSoTienCanDoi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSoDiemTuongUng = new javax.swing.JTextField();
        pnDiemQuyTien = new javax.swing.JPanel();
        txtSoDiemCanDoi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSoTienTuongUng = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        pnCapNhat = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Số tiền quy ra điểm: ");

        jLabel2.setText("Số điểm tương ứng");

        javax.swing.GroupLayout pnTienQuyDiemLayout = new javax.swing.GroupLayout(pnTienQuyDiem);
        pnTienQuyDiem.setLayout(pnTienQuyDiemLayout);
        pnTienQuyDiemLayout.setHorizontalGroup(
            pnTienQuyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTienQuyDiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTienQuyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(pnTienQuyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoTienCanDoi, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(txtSoDiemTuongUng))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTienQuyDiemLayout.setVerticalGroup(
            pnTienQuyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTienQuyDiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTienQuyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTienCanDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnTienQuyDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDiemTuongUng, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Số điểm quy ra tiền");

        jLabel4.setText("Số tiền tương ứng");

        javax.swing.GroupLayout pnDiemQuyTienLayout = new javax.swing.GroupLayout(pnDiemQuyTien);
        pnDiemQuyTien.setLayout(pnDiemQuyTienLayout);
        pnDiemQuyTienLayout.setHorizontalGroup(
            pnDiemQuyTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDiemQuyTienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDiemQuyTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(pnDiemQuyTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoDiemCanDoi, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(txtSoTienTuongUng))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDiemQuyTienLayout.setVerticalGroup(
            pnDiemQuyTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDiemQuyTienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDiemQuyTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDiemCanDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnDiemQuyTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTienTuongUng, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Số điểm", "Số tiền", "Trạng thái"
            }
        ));
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        pnCapNhat.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 5));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnCapNhat.add(btnThem);

        btnCapNhat.setText("Cập nhật");
        pnCapNhat.add(btnCapNhat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTienQuyDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDiemQuyTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
            .addComponent(pnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnTienQuyDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnDiemQuyTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        this.GetDiem();
        this.loadTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        int row = this.tblBang.getSelectedRow();
        this.loadFill(row);
    }//GEN-LAST:event_tblBangMouseClicked

    private int trangThai; // 1: tiền quy điểm, -1: điểm quy tiền
    private int soDiem;
    private double soTien;

    private void GetDiem() {
        UUID id = null;
        String soTienQuyDoi = txtSoTienCanDoi.getText();
        String soDiemTuongUng = txtSoDiemTuongUng.getText();

        if (soTienQuyDoi.isEmpty() || soDiemTuongUng.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            txtSoTienCanDoi.grabFocus();
            return;
        }
        if (soDiemTuongUng.matches("\\d{1,}") == false || soTienQuyDoi.matches("\\d{1,}") == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số. Xin kiểm tra lại");
        }
        this.soTien = Double.parseDouble(soTienQuyDoi);
        this.soDiem = Integer.parseInt(soDiemTuongUng);
        if (soDiem < 0 || soTien < 0) {
            JOptionPane.showMessageDialog(this, "Giá trị không hợp lệ. Xin kiểm tra lại");
            return;
        }
        this.trangThai = 1;
        QLQuyDoiDiem tienQuyDiem = new QLQuyDoiDiem(id, soDiem, soTien, trangThai);
        this.guiDiem.ThemQuyDoiDiem(tienQuyDiem);

        String soDiemQuyDoi = txtSoDiemCanDoi.getText();
        String soTienTuongUng = txtSoTienTuongUng.getText();
        if (soDiemQuyDoi.isEmpty() || soTienTuongUng.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            txtSoTienCanDoi.grabFocus();
            return;
        }
        if (soDiemQuyDoi.matches("\\d{1,}") == false || soTienTuongUng.matches("\\d{1,}") == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số. Xin kiểm tra lại");
        }
        this.soTien = Double.parseDouble(soTienTuongUng);
        this.soDiem = Integer.parseInt(soDiemQuyDoi);
        if (soDiem < 0 || soTien < 0) {
            JOptionPane.showMessageDialog(this, "Giá trị không hợp lệ. Xin kiểm tra lại");
            return;
        }
        this.trangThai = -1;
        tienQuyDiem = new QLQuyDoiDiem(id, soDiem, soTien, trangThai);
        this.guiDiem.ThemQuyDoiDiem(tienQuyDiem);

        JOptionPane.showMessageDialog(this, "Cấu hình điểm thành công");

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmQuyDoiDiem dialog = new FrmQuyDoiDiem(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnCapNhat;
    private javax.swing.JPanel pnDiemQuyTien;
    private javax.swing.JPanel pnTienQuyDiem;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtSoDiemCanDoi;
    private javax.swing.JTextField txtSoDiemTuongUng;
    private javax.swing.JTextField txtSoTienCanDoi;
    private javax.swing.JTextField txtSoTienTuongUng;
    // End of variables declaration//GEN-END:variables
}
