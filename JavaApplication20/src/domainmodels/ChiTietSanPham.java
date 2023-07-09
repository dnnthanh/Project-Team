package domainmodels;

import java.util.UUID;

public class ChiTietSanPham {

    private UUID Id;
    private UUID IdSanPham;
    private UUID IdNSX;
    private UUID IdMauSac;
    private UUID IdPhongCach;
    private UUID IdSize;
    private UUID IdMau;
    private UUID IdChatLieu;
    private String HinhAnh;
    private int SoLuong;
    private double GiaNhap;
    private double GiaBan;
    private String MoTa;
    private int TrangThai;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(UUID Id, UUID IdSanPham, UUID IdNSX, UUID IdMauSac, UUID IdPhongCach, UUID IdSize, UUID IdMau, UUID IdChatLieu, String HinhAnh, int SoLuong, double GiaNhap, double GiaBan, String MoTa, int TrangThai) {
        this.Id = Id;
        this.IdSanPham = IdSanPham;
        this.IdNSX = IdNSX;
        this.IdMauSac = IdMauSac;
        this.IdPhongCach = IdPhongCach;
        this.IdSize = IdSize;
        this.IdMau = IdMau;
        this.IdChatLieu = IdChatLieu;
        this.HinhAnh = HinhAnh;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.MoTa = MoTa;
        this.TrangThai = TrangThai;
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

    public UUID getIdNSX() {
        return IdNSX;
    }

    public void setIdNSX(UUID IdNSX) {
        this.IdNSX = IdNSX;
    }

    public UUID getIdMauSac() {
        return IdMauSac;
    }

    public void setIdMauSac(UUID IdMauSac) {
        this.IdMauSac = IdMauSac;
    }

    public UUID getIdPhongCach() {
        return IdPhongCach;
    }

    public void setIdPhongCach(UUID IdPhongCach) {
        this.IdPhongCach = IdPhongCach;
    }

    public UUID getIdSize() {
        return IdSize;
    }

    public void setIdSize(UUID IdSize) {
        this.IdSize = IdSize;
    }

    public UUID getIdMau() {
        return IdMau;
    }

    public void setIdMau(UUID IdMau) {
        this.IdMau = IdMau;
    }

    public UUID getIdChatLieu() {
        return IdChatLieu;
    }

    public void setIdChatLieu(UUID IdChatLieu) {
        this.IdChatLieu = IdChatLieu;
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

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
}
