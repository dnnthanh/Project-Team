package repositorys;

import domainmodels.NhaSanXuat;
import java.util.List;
import java.util.UUID;

public interface GuiNhaSanXuat {

    List<NhaSanXuat> getAll();

    int ThemNhaSanXuat(NhaSanXuat nsx);

    int XoaNhaSanXuat(UUID id);

    int CapNhatNhaSanXuat(NhaSanXuat nsx);

    NhaSanXuat GetNSX(String maNhaSanXuat);

    String GetMaNSX(UUID idNhaSanXuat);

    String GetTenNSX(UUID idNSX);
}
