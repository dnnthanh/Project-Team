package viewmodels;

import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public class QLMauSac {

    private UUID id;
    private String ma;
    private String ten;

    public QLMauSac() {
    }

    public QLMauSac(UUID id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
