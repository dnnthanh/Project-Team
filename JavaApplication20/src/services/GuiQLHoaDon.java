package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLHoaDon;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiQLHoaDon {

    List<QLHoaDon> getAll(int trangThaiHoaDon, UUID idNhanVien);

    int ThemQLHoaDon(QLHoaDon qlhd);

    int XoaQLHoaDon(UUID idHoaDon);

    int CapNhatHoaDon(QLHoaDon qlhd);

    List<QLHoaDon> getAll(UUID idNhanVien);
    
    QLHoaDon GetHoaDon (UUID id);
}
