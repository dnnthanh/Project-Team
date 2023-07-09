package services;

import domainmodels.PhongCach;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.GuiPhongCach;
import repositorys.PhongCachRepository;
import viewmodels.QLPhongCach;

/**
 *
 * @author Ngọc Thanh
 */
public class QLPhongCachService implements GuiQLPhongCach {

    private GuiPhongCach guiPhongCach;

    public QLPhongCachService() {
        this.guiPhongCach = new PhongCachRepository();
    }

    @Override
    public List<QLPhongCach> getAll() {
        List<PhongCach> lstPhongCach = this.guiPhongCach.getAll();
        List<QLPhongCach> lstQLPhongCach = new ArrayList<>();

        for (PhongCach pc : lstPhongCach) {
            UUID id = pc.getId();
            String ma = pc.getMa();
            String ten = pc.getTen();

            QLPhongCach qlpc = new QLPhongCach(id, ma, ten);
            lstQLPhongCach.add(qlpc);
        }
        return lstQLPhongCach;
    }

    @Override
    public int ThemQLPhongCach(QLPhongCach qlpc) {
        UUID id = qlpc.getId();
        String ma = qlpc.getMa();
        String ten = qlpc.getTen();

        PhongCach pc = new PhongCach(id, ma, ten, 1);
        return this.guiPhongCach.ThemPhongCach(pc);
    }

    @Override
    public int XoaQLPhongCach(UUID idPhongCach) {
        return this.guiPhongCach.XoaPhongCach(idPhongCach);
    }

    @Override
    public int CapNhatQLPhongCach(QLPhongCach qlpc) {
          UUID id = qlpc.getId();
        String ma = qlpc.getMa();
        String ten = qlpc.getTen();

        PhongCach pc = new PhongCach(id, ma, ten, 1);
        return this.guiPhongCach.CapNhatPhongCach(pc);
    }

}
