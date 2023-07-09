package repositorys;

import domainmodels.QuyDoiDiem;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiQuyDoiDiem {

    List<QuyDoiDiem> getAll();

    int ThemQuyDoiDiem(QuyDoiDiem quyDoiDiem);

    int CapNhatQuyDoiDiem(QuyDoiDiem quyDoiDiem);

    UUID GetId(int trangThai);
    
    QuyDoiDiem GetQuyDoiDiem (int trangThai);
}
