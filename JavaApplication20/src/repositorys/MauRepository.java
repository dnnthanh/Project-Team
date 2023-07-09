package repositorys;

import domainmodels.Mau;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class MauRepository implements GuiMau {

    final String SQL_ALL = "select *from tb_mau where trangThai = 1";
    final String SQL_INSERT = "insert into tb_mau (Ma, Ten) values(?, ?)";
    final String SQL_DELETE = "update tb_mau set trangthai = -1 where id = ?";
    final String SQL_UPDATE = "update tb_mau set Ten = ? where Id = ?";
    final String MAU_SELECTBYMA = "select *from tb_mau where ma = ?";
    final String MA_SELECTBYID = "select *from tb_mau where id = ?";
    final String TEN_SELECTBYID = "select *from tb_mau where id = ?";

    @Override
    public List<Mau> getAll() {
        try {
            List<Mau> lstMau = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                Mau mau = new Mau(id, ma, ten, trangThai);
                lstMau.add(mau);
            }
            return lstMau;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemMau(Mau mau) {
        Mau m = this.GetMau(mau.getMa());
        if (m != null) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_INSERT, mau.getMa(), mau.getTen());
        return row;
    }

    @Override
    public int XoaMau(UUID id) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, id);
        return row;
    }

    @Override
    public int CapNhatMau(Mau mau) {
        String ma = this.GetMaMau(mau.getId());
        if (ma.equalsIgnoreCase(mau.getMa()) == false) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, mau.getTen(), mau.getId());
        return row;
    }

    @Override
    public Mau GetMau(String maMau) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(MAU_SELECTBYMA, maMau);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String hoTen = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                Mau mau = new Mau(id, ma, hoTen, trangThai);
                return mau;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String GetMaMau(UUID idMau) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(MA_SELECTBYID, idMau);
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
    public String GetTenMau(UUID idMau) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(TEN_SELECTBYID, idMau);
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
