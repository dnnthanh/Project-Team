package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLNhaSanXuat;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiQLNhaSanXuat {

    List<QLNhaSanXuat> getAll();

    int ThemQLNhaSanXuat(QLNhaSanXuat qlnsx);

    int XoaQLNhaSanXuat(UUID idNhaSanXuat);

    int CapNhatQLNhaSanXuat(QLNhaSanXuat qlnsx);
}
