package repositorys;

import domainmodels.ChatLieu;
import domainmodels.ChucVu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class ChucVuRepository implements GuiChucVu {

    final String SQL_ALL = "select *from tb_chucvu where trangThai = 1";
    final String SQL_INSERT = "insert into tb_chucvu (Ma, Ten) values(?, ?)";
    final String SQL_DELETE = "update tb_chucvu set trangthai = -1 where id = ?";
    final String SQL_UPDATE = "update tb_chucvu set Ten = ? where Id = ?";
    final String CHUCVU_SELECTBYMA = "select *from tb_chucvu where ma = ?";
    final String MA_SELECTBYID = "select *from tb_chucvu where id = ?";
    final String TEN_SELECTBYID = "select *from tb_chucvu where id = ?";

    @Override
    public List<ChucVu> getAll() {
        try {
            List<ChucVu> lstChucVu = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String hoTen = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                ChucVu cv = new ChucVu(id, ma, hoTen, trangThai);
                lstChucVu.add(cv);
            }
            return lstChucVu;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemChucVu(ChucVu cv) {
        ChucVu chucVu = this.GetChucVu(cv.getMa());
        if (chucVu != null) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_INSERT, cv.getMa(), cv.getTen());
        return row;
    }

    @Override
    public int XoaChucVu(UUID idChucVu) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, idChucVu);
        return row;
    }

    @Override
    public int CapNhatChucVu(ChucVu cv) {
        String ma = this.GetMaChucVu(cv.getId());
        if (ma.equalsIgnoreCase(cv.getMa()) == false) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, cv.getTen(), cv.getId());
        return row;
    }

    @Override
    public ChucVu GetChucVu(String maChucVu) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(CHUCVU_SELECTBYMA, maChucVu);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String hoTen = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                ChucVu cv = new ChucVu(id, ma, hoTen, trangThai);
                return cv;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String GetMaChucVu(UUID idChucVu) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(MA_SELECTBYID, idChucVu);
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
    public String GetTenChucVu(UUID idChucVu) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(TEN_SELECTBYID, idChucVu);
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
