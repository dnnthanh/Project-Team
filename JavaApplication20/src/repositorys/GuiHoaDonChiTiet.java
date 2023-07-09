package repositorys;

import domainmodels.HoaDonChiTiet;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiHoaDonChiTiet {

    List<HoaDonChiTiet> getAll(UUID idHoaDon);

    int ThemSanPhamVaoHoaDonChiTiet(HoaDonChiTiet hdct);

    int CapNhatSanPham(HoaDonChiTiet hdct);

    boolean KiemTraSanPham(UUID idHoaDon, UUID IdChiTietSanPham);

    int SoLuongSanPhamTrongHoaDon(UUID idHoaDon, UUID idChiTietSanPham);

    int XoaToanBoSanPham(UUID idHoaDon);

    int XoaMotSanPham(UUID idHoaDon, UUID idChiTietSanPham);

    //int ThemSanPhamBangQR(HoaDonChiTiet hdct);

}
