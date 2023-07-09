package services;

import domainmodels.ChucVu;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.ChucVuRepository;
import repositorys.GuiChucVu;
import viewmodels.QLChucVu;

/**
 *
 * @author Ngọc Thanh
 */
public class QLChucVuService implements GuiQLChucVu {

    private GuiChucVu guiChucVu;

    public QLChucVuService() {
        this.guiChucVu = new ChucVuRepository();
    }

    @Override
    public List<QLChucVu> getAll() {
        List<ChucVu> lstChucVu = this.guiChucVu.getAll();
        List<QLChucVu> lstQLChucVu = new ArrayList<>();

        for (ChucVu cv : lstChucVu) {
            UUID id = cv.getId();
            String ma = cv.getMa();
            String ten = cv.getTen();

            QLChucVu qlcv = new QLChucVu(id, ma, ten);
            lstQLChucVu.add(qlcv);
        }
        return lstQLChucVu;
    }

    @Override
    public int ThemQLChucVu(QLChucVu qlcv) {
        UUID id = qlcv.getId();
        String ma = qlcv.getMa();
        String ten = qlcv.getTen();

        ChucVu chucVu = new ChucVu(id, ma, ten, 1);
        return this.guiChucVu.ThemChucVu(chucVu);
    }

    @Override
    public int XoaQLChucVu(UUID idChucVu) {
        return this.guiChucVu.XoaChucVu(idChucVu);
    }

    @Override
    public int CapNhatQLChucVu(QLChucVu qlcv) {
        UUID id = qlcv.getId();
        String ma = qlcv.getMa();
        String ten = qlcv.getTen();
        ChucVu chucVu = new ChucVu(id, ma, ten, 1);
        return this.guiChucVu.CapNhatChucVu(chucVu);
    }

}
