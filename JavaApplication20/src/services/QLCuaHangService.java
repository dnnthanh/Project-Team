package services;

import domainmodels.CuaHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.CuaHangRepository;
import repositorys.GuiCuaHang;
import viewmodels.QLCuaHang;

/**
 *
 * @author Ngọc Thanh
 */
public class QLCuaHangService implements GuiQLCuaHang {

    private GuiCuaHang guiCuaHang;

    public QLCuaHangService() {
        this.guiCuaHang = new CuaHangRepository();
    }

    @Override
    public List<QLCuaHang> getAll() {
        List<CuaHang> lstCuaHang = this.guiCuaHang.getAll();
        List<QLCuaHang> lstQLCuaHang = new ArrayList<>();

        for (CuaHang ch : lstCuaHang) {
            UUID id = ch.getId();
            String ma = ch.getMa();
            String ten = ch.getTen();
            String diaChi = ch.getDiaChi();
            String thanhPho = ch.getThanhPho();

            QLCuaHang qLCuaHang = new QLCuaHang(id, ma, ten, diaChi, thanhPho);
            lstQLCuaHang.add(qLCuaHang);
        }
        return lstQLCuaHang;
    }

    @Override
    public int ThemQLCuaHang(QLCuaHang qlch) {
        UUID id = qlch.getId();
        String ma = qlch.getMa();
        String ten = qlch.getTen();
        String diaChi = qlch.getDiaChi();
        String thanhPho = qlch.getThanhPho();

        CuaHang cuaHang = new CuaHang(id, ma, ten, diaChi, thanhPho, 1);
        return this.guiCuaHang.ThemCuaHang(cuaHang);
    }

    @Override
    public int XoaQLCuaHang(UUID idCuaHang) {
        return this.guiCuaHang.XoaCuaHang(idCuaHang);
    }

    @Override
    public int SuaQLCuaHang(QLCuaHang qlch) {
        UUID id = qlch.getId();
        String ma = qlch.getMa();
        String ten = qlch.getTen();
        String diaChi = qlch.getDiaChi();
        String thanhPho = qlch.getThanhPho();

        CuaHang cuaHang = new CuaHang(id, ma, ten, diaChi, thanhPho, 1);
        return this.guiCuaHang.CapNhatCuaHang(cuaHang);
    }

}
