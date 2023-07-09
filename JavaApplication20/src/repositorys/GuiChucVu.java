package repositorys;

import domainmodels.ChucVu;
import java.util.List;
import java.util.UUID;

public interface GuiChucVu {

    List<ChucVu> getAll();

    int ThemChucVu(ChucVu cv);

    int XoaChucVu(UUID idChucVu);

    int CapNhatChucVu(ChucVu cv);

    ChucVu GetChucVu(String maChucVu);

    String GetMaChucVu(UUID idChucVu);

    String GetTenChucVu(UUID idChucVu);
}
