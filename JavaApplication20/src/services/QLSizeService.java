package services;

import domainmodels.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.GuiSize;
import repositorys.SizeRepository;
import viewmodels.QLSize;

/**
 *
 * @author Ngọc Thanh
 */
public class QLSizeService implements GuiQLSize {

    private GuiSize guiSize;

    public QLSizeService() {
        this.guiSize = new SizeRepository();
    }

    @Override
    public List<QLSize> getAll() {
        List<Size> lstSize = this.guiSize.getAll();
        List<QLSize> lstQLSize = new ArrayList<>();

        for (Size size : lstSize) {
            UUID id = size.getId();
            String ma = size.getMa();
            String ten = size.getTen();

            QLSize qlsize = new QLSize(id, ma, ten);
            lstQLSize.add(qlsize);
        }
        return lstQLSize;
    }

    @Override
    public int ThemQLSize(QLSize qlSize) {
        UUID id = qlSize.getId();
        String ma = qlSize.getMa();
        String ten = qlSize.getTen();

        Size size = new Size(id, ma, ten, 1);
        return this.guiSize.ThemSize(size);
    }

    @Override
    public int XoaQLSize(UUID idSize) {
        return this.guiSize.XoaSize(idSize);
    }

    @Override
    public int CapNhatQLSize(QLSize qlSize) {
        UUID id = qlSize.getId();
        String ma = qlSize.getMa();
        String ten = qlSize.getTen();

        Size size = new Size(id, ma, ten, 1);
        return this.guiSize.CapNhatSize(size);
    }

}
