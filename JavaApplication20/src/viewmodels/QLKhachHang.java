package viewmodels;

import java.util.UUID;
import supports.Functions;

public class QLKhachHang {

    private UUID id;
    private String ma;
    private String hoTen;
    private String soDienThoai;
    private String diaChi;
    private String email;
    private String gioiTinh;
    private int soDiem;

    public QLKhachHang() {
    }

    public QLKhachHang(UUID id, String ma, String hoTen, String soDienThoai, String diaChi, String email, String gioiTinh, int soDiem) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.soDiem = soDiem;
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(int soDiem) {
        this.soDiem = soDiem;
    }

    public String GetMaKhachHang() {
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
