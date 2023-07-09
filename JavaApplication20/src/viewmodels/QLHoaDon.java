package viewmodels;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class QLHoaDon {

    private UUID Id;
    private String Ma;
    private String Ten;
    private UUID IdKhachHang;
    private String tenKhachHang;
    private UUID IdNhanVien;
    private String tenNhanVien;
    private UUID IdGiaoDich;
    private String NgayTao;
    private String NgayThanhToan;
    private Integer SoDiemTieu;
    private Double TongTien;
    private Integer KieuBan;
    private String hoTen;
    private String soDienThoai;
    private String diaChi;
    private Date ngayNhanHangMongMuon;
    private Date ngayBatDauGiao;
    private Date ngayNhanHangThanhCong;
    private String moTa;
    private Double soTienChuyenKhoan;
    private int trangThai;
    private double soTienKhachDua;
    private double phiShip;

    public QLHoaDon() {
    }

    public QLHoaDon(UUID Id, String Ma, String Ten, UUID IdKhachHang, String tenKhachHang, UUID IdNhanVien, String tenNhanVien, UUID IdGiaoDich, String NgayTao, String NgayThanhToan, Integer SoDiemTieu, Double TongTien, Integer KieuBan, String hoTen, String soDienThoai, String diaChi, Date ngayNhanHangMongMuon, Date ngayBatDauGiao, Date ngayNhanHangThanhCong, String moTa, Double soTienChuyenKhoan, int trangThai, double soTienKhachDua, double phiShip) {
        this.Id = Id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.IdKhachHang = IdKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.IdNhanVien = IdNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.IdGiaoDich = IdGiaoDich;
        this.NgayTao = NgayTao;
        this.NgayThanhToan = NgayThanhToan;
        this.SoDiemTieu = SoDiemTieu;
        this.TongTien = TongTien;
        this.KieuBan = KieuBan;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngayNhanHangMongMuon = ngayNhanHangMongMuon;
        this.ngayBatDauGiao = ngayBatDauGiao;
        this.ngayNhanHangThanhCong = ngayNhanHangThanhCong;
        this.moTa = moTa;
        this.soTienChuyenKhoan = soTienChuyenKhoan;
        this.trangThai = trangThai;
        this.soTienKhachDua = soTienKhachDua;
        this.phiShip = phiShip;
    }

    public double getSoTienKhachDua() {
        return soTienKhachDua;
    }

    public void setSoTienKhachDua(double soTienKhachDua) {
        this.soTienKhachDua = soTienKhachDua;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID Id) {
        this.Id = Id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public UUID getIdKhachHang() {
        return IdKhachHang;
    }

    public void setIdKhachHang(UUID IdKhachHang) {
        this.IdKhachHang = IdKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public UUID getIdNhanVien() {
        return IdNhanVien;
    }

    public void setIdNhanVien(UUID IdNhanVien) {
        this.IdNhanVien = IdNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public UUID getIdGiaoDich() {
        return IdGiaoDich;
    }

    public void setIdGiaoDich(UUID IdGiaoDich) {
        this.IdGiaoDich = IdGiaoDich;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public Integer getSoDiemTieu() {
        return SoDiemTieu;
    }

    public void setSoDiemTieu(Integer SoDiemTieu) {
        this.SoDiemTieu = SoDiemTieu;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public void setTongTien(Double TongTien) {
        this.TongTien = TongTien;
    }

    public Integer getKieuBan() {
        return KieuBan;
    }

    public void setKieuBan(Integer KieuBan) {
        this.KieuBan = KieuBan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayNhanHangMongMuon() {
        return ngayNhanHangMongMuon;
    }

    public void setNgayNhanHangMongMuon(Date ngayNhanHangMongMuon) {
        this.ngayNhanHangMongMuon = ngayNhanHangMongMuon;
    }

    public Date getNgayBatDauGiao() {
        return ngayBatDauGiao;
    }

    public void setNgayBatDauGiao(Date ngayBatDauGiao) {
        this.ngayBatDauGiao = ngayBatDauGiao;
    }

    public Date getNgayNhanHangThanhCong() {
        return ngayNhanHangThanhCong;
    }

    public void setNgayNhanHangThanhCong(Date ngayNhanHangThanhCong) {
        this.ngayNhanHangThanhCong = ngayNhanHangThanhCong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Double getSoTienChuyenKhoan() {
        return soTienChuyenKhoan;
    }

    public void setSoTienChuyenKhoan(Double soTienChuyenKhoan) {
        this.soTienChuyenKhoan = soTienChuyenKhoan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public double getPhiShip() {
        return phiShip;
    }

    public void setPhiShip(double phiShip) {
        this.phiShip = phiShip;
    }   

    public String getMaHoaDon() {
        String maHoaDon = "";
        for (int i = 1; i < 9; i++) {
            Random rand = new Random();
            int ranNum = rand.nextInt(10);
            maHoaDon += ranNum;
        }
        return maHoaDon.trim();
    }

    public int kiemTraNgayHopLe() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayTao = df.parse(this.NgayTao);
        Date ngayThanhToan = df.parse(this.NgayThanhToan);

        if (this.ngayBatDauGiao.before(ngayTao)) {
            return -1; // ngày giao ko hợp lệ
        }

        if (this.ngayNhanHangMongMuon.before(ngayTao)) {
            return -2; // ngày nhận hàng ko hợp lệ
        }

        if (this.ngayNhanHangThanhCong.before(ngayTao)) {
            return -3; // ngày nhận hàng ko hợp lệ
        }

        if (ngayThanhToan.before(ngayTao)) {
            return -4; // ngày thanh toán ko hợp lệ
        }

        if (this.ngayBatDauGiao.after(this.ngayNhanHangMongMuon) || this.ngayBatDauGiao.after(this.ngayNhanHangThanhCong)) {
            return -5; // ngay giao phải trước ngày nhận hàng của khách
        }
        
        if(this.ngayNhanHangMongMuon.after(this.ngayNhanHangThanhCong)){
            return -6;
        }
        return 1;
    }
}
