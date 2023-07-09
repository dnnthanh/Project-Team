package repositorys;

import domainmodels.CuaHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class CuaHangRepository implements GuiCuaHang {

    final String SQL_ALL = "select *from tb_cuahang where trangThai = 1";
    final String SQL_INSERT = "insert into tb_CuaHang(Ma, Ten, DiaChi, ThanhPho) values (?, ?, ?,?)";
    final String SQL_DELETE = "update tb_cuahang set trangthai = -1 where id = ?";
    final String SQL_UPDATE = "update tb_cuahang set Ten = ? where Id = ?";
    final String CUAHANG_SELECTBYMA = "select *from tb_cuahang where ma = ?";
    final String MA_SELECTBYID = "select *from tb_cuahang where id = ?";
    final String TEN_SELECTBYID = "select *from tb_cuahang where id = ?";

    @Override
    public List<CuaHang> getAll() {
        try {
            List<CuaHang> lstCuaHang = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();
                String diaChi = rs.getString("diaChi").trim();
                String thanhPho = rs.getString("thanhPho").trim();
                int trangThai = rs.getInt("trangThai");

                CuaHang cuaHang = new CuaHang(id, ma, ten, diaChi, thanhPho, trangThai);
                lstCuaHang.add(cuaHang);
            }
            return lstCuaHang;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemCuaHang(CuaHang ch) {
        CuaHang cuaHang = this.GetCuaHang(ch.getMa());
        if (cuaHang != null) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_INSERT, ch.getMa(), ch.getTen(), ch.getDiaChi(), ch.getThanhPho());
        return row;
    }

    @Override
    public int XoaCuaHang(UUID id) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, id);
        return row;
    }

    @Override
    public int CapNhatCuaHang(CuaHang ch) {
        String ma = this.GetMaCuaHang(ch.getId());
        if (ma.equalsIgnoreCase(ch.getMa()) == false) {
            return -1; // Không được thay đổi cửa hàng
        }
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, ch.getTen(), ch.getDiaChi(), ch.getThanhPho(), ch.getId());
        return row;
    }

    @Override
    public CuaHang GetCuaHang(String maCuaHang) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(CUAHANG_SELECTBYMA, maCuaHang);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();
                String diaChi = rs.getString("diaChi").trim();
                String thanhPho = rs.getString("thanhPho").trim();
                int trangThai = rs.getInt("trangThai");

                CuaHang cuaHang = new CuaHang(id, ma, ten, diaChi, thanhPho, trangThai);
                return cuaHang;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String GetMaCuaHang(UUID idCuaHang) {
       try {
            ResultSet rs = JDBCHelper.executeQuery(MA_SELECTBYID, idCuaHang);
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
    public String GetTenCuaHang(UUID idCuaHang) {
         try {
            ResultSet rs = JDBCHelper.executeQuery(TEN_SELECTBYID, idCuaHang);
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
