package repositorys;

import domainmodels.ChatLieu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class ChatLieuRepository implements GuiChatLieu {

    final String SQL_ALL = "select *from tb_chatlieu where trangThai = 1";
    final String SQL_INSERT = "insert into tb_chatlieu (Ma, Ten) values(?, ?)";
    final String SQL_DELETE = "update tb_chatlieu set trangthai = -1 where id = ?";
    final String SQL_UPDATE = "update tb_chatlieu set Ten = ? where Id = ?";
    final String CHATLIEU_SELECTBYMA = "select *from tb_chatlieu where ma = ?";
    final String MA_SELECTBYID = "select *from tb_chatlieu where id = ?";
    final String TEN_SELECTBYID = "select *from tb_chatlieu where id = ?";

    @Override
    public List<ChatLieu> getAll() {
        try {
            List<ChatLieu> lstChatLieu = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                ChatLieu chatLieu = new ChatLieu(id, ma, ten, trangThai);
                lstChatLieu.add(chatLieu);
            }
            return lstChatLieu;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemChatLieu(ChatLieu chatLieu) {
        ChatLieu cLieu = this.GetChatLieu(chatLieu.getMa());
        if (cLieu != null) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_INSERT, chatLieu.getMa(), chatLieu.getTen());
        return row;
    }

    @Override
    public int XoaChatLieu(UUID idChatLieu) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, idChatLieu);
        return row;
    }

    @Override
    public int CapNhatChatLieu(ChatLieu chatLieu) {
        String ma = this.GetMaChatLieu(chatLieu.getId());
        if (ma.equalsIgnoreCase(chatLieu.getMa()) == false) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, chatLieu.getTen(), chatLieu.getId());
        return row;
    }

    @Override
    public ChatLieu GetChatLieu(String maChatLieu) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(CHATLIEU_SELECTBYMA, maChatLieu);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                ChatLieu chatLieu = new ChatLieu(id, ma, ten, trangThai);
                return chatLieu;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String GetMaChatLieu(UUID idChatLieu) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(MA_SELECTBYID, idChatLieu);
            while (rs.next()) {
                String ma = rs.getString("Ma").trim();
                return ma;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String GetTenChatLieu(UUID idChatLieu) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(TEN_SELECTBYID, idChatLieu);
            while (rs.next()) {
                String ten = rs.getString("ten").trim();
                return ten;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
