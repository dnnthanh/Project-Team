package viewmodels;

import java.util.UUID;

public class QLChiTietSanPham {

    private UUID Id;
    private UUID IdSanPham;
    private String tenSanPham;
    private UUID IdNSX;
    private String tenNSX;
    private UUID IdMauSac;
    private String tenMauSac;
    private UUID IdPhongCach;
    private String tenPhongCach;
    private UUID IdSize;
    private String tenSize;
    private UUID IdMau;
    private String tenMau;
    private UUID IdChatLieu;
    private String tenChatLieu;
    private String HinhAnh;
    private int SoLuong;
    private double GiaNhap;
    private double GiaBan;
    private String MoTa;

    public QLChiTietSanPham() {
    }

    public QLChiTietSanPham(UUID Id, UUID IdSanPham, String tenSanPham, UUID IdNSX, String tenNSX, UUID IdMauSac, String tenMauSac, UUID IdPhongCach, String tenPhongCach, UUID IdSize, String tenSize, UUID IdMau, String tenMau, UUID IdChatLieu, String tenChatLieu, String HinhAnh, int SoLuong, double GiaNhap, double GiaBan, String MoTa) {
        this.Id = Id;
        this.IdSanPham = IdSanPham;
        this.tenSanPham = tenSanPham;
        this.IdNSX = IdNSX;
        this.tenNSX = tenNSX;
        this.IdMauSac = IdMauSac;
        this.tenMauSac = tenMauSac;
        this.IdPhongCach = IdPhongCach;
        this.tenPhongCach = tenPhongCach;
        this.IdSize = IdSize;
        this.tenSize = tenSize;
        this.IdMau = IdMau;
        this.tenMau = tenMau;
        this.IdChatLieu = IdChatLieu;
        this.tenChatLieu = tenChatLieu;
        this.HinhAnh = HinhAnh;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.MoTa = MoTa;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID Id) {
        this.Id = Id;
    }

    public UUID getIdSanPham() {
        return IdSanPham;
    }

    public void setIdSanPham(UUID IdSanPham) {
        this.IdSanPham = IdSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public UUID getIdNSX() {
        return IdNSX;
    }

    public void setIdNSX(UUID IdNSX) {
        this.IdNSX = IdNSX;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public UUID getIdMauSac() {
        return IdMauSac;
    }

    public void setIdMauSac(UUID IdMauSac) {
        this.IdMauSac = IdMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public UUID getIdPhongCach() {
        return IdPhongCach;
    }

    public void setIdPhongCach(UUID IdPhongCach) {
        this.IdPhongCach = IdPhongCach;
    }

    public String getTenPhongCach() {
        return tenPhongCach;
    }

    public void setTenPhongCach(String tenPhongCach) {
        this.tenPhongCach = tenPhongCach;
    }

    public UUID getIdSize() {
        return IdSize;
    }

    public void setIdSize(UUID IdSize) {
        this.IdSize = IdSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public UUID getIdMau() {
        return IdMau;
    }

    public void setIdMau(UUID IdMau) {
        this.IdMau = IdMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public UUID getIdChatLieu() {
        return IdChatLieu;
    }

    public void setIdChatLieu(UUID IdChatLieu) {
        this.IdChatLieu = IdChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
}
