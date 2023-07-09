package viewmodels;

import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public class QLHoaDonChiTiet {

    private UUID id;
    private UUID idHoaDon;
    private UUID idChiTietSanPham;
    private String tenSanPham;
    private Integer soLuong;
    private Double donGia;

    public QLHoaDonChiTiet() {
    }

    public QLHoaDonChiTiet(UUID id, UUID idHoaDon, UUID idChiTietSanPham, String tenSanPham, Integer soLuong, Double donGia) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idChiTietSanPham = idChiTietSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(UUID idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public UUID getIdChiTietSanPham() {
        return idChiTietSanPham;
    }

    public void setIdChiTietSanPham(UUID idChiTietSanPham) {
        this.idChiTietSanPham = idChiTietSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
}
