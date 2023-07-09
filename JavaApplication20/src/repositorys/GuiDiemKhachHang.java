package repositorys;

import domainmodels.DiemKhachHang;
import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiDiemKhachHang {

    int CapNhatDiem(DiemKhachHang diemKhachHang);

    int SoDiemHienTai(UUID idKhachHang);

    DiemKhachHang GetDiem(UUID idKhachHang);
    
    int ThemDiemKhachHangMoi (DiemKhachHang diemKhachHang);
}
