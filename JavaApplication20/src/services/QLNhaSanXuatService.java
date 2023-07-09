package services;

import domainmodels.NhaSanXuat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.GuiNhaSanXuat;
import repositorys.NhaSanXuatRepository;
import viewmodels.QLNhaSanXuat;

/**
 *
 * @author Ngọc Thanh
 */
public class QLNhaSanXuatService implements GuiQLNhaSanXuat {

    private GuiNhaSanXuat guiNhaSanXuat;

    public QLNhaSanXuatService() {
        this.guiNhaSanXuat = new NhaSanXuatRepository();
    }

    @Override
    public List<QLNhaSanXuat> getAll() {
        List<NhaSanXuat> lstNhaSanXuat = this.guiNhaSanXuat.getAll();
        List<QLNhaSanXuat> lstQLNhaSanXuat = new ArrayList<>();

        for (NhaSanXuat nsx : lstNhaSanXuat) {
            UUID id = nsx.getId();
            String ma = nsx.getMa();
            String ten = nsx.getTen();

            QLNhaSanXuat qlnsx = new QLNhaSanXuat(id, ma, ten);
            lstQLNhaSanXuat.add(qlnsx);
        }
        return lstQLNhaSanXuat;
    }

    @Override
    public int ThemQLNhaSanXuat(QLNhaSanXuat qlnsx) {
        UUID id = qlnsx.getId();
        String ma = qlnsx.getMa();
        String ten = qlnsx.getTen();

        NhaSanXuat nsx = new NhaSanXuat(id, ma, ten, 1);
        return this.guiNhaSanXuat.ThemNhaSanXuat(nsx);
    }

    @Override
    public int XoaQLNhaSanXuat(UUID idNhaSanXuat) {
        return this.guiNhaSanXuat.XoaNhaSanXuat(idNhaSanXuat);
    }

    @Override
    public int CapNhatQLNhaSanXuat(QLNhaSanXuat qlnsx) {
        UUID id = qlnsx.getId();
        String ma = qlnsx.getMa();
        String ten = qlnsx.getTen();

        NhaSanXuat nsx = new NhaSanXuat(id, ma, ten, 1);
        return this.guiNhaSanXuat.CapNhatNhaSanXuat(nsx);
    }

}
