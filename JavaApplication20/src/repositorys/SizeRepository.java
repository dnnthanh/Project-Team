package repositorys;

import domainmodels.Size;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class SizeRepository implements GuiSize {

    final String SQL_ALL = "select *from tb_size where trangThai = 1";
    final String SQL_INSERT = "insert into tb_size (Ma, Ten) values(?, ?)";
    final String SQL_DELETE = "update tb_size set trangthai = -1 where id = ?";
    final String SQL_UPDATE = "update tb_size set Ten = ? where Id = ?";
    final String SIZE_SELECTBYMA = "select *from tb_size where ma = ?";
    final String MA_SELECTBYID = "select *from tb_size where id = ?";
    final String TEN_SELECTBYID = "select *from tb_size where id = ?";

    @Override
    public List<Size> getAll() {
        try {
            List<Size> lstSize = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                Size size = new Size(id, ma, ten, trangThai);
                lstSize.add(size);
            }
            return lstSize;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemSize(Size size) {
        Size s = this.GetSize(size.getMa());
        if (s != null) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_INSERT, size.getMa(), size.getTen());
        return row;
    }

    @Override
    public int XoaSize(UUID id) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, id);
        return row;
    }

    @Override
    public int CapNhatSize(Size size) {
        String ma = this.GetMaSize(size.getId());
        if (ma.equalsIgnoreCase(size.getMa()) == false) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, size.getTen(), size.getId());
        return row;
    }

    @Override
    public Size GetSize(String maSize) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(SIZE_SELECTBYMA, maSize);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                Size size = new Size(id, ma, ten, trangThai);
                return size;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String GetMaSize(UUID idSize) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(MA_SELECTBYID, idSize);
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
    public String GetTenSize(UUID idSize) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(TEN_SELECTBYID, idSize);
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
