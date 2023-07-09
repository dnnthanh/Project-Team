package repositorys;

import domainmodels.PhongCach;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class PhongCachRepository implements GuiPhongCach {

    final String SQL_ALL = "select *from tb_phongcach where trangThai = 1";
    final String SQL_INSERT = "insert into tb_phongcach (Ma, Ten) values(?, ?)";
    final String SQL_DELETE = "update tb_phongcach set trangthai = -1 where id = ?";
    final String SQL_UPDATE = "update tb_phongcach set Ten = ? where Id = ?";
    final String PHONGCACH_SELECTBYMA = "select *from tb_phongcach where ma = ?";
    final String MA_SELECTBYID = "select *from tb_phongcach where id = ?";
    final String TEN_SELECTBYID = "select *from tb_phongcach where id = ?";

    @Override
    public List<PhongCach> getAll() {
        try {
            List<PhongCach> lstPhongCach = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                PhongCach phongCach = new PhongCach(id, ma, ten, trangThai);
                lstPhongCach.add(phongCach);
            }
            return lstPhongCach;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemPhongCach(PhongCach phongCach) {
        PhongCach pc = this.GetPhongCach(phongCach.getMa());
        if (pc != null) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_INSERT, phongCach.getMa(), phongCach.getTen());
        return row;
    }

    @Override
    public int XoaPhongCach(UUID id) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, id);
        return row;
    }

    @Override
    public int CapNhatPhongCach(PhongCach phongCach) {
        String ma = this.GetMaPhongCach(phongCach.getId());
        if (ma.equalsIgnoreCase(phongCach.getMa()) == false) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, phongCach.getTen(), phongCach.getId());
        return row;
    }

    @Override
    public PhongCach GetPhongCach(String maPhongCach) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(PHONGCACH_SELECTBYMA, maPhongCach);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String hoTen = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                PhongCach pc = new PhongCach(id, ma, hoTen, trangThai);
                return pc;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String GetMaPhongCach(UUID idPhongCach) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(MA_SELECTBYID, idPhongCach);
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
    public String GetTenPhongCach(UUID idPhongCach) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(TEN_SELECTBYID, idPhongCach);
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
