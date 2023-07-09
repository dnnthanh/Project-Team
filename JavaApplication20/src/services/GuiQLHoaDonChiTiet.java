package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLHoaDonChiTiet;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiQLHoaDonChiTiet {

    List<QLHoaDonChiTiet> getAll(UUID idHoaDon);

    int ThemSanPhamVaoHoaDonChiTiet(QLHoaDonChiTiet qlhdct);

    int CapNhatSanPham(QLHoaDonChiTiet qlhdct);

    boolean KiemTraSanPham(UUID idHoaDon, UUID IdChiTietSanPham);

    int SoLuongCoTrongCuaHang(UUID idChiTietSP);

    int SoLuongSanPhamCoTrongHoaDon(UUID idHoaDon, UUID idCTSP);

    int XoaToanBoSanPham(UUID idHoaDon);

    int XoaMotSanPham(UUID idHoaDon, UUID idChiTietSanPham);

    //int ThemSanPhamBangQR(QLHoaDonChiTiet qlhdct);
}
