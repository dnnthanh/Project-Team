package repositorys;

import domainmodels.HoaDon;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiHoaDon {

    List<HoaDon> getAll(int trangThai, UUID idNhanVien);

    int ThemHoaDon(HoaDon hd);

    int XoaHoaDon(UUID idHoaDon);

    int CapNhatHoaDon(HoaDon hd);

    List<HoaDon> getAll(UUID idNhanVien);

    HoaDon GetHoaDon(UUID id);
    
    //int CapNhatTrangThaiHoaDon (HoaDon hd);
}
