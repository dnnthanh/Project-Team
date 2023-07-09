package repositorys;

import domainmodels.SanPham;
import java.util.List;
import java.util.UUID;

public interface GuiSanPham {

    List<SanPham> getAll();

    int ThemSanPham(SanPham sanPham);

    int XoaSanPham(UUID id);

    int CapNhatSanPham(SanPham sanPham);

    SanPham GetSanPham(String maSanPham);

    String GetMaSanPham(UUID idSanPham);
    
    String GetTenSanPham(UUID idSanPham);

}
