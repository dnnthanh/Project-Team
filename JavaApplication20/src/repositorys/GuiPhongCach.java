package repositorys;

import domainmodels.PhongCach;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiPhongCach {

    List<PhongCach> getAll();

    int ThemPhongCach(PhongCach phongCach);

    int XoaPhongCach(UUID id);

    int CapNhatPhongCach(PhongCach phongCach);

    PhongCach GetPhongCach(String maPhongCach);

    String GetMaPhongCach(UUID idPhongCach);

    String GetTenPhongCach(UUID idPhongCach);
}
