package services;

import domainmodels.*;
import java.util.List;
import java.util.UUID;
import viewmodels.QLNhanVien;

public interface GuiQLNhanVien {

    List<QLNhanVien> getAll();

    int ThemQLNhanVien(QLNhanVien qlnv);

    int XoaQLNhanVien(UUID id);

    int CapNhatQLNhanVien(QLNhanVien qlnv);

    List<CuaHang> GetAllCuaHang();

    List<ChucVu> GetAllChucVu();
    
    QLNhanVien GetSDTNhanVien (String sdt);
}
