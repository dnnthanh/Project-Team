package viewmodels;

import java.util.Date;
import java.util.UUID;
import supports.Functions;

public class QLNhanVien {

    private UUID id;
    private String ma;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String soDienThoai;
    private String matKhau;
    private UUID idChucVu;
    private String tenChucVu;
    private UUID idCuaHang;
    private String tenCuaHang;
    private UUID idNguoiQuanLy;
    private int trangThai;

    public QLNhanVien() {
    }

    public QLNhanVien(UUID id, String ma, String hoTen, String gioiTinh, Date ngaySinh, String diaChi, String soDienThoai, String matKhau, UUID idChucVu, String tenChucVu, UUID idCuaHang, String tenCuaHang, UUID idNguoiQuanLy, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.matKhau = matKhau;
        this.idChucVu = idChucVu;
        this.tenChucVu = tenChucVu;
        this.idCuaHang = idCuaHang;
        this.tenCuaHang = tenCuaHang;
        this.idNguoiQuanLy = idNguoiQuanLy;
        this.trangThai = trangThai;
    }

    public UUID getIdNguoiQuanLy() {
        return idNguoiQuanLy;
    }

    public void setIdNguoiQuanLy(UUID idNguoiQuanLy) {
        this.idNguoiQuanLy = idNguoiQuanLy;
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

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public UUID getIdCuaHang() {
        return idCuaHang;
    }

    public void setIdCuaHang(UUID idCuaHang) {
        this.idCuaHang = idCuaHang;
    }

    public String getTenCuaHang() {
        return tenCuaHang;
    }

    public void setTenCuaHang(String tenCuaHang) {
        this.tenCuaHang = tenCuaHang;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    public String GetMaNhanVien() {
        this.hoTen = Functions.ChuanHoaChuoi(this.hoTen); //chuẩn hóa chuỗi
        String temp = this.hoTen;
        temp = Functions.LoaiBoDau(temp); // Loại bỏ dấu tiếng việt
        String str[] = temp.split("\\s");
        int length = str.length;
        String coding = str[length - 1].toLowerCase() + str[0].substring(0, 1).toLowerCase();
        for (int i = 1; i < length - 1; ++i) {
            coding += str[i].substring(0, 1).toLowerCase();
        }
        for (int i = 0; i < 6; ++i) {
            double random = Math.random();
            random = random * 10;
            coding += String.valueOf((int) random);
        }
        return coding;
    }
}
