package services;

import domainmodels.SuDungDiem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.GuiSuDungDiem;
import repositorys.SuDungDiemRepository;
import viewmodels.QLHoaDon;
import viewmodels.QLKhachHang;
import viewmodels.QLSuDungDiem;

/**
 *
 * @author Ngọc Thanh
 */
public class QLSuDungDiemService implements GuiQLSuDungDiem {

    private GuiSuDungDiem guiSuDungDiem;
    private GuiQLHoaDon guiQLHoaDon;
    private GuiQLKhachHang guiKhachHang;

    public QLSuDungDiemService() {
        this.guiSuDungDiem = new SuDungDiemRepository();
        this.guiQLHoaDon = new QLHoaDonService();
        this.guiKhachHang = new QLKhachHangService();
    }

    @Override
    public List<QLSuDungDiem> getAll() {
        List<SuDungDiem> lstSuDungDiem = this.guiSuDungDiem.getAll();
        List<QLSuDungDiem> lstQL = new ArrayList<>();
        for (SuDungDiem sdd : lstSuDungDiem) {
            UUID id = sdd.getId();
            UUID idDiem = sdd.getIdDiem();
            UUID idHoaDon = sdd.getIdHoaDon();
            UUID idQuyDoiDiem = sdd.getIdQuyDoiDiem();
            int soDiem = sdd.getSoDiem();
            int trangThai = sdd.getTrangThai();
            QLHoaDon hoaDon = this.guiQLHoaDon.GetHoaDon(idHoaDon);
            String maHoaDon = hoaDon.getMa();
            UUID idKhachHang = hoaDon.getIdKhachHang();
            QLKhachHang khachHang = this.guiKhachHang.GetKhachHang(idKhachHang);
            String maKhachHang = khachHang.getMa();
            String tenKhachHang = khachHang.getHoTen();
            String sdt = khachHang.getSoDienThoai();
            String ngayTao = hoaDon.getNgayTao();
            String ngayThanhToan = hoaDon.getNgayThanhToan();

            QLSuDungDiem diem = new QLSuDungDiem(id, idHoaDon, maHoaDon, ngayTao, ngayThanhToan, idKhachHang, maKhachHang, tenKhachHang, sdt, idQuyDoiDiem, idDiem, soDiem, trangThai);
            lstQL.add(diem);
        }
        return lstQL;
    }

    @Override
    public int TienQuyDiem(double tienHoaDon, int trangThai) {
        return this.guiSuDungDiem.TienQuyDiem(tienHoaDon, trangThai);
    }

    @Override
    public double DiemQuyTien(int soDiemDangCo, int trangThai) {
        return this.guiSuDungDiem.DiemQuyTien(soDiemDangCo, trangThai);
    }

    @Override
    public int ThemLichSuSuDungDiem(QLSuDungDiem diem) {
        UUID id = diem.getId();
        UUID idQuyDoiDiem = diem.getIdQuyDoiDiem();
        UUID idHoaDon = diem.getIdHoaDon();
        UUID idDiem = diem.getIdDiem();
        int soDiem = diem.getSoDiem();
        int trangThai = diem.getTrangThai();

        SuDungDiem sdd = new SuDungDiem(id, idQuyDoiDiem, idHoaDon, idDiem, soDiem, trangThai);
        return this.guiSuDungDiem.ThemLichSuSuDung(sdd);
    }

}
