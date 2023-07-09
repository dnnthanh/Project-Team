package domainmodels;

import java.util.Date;
import java.util.UUID;

public class NhanVien {

    private UUID id;
    private String ma;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String soDienThoai;
    private String matKhau;
    private UUID idChucVu;
    private UUID idCuaHang;
    private UUID idNguoiQuanLy;
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(UUID id, String ma, String hoTen, String gioiTinh, Date ngaySinh, String diaChi, String soDienThoai, String matKhau, UUID idChucVu, UUID idCuaHang, UUID idNguoiQuanLy, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.matKhau = matKhau;
        this.idChucVu = idChucVu;
        this.idCuaHang = idCuaHang;
        this.idNguoiQuanLy = idNguoiQuanLy;
        this.trangThai = trangThai;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public UUID getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(UUID idChucVu) {
        this.idChucVu = idChucVu;
    }

    public UUID getIdCuaHang() {
        return idCuaHang;
    }

    public void setIdCuaHang(UUID idCuaHang) {
        this.idCuaHang = idCuaHang;
    }

    public UUID getIdNguoiQuanLy() {
        return idNguoiQuanLy;
    }

    public void setIdNguoiQuanLy(UUID idNguoiQuanLy) {
        this.idNguoiQuanLy = idNguoiQuanLy;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
