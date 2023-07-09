package repositorys;

import domainmodels.MauSac;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ngọc Thanh
 */
public class MauSacRepository implements GuiMauSac {

    final String SQL_ALL = "select *from tb_mausac where trangThai = 1";
    final String SQL_INSERT = "insert into tb_mausac(Ma, Ten) values(?, ?)";
    final String SQL_DELETE = "update tb_mausac set trangthai = -1 where id = ?";
    final String SQL_UPDATE = "update tb_mausac set Ten = ? where Id = ?";
    final String MAUSAC_SELECTBYMA = "select *from tb_mausac where ma = ?";
    final String MA_SELECTBYID = "select *from tb_mausac where id = ?";
    final String TEN_SELECTBYID = "select *from tb_mausac where id = ?";

    @Override
    public List<MauSac> getAll() {
        try {
            List<MauSac> lstMauSac = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                MauSac mauSac = new MauSac(id, ma, ten, trangThai);
                lstMauSac.add(mauSac);
            }
            return lstMauSac;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemMauSac(MauSac ms) {
        MauSac mauSac = this.GetMauSac(ms.getMa());
        if (ms != null) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_INSERT, ms.getMa(), ms.getTen());
        return row;
    }

    @Override
    public int XoaMauSac(UUID id) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, id);
        return row;
    }

    @Override
    public int CapNhatMauSac(MauSac ms) {
        String ma = this.GetMaMauSac(ms.getId());
        if (ma.equalsIgnoreCase(ms.getMa()) == false) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, ms.getTen(), ms.getId());
        return row;
    }

    @Override
    public MauSac GetMauSac(String maMauSac) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(MAUSAC_SELECTBYMA, maMauSac);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String hoTen = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                MauSac mauSac = new MauSac(id, ma, hoTen, trangThai);
                return mauSac;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String GetMaMauSac(UUID idMauSac) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(MA_SELECTBYID, idMauSac);
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
    public String GetTenMauSac(UUID idMauSac) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(TEN_SELECTBYID, idMauSac);
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
