package repositorys;

import domainmodels.KhachHang;
import java.util.List;
import java.util.UUID;

public interface GuiKhachHang {

    List<KhachHang> getAll();

    int ThemKhachHang(KhachHang khachHang);

    int CapNhatKhachHang(KhachHang khachHang);

    int XoaKhachHang(UUID id);

    KhachHang GetSoDienThoai(String sdtKhachHang);
    
    String GetTenKhachHang (UUID idKhachHang);
    
    List<KhachHang> GetKhachHang (String str);
    
    int SoDiem (UUID idKhachHang);
    
    KhachHang GetId (UUID idKhachHang);
}
