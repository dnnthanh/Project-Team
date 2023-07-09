package viewmodels;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public class QLSuDungDiem {

    private UUID id;
    private UUID idHoaDon;
    private String maHoaDon;
    private String ngayTao;
    private String ngayThanhToan;
    private UUID idKhachHang;
    private String maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private UUID idQuyDoiDiem;
    private UUID idDiem;
    private int soDiem;
    private int trangThai;

    public QLSuDungDiem() {
    }

    public QLSuDungDiem(UUID id, UUID idHoaDon, String maHoaDon, String ngayTao, String ngayThanhToan, UUID idKhachHang, String maKhachHang, String tenKhachHang, String soDienThoai, UUID idQuyDoiDiem, UUID idDiem, int soDiem, int trangThai) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.idKhachHang = idKhachHang;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.idQuyDoiDiem = idQuyDoiDiem;
        this.idDiem = idDiem;
        this.soDiem = soDiem;
        this.trangThai = trangThai;
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

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public UUID getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(UUID idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(int soDiem) {
        this.soDiem = soDiem;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public UUID getIdQuyDoiDiem() {
        return idQuyDoiDiem;
    }

    public void setIdQuyDoiDiem(UUID idQuyDoiDiem) {
        this.idQuyDoiDiem = idQuyDoiDiem;
    }

    public UUID getIdDiem() {
        return idDiem;
    }

    public void setIdDiem(UUID idDiem) {
        this.idDiem = idDiem;
    }
}
