package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLGiaoDich;

public interface GuiQLGiaoDich {

    List<QLGiaoDich> getAll();

    int ThemQLGiaoDich(QLGiaoDich qlgd);

    int XoaQLGiaoDich(UUID idGiaoDich);

    int CapNhatQLGiaoDich(QLGiaoDich qlgd);

    UUID GetId(String ten);
    
    String GetTen (UUID id);
}
