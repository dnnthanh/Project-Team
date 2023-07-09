package domainmodels;

import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public class SuDungDiem {

    private UUID id;
    private UUID idQuyDoiDiem;
    private UUID idHoaDon;
    private UUID idDiem;
    private int soDiem;
    private int trangThai;

    public SuDungDiem() {
    }

    public SuDungDiem(UUID id, UUID idQuyDoiDiem, UUID idHoaDon, UUID idDiem, int soDiem, int trangThai) {
        this.id = id;
        this.idQuyDoiDiem = idQuyDoiDiem;
        this.idHoaDon = idHoaDon;
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

    public UUID getIdQuyDoiDiem() {
        return idQuyDoiDiem;
    }

    public void setIdQuyDoiDiem(UUID idQuyDoiDiem) {
        this.idQuyDoiDiem = idQuyDoiDiem;
    }

    public UUID getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(UUID idHoaDon) {
        this.idHoaDon = idHoaDon;
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

    public UUID getIdDiem() {
        return idDiem;
    }

    public void setIdDiem(UUID idDiem) {
        this.idDiem = idDiem;
    }
}
