package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLMauSac;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiQLMauSac {

    List<QLMauSac> getAll();

    int ThemQLMauSac(QLMauSac qlms);

    int XoaQLMauSac(UUID idMauSac);

    int CapNhatQLMauSac(QLMauSac qlms);
}
