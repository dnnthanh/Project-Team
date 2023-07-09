package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLChucVu;

public interface GuiQLChucVu {
    List<QLChucVu> getAll();

    int ThemQLChucVu(QLChucVu qlcv);

    int XoaQLChucVu(UUID idChucVu);

    int CapNhatQLChucVu(QLChucVu qlcv);
}
