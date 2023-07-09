package views;

import com.github.sarxos.webcam.WebcamResolution;
import domainmodels.ChucVu;
import domainmodels.CuaHang;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.GuiQLNhanVien;
import services.QLNhanVienService;
import viewmodels.QLNhanVien;

/**
 *
 * @author Ngọc Thanh
 */
public class FrmNhanVien extends javax.swing.JDialog {

    public static QLNhanVien nhanVien;
    public static QLNhanVien chuCuaHang;
    public static QLNhanVien nhanVienQuetQR;

    private GuiQLNhanVien guiNhanVien;
    private List<QLNhanVien> lstNhanVien;
    private List<CuaHang> lstCuaHang;
    private List<ChucVu> lstChucVu;

    private DefaultTableModel model;
    private DefaultComboBoxModel boxCuaHang;
    private DefaultComboBoxModel boxChucVu;

    public FrmNhanVien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Quản lý nhân viên");
        this.guiNhanVien = new QLNhanVienService();
        this.model = (DefaultTableModel) tblBang.getModel();
        tblBang.setModel(model);
        this.loadTable();
        this.loadComBoBox();

        this.lstChucVu = this.guiNhanVien.GetAllChucVu();
        this.lstCuaHang = this.guiNhanVien.GetAllCuaHang();
        if (nhanVien != null) {
            this.pnBang.setVisible(false);
            this.pnCrud.setVisible(false);
            this.loadNhanVien(nhanVien);
        } else if (chuCuaHang != null) {
            this.loadFill(0);
            this.pnTaiKhoan.setVisible(false);
        }
    }

    private void clear() {
        txtHoTen.setText("");
        txtNgaySinh.setDateFormatString("");
        txtSoDienThoai.setText("");
        txtMatKhau.setText("");
        txtDiaChi.setText("");
        txtHoTen.grabFocus();
        buttonGroup1.clearSelection();
    }

    private void loadComBoBox() {
        boxCuaHang = new DefaultComboBoxModel(this.guiNhanVien.GetAllCuaHang().toArray());
        cboCuaHang.setModel(boxCuaHang);

        boxChucVu = new DefaultComboBoxModel(this.guiNhanVien.GetAllChucVu().toArray());
        cboChucVu.setModel(boxChucVu);
    }

    private void loadTable() {
        model.setRowCount(0);
        this.lstNhanVien = this.guiNhanVien.getAll();

        int stt = 1;
        for (QLNhanVien nv : lstNhanVien) {
            String trangThai;
            if (nv.getTrangThai() == 1) {
                trangThai = "Đang làm";
            } else {
                trangThai = "Nghỉ việc";
            }
            model.addRow(new Object[]{stt++, nv.getMa(), nv.getHoTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getSoDienThoai(),
                nv.getDiaChi(), nv.getMatKhau(), trangThai});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnTaiKhoan = new javax.swing.JPanel();
        btnDoiMatKhau = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboCuaHang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboChucVu = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        pnCrud = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnThemTay = new javax.swing.JButton();
        pnBang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(228, 221, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnTaiKhoan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 5));

        btnDoiMatKhau.setText("Đổi mật khẩu");
        pnTaiKhoan.add(btnDoiMatKhau);

        jLabel1.setText("Họ Tên");

        jLabel5.setText("Số điện thoại");

        jLabel2.setText("Giới Tính");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel6.setText("Mật khẩu");

        jLabel7.setText("Cửa hàng");

        jLabel4.setText("Địa chỉ");

        jLabel8.setText("Chức vụ");

        jLabel3.setText("Ngày sinh");

        txtNgaySinh.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(37, 37, 37)
                                .addComponent(rdoNu))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatKhau)
                            .addComponent(cboCuaHang, 0, 218, Short.MAX_VALUE)
                            .addComponent(cboChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoNam)
                        .addComponent(rdoNu)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pnCrud.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 5));

        btnThem.setText("QR");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnCrud.add(btnThem);

        btnXoa.setText("Xóa");
        pnCrud.add(btnXoa);

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        pnCrud.add(btnCapNhat);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        pnCrud.add(btnClear);

        btnThemTay.setText("Thêm");
        btnThemTay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTayActionPerformed(evt);
            }
        });
        pnCrud.add(btnThemTay);

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Họ tên", "Giới Tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Mật khẩu", "Trạng thái"
            }
        ));
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        javax.swing.GroupLayout pnBangLayout = new javax.swing.GroupLayout(pnBang);
        pnBang.setLayout(pnBangLayout);
        pnBangLayout.setHorizontalGroup(
            pnBangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnBangLayout.setVerticalGroup(
            pnBangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCrud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnBang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnBang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnCrud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadNhanVien(QLNhanVien nhanVien) {
        txtHoTen.setText(nhanVien.getHoTen());
        txtDiaChi.setText(nhanVien.getDiaChi());
        txtNgaySinh.setDate(nhanVien.getNgaySinh());
        String gioiTinh = nhanVien.getGioiTinh();
        if (gioiTinh.equalsIgnoreCase("nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtSoDienThoai.setText(nhanVien.getSoDienThoai());
        txtMatKhau.setText(nhanVien.getMatKhau());
        cboCuaHang.setSelectedItem(nhanVien.getTenCuaHang());
        cboChucVu.setSelectedItem(nhanVien.getTenChucVu());
    }

    private QLNhanVien GetNhanVien() {
        String sdt = txtSoDienThoai.getText();
        String matKhau = txtMatKhau.getText();

        int indexChucVu = cboChucVu.getSelectedIndex();
        String chucVu = cboChucVu.getSelectedItem().toString();
        UUID idChucVu = this.lstChucVu.get(indexChucVu).getId();

        int indexCuaHang = cboCuaHang.getSelectedIndex();
        String cuaHang = cboCuaHang.getSelectedItem().toString();
        UUID idCuaHang = this.lstCuaHang.get(indexCuaHang).getId();

        if (sdt.isEmpty() || matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống. Xin kiểm tra lại");
            txtSoDienThoai.grabFocus();
            return null;
        }

        if (sdt.matches("\\d{10}") == false) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ. Xin kiểm tra lại");
            txtSoDienThoai.grabFocus();
            return null;
        }
        nhanVienQuetQR.setIdChucVu(idChucVu);
        nhanVienQuetQR.setTenChucVu(chucVu);
        nhanVienQuetQR.setIdCuaHang(idCuaHang);
        nhanVienQuetQR.setTenCuaHang(cuaHang);
        nhanVienQuetQR.setId(null);
        nhanVienQuetQR.setSoDienThoai(sdt);
        nhanVienQuetQR.setMatKhau(matKhau);
        nhanVienQuetQR.setIdNguoiQuanLy(nhanVien.getId());
        nhanVienQuetQR.setMa(nhanVienQuetQR.GetMaNhanVien());
        return nhanVienQuetQR;
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        this.clear();
        new FrmQRCode(new javax.swing.JFrame(), true).setVisible(true);
        if (nhanVienQuetQR != null) {
            this.loadNhanVien(nhanVienQuetQR);
            int row = this.guiNhanVien.ThemQLNhanVien(nhanVienQuetQR);
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
                this.loadTable();
                int size = this.lstNhanVien.size() - 1;
                this.tblBang.setRowSelectionInterval(size, size);
            } else {
                JOptionPane.showMessageDialog(this, "Đã tồn tại số điện thoại này. Xin kiểm tra lại");
                txtSoDienThoai.grabFocus();
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void loadFill(int i) {
        QLNhanVien nhanVien = this.lstNhanVien.get(i);
        this.loadNhanVien(nhanVien);
    }

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        int row = tblBang.getSelectedRow();
        this.loadFill(row);
    }//GEN-LAST:event_tblBangMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnThemTayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTayActionPerformed
        String hoTen = txtHoTen.getText();
        String gioiTinh = null;
        if (rdoNam.isSelected()) {
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nữ";
        }
        Date ngaySinh = txtNgaySinh.getDate();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSoDienThoai.getText();
        String matKhau = txtMatKhau.getText();

        int indexChucVu = cboChucVu.getSelectedIndex();
        String chucVu = cboChucVu.getSelectedItem().toString();
        UUID idChucVu = this.lstChucVu.get(indexChucVu).getId();

        int indexCuaHang = cboCuaHang.getSelectedIndex();
        String cuaHang = cboCuaHang.getSelectedItem().toString();
        UUID idCuaHang = this.lstCuaHang.get(indexCuaHang).getId();

        if (hoTen.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống. Xin kiểm tra lại");
            txtHoTen.grabFocus();
            return;
        }

        if (gioiTinh == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính");
            return;
        }
        if (ngaySinh == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh");
            return;
        }

        if (sdt.matches("\\d{10}") == false) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ. Xin kiểm tra lại");
            txtSoDienThoai.grabFocus();
            return;
        }
        String ma = null;
        UUID id = null;
        UUID idNQL = chuCuaHang.getId();

        QLNhanVien nhanVien = new QLNhanVien(id, ma, hoTen, gioiTinh, ngaySinh, diaChi, sdt, matKhau, idChucVu, chucVu, idCuaHang, cuaHang, idNQL, 1);
        nhanVien.setMa(nhanVien.GetMaNhanVien());

        int row = this.guiNhanVien.ThemQLNhanVien(nhanVien);
        if (row > 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công nhân viên");
            this.loadTable();
            this.clear();
        } else {
            JOptionPane.showMessageDialog(this, "Số điện thoại bị trùng");
            txtSoDienThoai.grabFocus();
        }
    }//GEN-LAST:event_btnThemTayActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhatActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmNhanVien dialog = new FrmNhanVien(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemTay;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JComboBox<String> cboCuaHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnBang;
    private javax.swing.JPanel pnCrud;
    private javax.swing.JPanel pnTaiKhoan;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMatKhau;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
