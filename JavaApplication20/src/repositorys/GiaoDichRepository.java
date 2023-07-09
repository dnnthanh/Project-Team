package repositorys;

import domainmodels.GiaoDich;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class GiaoDichRepository implements GuiGiaoDich {

    final String SQL_ALL = "select *from tb_giaodich where trangThai = 1";
    final String SQL_INSERT = "insert into tb_giaodich(Ma, Ten) values (?, ?)";
    final String SQL_DELETE = "update tb_giaodich set trangthai = -1 where id = ?";
    final String SQL_UPDATE = "update tb_cuahang set Ten = ? where Id = ?";
    final String ID_SELECTBYTEN = "select *from tb_giaodich where ten = ?";
    final String TEN_SELECTBYYD = "select *from tb_giaodich where id = ?";

    @Override
    public List<GiaoDich> getAll() {
        try {
            List<GiaoDich> lstGiaoDich = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                GiaoDich chatLieu = new GiaoDich(id, ma, ten, trangThai);
                lstGiaoDich.add(chatLieu);
            }
            return lstGiaoDich;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemGiaoDich(GiaoDich gd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int XoaGiaoDich(UUID id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int CapNhatGiaoDich(GiaoDich gd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UUID GetId(String ten) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(ID_SELECTBYTEN, ten);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                return id;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String tenGiaoDich(UUID id) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(TEN_SELECTBYYD, id);
            while (rs.next()) {
                String ten = rs.getString("ten").trim();
                return ten;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
}
