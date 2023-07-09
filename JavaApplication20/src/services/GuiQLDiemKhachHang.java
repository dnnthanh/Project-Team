package services;

import java.util.UUID;
import viewmodels.QLDiemKhachHang;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiQLDiemKhachHang {

    int CapNhatDiem(QLDiemKhachHang diemKhachHang);

    int SoDiemHienTai(UUID idKhachHang);

    QLDiemKhachHang GetDiem(UUID idKhachHang);
    
    int ThemDiemKhachHangMoi (QLDiemKhachHang diemKhachHang);
}
