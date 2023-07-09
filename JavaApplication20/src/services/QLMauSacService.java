package services;

import domainmodels.MauSac;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.GuiMauSac;
import repositorys.MauSacRepository;
import viewmodels.QLMauSac;

/**
 *
 * @author Ngọc Thanh
 */
public class QLMauSacService implements GuiQLMauSac {

    private GuiMauSac guiMauSac;

    public QLMauSacService() {
        this.guiMauSac = new MauSacRepository();
    }

    @Override
    public List<QLMauSac> getAll() {
        List<MauSac> lstMauSac = this.guiMauSac.getAll();
        List<QLMauSac> lstQLMauSac = new ArrayList<>();

        for (MauSac ms : lstMauSac) {
            UUID id = ms.getId();
            String ma = ms.getMa();
            String ten = ms.getTen();

            QLMauSac qlms = new QLMauSac(id, ma, ten);
            lstQLMauSac.add(qlms);
        }
        return lstQLMauSac;
    }

    @Override
    public int ThemQLMauSac(QLMauSac qlms) {
        UUID id = qlms.getId();
        String ma = qlms.getMa();
        String ten = qlms.getTen();

        MauSac ms = new MauSac(id, ma, ten, 1);
        return this.guiMauSac.ThemMauSac(ms);
    }

    @Override
    public int XoaQLMauSac(UUID idMauSac) {
        return this.guiMauSac.XoaMauSac(idMauSac);
    }

    @Override
    public int CapNhatQLMauSac(QLMauSac qlms) {
         UUID id = qlms.getId();
        String ma = qlms.getMa();
        String ten = qlms.getTen();

        MauSac ms = new MauSac(id, ma, ten, 1);
        return this.guiMauSac.CapNhatMauSac(ms);
    }

}
