package repositorys;

import domainmodels.SanPham;
import java.util.List;
import java.util.UUID;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilitys.JDBCHelper;

public class SanPhamRepository implements GuiSanPham {

    final String SQL_ALL = "select *from tb_sanPham where trangThai = 1";
    final String SQL_INSERT = "insert into tb_sanpham(Ma, Ten) values(?, ?)";
    final String SQL_DELETE = "update tb_sanpham set trangthai = -1 where id = ?";
    final String SQL_UPDATE = "update tb_sanpham set Ten = ? where Id = ?";
    final String SANPHAM_SELECTBYMA = "select *from tb_sanpham where ma = ?";
    final String MA_SELECTBYID = "select *from tb_sanpham where id = ?";
    final String TEN_SELECTBYID = "select *from tb_sanpham where id = ?";

    @Override
    public List<SanPham> getAll() {
        try {
            List<SanPham> lstSanPham = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                SanPham sanPham = new SanPham(id, ma, ten, trangThai);
                lstSanPham.add(sanPham);
            }
            return lstSanPham;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemSanPham(SanPham sanPham) {
        SanPham s = this.GetSanPham(sanPham.getMa());
        if (s != null) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_INSERT, sanPham.getMa(), sanPham.getTen());
        return row;
    }

    @Override
    public int XoaSanPham(UUID id) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, id);
        return row;
    }

    @Override
    public int CapNhatSanPham(SanPham sanPham) {
        String ma = this.GetMaSanPham(sanPham.getId());
        if (ma.equalsIgnoreCase(sanPham.getMa()) == false) {
            return -1; // Không được sửa mã sản phẩm
        }
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, sanPham.getTen(), sanPham.getId());
        return row;
    }

    @Override
    public SanPham GetSanPham(String maSanPham) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(SANPHAM_SELECTBYMA, maSanPham);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("Ma").trim();
                String hoTen = rs.getString("ten").trim();
                int trangThai = rs.getInt("trangThai");

                SanPham sp = new SanPham(id, ma, hoTen, trangThai);
                return sp;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String GetMaSanPham(UUID idSanPham) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(MA_SELECTBYID, idSanPham);
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
    public String GetTenSanPham(UUID idSanPham) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(TEN_SELECTBYID, idSanPham);
            while (rs.next()) {
                String ten = rs.getString("ten").trim();
                return ten;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

//    public static void main(String[] args) {
//        SanPhamRepository sp = new SanPhamRepository();
//        UUID id = UUID.fromString("5ed92c72-06c8-474c-b34d-5bc8628edff8");
//        
//        System.out.println(sp.GetTenSanPham(id));
//    }
}
