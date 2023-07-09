package services;

import domainmodels.Mau;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.GuiMau;
import repositorys.MauRepository;
import viewmodels.QLMau;

/**
 *
 * @author Ngọc Thanh
 */
public class QLMauService implements GuiQLMau {

    private GuiMau guiMau;

    public QLMauService() {
        this.guiMau = new MauRepository();
    }

    @Override
    public List<QLMau> getAll() {
        List<Mau> lstMau = this.guiMau.getAll();
        List<QLMau> lstQLMau = new ArrayList<>();

        for (Mau mau : lstMau) {
            UUID id = mau.getId();
            String ma = mau.getMa();
            String ten = mau.getTen();

            QLMau qlm = new QLMau(id, ma, ten);
            lstQLMau.add(qlm);
        }
        return lstQLMau;
    }

    @Override
    public int ThemQLMau(QLMau qlm) {
        UUID id = qlm.getId();
        String ma = qlm.getMa();
        String ten = qlm.getTen();

        Mau mau = new Mau(id, ma, ten, 1);
        return this.guiMau.ThemMau(mau);
    }

    @Override
    public int XoaQLMau(UUID idMau) {
        return this.guiMau.XoaMau(idMau);
    }

    @Override
    public int CapNhatQLMau(QLMau qlm) {
        UUID id = qlm.getId();
        String ma = qlm.getMa();
        String ten = qlm.getTen();

        Mau mau = new Mau(id, ma, ten, 1);
        return this.guiMau.CapNhatMau(mau);
    }

}
