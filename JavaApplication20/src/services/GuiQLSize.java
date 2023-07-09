package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLSize;

public interface GuiQLSize {

    List<QLSize> getAll();

    int ThemQLSize(QLSize qlSize);

    int XoaQLSize(UUID idSize);

    int CapNhatQLSize(QLSize qlSize);
}
