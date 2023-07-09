package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLQuyDoiDiem;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiQLQuyDoiDiem {

    List<QLQuyDoiDiem> getAll();

    int ThemQuyDoiDiem(QLQuyDoiDiem diem);

    int CapNhatQuyDoiDiem(QLQuyDoiDiem diem);

    UUID GetId(int trangThai);
}
