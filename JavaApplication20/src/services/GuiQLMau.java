package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLMau;

public interface GuiQLMau {

    List<QLMau> getAll();

    int ThemQLMau(QLMau qlm);

    int XoaQLMau(UUID idMau);

    int CapNhatQLMau(QLMau qlm);
}
