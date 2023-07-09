package views;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import repositorys.DBContext;
import services.GuiQLChiTietSanPham;
import services.GuiQLDiemKhachHang;
import services.GuiQLGiaoDich;
import services.GuiQLHoaDon;
import services.GuiQLHoaDonChiTiet;
import services.GuiQLKhachHang;
import services.GuiQLNhanVien;
import services.GuiQLQuyDoiDiem;
import services.GuiQLSuDungDiem;
import services.QLChiTietSanPhamService;
import services.QLDiemKhachHangService;
import services.QLGiaoDichService;
import services.QLHoaDonChiTietService;
import services.QLHoaDonService;
import services.QLKhachHangService;
import services.QLNhanVienService;
import services.QLQuyDoiDiemService;
import services.QLSuDungDiemService;
import supports.DocSoThanhChuoi;
import supports.Functions;
import viewmodels.QLChiTietSanPham;
import viewmodels.QLHoaDon;
import viewmodels.QLHoaDonChiTiet;
import viewmodels.QLKhachHang;
import viewmodels.QLNhanVien;
import supports.DocSoThanhChuoi;
import viewmodels.QLDiemKhachHang;
import viewmodels.QLSuDungDiem;

public class FrmMainUi extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private DefaultTableModel modelSanPham;
    private DefaultTableModel modelHoaDon;
    private DefaultTableModel modelHoaDonChiTiet;

    private GuiQLChiTietSanPham guiSanPham;
    private GuiQLHoaDon guiHoaDon;
    private GuiQLHoaDonChiTiet guiHoaDonChiTiet;
    private GuiQLNhanVien guiNhanVien;
    private GuiQLDiemKhachHang guiDiemKhachHang;
    private GuiQLSuDungDiem guiSDDiem;
    private GuiQLQuyDoiDiem guiQuyDoi;
    private GuiQLGiaoDich guiGiaoDich;
    private GuiQLKhachHang guiKhachHang;

    private List<QLHoaDon> lstHoaDon;
    private List<QLChiTietSanPham> lstSanPham;
    private List<QLHoaDonChiTiet> lstGioHang;

    private String loaiGiaoDich = "Tiền mặt";
    public static QLNhanVien nhanVien;
    private UUID idNhanVien;
    private String chucVu;
    private int TrangThaiCuaHoaDon;
    private int kieuBan = 0;

    public static QLKhachHang khachHang;

    private WebcamPanel panel = null;
    public Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public FrmMainUi() {
        initComponents();
        this.DoRongCacCot();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.HienThiSoTienChuyenKhoan(false);
        this.HienThiSoTienMat(true);
        this.InIt();
        this.initWebcam();
    }

    private void InIt() {
        this.guiSanPham = new QLChiTietSanPhamService();
        this.guiHoaDon = new QLHoaDonService();
        this.guiHoaDonChiTiet = new QLHoaDonChiTietService();
        this.guiNhanVien = new QLNhanVienService();
        this.guiDiemKhachHang = new QLDiemKhachHangService();
        this.guiSDDiem = new QLSuDungDiemService();
        this.guiQuyDoi = new QLQuyDoiDiemService();
        this.guiGiaoDich = new QLGiaoDichService();
        this.guiKhachHang = new QLKhachHangService();

        modelHoaDon = (DefaultTableModel) this.tblHoaDon.getModel();
        tblHoaDon.setModel(modelHoaDon);

        modelHoaDonChiTiet = (DefaultTableModel) this.tblGioHang.getModel();
        tblGioHang.setModel(modelHoaDonChiTiet);

        modelSanPham = (DefaultTableModel) this.tblSanPham.getModel();
        tblSanPham.setModel(modelSanPham);

        this.idNhanVien = this.nhanVien.getId();
        this.chucVu = this.nhanVien.getTenChucVu();
        this.TrangThaiCuaHoaDon = cboTrangThaiHoaDon.getSelectedIndex();
        lblTenNhanVien.setText(lblTenNhanVien.getText() + this.nhanVien.getHoTen());

        txtSoTienMat.grabFocus();
        this.rdoTienMat.setSelected(true);
        txtSoDiemSuDung.setEditable(false);
        this.loadHoaDon();
        int size = modelHoaDon.getRowCount();
        if (size > 0) {
            tblHoaDon.setRowSelectionInterval(0, 0);
            QLHoaDon hoaDon = this.lstHoaDon.get(0);
            this.lstGioHang = this.guiHoaDonChiTiet.getAll(hoaDon.getId());
            this.loadGioHang();
            size = modelHoaDonChiTiet.getRowCount();
            if (size > 0) {
                tblGioHang.setRowSelectionInterval(0, 0);
            }
            this.loadThongTinDeThanhToan(0);
        }
        this.loadSanPham();
    }

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        pnQr.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 160));

        executor.execute(this);
    }

    private void loadHoaDon() {
        modelHoaDon.setRowCount(0);
        this.lstHoaDon = this.guiHoaDon.getAll(TrangThaiCuaHoaDon, idNhanVien);
        int stt = 1;
        for (QLHoaDon qLHoaDon : lstHoaDon) {
            String kieuBan = "Bán trực tiếp";
            if (qLHoaDon.getKieuBan() == 1) {
                kieuBan = "Bán giao hàng";
            }
            String ngayTao = qLHoaDon.getNgayTao().substring(0, qLHoaDon.getNgayTao().length() - 4);
            modelHoaDon.addRow(new Object[]{stt++, qLHoaDon.getMa(), qLHoaDon.getTenNhanVien(), qLHoaDon.getTenKhachHang(), ngayTao, kieuBan});
        }
    }

    private void loadSanPham() {
        modelSanPham.setRowCount(0);
        this.lstSanPham = this.guiSanPham.getAll();
        int stt = 1;
        for (QLChiTietSanPham sp : lstSanPham) {
            modelSanPham.addRow(new Object[]{stt++, sp.getTenSanPham(), sp.getTenSize(), sp.getTenNSX(), sp.getTenMau(), sp.getTenPhongCach(),
                sp.getTenMauSac(), sp.getTenChatLieu(), sp.getSoLuong(), sp.getGiaBan()});
        }
    }

    private double tongTienHoaDon;

    private void loadGioHang() {
        modelHoaDonChiTiet.setRowCount(0);
        int row = this.tblHoaDon.getSelectedRow();
        QLHoaDon hoaDon = this.lstHoaDon.get(row);
        this.lstGioHang = this.guiHoaDonChiTiet.getAll(hoaDon.getId());

        int stt = 1;
        this.tongTienHoaDon = 0;
        for (QLHoaDonChiTiet qLhdct : lstGioHang) {
            double thanhTien = qLhdct.getDonGia() * qLhdct.getSoLuong();
            modelHoaDonChiTiet.addRow(new Object[]{stt++, qLhdct.getTenSanPham(), qLhdct.getSoLuong(), new BigDecimal(qLhdct.getDonGia()), new BigDecimal(thanhTien)});
            tongTienHoaDon += (qLhdct.getDonGia() * qLhdct.getSoLuong());
        }
        lblTongTienHoaDon.setText("Tổng tiền: " + new BigDecimal(this.tongTienHoaDon));
        hoaDon.setTongTien(this.tongTienHoaDon);
        this.guiHoaDon.CapNhatHoaDon(hoaDon);
    }

    private void HienThiSoTienChuyenKhoan(boolean res) {
        lblSoTienChuyenKhoan.setVisible(res);
        txtSoTienChuyenKhoan.setVisible(res);
        lblVND.setVisible(res);
        lblDocSoTienKhachCK.setVisible(res);
    }

    private void HienThiSoTienMat(boolean res) {
        lblSoTienMat.setVisible(res);
        txtSoTienMat.setVisible(res);
        lblvnd.setVisible(res);
        lblDocSoTienMatKhachTra.setVisible(res);
    }

    private void DoRongCacCot() {
        tblGioHang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblGioHang.getColumnModel().getColumn(0).setPreferredWidth(35);
        tblGioHang.getColumnModel().getColumn(1).setPreferredWidth(194);
        tblGioHang.getColumnModel().getColumn(2).setPreferredWidth(70);
        tblGioHang.getColumnModel().getColumn(3).setPreferredWidth(110);
        tblGioHang.getColumnModel().getColumn(4).setPreferredWidth(110);

        tblSanPham.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(35);
        tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblSanPham.getColumnModel().getColumn(2).setPreferredWidth(58);
        tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(58);
        tblSanPham.getColumnModel().getColumn(4).setPreferredWidth(58);
        tblSanPham.getColumnModel().getColumn(5).setPreferredWidth(73);
        tblSanPham.getColumnModel().getColumn(6).setPreferredWidth(59);
        tblSanPham.getColumnModel().getColumn(7).setPreferredWidth(59);
        tblSanPham.getColumnModel().getColumn(8).setPreferredWidth(70);
        tblSanPham.getColumnModel().getColumn(9).setPreferredWidth(80);

        tblHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(35);
        tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblHoaDon.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(115);
        tblHoaDon.getColumnModel().getColumn(4).setPreferredWidth(90);
    }

    private QLHoaDon getQLHoaDon() {
        UUID id = null;
        String ma = "NULL";
        String ten = "Hóa đơn " + (modelHoaDon.getRowCount() + 1);
        UUID idKhachHang = null;
        String tenKhachHang = "Khách lẻ";
        UUID idNhanVien = this.idNhanVien;
        String tenNhanVien = this.nhanVien.getHoTen();
        UUID idGiaoDich = this.guiGiaoDich.GetId(this.loaiGiaoDich);
        String ngayTao = null;
        String ngayThanhToan = null;
        Integer soDiemTieu = null;
        Double tongTien = 0.0;
        Integer kieuBan = this.kieuBan;
        String hoTen = null;
        String soDienThoai = null;
        String diachi = null;
        Date ngayNhanHangMongMuon = null;
        Date ngayBatDauGiaoHang = null;
        Date ngayNhanHangThanhCong = null;
        String moTa = null;
        int trangThai = 0;
        double soTienChuyenKhoan = 0;
        double soTienKhachDua = 0;
        double phiShip = 0;
        QLHoaDon qLHoaDon = new QLHoaDon(id, ma, ten, idKhachHang, tenKhachHang, idNhanVien, tenNhanVien, idGiaoDich, ngayTao, ngayThanhToan, soDiemTieu, tongTien, kieuBan, hoTen, soDienThoai, diachi, ngayNhanHangMongMuon, ngayBatDauGiaoHang, ngayNhanHangThanhCong, moTa, soTienChuyenKhoan, trangThai, soTienKhachDua, phiShip);
        qLHoaDon.setMa(qLHoaDon.getMaHoaDon());
        this.guiHoaDon.CapNhatHoaDon(qLHoaDon);
        return qLHoaDon;
    }

    private QLHoaDonChiTiet getQLHoaDonChiTiet() {
        UUID id = null;
        UUID idHoaDon = null;
        UUID idCTSP = null;
        String tenSP = null;
        Integer soLuong = null;
        Double giaBan = null;

        QLHoaDonChiTiet hdct = new QLHoaDonChiTiet(id, idHoaDon, idCTSP, tenSP, soLuong, giaBan);
        return hdct;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmSanPham = new javax.swing.JPopupMenu();
        mniThemSanPham = new javax.swing.JMenuItem();
        pmGioHang = new javax.swing.JPopupMenu();
        mniCapNhatSanPham = new javax.swing.JMenuItem();
        mniXoaMotSanPham = new javax.swing.JMenuItem();
        mniXoaTatCaSanPham = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        pmGiaoHang = new javax.swing.JPopupMenu();
        mniXemHoaDonGiaoHang = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        Logo = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        btnXoaHoaDon = new javax.swing.JButton();
        cboTrangThaiHoaDon = new javax.swing.JComboBox<>();
        btnCapNhat = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnCapNhatSanPham = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        btnXoaTatCaSanPham = new javax.swing.JButton();
        lblTongTienHoaDon = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnChonKhachHang = new javax.swing.JButton();
        lblMaKhachHang = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblMaNhanVien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblSoTienMat = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextPane();
        jLabel17 = new javax.swing.JLabel();
        rdoTienMat = new javax.swing.JRadioButton();
        rdoChuyenKhoan = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        lblvnd = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        rdoCaHai = new javax.swing.JRadioButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        cboHinhThucBan = new javax.swing.JComboBox<>();
        lblMaHoaDon = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblSoTienGiam = new javax.swing.JLabel();
        txtSoDiemSuDung = new javax.swing.JTextField();
        txtSoTienMat = new javax.swing.JTextField();
        lblSoTienThanhToan = new javax.swing.JLabel();
        lblSoTienTraLai = new javax.swing.JLabel();
        lblSoTienChuyenKhoan = new javax.swing.JLabel();
        txtSoTienChuyenKhoan = new javax.swing.JTextField();
        lblVND = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lblDocSoTien = new javax.swing.JLabel();
        lblDocSoTienKhachCK = new javax.swing.JLabel();
        lblDocSoTienMatKhachTra = new javax.swing.JLabel();
        lblDocSoTienThanhToan = new javax.swing.JLabel();
        btnGiaoHang = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        pnQr = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblTenNhanVien = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        pnKhachHang = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        pnNhanVien = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        pnDoanhThu = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        pnQuyDoiDiem = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();

        mniThemSanPham.setText("Thêm sản phẩm");
        mniThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThemSanPhamActionPerformed(evt);
            }
        });
        pmSanPham.add(mniThemSanPham);

        mniCapNhatSanPham.setText("Cập nhật số lượng sản phẩm");
        mniCapNhatSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatSanPhamActionPerformed(evt);
            }
        });
        pmGioHang.add(mniCapNhatSanPham);

        mniXoaMotSanPham.setText("Xóa sản phẩm");
        mniXoaMotSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXoaMotSanPhamActionPerformed(evt);
            }
        });
        pmGioHang.add(mniXoaMotSanPham);

        mniXoaTatCaSanPham.setText("Xóa tất cả sản phẩm");
        mniXoaTatCaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXoaTatCaSanPhamActionPerformed(evt);
            }
        });
        pmGioHang.add(mniXoaTatCaSanPham);

        mniXemHoaDonGiaoHang.setText("Xem thông tin hóa đơn giao hàng");
        mniXemHoaDonGiaoHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXemHoaDonGiaoHangActionPerformed(evt);
            }
        });
        pmGiaoHang.add(mniXemHoaDonGiaoHang);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(228, 221, 213));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(228, 221, 200));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setPreferredSize(new java.awt.Dimension(169, 169));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N

        javax.swing.GroupLayout LogoLayout = new javax.swing.GroupLayout(Logo);
        Logo.setLayout(LogoLayout);
        LogoLayout.setHorizontalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LogoLayout.setVerticalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoLayout.createSequentialGroup()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel2.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, -1, -1));

        jPanel1.setBackground(new java.awt.Color(228, 221, 216));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Hóa đơn");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Tên nhân viên", "Tên khách hàng", "Ngày tạo", "Kiểu bán"
            }
        ));
        tblHoaDon.setComponentPopupMenu(pmGiaoHang);
        tblHoaDon.setGridColor(new java.awt.Color(255, 255, 255));
        tblHoaDon.setOpaque(false);
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblHoaDon);

        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnXoaHoaDon.setText("Hủy  hóa đơn");
        btnXoaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHoaDonActionPerformed(evt);
            }
        });

        cboTrangThaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Treo", "Thành công", "Đã hủy", "Chờ xử lý", "Giao hàng" }));
        cboTrangThaiHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiHoaDonActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(btnTaoHoaDon)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaHoaDon)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btnCapNhat)
                        .addGap(18, 18, 18)
                        .addComponent(cboTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnTaoHoaDon)
                    .addComponent(btnXoaHoaDon)
                    .addComponent(cboTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(228, 221, 216));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Giỏ hàng");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền"
            }
        ));
        tblGioHang.setComponentPopupMenu(pmGioHang);
        tblGioHang.setOpaque(false);
        jScrollPane6.setViewportView(tblGioHang);

        btnCapNhatSanPham.setText("Cập nhật sản phẩm");
        btnCapNhatSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSanPhamActionPerformed(evt);
            }
        });

        btnXoaSanPham.setText("Xóa sản phẩm");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        btnXoaTatCaSanPham.setText("Xóa tất cả");
        btnXoaTatCaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTatCaSanPhamActionPerformed(evt);
            }
        });

        lblTongTienHoaDon.setText("Tổng tiền:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCapNhatSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaTatCaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblTongTienHoaDon)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnCapNhatSanPham)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaSanPham)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaTatCaSanPham)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTongTienHoaDon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(228, 221, 216));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Đơn hàng");

        jPanel9.setBackground(new java.awt.Color(242, 242, 230));

        jLabel2.setText("Mã khách hàng:");

        jLabel3.setText("Tên khách hàng:");

        btnChonKhachHang.setText("Chọn");
        btnChonKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKhachHangActionPerformed(evt);
            }
        });

        lblMaKhachHang.setText("NULL");

        lblTenKhachHang.setText("Khách lẻ");

        jLabel25.setText("Mã nhân viên:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(12, 12, 12)
                .addComponent(btnChonKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnChonKhachHang)
                    .addComponent(lblMaKhachHang))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTenKhachHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel4.setText("Mã hóa đơn:");

        jLabel8.setText("Tổng tiền:");

        jLabel9.setText("Số tiền giảm:");

        lblSoTienMat.setText("Số tiền khách trả:");

        jLabel11.setText("Thanh toán:");

        jLabel12.setText("Số tiền trả lại:");

        jLabel13.setText("Ghi chú:");

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(txtGhiChu);

        jLabel17.setText("Hình thức thanh toán:");

        buttonGroup1.add(rdoTienMat);
        rdoTienMat.setText("Tiền mặt");
        rdoTienMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTienMatActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoChuyenKhoan);
        rdoChuyenKhoan.setText("Chuyển khoản");
        rdoChuyenKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChuyenKhoanActionPerformed(evt);
            }
        });

        jLabel26.setText("VNÐ");

        lblvnd.setText("VNÐ");

        jLabel28.setText("VNÐ");

        jLabel29.setText("VNÐ");

        jLabel30.setText("VNÐ");

        buttonGroup1.add(rdoCaHai);
        rdoCaHai.setText("Cả 2");
        rdoCaHai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCaHaiActionPerformed(evt);
            }
        });

        jLabel31.setText("Số điểm sử dụng:");

        jLabel35.setText("Hình thức giao hàng:");

        cboHinhThucBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bán trực tiếp", "Bán giao hàng" }));
        cboHinhThucBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThucBanActionPerformed(evt);
            }
        });

        lblMaHoaDon.setText("NULL");

        lblTongTien.setText(" 0");

        lblSoTienGiam.setText(" 0");

        txtSoDiemSuDung.setText("0");
        txtSoDiemSuDung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoDiemSuDungKeyReleased(evt);
            }
        });

        txtSoTienMat.setText("0");
        txtSoTienMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoTienMatKeyReleased(evt);
            }
        });

        lblSoTienThanhToan.setText(" 0");

        lblSoTienTraLai.setText(" ");

        lblSoTienChuyenKhoan.setText("Số tiền chuyển khoản:");

        txtSoTienChuyenKhoan.setText("0");
        txtSoTienChuyenKhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoTienChuyenKhoanKeyReleased(evt);
            }
        });

        lblVND.setText("VNÐ");

        jLabel36.setText("Thành tiền (bằng chữ): ");

        lblDocSoTien.setText(" ");

        lblDocSoTienKhachCK.setText("Không");

        lblDocSoTienMatKhachTra.setText("Không");

        lblDocSoTienThanhToan.setText("Không");

        btnGiaoHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGiaoHang.setText("Giao Hàng");
        btnGiaoHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaoHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(47, 47, 47)
                        .addComponent(lblSoTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(lblSoTienGiam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtSoDiemSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblDocSoTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGiaoHang))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cboHinhThucBan, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel13)
                                            .addComponent(lblDocSoTienKhachCK, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 37, Short.MAX_VALUE)))
                                .addGap(13, 13, 13))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblSoTienTraLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel28))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(txtSoTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblvnd)))
                                .addGap(32, 32, 32))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(lblSoTienChuyenKhoan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoTienChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblVND)
                                .addGap(31, 31, 31)))
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoTienMat)
                        .addGap(18, 18, 18)
                        .addComponent(rdoChuyenKhoan)
                        .addGap(11, 11, 11)
                        .addComponent(rdoCaHai))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDocSoTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoTienMat)
                            .addComponent(lblDocSoTienMatKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel26))
                    .addComponent(lblTongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtSoDiemSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel29)
                    .addComponent(lblSoTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel30)
                    .addComponent(lblSoTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(lblDocSoTienThanhToan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvnd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDocSoTienMatKhachTra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel28)
                    .addComponent(lblSoTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(rdoTienMat)
                    .addComponent(rdoChuyenKhoan)
                    .addComponent(rdoCaHai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoTienChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTienChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVND))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDocSoTienKhachCK, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(cboHinhThucBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDocSoTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGiaoHang))
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(228, 221, 216));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Danh sách sản phẩm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Sản phẩm", "Size", "NSX", "Mẫu", "Phong cách", "Màu sắc", "Chất liệu", "Số lượng", "Giá bán"
            }
        ));
        tblSanPham.setComponentPopupMenu(pmSanPham);
        tblSanPham.setOpaque(false);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSanPhamMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(tblSanPham);

        jLabel16.setText("Tìm kiếm sản phẩm");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pnQr.setBackground(new java.awt.Color(255, 255, 255));
        pnQr.setPreferredSize(new java.awt.Dimension(160, 200));
        pnQr.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnQr, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(pnQr, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnQr.getAccessibleContext().setAccessibleParent(this);

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 0, -1, -1));

        jPanel3.setPreferredSize(new java.awt.Dimension(169, 22));

        lblTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenNhanVien.setText("Xin chào: ");
        lblTenNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTenNhanVienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel4.setBackground(new java.awt.Color(228, 221, 200));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 58));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Hóa đơn");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 278, 169, -1));

        jPanel7.setBackground(new java.awt.Color(228, 221, 200));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Bán hàng");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 214, 169, -1));

        jPanel13.setBackground(new java.awt.Color(228, 221, 200));
        jPanel13.setPreferredSize(new java.awt.Dimension(0, 58));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Sản phẩm");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 342, 169, -1));

        pnKhachHang.setBackground(new java.awt.Color(228, 221, 200));
        pnKhachHang.setPreferredSize(new java.awt.Dimension(0, 58));
        pnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnKhachHangMousePressed(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Khách hàng");

        javax.swing.GroupLayout pnKhachHangLayout = new javax.swing.GroupLayout(pnKhachHang);
        pnKhachHang.setLayout(pnKhachHangLayout);
        pnKhachHangLayout.setHorizontalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhachHangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        pnKhachHangLayout.setVerticalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        jPanel2.add(pnKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 406, 169, -1));

        pnNhanVien.setBackground(new java.awt.Color(228, 221, 200));
        pnNhanVien.setPreferredSize(new java.awt.Dimension(0, 58));
        pnNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnNhanVienMousePressed(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Nhân viên");

        javax.swing.GroupLayout pnNhanVienLayout = new javax.swing.GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNhanVienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        jPanel2.add(pnNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 169, -1));

        pnDoanhThu.setBackground(new java.awt.Color(228, 221, 200));
        pnDoanhThu.setPreferredSize(new java.awt.Dimension(0, 58));
        pnDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnDoanhThuMousePressed(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Doanh thu");

        javax.swing.GroupLayout pnDoanhThuLayout = new javax.swing.GroupLayout(pnDoanhThu);
        pnDoanhThu.setLayout(pnDoanhThuLayout);
        pnDoanhThuLayout.setHorizontalGroup(
            pnDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDoanhThuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        pnDoanhThuLayout.setVerticalGroup(
            pnDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        jPanel2.add(pnDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 169, -1));

        pnQuyDoiDiem.setBackground(new java.awt.Color(228, 221, 200));
        pnQuyDoiDiem.setPreferredSize(new java.awt.Dimension(0, 58));
        pnQuyDoiDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnQuyDoiDiemMousePressed(evt);
            }
        });

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setText("Quy đổi điểm");

        javax.swing.GroupLayout pnQuyDoiDiemLayout = new javax.swing.GroupLayout(pnQuyDoiDiem);
        pnQuyDoiDiem.setLayout(pnQuyDoiDiemLayout);
        pnQuyDoiDiemLayout.setHorizontalGroup(
            pnQuyDoiDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuyDoiDiemLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        pnQuyDoiDiemLayout.setVerticalGroup(
            pnQuyDoiDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        jPanel2.add(pnQuyDoiDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 169, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình",
                "Thoát?", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Suy nghĩ kỹ nhen");
            this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        } else {
            this.webcam.close();
            this.setVisible(false);
            this.dispose();
            new FrmDangNhap().setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        QLHoaDon qlhd = this.getQLHoaDon();
        int row = this.guiHoaDon.ThemQLHoaDon(qlhd);
        if (row > 0) {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
            cboTrangThaiHoaDon.setSelectedIndex(0);
            this.loadHoaDon();
            int idx = modelHoaDon.getRowCount() - 1;
            tblHoaDon.setRowSelectionInterval(idx, idx);
            modelHoaDonChiTiet.setRowCount(0);
            lblTongTienHoaDon.setText("Tổng tiền: " + 0);
            int size = this.lstHoaDon.size() - 1;
            this.loadThongTinDeThanhToan(size);
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = tblHoaDon.getSelectedRow();
        UUID idHoaDon = this.lstHoaDon.get(row).getId();
        this.lstGioHang = this.guiHoaDonChiTiet.getAll(idHoaDon);
        this.loadGioHang();
        this.loadThongTinDeThanhToan(row);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnXoaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHoaDonActionPerformed
        if (modelHoaDon.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Không có hóa đơn nào!");
            return;
        }
        int row = tblHoaDon.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn bạn muốn xóa");
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa hóa đơn này?", "Xóa", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Suy nghĩ kỹ nhen");
        } else {
            QLHoaDon hoaDon = this.lstHoaDon.get(row);
            this.lstGioHang = this.guiHoaDonChiTiet.getAll(hoaDon.getId());
            if (this.lstGioHang.size() > 0) {
                String moTa = JOptionPane.showInputDialog(this, "Lý do hủy hóa đơn là: ");
                if (moTa == null) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập lý do");
                    return;
                } else {
                    hoaDon.setMoTa(moTa);
                    this.guiHoaDon.CapNhatHoaDon(hoaDon);
                }
            }

            UUID idHoaDon = hoaDon.getId();
            int idx = this.guiHoaDon.XoaQLHoaDon(idHoaDon);
            if (idx > 0) {
                JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công");
                this.loadHoaDon();
            }

            int size = this.lstHoaDon.size();
            if (size > 0) {
                tblHoaDon.setRowSelectionInterval(0, 0);
                this.loadGioHang();
            } else {
                modelHoaDonChiTiet.setRowCount(0);
            }
        }
    }//GEN-LAST:event_btnXoaHoaDonActionPerformed

    private void tblSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMousePressed
        if (evt.getClickCount() == 2) {
            int row = this.tblSanPham.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần thêm");
                return;
            }
            QLChiTietSanPham sanPham = this.lstSanPham.get(row);
            this.ThemSanPham(sanPham.getId());
        }
    }//GEN-LAST:event_tblSanPhamMousePressed

    private void btnCapNhatSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSanPhamActionPerformed
        this.CapNhatSanPham();
        int rowHoaDon = this.tblHoaDon.getSelectedRow();
        if (rowHoaDon >= 0) {
            this.loadThongTinDeThanhToan(rowHoaDon);
        }
    }//GEN-LAST:event_btnCapNhatSanPhamActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        this.XoaMotSanPham();
        int rowHoaDon = this.tblHoaDon.getSelectedRow();
        if (rowHoaDon >= 0) {
            this.loadThongTinDeThanhToan(rowHoaDon);
        }
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnXoaTatCaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTatCaSanPhamActionPerformed
        this.XoaToanBoSanPham();
        if (modelHoaDon.getRowCount() > 0) {
            lblTongTien.setText("0");
            txtSoDiemSuDung.setText("0");
            lblSoTienGiam.setText("0");
            lblSoTienThanhToan.setText("0");
            txtSoTienMat.setText("0");
            lblSoTienTraLai.setText("0");
            txtSoTienChuyenKhoan.setText("0");
            lblDocSoTien.setText("");
            lblMaKhachHang.setText("NULL");
            lblTenKhachHang.setText("Khách lẻ");
            lblMaHoaDon.setText("NULL");
            lblDocSoTienThanhToan.setText("Không");
            lblDocSoTienMatKhachTra.setText("Không");
            lblDocSoTienKhachCK.setText("Không");
            rdoTienMat.setSelected(true);
            txtGhiChu.setText("");
            cboHinhThucBan.setSelectedIndex(0);
            this.HienThiSoTienChuyenKhoan(false);
        }
    }//GEN-LAST:event_btnXoaTatCaSanPhamActionPerformed

    private void mniThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThemSanPhamActionPerformed
        int row = this.tblSanPham.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần thêm");
            return;
        }
        QLChiTietSanPham sanPham = this.lstSanPham.get(row);
        this.ThemSanPham(sanPham.getId());
    }//GEN-LAST:event_mniThemSanPhamActionPerformed

    private void mniCapNhatSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatSanPhamActionPerformed
        this.CapNhatSanPham();
        int rowHoaDon = this.tblHoaDon.getSelectedRow();
        if (rowHoaDon >= 0) {
            this.loadThongTinDeThanhToan(rowHoaDon);
        }
    }//GEN-LAST:event_mniCapNhatSanPhamActionPerformed

    private void mniXoaMotSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXoaMotSanPhamActionPerformed
        this.XoaMotSanPham();
        int rowHoaDon = this.tblHoaDon.getSelectedRow();
        if (rowHoaDon >= 0) {
            this.idx = 0;
            this.loadThongTinDeThanhToan(rowHoaDon);
        }
    }//GEN-LAST:event_mniXoaMotSanPhamActionPerformed

    private void mniXoaTatCaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXoaTatCaSanPhamActionPerformed
        this.XoaToanBoSanPham();
        if (modelHoaDon.getRowCount() > 0) {
            lblTongTien.setText("0");
            txtSoDiemSuDung.setText("0");
            lblSoTienGiam.setText("0");
            lblSoTienThanhToan.setText("0");
            txtSoTienMat.setText("0");
            lblSoTienTraLai.setText("0");
            txtSoTienChuyenKhoan.setText("0");
            lblDocSoTien.setText("");
            lblMaKhachHang.setText("NULL");
            lblTenKhachHang.setText("Khách lẻ");
            lblMaHoaDon.setText("NULL");
            lblDocSoTienThanhToan.setText("Không");
            lblDocSoTienMatKhachTra.setText("Không");
            lblDocSoTienKhachCK.setText("Không");
            rdoTienMat.setSelected(true);
            txtGhiChu.setText("");
            cboHinhThucBan.setSelectedIndex(0);
            this.HienThiSoTienChuyenKhoan(false);
        }
    }//GEN-LAST:event_mniXoaTatCaSanPhamActionPerformed

    private int idx = 0;
    private void cboHinhThucBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThucBanActionPerformed
        if (idx != 0) {
            int index = cboHinhThucBan.getSelectedIndex();
            int rowHoaDon = tblHoaDon.getSelectedRow();
            if (modelHoaDon.getRowCount() > 0) {
                if (rowHoaDon < 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
                    this.idx = 0;
                    return;
                }
                if (index == 0) {
                    this.kieuBan = 0;
                    modelHoaDon.setValueAt("Bán trực tiếp", rowHoaDon, 5);
                } else {
                    this.kieuBan = 1;
                    modelHoaDon.setValueAt("Bán giao hàng", rowHoaDon, 5);
                }
                QLHoaDon hoaDon = this.lstHoaDon.get(rowHoaDon);
                hoaDon.setKieuBan(this.kieuBan);
                this.guiHoaDon.CapNhatHoaDon(hoaDon);

                if (this.kieuBan == 1) {
                    FrmGiaoHang.hoaDon = hoaDon;
                    FrmGiaoHang.nhanVien = nhanVien;
                    new FrmGiaoHang(new javax.swing.JFrame(), true).setVisible(true);
                    this.loadThongTinDeThanhToan(rowHoaDon);
                }
            }
        }
        idx++;
    }//GEN-LAST:event_cboHinhThucBanActionPerformed

    private void loadThongTinDeThanhToan(int rowHoaDon) {
        QLHoaDon hoaDon = this.lstHoaDon.get(rowHoaDon);
        lblMaHoaDon.setText(hoaDon.getMa());
        lblMaNhanVien.setText(this.nhanVien.getMa());
        Double tongTien = hoaDon.getTongTien() + hoaDon.getPhiShip();
        if (tongTien == null) {
            tongTien = 0.0;
        }
        lblMaKhachHang.setText("NULL");
        lblTenKhachHang.setText("Khách lẻ");
        txtSoDiemSuDung.setEditable(false);
        txtSoTienMat.grabFocus();
        if (hoaDon.getIdKhachHang() != null) {
            QLKhachHang khachHang = this.guiKhachHang.GetKhachHang(hoaDon.getIdKhachHang());
            lblMaKhachHang.setText(khachHang.getMa());
            lblTenKhachHang.setText(khachHang.getHoTen());
            txtSoDiemSuDung.setEditable(true);
            txtSoDiemSuDung.grabFocus();
            if (hoaDon.getSoDiemTieu() != null) {
                txtSoDiemSuDung.setText(String.valueOf(hoaDon.getSoDiemTieu()));
                lblSoTienGiam.setText("" + new BigDecimal(this.guiSDDiem.DiemQuyTien(Integer.parseInt(txtSoDiemSuDung.getText()), -1)));
            }
        } else {
            txtSoDiemSuDung.setText("0");
            lblSoTienGiam.setText("0");
        }
        lblTongTien.setText("" + new BigDecimal(tongTien));
        lblSoTienThanhToan.setText("" + new BigDecimal(tongTien));
        lblDocSoTienThanhToan.setText(new DocSoThanhChuoi().DocSoHoanThien(Double.parseDouble(lblSoTienThanhToan.getText())));
        this.idx = 0;
        int kieuBan = hoaDon.getKieuBan();
        cboHinhThucBan.setSelectedIndex(kieuBan);
        txtSoTienMat.setText("0");
        lblDocSoTienMatKhachTra.setText("Không");
        this.HienThiSoTienChuyenKhoan(true);
        txtSoTienChuyenKhoan.setText("0");
        lblDocSoTienKhachCK.setText("0");
        lblDocSoTien.setText("");
        lblSoTienTraLai.setText("");
        if (this.guiGiaoDich.GetTen(hoaDon.getIdGiaoDich()).equalsIgnoreCase("tiền mặt")) {
            rdoTienMat.isSelected();
            this.HienThiSoTienChuyenKhoan(false);
            double tienKhachDua = 0;
            if (hoaDon.getSoTienKhachDua() > 0) {
                tienKhachDua = hoaDon.getSoTienKhachDua();
                txtSoTienMat.setText("" + new BigDecimal(tienKhachDua));
                lblDocSoTienMatKhachTra.setText(new DocSoThanhChuoi().DocSoHoanThien(Double.parseDouble(txtSoTienMat.getText())));
            }

        } else if (this.guiGiaoDich.GetTen(hoaDon.getIdGiaoDich()).equalsIgnoreCase("chuyển khoản")) {
            rdoChuyenKhoan.isSelected();
            this.HienThiSoTienMat(false);
            double tienKhachCK = 0;
            if (hoaDon.getSoTienChuyenKhoan() != null) {
                tienKhachCK = hoaDon.getSoTienKhachDua();
                txtSoTienChuyenKhoan.setText("" + new BigDecimal(tienKhachCK));
                lblDocSoTienKhachCK.setText(new DocSoThanhChuoi().DocSoHoanThien(Double.parseDouble(txtSoTienChuyenKhoan.getText())));
            }

        } else {
            rdoCaHai.isSelected();
            this.HienThiSoTienChuyenKhoan(true);
            this.HienThiSoTienChuyenKhoan(true);
            if (hoaDon.getSoTienChuyenKhoan() > 0) {
                txtSoTienChuyenKhoan.setText("" + new BigDecimal(hoaDon.getSoTienChuyenKhoan()));
                lblDocSoTienKhachCK.setText(new DocSoThanhChuoi().DocSoHoanThien(Double.parseDouble(txtSoTienChuyenKhoan.getText())));
            }

            if (hoaDon.getSoTienKhachDua() - hoaDon.getSoTienChuyenKhoan() > 0) {
                txtSoTienMat.setText("" + new BigDecimal(hoaDon.getSoTienKhachDua() - hoaDon.getSoTienChuyenKhoan()));
                lblDocSoTienMatKhachTra.setText(new DocSoThanhChuoi().DocSoHoanThien(Double.parseDouble(txtSoTienMat.getText())));
            }
        }
        if (hoaDon.getSoTienKhachDua() > 0) {
            lblSoTienTraLai.setText("" + new BigDecimal(hoaDon.getSoTienKhachDua() - hoaDon.getTongTien() + Double.parseDouble(lblSoTienGiam.getText()) - hoaDon.getPhiShip()));
        }
    }

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (modelHoaDon.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Không có hóa đơn nào!");
            return;
        }
        int rowHoaDon = tblHoaDon.getSelectedRow();
        if (rowHoaDon < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần thanh toán. Xin kiểm tra lại");
            return;
        }

        if (modelHoaDonChiTiet.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cho khách hàng");
            return;
        }
        this.ThanhToan(rowHoaDon);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnChonKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKhachHangActionPerformed
        if (modelHoaDon.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Không có hóa đơn nào!");
            return;
        }

        int rowHoaDon = this.tblHoaDon.getSelectedRow();
        if (rowHoaDon < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }
        khachHang = null;
        if (modelHoaDon.getRowCount() > 0) {
            QLHoaDon hoaDon = this.lstHoaDon.get(rowHoaDon);
            UUID idKhachHang = hoaDon.getIdKhachHang();
            if (idKhachHang != null) {
                khachHang = this.guiKhachHang.GetKhachHang(hoaDon.getIdKhachHang());
                hoaDon.setIdKhachHang(khachHang.getId());
                this.guiHoaDon.CapNhatHoaDon(hoaDon);
            }
        }
        new FrmKhachHang(new javax.swing.JFrame(), true).setVisible(true);
        if (khachHang != null) {
            txtSoDiemSuDung.setEditable(true);
            lblMaKhachHang.setText(khachHang.getMa());
            lblTenKhachHang.setText(khachHang.getHoTen());
            int rowHD = this.tblHoaDon.getSelectedRow();
            QLHoaDon hd = this.lstHoaDon.get(rowHD);
            this.tblHoaDon.setValueAt(lblTenKhachHang.getText(), rowHD, 3);
            hd.setIdKhachHang(khachHang.getId());
            this.guiHoaDon.CapNhatHoaDon(hd);
        }
    }//GEN-LAST:event_btnChonKhachHangActionPerformed

    private void txtSoDiemSuDungKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoDiemSuDungKeyReleased
        String inPut = txtSoDiemSuDung.getText();
        if (inPut.isEmpty()) {
            txtSoDiemSuDung.setText("0");
            lblSoTienGiam.setText("0");
        } else {
            int soDiem = Integer.parseInt(inPut);
            double diemQuyTien = this.guiSDDiem.DiemQuyTien(soDiem, -1);
            lblSoTienGiam.setText(String.valueOf(diemQuyTien));
            double tongTien = Double.parseDouble(lblTongTien.getText());
            lblSoTienThanhToan.setText(String.valueOf(tongTien - diemQuyTien));
            lblDocSoTienThanhToan.setText(new DocSoThanhChuoi().DocSoHoanThien(tongTien - diemQuyTien));
        }
    }//GEN-LAST:event_txtSoDiemSuDungKeyReleased

    private void rdoTienMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTienMatActionPerformed
        this.HienThiSoTienMat(true);
        this.HienThiSoTienChuyenKhoan(false);
        this.txtSoTienMat.grabFocus();
        this.tienChuyenKhoan = 0;
    }//GEN-LAST:event_rdoTienMatActionPerformed

    private void rdoChuyenKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChuyenKhoanActionPerformed
        this.HienThiSoTienChuyenKhoan(true);
        this.HienThiSoTienMat(false);
        this.txtSoTienChuyenKhoan.grabFocus();
        this.tienMatKhachDua = 0;
    }//GEN-LAST:event_rdoChuyenKhoanActionPerformed

    private void rdoCaHaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCaHaiActionPerformed
        txtSoTienMat.grabFocus();
        this.HienThiSoTienMat(true);
        this.HienThiSoTienChuyenKhoan(true);
    }//GEN-LAST:event_rdoCaHaiActionPerformed

    private void txtSoTienMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoTienMatKeyReleased
        String inPut = txtSoTienMat.getText();
        if (inPut.isEmpty()) {
            txtSoTienMat.setText("0");
            lblDocSoTienMatKhachTra.setText("Không");
        } else {
            try {
                this.tienMatKhachDua = Double.parseDouble(inPut);
                lblDocSoTienMatKhachTra.setText(new DocSoThanhChuoi().DocSoHoanThien(this.tienMatKhachDua));

                this.tienChuyenKhoan = Double.parseDouble(txtSoTienChuyenKhoan.getText());
                int rowHD = this.tblHoaDon.getSelectedRow();
                if (rowHD > 0) {
                    QLHoaDon hoaDon = this.lstHoaDon.get(rowHD);
                    hoaDon.setSoTienKhachDua(this.tienMatKhachDua + this.tienChuyenKhoan);
                    this.guiHoaDon.CapNhatHoaDon(hoaDon);
                }
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_txtSoTienMatKeyReleased

    private void cboTrangThaiHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiHoaDonActionPerformed
        this.TrangThaiCuaHoaDon = cboTrangThaiHoaDon.getSelectedIndex();
        if (TrangThaiCuaHoaDon == 0) {
            this.lstHoaDon = this.guiHoaDon.getAll(0, idNhanVien);
        } else if (TrangThaiCuaHoaDon == 1) {
            this.lstHoaDon = this.guiHoaDon.getAll(1, idNhanVien);
        } else if (TrangThaiCuaHoaDon == 2) {
            this.lstHoaDon = this.guiHoaDon.getAll(-1, idNhanVien);
        } else if (TrangThaiCuaHoaDon == 3) {
            this.lstHoaDon = this.guiHoaDon.getAll(2, idNhanVien);
        } else {
            this.lstHoaDon = this.guiHoaDon.getAll(4, idNhanVien);
        }
        this.loadHoaDon();
        if (modelHoaDon.getRowCount() < 1) {
            this.LamMoiHoaDon();
            modelHoaDonChiTiet.setRowCount(0);
        } else {
            this.tblHoaDon.setRowSelectionInterval(0, 0);
            this.loadThongTinDeThanhToan(0);
            this.loadGioHang();
        }
    }//GEN-LAST:event_cboTrangThaiHoaDonActionPerformed

    private void txtSoTienChuyenKhoanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoTienChuyenKhoanKeyReleased
        String inPut = txtSoTienChuyenKhoan.getText();
        if (inPut.isEmpty()) {
            txtSoTienChuyenKhoan.setText("0");
            lblDocSoTienKhachCK.setText("Không");
        } else {
            try {
                this.tienChuyenKhoan = Double.parseDouble(inPut);
                lblDocSoTienKhachCK.setText(new DocSoThanhChuoi().DocSoHoanThien(this.tienChuyenKhoan));

                this.tienMatKhachDua = Double.parseDouble(txtSoTienMat.getText());
                int rowHD = this.tblHoaDon.getSelectedRow();
                if (rowHD > 0) {
                    QLHoaDon hoaDon = this.lstHoaDon.get(rowHD);
                    hoaDon.setSoTienKhachDua(this.tienChuyenKhoan + this.tienMatKhachDua);
                    this.guiHoaDon.CapNhatHoaDon(hoaDon);
                }
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_txtSoTienChuyenKhoanKeyReleased

    private void lblTenNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTenNhanVienMouseClicked
        FrmNhanVien.nhanVien = nhanVien;
        new FrmNhanVien(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_lblTenNhanVienMouseClicked

    public static int TrangThaiHoaDonKhiGiaoHang = -1;
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if (modelHoaDon.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Không có hóa đơn nào!");
            return;
        }
        int rowHoaDon = this.tblHoaDon.getSelectedRow();
        if (rowHoaDon < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }
        QLHoaDon hoaDon = this.lstHoaDon.get(rowHoaDon);
        if (hoaDon.getKieuBan() == 0) {
            JOptionPane.showMessageDialog(this, "Chỉ áp dụng đối với bán giao hàng");
            return;
        }
        new FrmCapNhatTrangThaiHoaDon(new javax.swing.JFrame(), true).setVisible(true);
        if (TrangThaiHoaDonKhiGiaoHang == -1) {
            return;
        }
        JOptionPane.showMessageDialog(this, "Cập nhật trạng thái hóa đơn thành công");
        hoaDon.setNgayBatDauGiao(Functions.getDate());
        hoaDon.setTrangThai(TrangThaiHoaDonKhiGiaoHang);
        this.guiHoaDon.CapNhatHoaDon(hoaDon);
        this.loadHoaDon();
        if (TrangThaiHoaDonKhiGiaoHang == 1) {
            hoaDon.setNgayNhanHangThanhCong(Functions.getDate());
            if (hoaDon.getIdKhachHang() != null) {
                this.trangThaiSuDungDiem = 1;
                double tongTien = hoaDon.getTongTien();
                int soDiemCong = this.guiSDDiem.TienQuyDiem(tongTien, trangThaiSuDungDiem);
                QLKhachHang khachHang = this.guiKhachHang.GetKhachHang(hoaDon.getIdKhachHang());
                int soDiemKhachHang = khachHang.getSoDiem() + soDiemCong;

                QLDiemKhachHang diemKhachHang = this.guiDiemKhachHang.GetDiem(hoaDon.getIdKhachHang());
                diemKhachHang.setSoDiem(soDiemKhachHang);
                this.guiDiemKhachHang.CapNhatDiem(diemKhachHang);
                QLSuDungDiem diem = this.getQLSuDungDiem(hoaDon);
                diem.setSoDiem(soDiemCong);
                this.guiSDDiem.ThemLichSuSuDungDiem(diem);
            }
            this.CapNhatSoLuongSanPham(hoaDon.getId());
            this.loadSanPham();
        }
        
        if(modelHoaDon.getRowCount() < 1){
            modelHoaDonChiTiet.setRowCount(0);
        }else{
            tblHoaDon.setRowSelectionInterval(0, 0);
            this.loadThongTinDeThanhToan(0);
            this.loadGioHang();
        }
        
    }//GEN-LAST:event_btnCapNhatActionPerformed


    private void pnDoanhThuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDoanhThuMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnDoanhThuMousePressed

    private void pnQuyDoiDiemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnQuyDoiDiemMousePressed
        FrmQuyDoiDiem.chucVu = this.chucVu;
        new FrmQuyDoiDiem(new javax.swing.JFrame(), true).setVisible(true);

    }//GEN-LAST:event_pnQuyDoiDiemMousePressed

    private void pnKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnKhachHangMousePressed
        new FrmKhachHang(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_pnKhachHangMousePressed


    private void btnGiaoHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaoHangActionPerformed
        if (modelHoaDon.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Không có hóa đơn nào!");
            return;
        }

        int rowHoaDon = tblHoaDon.getSelectedRow();
        if (rowHoaDon < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }

        if (modelHoaDonChiTiet.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cho khách hàng");
            return;
        }

        QLHoaDon hoaDon = this.lstHoaDon.get(rowHoaDon);
        if (hoaDon.getKieuBan() == 0) {
            JOptionPane.showMessageDialog(this, "Chỉ áp dụng với hóa đơn giao hàng");
            return;
        }

        if (hoaDon.getNgayBatDauGiao() == null || hoaDon.getNgayThanhToan() == null
                || hoaDon.getNgayNhanHangMongMuon() == null || hoaDon.getNgayNhanHangThanhCong() == null
                || hoaDon.getHoTen() == null || hoaDon.getSoDienThoai() == null || hoaDon.getDiaChi() == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa cập nhật đầy đủ thông tin giao hàng cho khách hàng");
            return;
        }

        double TongTien = this.tienChuyenKhoan + this.tienMatKhachDua - this.guiSDDiem.DiemQuyTien(Integer.parseInt(txtSoDiemSuDung.getText()), -1);
        double tienHoaDon = hoaDon.getTongTien();
        if (TongTien < tienHoaDon) {
            JOptionPane.showMessageDialog(this, "Khách hàng chưa thanh toán đầy đủ");
            return;
        }
        hoaDon.setSoTienKhachDua(TongTien);
        this.guiHoaDon.CapNhatHoaDon(hoaDon);
        JOptionPane.showMessageDialog(this, "Đặt hàng thành công cho khách hàng");
        this.loadHoaDon();
        if (modelHoaDon.getRowCount() == 0) {
            modelHoaDonChiTiet.setRowCount(0);
            this.LamMoiHoaDon();
        } else {
            tblHoaDon.setRowSelectionInterval(0, 0);
            this.loadGioHang();
        }
    }//GEN-LAST:event_btnGiaoHangActionPerformed

    private void mniXemHoaDonGiaoHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXemHoaDonGiaoHangActionPerformed
        if (modelHoaDon.getRowCount() < 0) {
            JOptionPane.showMessageDialog(this, "Không có hóa đơn nào");
            return;
        }

        int rowHoaDon = this.tblHoaDon.getSelectedRow();
        if (rowHoaDon < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }

        QLHoaDon hoaDon = this.lstHoaDon.get(rowHoaDon);
        if (hoaDon.getKieuBan() == 0) {
            JOptionPane.showMessageDialog(this, "Chỉ áp dụng đối với hóa đơn giao hàng");
            return;
        }

        FrmGiaoHang.nhanVien = nhanVien;
        FrmGiaoHang.hoaDon = hoaDon;
        new FrmGiaoHang(new javax.swing.JFrame(), true).setVisible(true);
        this.loadThongTinDeThanhToan(rowHoaDon);
    }//GEN-LAST:event_mniXemHoaDonGiaoHangActionPerformed

    private void pnNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnNhanVienMousePressed
        if (chucVu.equalsIgnoreCase("nhân viên")) {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền xem thông tin nhân viên khác");
        } else {
            FrmNhanVien.chuCuaHang = nhanVien;
            new FrmNhanVien(new javax.swing.JFrame(), true).setVisible(true);
        }
    }//GEN-LAST:event_pnNhanVienMousePressed

    private void ThemSanPham(UUID idCTSP) {
        if (modelHoaDon.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Vui lòng tạo hóa đơn!");
            return;
        }
        int rowHoaDon = tblHoaDon.getSelectedRow();
        if (rowHoaDon < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }
        QLChiTietSanPham sanPham = this.guiSanPham.GetQLChiTietSanPham(idCTSP);
        UUID idHD = this.lstHoaDon.get(rowHoaDon).getId();
        QLHoaDonChiTiet hdct = this.getQLHoaDonChiTiet();
        hdct.setIdHoaDon(idHD);
        hdct.setIdChiTietSanPham(idCTSP);
        String input = JOptionPane.showInputDialog(this, "Vui lòng nhập số lượng sản phẩm là: ");
        if (input == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return;
        }
        if (input.matches("\\d{1,}") == false) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không hợp lệ. Xin kiểm tra lại");
            return;
        }
        if (Integer.parseInt(input) > sanPham.getSoLuong() || Integer.parseInt(input) == 0) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không hợp lệ. Xin kiểm tra lại");
            return;
        }
        int soLuong = this.guiHoaDonChiTiet.SoLuongSanPhamCoTrongHoaDon(idHD, idCTSP);
        soLuong += Integer.parseInt(input);
        hdct.setSoLuong(soLuong);
        hdct.setDonGia(sanPham.getGiaBan());
        hdct.setTenSanPham(this.guiSanPham.TenSP(idCTSP));
        this.guiHoaDonChiTiet.ThemSanPhamVaoHoaDonChiTiet(hdct);
        this.loadGioHang();
        this.loadThongTinDeThanhToan(rowHoaDon);
        this.tblGioHang.setRowSelectionInterval(0, 0);
    }

    private void CapNhatSanPham() {
        if (modelHoaDonChiTiet.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Không có sản phẩm nào để cập nhật!");
            return;
        }
        String soSanPham = JOptionPane.showInputDialog(this, "Xin mời nhập số lượng sản phẩm là: ");
        if (soSanPham == null) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống");
            return;
        }
        String regex = "\\d{1,}";
        if (soSanPham.matches(regex) == false) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không hợp lệ. Xin kiểm tra lại");
            return;
        }
        int soLuong = Integer.parseInt(soSanPham);

        int row2 = tblHoaDon.getSelectedRow();
        if (row2 < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }

        QLHoaDon hoaDon = this.lstHoaDon.get(row2);
        int row3 = tblGioHang.getSelectedRow();
        if (row3 < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm trong giỏ hàng cần cập nhật");
            return;
        }

        QLHoaDonChiTiet hdct = this.lstGioHang.get(row3);
        UUID idCTSP = this.lstGioHang.get(row3).getIdChiTietSanPham();

        int soLuongTonTrongCuaHang = this.guiHoaDonChiTiet.SoLuongCoTrongCuaHang(idCTSP);
        if (soLuong < 0 || soLuong > soLuongTonTrongCuaHang) {
            JOptionPane.showMessageDialog(this, "Số sản phẩm bạn nhập không hợp lệ. Xin kiểm tra lại");
            return;
        }
        int rowHDCT = this.tblGioHang.getSelectedRow();
        hdct.setSoLuong(soLuong);
        hdct.setIdChiTietSanPham(idCTSP);
        hdct.setIdHoaDon(hoaDon.getId());
        this.guiHoaDonChiTiet.CapNhatSanPham(hdct);
        double tongHoaDon = hdct.getDonGia() * hdct.getSoLuong();
        hoaDon.setTongTien(tongHoaDon);
        this.guiHoaDon.CapNhatHoaDon(hoaDon);
        this.loadGioHang();
    }

    private void XoaMotSanPham() {
        if (modelHoaDonChiTiet.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Không có sản phẩm nào để xóa");
            return;
        }

        int rowHoaDon = tblHoaDon.getSelectedRow();
        if (rowHoaDon < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn bạn muốn xóa sản phẩm");
            return;
        }

        int rowSanPham = tblGioHang.getSelectedRow();
        if (rowSanPham < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm bạn cần xóa");
            return;
        }

        int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa sản phẩm này không", "Xóa", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Suy nghĩ kỹ nhen");
            return;
        }

        QLHoaDon hoaDon = this.lstHoaDon.get(rowHoaDon);
        UUID idCTSP = this.lstGioHang.get(rowSanPham).getIdChiTietSanPham();
        UUID idHoaDon = hoaDon.getId();

        int row = this.guiHoaDonChiTiet.XoaMotSanPham(idHoaDon, idCTSP);
        if (row > 0) {
            JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công");
            int rowHDCT = this.tblGioHang.getSelectedRow();
            QLHoaDonChiTiet hdct = this.lstGioHang.get(rowHDCT);
            this.guiHoaDonChiTiet.CapNhatSanPham(hdct);
            double tongHoaDon = hdct.getDonGia() * hdct.getSoLuong();
            hoaDon.setTongTien(tongHoaDon);
            this.guiHoaDon.CapNhatHoaDon(hoaDon);
            this.loadGioHang();
        }
    }

    private void XoaToanBoSanPham() {
        if (modelHoaDonChiTiet.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Không có sản phẩm nào để xóa");
            return;
        }

        int rowHoaDon = tblHoaDon.getSelectedRow();
        if (rowHoaDon < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn bạn muốn xóa sản phẩm");
            return;
        }

        QLHoaDon hoaDon = this.lstHoaDon.get(rowHoaDon);
        UUID idHoaDon = hoaDon.getId();
        int size = this.lstGioHang.size();
        if (size > 0) {
            int chon = JOptionPane.showConfirmDialog(this, "Sản phẩm chưa được lưu bạn có muốn xóa?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (chon == JOptionPane.YES_OPTION) {
                int row = this.guiHoaDonChiTiet.XoaToanBoSanPham(idHoaDon);
                if (row > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công toàn bộ sản phẩm có trong hóa đơn");
                    modelHoaDonChiTiet.setRowCount(0);
                    hoaDon.setTongTien(0.0);
                    this.guiHoaDon.CapNhatHoaDon(hoaDon);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Suy nghĩ kỹ nhen");
            }
        }
    }

    private double tienThua;

    private boolean XuLyDiem() {
        int soDiemKhachDung = 0;
        try {
            if (txtSoDiemSuDung.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống. Nếu khách hàng không sử dụng điểm hãy để giá trị là 0");
                txtSoDiemSuDung.setText("0");
                return false;
            }
            soDiemKhachDung = Integer.parseInt(txtSoDiemSuDung.getText());
            if (soDiemKhachDung < 0) {
                JOptionPane.showMessageDialog(this, "Số điểm bạn nhập cho khách hàng không hợp lệ");
                txtSoDiemSuDung.grabFocus();
                return false;
            }

            if (khachHang != null) {
                if (soDiemKhachDung > khachHang.getSoDiem()) {
                    JOptionPane.showMessageDialog(this, "Số điểm bạn nhập quá giới hạn điểm cho khách hàng");
                    txtSoDiemSuDung.grabFocus();
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị là số");
            txtSoDiemSuDung.grabFocus();
            return false;
        }
        return true;
    }

    private boolean XuLyTien() {
        if (txtSoTienMat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống. Xin kiểm tra lại");
            txtSoTienMat.grabFocus();
            return false;
        }
        try {
            this.tienMatKhachDua = Double.parseDouble(txtSoTienMat.getText());
            if (this.tienMatKhachDua < 0) {
                JOptionPane.showMessageDialog(this, "giá trị không hợp lệ. Xin kiểm tra lại");
                txtSoTienMat.grabFocus();
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị là số");
            txtSoTienMat.grabFocus();
            return false;
        }

        if (txtSoTienChuyenKhoan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống. Xin kiểm tra lại");
            txtSoTienChuyenKhoan.grabFocus();
            return false;
        }
        try {
            this.tienChuyenKhoan = Double.parseDouble(txtSoTienChuyenKhoan.getText());
            if (tienChuyenKhoan < 0) {
                JOptionPane.showMessageDialog(this, "giá trị không hợp lệ. Xin kiểm tra lại");
                txtSoTienChuyenKhoan.grabFocus();
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị là số");
            txtSoTienChuyenKhoan.grabFocus();
            return false;
        }

        return true;
    }

    private double tongTienDonHang;
    private double tienMatKhachDua = 0;
    private double tienChuyenKhoan = 0;

    private void loaiGiaoDich() {
        if (rdoChuyenKhoan.isSelected()) {
            loaiGiaoDich = "Chuyển khoản";
        } else if (rdoCaHai.isSelected()) {
            loaiGiaoDich = "Chuyển khoản + Tiền mặt";
        }
    }

    private boolean XuLyTienSauKhiChonLoaiGiaoDich() {
        if (this.loaiGiaoDich.equalsIgnoreCase("Tiền mặt")) {
            this.tienMatKhachDua = Double.parseDouble(txtSoTienMat.getText());
            if (this.tienMatKhachDua < this.tongTienDonHang) {
                JOptionPane.showMessageDialog(this, "Khách hàng chưa thanh toán đầy đủ tiền đơn hàng");
                txtSoTienMat.grabFocus();
                return false;
            }
        }

        if (this.loaiGiaoDich.equalsIgnoreCase("Chuyển khoản")) {
            this.tienChuyenKhoan = Double.parseDouble(txtSoTienChuyenKhoan.getText());
            if (this.tienChuyenKhoan < this.tongTienDonHang) {
                JOptionPane.showMessageDialog(this, "Khách hàng chưa thanh toán đầy đủ đơn hàng");
                txtSoTienChuyenKhoan.grabFocus();
                return false;
            }
        }

        if (this.tienChuyenKhoan + this.tienMatKhachDua < this.tongTienDonHang) {
            JOptionPane.showMessageDialog(this, "Khách hàng chưa thanh toán đầy đủ đơn hàng");
            return false;
        }
        return true;
    }

    private void ThanhToan(int rowHoaDon) {
        boolean res = this.XuLyDiem();
        if (res == true) {
            QLHoaDon hoaDon = this.lstHoaDon.get(rowHoaDon);
            if (hoaDon.getKieuBan() == 1) {
                JOptionPane.showMessageDialog(this, "Thanh toán chỉ áp dụng đối với hóa đơn bán trực tiếp tại cửa hàng");
                return;
            }
            this.tongTienDonHang = hoaDon.getTongTien() - this.guiSDDiem.DiemQuyTien(Integer.parseInt(txtSoDiemSuDung.getText()), -1);
            res = this.XuLyTien();
            if (res == true) {
                this.loaiGiaoDich();
                res = this.XuLyTienSauKhiChonLoaiGiaoDich();
                if (res == true) {
                    int size = this.guiHoaDonChiTiet.getAll(hoaDon.getId()).size();
                    if (size < 1) {
                        JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cho hóa đơn");
                        return;
                    }
                    this.xuLy(hoaDon);
                    if (hoaDon.getIdKhachHang() != null) {
                        this.diemKhachHang = this.guiDiemKhachHang.GetDiem(khachHang.getId());
                        this.soDiemCuaKhachHang = khachHang.getSoDiem();
                        this.XuLyDiemTru(hoaDon);
                        this.XuLyDiemCong(hoaDon);
                    }

                    JOptionPane.showMessageDialog(this, "Thanh toán hóa đơn thành công");
                    double tienTraLai = hoaDon.getSoTienKhachDua() - hoaDon.getTongTien();
                    lblSoTienTraLai.setText(String.valueOf(tienTraLai));
                    lblDocSoTien.setText(new DocSoThanhChuoi().DocSoHoanThien(this.tongTienDonHang));
                    int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất hóa đơn không?",
                            "Xuất hóa đơn", JOptionPane.YES_NO_OPTION);

                    if (luaChon == JOptionPane.NO_OPTION) {
                    } else {
                        this.XuatHoaDon(hoaDon);
                    }
                    this.loadHoaDon();
                    if (modelHoaDon.getRowCount() > 0) {
                        tblHoaDon.setRowSelectionInterval(0, 0);
                        this.loadThongTinDeThanhToan(0);
                        this.loadGioHang();
                        if (modelHoaDonChiTiet.getRowCount() > 0) {
                            this.tblGioHang.setRowSelectionInterval(0, 0);
                        }
                    } else {
                        modelHoaDonChiTiet.setRowCount(0);
                        this.LamMoiHoaDon();
                    }
                    this.CapNhatSoLuongSanPham(hoaDon.getId());
                    this.loadSanPham();
                }
            }
        }
    }

    private void XuatHoaDon(QLHoaDon hoaDon) {
        Hashtable map = new Hashtable();
        JasperReport jasperReport = null;
        try {
            jasperReport = JasperCompileManager.compileReport("src/report/rptXuatHoaDon.jrxml");
            map.put("IdHoaDon", String.valueOf(hoaDon.getId()));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, DBContext.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
            JasperExportManager.exportReportToPdfFile(jasperPrint, hoaDon.getMa().trim() + ".pdf");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void LamMoiHoaDon() {
        lblTongTien.setText("0");
        txtSoDiemSuDung.setText("0");
        lblSoTienGiam.setText("0");
        lblSoTienThanhToan.setText("0");
        txtSoTienMat.setText("0");
        lblSoTienTraLai.setText("");
        txtSoTienChuyenKhoan.setText("0");
        lblDocSoTien.setText("");
        lblMaKhachHang.setText("NULL");
        lblTenKhachHang.setText("Khách lẻ");
        lblMaHoaDon.setText("NULL");
        khachHang = null;
        txtSoDiemSuDung.setEditable(false);
        lblDocSoTienThanhToan.setText("Không");
        lblDocSoTienMatKhachTra.setText("Không");
        lblDocSoTienKhachCK.setText("Không");
        rdoTienMat.setSelected(true);
        txtGhiChu.setText("");
        cboHinhThucBan.setSelectedIndex(0);
        this.HienThiSoTienMat(true);
        this.HienThiSoTienChuyenKhoan(false);
        txtSoTienChuyenKhoan.grabFocus();
        return;
    }

    private void xuLy(QLHoaDon hoaDon) {
        UUID idKhachHang = null;
        if (khachHang != null) {
            idKhachHang = khachHang.getId();
        }
        hoaDon.setIdKhachHang(idKhachHang);
        UUID idGiaoDich = this.guiGiaoDich.GetId(this.loaiGiaoDich);
        hoaDon.setIdGiaoDich(idGiaoDich);
        int trangThai = 1;
        hoaDon.setTrangThai(trangThai);
        int soDiemSuDung = Integer.parseInt(this.txtSoDiemSuDung.getText());
        hoaDon.setSoDiemTieu(soDiemSuDung);
        String ngayThanhToan = Functions.ngayGioHienTai();
        hoaDon.setNgayThanhToan(ngayThanhToan);
        double tongTien = Double.parseDouble(this.lblSoTienThanhToan.getText());
        hoaDon.setTongTien(tongTien);
        double tongTienKhachDua = Double.parseDouble(txtSoTienMat.getText()) + Double.parseDouble(txtSoTienChuyenKhoan.getText());
        hoaDon.setSoTienKhachDua(tongTienKhachDua);
        hoaDon.setSoTienChuyenKhoan(Double.parseDouble(txtSoTienChuyenKhoan.getText()));
        hoaDon.setMoTa(txtGhiChu.getText());
        this.guiHoaDon.CapNhatHoaDon(hoaDon);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmMainUi().kieuBan = 0;
                new FrmMainUi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Logo;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnCapNhatSanPham;
    private javax.swing.JButton btnChonKhachHang;
    private javax.swing.JButton btnGiaoHang;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoaHoaDon;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JButton btnXoaTatCaSanPham;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboHinhThucBan;
    private javax.swing.JComboBox<String> cboTrangThaiHoaDon;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblDocSoTien;
    private javax.swing.JLabel lblDocSoTienKhachCK;
    private javax.swing.JLabel lblDocSoTienMatKhachTra;
    private javax.swing.JLabel lblDocSoTienThanhToan;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblMaKhachHang;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblSoTienChuyenKhoan;
    private javax.swing.JLabel lblSoTienGiam;
    private javax.swing.JLabel lblSoTienMat;
    private javax.swing.JLabel lblSoTienThanhToan;
    private javax.swing.JLabel lblSoTienTraLai;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTongTienHoaDon;
    private javax.swing.JLabel lblVND;
    private javax.swing.JLabel lblvnd;
    private javax.swing.JMenuItem mniCapNhatSanPham;
    private javax.swing.JMenuItem mniThemSanPham;
    private javax.swing.JMenuItem mniXemHoaDonGiaoHang;
    private javax.swing.JMenuItem mniXoaMotSanPham;
    private javax.swing.JMenuItem mniXoaTatCaSanPham;
    private javax.swing.JPopupMenu pmGiaoHang;
    private javax.swing.JPopupMenu pmGioHang;
    private javax.swing.JPopupMenu pmSanPham;
    private javax.swing.JPanel pnDoanhThu;
    private javax.swing.JPanel pnKhachHang;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JPanel pnQr;
    private javax.swing.JPanel pnQuyDoiDiem;
    private javax.swing.JRadioButton rdoCaHai;
    private javax.swing.JRadioButton rdoChuyenKhoan;
    private javax.swing.JRadioButton rdoTienMat;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextPane txtGhiChu;
    private javax.swing.JTextField txtSoDiemSuDung;
    private javax.swing.JTextField txtSoTienChuyenKhoan;
    private javax.swing.JTextField txtSoTienMat;
    // End of variables declaration//GEN-END:variables

    private int trangThaiSuDungDiem;
    private int soDiemCuaKhachHang;
    private QLDiemKhachHang diemKhachHang;

    private void CapNhatSoLuongSanPham(UUID idHoaDon) {
        List<QLHoaDonChiTiet> lstHoaDonCT = this.guiHoaDonChiTiet.getAll(idHoaDon);
        for (QLHoaDonChiTiet hdct : lstHoaDonCT) {
            int soLuong = hdct.getSoLuong();
            UUID idCTSP = hdct.getIdChiTietSanPham();
            this.guiSanPham.UpdateSoLuong(soLuong, idCTSP);
        }
    }

    private void XuLyDiemTru(QLHoaDon qlhd) {
        int soDiem = Integer.parseInt(txtSoDiemSuDung.getText());
        if (soDiem > 0) {
            this.trangThaiSuDungDiem = -1;
            this.soDiemCuaKhachHang -= soDiem;
            this.diemKhachHang.setSoDiem(soDiemCuaKhachHang);

            this.guiDiemKhachHang.CapNhatDiem(this.diemKhachHang);
            QLSuDungDiem diem = this.getQLSuDungDiem(qlhd);
            diem.setSoDiem(soDiem);
            this.guiSDDiem.ThemLichSuSuDungDiem(diem);
        }
    }

    private void XuLyDiemCong(QLHoaDon qlhd) {
        this.trangThaiSuDungDiem = 1;
        double tongTien = Double.parseDouble(lblSoTienThanhToan.getText());
        int soDiemCong = this.guiSDDiem.TienQuyDiem(tongTien, trangThaiSuDungDiem);
        this.soDiemCuaKhachHang += soDiemCong;
        diemKhachHang.setSoDiem(this.soDiemCuaKhachHang);
        this.guiDiemKhachHang.CapNhatDiem(this.diemKhachHang);
        QLSuDungDiem diem = this.getQLSuDungDiem(qlhd);
        diem.setSoDiem(soDiemCong);
        this.guiSDDiem.ThemLichSuSuDungDiem(diem);
    }

    private QLSuDungDiem getQLSuDungDiem(QLHoaDon qlHoaDon) {
        UUID id = null;
        UUID idHoaDon = qlHoaDon.getId();
        String ma = qlHoaDon.getMa();
        String ngayTao = qlHoaDon.getNgayTao();
        String ngayThanhToan = qlHoaDon.getNgayThanhToan();
        UUID idKhachHang = this.khachHang.getId();
        String maKhachHang = null;
        String tenKhachHang = null;
        String soDienThoai = null;
        UUID idQuyDoiDiem = this.guiQuyDoi.GetId(this.trangThaiSuDungDiem);
        Integer soDiem = null;
        if (idKhachHang != null) {
            soDiem = Integer.parseInt(txtSoDiemSuDung.getText());
        }
        int trangThai = this.trangThaiSuDungDiem;
        UUID idDiem = this.diemKhachHang.getId();

        QLSuDungDiem diem = new QLSuDungDiem(id, idHoaDon, ma, ngayTao, ngayThanhToan, idKhachHang, maKhachHang, tenKhachHang, soDienThoai, idQuyDoiDiem, idDiem, soDiem, trangThai);
        return diem;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
                Result result = null;
                BufferedImage image = null;
                if (webcam.isOpen()) {
                    if ((image = webcam.getImage()) == null) {
                        continue;
                    }
                    if (image != null) {
                        LuminanceSource source = new BufferedImageLuminanceSource(image);
                        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                        try {
                            result = new MultiFormatReader().decode(bitmap);
                            if (result != null) {
                                this.ThemSanPham(UUID.fromString(result.getText()));
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    webcam.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
