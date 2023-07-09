package viewmodels;

import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public class QLDiemKhachHang {

    private UUID id;
    private UUID idKhachHang;
    private int soDiem;

    public QLDiemKhachHang() {
    }

    public QLDiemKhachHang(UUID id, UUID idKhachHang, int soDiem) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.soDiem = soDiem;
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

    public int getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(int soDiem) {
        this.soDiem = soDiem;
    }
}
