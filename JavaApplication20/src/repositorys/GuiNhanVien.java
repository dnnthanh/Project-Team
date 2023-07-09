package repositorys;

import domainmodels.*;
import java.util.List;
import java.util.UUID;

public interface GuiNhanVien {

    List<NhanVien> getAll();

    int ThemNhanVien(NhanVien nv);

    int XoaNhanVien(UUID id);

    int CapNhatNhanVien(NhanVien nv);

    List<ChucVu> GetAllChucVu();

    List<CuaHang> GetAllCuaHang();

    NhanVien GetSDTNhanVien(String sdt);

    String GetTenNhanVien(UUID idNhanVien);

    String GetTenChucVu(UUID idChucVu);

    String GetTenCuaHang(UUID idCuaHang);
}
