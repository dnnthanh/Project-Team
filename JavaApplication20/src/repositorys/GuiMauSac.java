package repositorys;

import domainmodels.MauSac;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiMauSac {

    List<MauSac> getAll();

    int ThemMauSac(MauSac ms);

    int XoaMauSac(UUID id);

    int CapNhatMauSac(MauSac ms);

    MauSac GetMauSac(String maMauSac);

    String GetMaMauSac(UUID idMauSac);

    String GetTenMauSac(UUID idMauSac);
}
