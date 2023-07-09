package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLSanPham;

public interface GuiQLSanPham {

    List<QLSanPham> getAll();

    int ThemQLSanPham(QLSanPham qlsp);

    int XoaQLSanPham(UUID idSanPham);

    int CapNhatQLSanPham(QLSanPham qlsp);
}
