package services;

import domainmodels.ChatLieu;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.ChatLieuRepository;
import repositorys.GuiChatLieu;
import viewmodels.QLChatLieu;

/**
 *
 * @author Ngọc Thanh
 */
public class QLChatLieuService implements GuiQLChatLieu {

    private GuiChatLieu guiChatLieu;

    public QLChatLieuService() {
        this.guiChatLieu = new ChatLieuRepository();
    }

    @Override
    public List<QLChatLieu> getAll() {
        List<ChatLieu> lstChatLieu = this.guiChatLieu.getAll();
        List<QLChatLieu> lstQLChatLieu = new ArrayList<>();

        for (ChatLieu chatLieu : lstChatLieu) {
            UUID id = chatLieu.getId();
            String ma = chatLieu.getMa();
            String ten = chatLieu.getTen();

            QLChatLieu qlcl = new QLChatLieu(id, ma, ten);
            lstQLChatLieu.add(qlcl);
        }
        return lstQLChatLieu;
    }

    @Override
    public int ThemQLChatLieu(QLChatLieu qlcl) {
        UUID id = qlcl.getId();
        String ma = qlcl.getMa();
        String ten = qlcl.getTen();

        ChatLieu chatLieu = new ChatLieu(id, ma, ten, 1);
        return this.guiChatLieu.ThemChatLieu(chatLieu);
    }

    @Override
    public int XoaQLChatLieu(UUID idChatLieu) {
        return this.guiChatLieu.XoaChatLieu(idChatLieu);
    }

    @Override
    public int CapNhatQLChatLieu(QLChatLieu qlcl) {
        UUID id = qlcl.getId();
        String ma = qlcl.getMa();
        String ten = qlcl.getTen();

        ChatLieu chatLieu = new ChatLieu(id, ma, ten, 1);
        return this.guiChatLieu.CapNhatChatLieu(chatLieu);
    }

}
