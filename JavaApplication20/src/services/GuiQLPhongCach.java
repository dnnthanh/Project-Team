package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLPhongCach;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiQLPhongCach {

    List<QLPhongCach> getAll();

    int ThemQLPhongCach(QLPhongCach qlpc);

    int XoaQLPhongCach(UUID idPhongCach);

    int CapNhatQLPhongCach(QLPhongCach qlpc);
}
