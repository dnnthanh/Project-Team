package domainmodels;

import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public class QuyDoiDiem {

    private UUID id;
    private int soDiem;
    private double soTien;
    private int trangThai;

    public QuyDoiDiem() {
    }

    public QuyDoiDiem(UUID id, int soDiem, double soTien, int trangThai) {
        this.id = id;
        this.soDiem = soDiem;
        this.soTien = soTien;
        this.trangThai = trangThai;
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(int soDiem) {
        this.soDiem = soDiem;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
