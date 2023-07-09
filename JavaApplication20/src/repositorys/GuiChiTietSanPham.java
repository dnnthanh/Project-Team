package repositorys;

import domainmodels.ChiTietSanPham;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiChiTietSanPham {

    List<ChiTietSanPham> getAll();

    int ThemChiTietSanPham(ChiTietSanPham chiTietSanPham);

    int XoaChiTietSanPham(UUID id);

    int CapNhatChiTietSanPham(ChiTietSanPham chiTietSanPham);

    String TenSanPham(UUID idSanPham);

    String TenSP(UUID idChiTietSanPham);

    String TenNSX(UUID idNhaSanXuat);

    String TenMauSac(UUID idMauSac);

    String TenPhongCach(UUID idPhongCach);

    String TenSize(UUID idSize);

    String TenMau(UUID idMau);

    String TenChatLieu(UUID idChatLieu);

    int UpdateSoLuong(int soLuong, UUID id);

    int GetSoLuong(UUID id);
    
    List<ChiTietSanPham> GetCTSP(String s);
    
    ChiTietSanPham GetChiTietSanPham (UUID id);
}
