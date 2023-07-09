package services;

import domainmodels.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.ChiTietSPRepository;
import repositorys.GuiChiTietSanPham;
import repositorys.GuiHoaDonChiTiet;
import repositorys.HoaDonCTRepository;
import viewmodels.QLHoaDonChiTiet;

/**
 *
 * @author Ngọc Thanh
 */
public class QLHoaDonChiTietService implements GuiQLHoaDonChiTiet {

    private GuiHoaDonChiTiet guiHoaDonChiTiet;
    private GuiChiTietSanPham guiChiTietSanPham;

    public QLHoaDonChiTietService() {
        this.guiHoaDonChiTiet = new HoaDonCTRepository();
        this.guiChiTietSanPham = new ChiTietSPRepository();
    }

    @Override
    public List<QLHoaDonChiTiet> getAll(UUID idHoaDon) {
        List<HoaDonChiTiet> lstHoaDonChiTiet = this.guiHoaDonChiTiet.getAll(idHoaDon);
        List<QLHoaDonChiTiet> lstList = new ArrayList<>();
        for (HoaDonChiTiet hoaDonChiTiet : lstHoaDonChiTiet) {
            UUID id = hoaDonChiTiet.getId();
            UUID idhd = hoaDonChiTiet.getIdHoaDon();
            UUID idCTSP = hoaDonChiTiet.getIdChiTietSanPham();
            String tenSP = this.guiChiTietSanPham.TenSP(idCTSP);
            Integer soLuong = hoaDonChiTiet.getSoLuong();
            Double giaBan = hoaDonChiTiet.getDonGia();

            QLHoaDonChiTiet qlhdct = new QLHoaDonChiTiet(id, idHoaDon, idCTSP, tenSP, soLuong, giaBan);
            lstList.add(qlhdct);
        }
        return lstList;
    }

    @Override
    public int ThemSanPhamVaoHoaDonChiTiet(QLHoaDonChiTiet qlhdct) {
        UUID id = qlhdct.getId();
        UUID idHoaDon = qlhdct.getIdHoaDon();
        UUID idCTSP = qlhdct.getIdChiTietSanPham();
        Integer soLuong = qlhdct.getSoLuong();
        Double donGia = qlhdct.getDonGia();

        HoaDonChiTiet hdct = new HoaDonChiTiet(id, idHoaDon, idCTSP, soLuong, donGia);
        return this.guiHoaDonChiTiet.ThemSanPhamVaoHoaDonChiTiet(hdct);
    }

    @Override
    public boolean KiemTraSanPham(UUID idHoaDon, UUID IdChiTietSanPham) {
        return this.guiHoaDonChiTiet.KiemTraSanPham(idHoaDon, IdChiTietSanPham);
    }

    @Override
    public int CapNhatSanPham(QLHoaDonChiTiet qlhdct) {
        UUID id = qlhdct.getId();
        UUID idHoaDon = qlhdct.getIdHoaDon();
        UUID idCTSP = qlhdct.getIdChiTietSanPham();
        Integer soLuong = qlhdct.getSoLuong();
        Double donGia = qlhdct.getDonGia();

        HoaDonChiTiet hdct = new HoaDonChiTiet(id, idHoaDon, idCTSP, soLuong, donGia);
        return this.guiHoaDonChiTiet.CapNhatSanPham(hdct);
    }

    @Override
    public int SoLuongCoTrongCuaHang(UUID idChiTietSP) {
        return this.guiChiTietSanPham.GetSoLuong(idChiTietSP);
    }

    @Override
    public int SoLuongSanPhamCoTrongHoaDon(UUID idHoaDon, UUID idCTSP) {
        return this.guiHoaDonChiTiet.SoLuongSanPhamTrongHoaDon(idHoaDon, idCTSP);
    }

    @Override
    public int XoaToanBoSanPham(UUID idHoaDon) {
        return this.guiHoaDonChiTiet.XoaToanBoSanPham(idHoaDon);
    }

    @Override
    public int XoaMotSanPham(UUID idHoaDon, UUID idChiTietSanPham) {
        return this.guiHoaDonChiTiet.XoaMotSanPham(idHoaDon, idChiTietSanPham);
    }

//    @Override
//    public int ThemSanPhamBangQR(QLHoaDonChiTiet qlhdct) {
//      UUID id = qlhdct.getId();
//        UUID idHoaDon = qlhdct.getIdHoaDon();
//        UUID idCTSP = qlhdct.getIdChiTietSanPham();
//        Integer soLuong = qlhdct.getSoLuong();
//        Double donGia = qlhdct.getDonGia();
//
//        HoaDonChiTiet hdct = new HoaDonChiTiet(id, idHoaDon, idCTSP, soLuong, donGia);
//        return this.guiHoaDonChiTiet.ThemSanPhamBangQR(hdct);
//    }

}
