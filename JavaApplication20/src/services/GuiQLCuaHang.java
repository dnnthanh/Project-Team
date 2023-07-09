package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLCuaHang;

public interface GuiQLCuaHang {

    List<QLCuaHang> getAll();

    int ThemQLCuaHang(QLCuaHang qlch);

    int XoaQLCuaHang(UUID idCuaHang);

    int SuaQLCuaHang(QLCuaHang qlch);
}
