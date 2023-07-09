package repositorys;

import domainmodels.GiaoDich;
import java.util.List;
import java.util.UUID;

public interface GuiGiaoDich {

    List<GiaoDich> getAll();

    int ThemGiaoDich(GiaoDich gd);

    int XoaGiaoDich(UUID id);

    int CapNhatGiaoDich(GiaoDich gd);

    UUID GetId(String ten);
    
    String tenGiaoDich(UUID id);
}
