package repositorys;

import domainmodels.CuaHang;
import java.util.List;
import java.util.UUID;

public interface GuiCuaHang {

    List<CuaHang> getAll();

    int ThemCuaHang(CuaHang ch);

    int XoaCuaHang(UUID id);

    int CapNhatCuaHang(CuaHang ch);

    CuaHang GetCuaHang(String maCuaHang);

    String GetMaCuaHang(UUID idCuaHang);

    String GetTenCuaHang(UUID idCuaHang);
}
