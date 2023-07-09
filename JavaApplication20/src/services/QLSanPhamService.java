package services;

import domainmodels.SanPham;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.GuiSanPham;
import repositorys.SanPhamRepository;
import viewmodels.QLSanPham;

public class QLSanPhamService implements GuiQLSanPham {

    private GuiSanPham guiSanPham;

    public QLSanPhamService() {
        this.guiSanPham = new SanPhamRepository();
    }

    @Override
    public List<QLSanPham> getAll() {
        List<SanPham> lstSanPham = this.guiSanPham.getAll();
        List<QLSanPham> lstQLSanPham = new ArrayList<>();

        for (SanPham sp : lstSanPham) {
            UUID id = sp.getId();
            String ma = sp.getMa();
            String ten = sp.getTen();

            QLSanPham qlsp = new QLSanPham(id, ma, ten);
            lstQLSanPham.add(qlsp);
        }
        return lstQLSanPham;
    }

    @Override
    public int ThemQLSanPham(QLSanPham qlsp) {
        UUID id = qlsp.getId();
        String ma = qlsp.getMa();
        String ten = qlsp.getTen();

        SanPham sp = new SanPham(id, ma, ten, 1);
        return this.guiSanPham.ThemSanPham(sp);
    }

    @Override
    public int XoaQLSanPham(UUID idSanPham) {
        return this.guiSanPham.XoaSanPham(idSanPham);
    }

    @Override
    public int CapNhatQLSanPham(QLSanPham qlsp) {
        UUID id = qlsp.getId();
        String ma = qlsp.getMa();
        String ten = qlsp.getTen();

        SanPham sp = new SanPham(id, ma, ten, 1);
        return this.guiSanPham.CapNhatSanPham(sp);
    }

}
