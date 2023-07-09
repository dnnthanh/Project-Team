package repositorys;

import domainmodels.Mau;
import java.util.List;
import java.util.UUID;

public interface GuiMau {

    List<Mau> getAll();

    int ThemMau(Mau mau);

    int XoaMau(UUID id);

    int CapNhatMau(Mau mau);

    Mau GetMau(String maMau);

    String GetMaMau(UUID idMau);

    String GetTenMau(UUID idMau);
}
