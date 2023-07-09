package services;

import domainmodels.KhachHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.GuiKhachHang;
import repositorys.KhachHangRepository;
import viewmodels.QLKhachHang;

/**
 *
 * @author Ngọc Thanh
 */
public class QLKhachHangService implements GuiQLKhachHang {

    private GuiKhachHang guiKhachHang;

    public QLKhachHangService() {
        this.guiKhachHang = new KhachHangRepository();
    }

    @Override
    public List<QLKhachHang> getAll() {
        List<KhachHang> lstKhachHang = this.guiKhachHang.getAll();
        List<QLKhachHang> lstQLKhachHang = new ArrayList<>();

        for (KhachHang kh : lstKhachHang) {
            UUID id = kh.getId();
            String ma = kh.getMa();
            String ten = kh.getHoTen();
            String sdt = kh.getSoDienThoai();
            String diaChi = kh.getDiaChi();
            String email = kh.getEmail();
            String gioiTinh = kh.getGioiTinh();
            int soDiem = this.guiKhachHang.SoDiem(id);
            QLKhachHang qlkh = new QLKhachHang(id, ma, ten, sdt, diaChi, email, gioiTinh, soDiem);
            lstQLKhachHang.add(qlkh);
        }
        return lstQLKhachHang;
    }

    @Override
    public int ThemQLKhachHang(QLKhachHang qlkh) {
        UUID id = qlkh.getId();
        String ma = qlkh.getMa();
        String ten = qlkh.getHoTen();
        String sdt = qlkh.getSoDienThoai();
        String diaChi = qlkh.getDiaChi();
        String email = qlkh.getEmail();
        String gioiTinh = qlkh.getGioiTinh();

        KhachHang khachHang = new KhachHang(id, ma, ten, sdt, diaChi, email, 1, gioiTinh);
        return this.guiKhachHang.ThemKhachHang(khachHang);
    }

    @Override
    public int XoaQLKhachHang(UUID idKhachHang) {
        return this.guiKhachHang.XoaKhachHang(idKhachHang);
    }

    @Override
    public int SuaQLKhachHang(QLKhachHang qlkh) {
        UUID id = qlkh.getId();
        String ma = qlkh.getMa();
        String ten = qlkh.getHoTen();
        String sdt = qlkh.getSoDienThoai();
        String diaChi = qlkh.getDiaChi();
        String email = qlkh.getEmail();
        String gioiTinh = qlkh.getGioiTinh();

        KhachHang khachHang = new KhachHang(id, ma, ten, sdt, diaChi, email, 1, gioiTinh);
        return this.guiKhachHang.CapNhatKhachHang(khachHang);
    }

    @Override
    public List<QLKhachHang> GetKhachHang(String str) {
        List<KhachHang> lstKhachHang = this.guiKhachHang.GetKhachHang(str);
        List<QLKhachHang> lstQLKhachHang = new ArrayList<>();

        for (KhachHang kh : lstKhachHang) {
            UUID id = kh.getId();
            String ma = kh.getMa();
            String ten = kh.getHoTen();
            String sdt = kh.getSoDienThoai();
            String diaChi = kh.getDiaChi();
            String email = kh.getEmail();
            String gioiTinh = kh.getGioiTinh();
            int soDiem = this.guiKhachHang.SoDiem(id);
            QLKhachHang qlkh = new QLKhachHang(id, ma, ten, sdt, diaChi, email, gioiTinh, soDiem);
            lstQLKhachHang.add(qlkh);
        }
        return lstQLKhachHang;
    }

    @Override
    public QLKhachHang GetKhachHang(UUID id) {
        KhachHang kh = this.guiKhachHang.GetId(id);
        String ma = kh.getMa();
        String ten = kh.getHoTen();
        String sdt = kh.getSoDienThoai();
        String diaChi = kh.getDiaChi();
        String email = kh.getEmail();
        String gioiTinh = kh.getGioiTinh();
        int soDiem = this.guiKhachHang.SoDiem(id);
        QLKhachHang qlkh = new QLKhachHang(id, ma, ten, sdt, diaChi, email, gioiTinh, soDiem);
        return qlkh;
    }

    @Override
    public UUID GetId(String sdt) {
        KhachHang kh = this.guiKhachHang.GetSoDienThoai(sdt);
        UUID id = kh.getId();
        return id;
    }

}
