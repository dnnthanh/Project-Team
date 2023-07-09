package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLChatLieu;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiQLChatLieu {

    List<QLChatLieu> getAll();

    int ThemQLChatLieu(QLChatLieu qlcl);

    int XoaQLChatLieu(UUID idChatLieu);

    int CapNhatQLChatLieu(QLChatLieu qlcl);
}
