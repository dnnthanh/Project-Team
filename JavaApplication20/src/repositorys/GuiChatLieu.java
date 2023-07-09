package repositorys;

import domainmodels.ChatLieu;
import java.util.List;
import java.util.UUID;

public interface GuiChatLieu {

    List<ChatLieu> getAll();

    int ThemChatLieu(ChatLieu chatLieu);

    int XoaChatLieu(UUID idChatLieu);

    int CapNhatChatLieu(ChatLieu chatLieu);

    ChatLieu GetChatLieu(String maChatLieu);

    String GetMaChatLieu(UUID idChatLieu);

    String GetTenChatLieu(UUID idChatLieu);
}
