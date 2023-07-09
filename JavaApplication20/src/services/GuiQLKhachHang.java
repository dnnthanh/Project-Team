package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLKhachHang;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiQLKhachHang {

    List<QLKhachHang> getAll();

    int ThemQLKhachHang(QLKhachHang qlkh);

    int XoaQLKhachHang(UUID idKhachHang);

    int SuaQLKhachHang(QLKhachHang qlkh);

    List<QLKhachHang> GetKhachHang(String str);
    
    QLKhachHang GetKhachHang (UUID id);
    
    UUID GetId (String sdt);
}
