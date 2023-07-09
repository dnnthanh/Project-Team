package repositorys;

import domainmodels.ChucVu;
import domainmodels.CuaHang;
import domainmodels.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class NhanVienRepository implements GuiNhanVien {

    private GuiChucVu guiChucVu;
    private GuiCuaHang guiCuaHang;

    public NhanVienRepository() {
        this.guiChucVu = new ChucVuRepository();
        this.guiCuaHang = new CuaHangRepository();
    }

    final String SQL_ALL = "select *from tb_NhanVien where IdNQL is not NULL";
    final String SQL_INSERT = "insert into tb_NhanVien (Ma, HoTen, SoDienThoai, matkhau, NgaySinh, DiaChi, GioiTinh, IdChucVu, IdCuaHang, IdNQL) VALUES(?,?,?,?,?,?,?,?,?,?)";
    final String SQL_DELETE = "update tb_NhanVien set TrangThai = -1 where Id = ?";
    final String SQL_UPDATE = "update tb_NhanVien set HoTen=?, GioiTinh=?, NgaySinh=?, DiaChi=?, MatKhau=? where Id=?";
    final String NHANVIEN_SELECTBYSDT = "select *from tb_NhanVien where SoDienThoai = ?";
    final String TEN_SELECTBYID = "select *from tb_NhanVien where id = ?";

    @Override
    public List<NhanVien> getAll() {
        try {
            List<NhanVien> lstNhanVien = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("ma").trim();
                String hoTen = rs.getString("hoTen").trim();
                String gioiTinh = rs.getString("gioiTinh").trim();
                Date ngaySinh = rs.getDate("ngaySinh");
                String diaChi = rs.getString("diaChi").trim();
                String soDienThoai = rs.getString("SoDienThoai").trim();
                String matKhau = rs.getString("matKhau").trim();
                UUID idChucVu = UUID.fromString(rs.getString("idChucVu").trim());
                UUID idCuaHang = UUID.fromString(rs.getString("idCuaHang").trim());
                UUID idNguoiQuanLy = null;
                if (rs.getString("idNQL") != null) {
                    idNguoiQuanLy = UUID.fromString(rs.getString("idNQL").trim());
                }
                int trangThai = rs.getInt("trangThai");

                NhanVien nv = new NhanVien(id, ma, hoTen, gioiTinh, ngaySinh, diaChi, soDienThoai, matKhau, idChucVu, idCuaHang, idNguoiQuanLy, trangThai);
                lstNhanVien.add(nv);
            }
            return lstNhanVien;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemNhanVien(NhanVien nv) {
        NhanVien nhanVien = this.GetSDTNhanVien(nv.getSoDienThoai());
        if (nhanVien != null) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_INSERT, nv.getMa(), nv.getHoTen(), nv.getSoDienThoai(),
                nv.getMatKhau(), nv.getNgaySinh(), nv.getDiaChi(),
                nv.getGioiTinh(), nv.getIdChucVu(), nv.getIdCuaHang(), nv.getIdNguoiQuanLy());

        return row;
    }

    @Override
    public int XoaNhanVien(UUID id) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, id);
        return row;
    }

    @Override
    public int CapNhatNhanVien(NhanVien nv) {
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, nv.getHoTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getDiaChi(), nv.getMatKhau(), nv.getId());
        return row;
    }

    @Override
    public List<ChucVu> GetAllChucVu() {
        return this.guiChucVu.getAll();
    }

    @Override
    public List<CuaHang> GetAllCuaHang() {
        return this.guiCuaHang.getAll();
    }

    @Override
    public NhanVien GetSDTNhanVien(String sdt) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(NHANVIEN_SELECTBYSDT, sdt);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                String ma = rs.getString("ma").trim();
                String hoTen = rs.getString("hoTen").trim();
                String gioiTinh = rs.getString("gioiTinh").trim();
                Date ngaySinh = rs.getDate("ngaySinh");
                String diaChi = rs.getString("diaChi").trim();
                String soDienThoai = rs.getString("SoDienThoai").trim();
                String matKhau = rs.getString("matKhau").trim();
                UUID idChucVu = UUID.fromString(rs.getString("idChucVu").trim());
                UUID idCuaHang = UUID.fromString(rs.getString("idCuaHang").trim());
                UUID idNguoiQuanLy = null;
                if (rs.getString("idNQL") != null) {
                    idNguoiQuanLy = UUID.fromString(rs.getString("idNQL").trim());
                }
                int trangThai = rs.getInt("trangThai");

                NhanVien nv = new NhanVien(id, ma, hoTen, gioiTinh, ngaySinh, diaChi, soDienThoai, matKhau, idChucVu, idCuaHang, idNguoiQuanLy, trangThai);
                return nv;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String GetTenNhanVien(UUID idNhanVien) {
        ResultSet rs = JDBCHelper.executeQuery(TEN_SELECTBYID, idNhanVien);
        try {
            while (rs.next()) {
                String hoTen = rs.getString("hoTen").trim();
                return hoTen;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String GetTenChucVu(UUID idChucVu) {
        return this.guiChucVu.GetTenChucVu(idChucVu);
    }

    @Override
    public String GetTenCuaHang(UUID idCuaHang) {
        return this.guiCuaHang.GetTenCuaHang(idCuaHang);
    }
}
