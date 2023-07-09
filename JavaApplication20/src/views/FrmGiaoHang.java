package views;

import domainmodels.DiemKhachHang;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;
import javax.swing.JOptionPane;
import services.GuiQLDiemKhachHang;
import services.GuiQLHoaDon;
import services.GuiQLKhachHang;
import services.QLDiemKhachHangService;
import services.QLHoaDonService;
import services.QLKhachHangService;
import services.QLNhanVienService;
import viewmodels.QLDiemKhachHang;
import viewmodels.QLHoaDon;
import viewmodels.QLKhachHang;
import viewmodels.QLNhanVien;

/**
 *
 * @author lanan
 */
public class FrmGiaoHang extends javax.swing.JDialog {

    public static QLNhanVien nhanVien;
    private GuiQLKhachHang guiKhachHang;
    private GuiQLDiemKhachHang guiDiemKhachHang;
    private GuiQLHoaDon guiHoaDon;

    public static QLHoaDon hoaDon;

    public static int trangThaiHienThi = -1;
  
    public FrmGiaoHang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.inIt();

    }

    private void inIt() {
        setLocationRelativeTo(null);
        this.setTitle("Form giao hàng");
        txtGhiChu.setWrapStyleWord(true); // Tu dong xuong dong cho phu hop
        txtGhiChu.setLineWrap(true); // Tu dong xuong dong
        this.guiKhachHang = new QLKhachHangService();
        this.guiDiemKhachHang = new QLDiemKhachHangService();
        this.guiHoaDon = new QLHoaDonService();

        lblNgayTao.setText(hoaDon.getNgayTao());
        lblTongTien.setText(String.valueOf(hoaDon.getTongTien()));
        txtTenNhanVien.setText(hoaDon.getTenNhanVien());
        txtMaNhanVien.setText(nhanVien.getMa());
        txtMaHoaDon.setText(hoaDon.getMa());
        lblNgayTao.setText(hoaDon.getNgayTao());
        if (hoaDon.getMoTa() != null) {
            txtGhiChu.setText(hoaDon.getMoTa());
        }
        this.loadKhachHang();
        this.HienThiHoaDon();
    }

    private void HienThiHoaDon() {
        if (trangThaiHienThi == 1) {
            this.loadHoaDonGiaoHang();
        } else {
            if (hoaDon.getNgayThanhToan() == null) {
                txtPhiGiaoHang.setText("");   
            } else {
                this.loadHoaDonGiaoHang();
            }
        }
    }

    private void loadHoaDonGiaoHang() {
        try {
            txtNgayThanhToan.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(hoaDon.getNgayThanhToan()));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        txtNgayNhanMongMuon.setDate(hoaDon.getNgayNhanHangMongMuon());
        txtNgayGiaoHang.setDate(hoaDon.getNgayBatDauGiao());
        txtNgayNhanThanhCong.setDate(hoaDon.getNgayNhanHangThanhCong());
        txtPhiGiaoHang.setText(String.valueOf(hoaDon.getPhiShip()));
    }

    private void loadKhachHang() {
        if (hoaDon.getIdKhachHang() != null) {
            QLKhachHang khachHang = this.guiKhachHang.GetKhachHang(hoaDon.getIdKhachHang());
            String tenKhachHang = khachHang.getHoTen();
            txtTenNguoiNhan.setText(tenKhachHang);

            String sdt = "";
            if (khachHang.getSoDienThoai() != null) {
                sdt = khachHang.getSoDienThoai();
            }
            txtSoDienThoai.setText(sdt);
            String diaChi = "";
            if (khachHang.getDiaChi() != null) {
                diaChi = khachHang.getDiaChi();
            }
            txtDiaChi.setText(diaChi);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtPhiGiaoHang = new javax.swing.JTextField();
        txtMaHoaDon = new javax.swing.JTextField();
        txtNgayThanhToan = new com.toedter.calendar.JDateChooser();
        txtNgayNhanMongMuon = new com.toedter.calendar.JDateChooser();
        txtNgayGiaoHang = new com.toedter.calendar.JDateChooser();
        txtNgayNhanThanhCong = new com.toedter.calendar.JDateChooser();
        txtTenNguoiNhan = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTenNhanVien = new javax.swing.JTextField();
        lbl2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        btnXacNhan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("FormGiaoHang"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Bán Giao Hàng");

        lbl1.setText("Tên Người Nhận");

        jLabel3.setText("Số Điện Thoại");

        jLabel4.setText("Địa Chỉ");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        jLabel12.setText("Phí Giao Hàng");

        jLabel13.setText("Mã hóa đơn");

        jLabel15.setText("Ngày Thanh Toán");

        jLabel16.setText("Ngày Giao Hàng");

        jLabel17.setText("Ngày Mong Muốn Nhận");

        jLabel18.setText("Ngày Nhận Thành Công");

        txtPhiGiaoHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhiGiaoHangKeyReleased(evt);
            }
        });

        txtMaHoaDon.setEditable(false);

        txtNgayThanhToan.setDateFormatString("yyyy-MM-dd");

        txtNgayNhanMongMuon.setDateFormatString("yyyy-MM-dd");

        txtNgayGiaoHang.setDateFormatString("yyyy-MM-dd");

        txtNgayNhanThanhCong.setDateFormatString("yyyy-MM-dd");

        txtTenNhanVien.setEditable(false);

        lbl2.setText("Tên nhân viên");

        jLabel19.setText("Mã nhân viên");

        txtMaNhanVien.setEditable(false);

        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        jLabel2.setText("Tổng tiền: ");

        jLabel5.setText("Ngày tạo hóa đơn");

        jLabel6.setText("Ghi chú");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel1)
                        .addGap(0, 332, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(32, 32, 32))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoDienThoai)
                                    .addComponent(txtDiaChi)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenNhanVien)
                                    .addComponent(txtTenNguoiNhan))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(59, 59, 59)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(47, 47, 47)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                        .addComponent(txtPhiGiaoHang)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNgayNhanMongMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNgayGiaoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNgayNhanThanhCong, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                        .addComponent(lblNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl2)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl1)
                            .addComponent(txtTenNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtPhiGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayGiaoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgayNhanMongMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayNhanThanhCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát", "Thoát", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Suy nghĩ kỹ nè");
        }
    }//GEN-LAST:event_formWindowClosing

    private boolean ValiDateTien() {
        if (txtPhiGiaoHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống. Xin kiểm tra lại");
            return false;
        }

        try {
            double phiGiaoHang = Double.parseDouble(txtPhiGiaoHang.getText());
            if (phiGiaoHang < 0) {
                JOptionPane.showMessageDialog(this, "Tiền ship không hợp lệ. Xin kiểm tra lại");
                txtPhiGiaoHang.grabFocus();
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Giá trị không hợp lệ. Xin kiểm tra lại");
            txtPhiGiaoHang.grabFocus();
            return false;
        }
        return true;
    }

    private boolean ValiDateNgay() {
        java.util.Date ngayThanhToan = null;
        java.util.Date ngayGiaoHang = null;
        java.util.Date ngayMongMuonNhanHang = null;
        java.util.Date ngayNhanHangThanhCong = null;

        ngayThanhToan = txtNgayThanhToan.getDate();
        if (ngayThanhToan == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống.Xin kiểm tra lại");
            txtNgayThanhToan.grabFocus();
        }

        ngayGiaoHang = txtNgayGiaoHang.getDate();
        if (ngayGiaoHang == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống.Xin kiểm tra lại");
            txtNgayGiaoHang.grabFocus();
        }

        ngayMongMuonNhanHang = txtNgayNhanMongMuon.getDate();
        if (ngayMongMuonNhanHang == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống.Xin kiểm tra lại");
            txtNgayNhanMongMuon.grabFocus();
        }

        ngayNhanHangThanhCong = txtNgayNhanThanhCong.getDate();
        if (ngayNhanHangThanhCong == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống.Xin kiểm tra lại");
            txtNgayNhanThanhCong.grabFocus();
        }

        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        String ngayTToan = df.format(ngayThanhToan);

        hoaDon.setNgayThanhToan(ngayTToan);
        hoaDon.setNgayBatDauGiao(ngayGiaoHang);
        hoaDon.setNgayNhanHangMongMuon(ngayMongMuonNhanHang);
        hoaDon.setNgayNhanHangThanhCong(ngayNhanHangThanhCong);

        int res = 0;
        try {
            res = hoaDon.kiemTraNgayHopLe();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (res == -1) {
            JOptionPane.showMessageDialog(this, "Ngày giao phải sau hoặc cùng ngày tạo hóa đơn");
            return false;
        }

        if (res == -2) {
            JOptionPane.showMessageDialog(this, "Ngày nhận hàng mong muốn phải sau hoặc cùng ngày tạo hóa đơn");
            return false;
        }

        if (res == -3) {
            JOptionPane.showMessageDialog(this, "Ngày nhận hàng thành công phải sau hoặc cùng ngày tạo hóa đơn");
            return false;
        }

        if (res == -4) {
            JOptionPane.showMessageDialog(this, "Ngày thanh toán phải sau hoặc cùng ngày tạo hóa đơn");
            return false;
        }

        if (res == -5) {
            JOptionPane.showMessageDialog(this, "Ngày giao phải trước ngày nhận hàng cửa khách");
            return false;
        }
        return true;
    }

    private void ThemKhachHang() {
        String tenKhachHang = txtTenNguoiNhan.getText();
        String soDienThoai = txtSoDienThoai.getText();
        String diaChi = txtDiaChi.getText();

        UUID id = null;
        String ma = null;
        QLKhachHang khachHang = new QLKhachHang(id, ma, tenKhachHang, soDienThoai, diaChi, null, null, 0);
        khachHang.setMa(khachHang.GetMaKhachHang());
        this.guiKhachHang.ThemQLKhachHang(khachHang); // thêm khách hàng
        UUID idKhachHang = this.guiKhachHang.GetId(soDienThoai);
        QLDiemKhachHang diemKhachHang = new QLDiemKhachHang(null, idKhachHang, 0);
        this.guiDiemKhachHang.ThemDiemKhachHangMoi(diemKhachHang); // tạo điểm cho khách hàng
    }

    private void XuLy() {
        String tenKhachHang = txtTenNguoiNhan.getText();
        String sdt = txtSoDienThoai.getText();
        String diaChi = txtDiaChi.getText();

        if (tenKhachHang.isEmpty() || sdt.isEmpty() || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống. Xin kiểm tra lại");
            return;
        }

        if (sdt.matches("\\d{10}") == false) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ. Xin kiểm tra lại");
            return;
        }

        boolean checkMoney = this.ValiDateTien();
        if (checkMoney == false) {
            return;
        }

        boolean checkDay = this.ValiDateNgay();
        if (checkDay == false) {
            return;
        }

        if (hoaDon.getIdKhachHang() != null) {
            QLKhachHang khachHang = this.guiKhachHang.GetKhachHang(hoaDon.getIdKhachHang());
            khachHang.setSoDienThoai(sdt);
            khachHang.setDiaChi(diaChi);
            this.guiKhachHang.SuaQLKhachHang(khachHang);
        } else {
            this.ThemKhachHang();
        }

        UUID idKhachHang = hoaDon.getIdKhachHang();
        if (idKhachHang == null) {
            idKhachHang = this.guiKhachHang.GetId(sdt);
        }

        java.util.Date d = txtNgayThanhToan.getDate();
        java.sql.Date ngayThanhToan = new java.sql.Date(d.getTime());
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);

        String ngayTToan = df.format(d);

        d = txtNgayGiaoHang.getDate();
        java.sql.Date ngayGiaoHang = new java.sql.Date(d.getTime());

        d = txtNgayNhanMongMuon.getDate();
        java.sql.Date ngayNhanMongMuon = new java.sql.Date(d.getTime());

        d = txtNgayNhanThanhCong.getDate();
        java.sql.Date ngayNhanThanhCong = new java.sql.Date(d.getTime());

        //hoaDon.setKieuBan(1);
        hoaDon.setSoDiemTieu(0);
        hoaDon.setTongTien(hoaDon.getTongTien());
        hoaDon.setPhiShip(Integer.parseInt(txtPhiGiaoHang.getText()));
        hoaDon.setIdKhachHang(idKhachHang);
        hoaDon.setHoTen(txtTenNguoiNhan.getText());
        hoaDon.setSoDienThoai(sdt);
        hoaDon.setDiaChi(diaChi);
        hoaDon.setTrangThai(3);
        hoaDon.setMoTa(txtGhiChu.getText());
        hoaDon.setNgayBatDauGiao(ngayGiaoHang);
        hoaDon.setNgayNhanHangMongMuon(ngayNhanMongMuon);
        hoaDon.setNgayNhanHangThanhCong(ngayNhanThanhCong);
        hoaDon.setNgayThanhToan(ngayTToan);
        this.guiHoaDon.CapNhatHoaDon(hoaDon);
        JOptionPane.showMessageDialog(this, "Thành công");
        this.dispose();
    }

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        this.XuLy();
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void txtPhiGiaoHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhiGiaoHangKeyReleased
        String tienShip = txtPhiGiaoHang.getText();
        if (tienShip.isEmpty() == false) {
            try {
                double tienGiaoHang = Double.parseDouble(tienShip);
                double TongTien = tienGiaoHang + hoaDon.getTongTien();
                lblTongTien.setText(String.valueOf(TongTien));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_txtPhiGiaoHangKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmGiaoHang dialog = new FrmGiaoHang(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaNhanVien;
    private com.toedter.calendar.JDateChooser txtNgayGiaoHang;
    private com.toedter.calendar.JDateChooser txtNgayNhanMongMuon;
    private com.toedter.calendar.JDateChooser txtNgayNhanThanhCong;
    private com.toedter.calendar.JDateChooser txtNgayThanhToan;
    private javax.swing.JTextField txtPhiGiaoHang;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenNguoiNhan;
    private javax.swing.JTextField txtTenNhanVien;
    // End of variables declaration//GEN-END:variables
}
