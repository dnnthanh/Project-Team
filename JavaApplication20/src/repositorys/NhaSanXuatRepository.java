package repositorys;

import domainmodels.NhaSanXuat;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NhaSanXuatRepository implements GuiNhaSanXuat {

    final String SQL_ALL = "select *from tb_nsx where trangThai = 1";
    final String SQL_INSERT = "insert into tb_nsx(Ma, Ten) values(?, ?)";
    final String SQL_DELETE = "update tb_nsx set trangthai = -1 where id = ?";
    final String SQL_UPDATE = "update tb_nsx set Ten = ? where Id = ?";
    final String NSX_SELECTBYMA = "select *from tb_nsx where ma = ?";
    final String MA_SELECTBYID = "select *from tb_nsx where id = ?";
    final String TEN_SELECTBYID = "select *from tb_nsx where id = ?";

    @Override
    public List<NhaSanXuat> getAll() {
        try {
            List<NhaSanXuat> lstNhaSanXuat = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                NhaSanXuat nhaSanXuat = new NhaSanXuat(id, ma, ten, trangThai);
                lstNhaSanXuat.add(nhaSanXuat);
            }
            return lstNhaSanXuat;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemNhaSanXuat(NhaSanXuat nsx) {
        NhaSanXuat nhaSanXuat = this.GetNSX(nsx.getMa());
        if (nhaSanXuat != null) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_INSERT, nsx.getMa(), nsx.getTen());
        return row;
    }

    @Override
    public int XoaNhaSanXuat(UUID id) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, id);
        return row;
    }

    @Override
    public int CapNhatNhaSanXuat(NhaSanXuat nsx) {
        String ma = this.GetMaNSX(nsx.getId());
        if (ma.equalsIgnoreCase(nsx.getMa()) == false) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, nsx.getTen(), nsx.getId());
        return row;
    }

    @Override
    public NhaSanXuat GetNSX(String maNhaSanXuat) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(NSX_SELECTBYMA, maNhaSanXuat);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String hoTen = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                NhaSanXuat nsx = new NhaSanXuat(id, ma, hoTen, trangThai);
                return nsx;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String GetMaNSX(UUID idNhaSanXuat) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(MA_SELECTBYID, idNhaSanXuat);
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
    public String GetTenNSX(UUID idNSX) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(TEN_SELECTBYID, idNSX);
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
