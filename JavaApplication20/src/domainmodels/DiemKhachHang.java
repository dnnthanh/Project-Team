package domainmodels;

import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public class DiemKhachHang {
    private UUID id;
    private UUID idKhachHang;
    private int soDiemDangCo;
    private int trangThai;

    public DiemKhachHang() {
    }

    public DiemKhachHang(UUID id, UUID idKhachHang, int soDiemDangCo, int trangThai) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.soDiemDangCo = soDiemDangCo;
        this.trangThai = trangThai;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(UUID idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getSoDiemDangCo() {
        return soDiemDangCo;
    }

    public void setSoDiemDangCo(int soDiemDangCo) {
        this.soDiemDangCo = soDiemDangCo;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
