package views;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.GuiQLSuDungDiem;
import services.QLSuDungDiemService;
import viewmodels.QLSuDungDiem;

/**
 *
 * @author Ngọc Thanh
 */
public class FrmLichSuTieuDung extends javax.swing.JDialog {

    private GuiQLSuDungDiem guiSuDungDiem;
    private DefaultTableModel model;
    private List<QLSuDungDiem> lstQuanLySuDungDiem;

    public FrmLichSuTieuDung(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Lịch sử sử dụng điểm của khách hàng");
        this.guiSuDungDiem = new QLSuDungDiemService();
        this.model = (DefaultTableModel) tblBang.getModel();
        tblBang.setModel(model);
        this.loadTable();
    }

    private void loadTable() {
        model.setRowCount(0);
        this.lstQuanLySuDungDiem = this.guiSuDungDiem.getAll();

        int stt = 1;
        for (QLSuDungDiem diem : lstQuanLySuDungDiem) {
            String trangThai = "Cộng điểm";
            if (diem.getTrangThai() == -1) {
                trangThai = "Trừ điểm";
            }
            model.addRow(new Object[]{stt++, diem.getMaHoaDon(), diem.getNgayTao(),
                diem.getNgayThanhToan(), diem.getMaKhachHang(), diem.getTenKhachHang(),
                diem.getSoDienThoai(), diem.getSoDiem(), trangThai});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày tạo", "Ngày thanh toán", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Số điểm", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(tblBang);
        if (tblBang.getColumnModel().getColumnCount() > 0) {
            tblBang.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblBang.getColumnModel().getColumn(1).setPreferredWidth(35);
            tblBang.getColumnModel().getColumn(2).setPreferredWidth(28);
            tblBang.getColumnModel().getColumn(3).setPreferredWidth(45);
            tblBang.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblBang.getColumnModel().getColumn(5).setPreferredWidth(55);
            tblBang.getColumnModel().getColumn(6).setPreferredWidth(45);
            tblBang.getColumnModel().getColumn(7).setPreferredWidth(20);
            tblBang.getColumnModel().getColumn(8).setPreferredWidth(60);
        }

        txtTimKiem.setText("Tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
            .addComponent(txtTimKiem)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmLichSuTieuDung dialog = new FrmLichSuTieuDung(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
