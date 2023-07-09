package repositorys;

import domainmodels.KhachHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class KhachHangRepository implements GuiKhachHang {

    final String SQL_ALL = "select *from tb_KhachHang where trangThai = 1";
    final String SQL_INSERT = "insert into tb_KhachHang(ma,HoTen,sdt,DiaChi,email,GioiTinh) values(?,?,?,?,?,?)";
    final String SQL_DELETE = "update tb_KhachHang set trangthai = -1 where id = ?";
    final String SQL_UPDATE = "update tb_KhachHang set HoTen = ?, sdt = ?, diaChi = ?, email = ?, gioiTinh = ? where id = ?";
    final String KHACHHANG_SELECTBYSDT = "select *from tb_khachhang where sdt = ?";
    final String KHACHHANG_SELECTBYID = "select *from tb_khachhang where id = ?";
    final String TEN_SELECTBYID = "select *from tb_KhachHang where Id = ?";
    final String DIEM_SELECTBYID = "select *from tb_Diem where IdKhachHang = ?";

    @Override
    public List<KhachHang> getAll() {
        try {
            List<KhachHang> lstkhachHang = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id").trim());
                String ma = rs.getString("ma").trim();
                String hoTen = rs.getString("hoTen").trim();
                String soDienThoai = null;
                if (rs.getString("sdt") != null) {
                    soDienThoai = rs.getString("sdt").trim();
                }
                String diaChi = null;
                if (rs.getString("diaChi") != null) {
                    diaChi = rs.getString("diaChi").trim();
                }
                String email = null;
                if (rs.getString("email") != null) {
                    email = rs.getString("email").trim();
                }
                int trangThai = rs.getInt("trangThai");
                String gioiTinh = null;
                if (rs.getString("gioiTinh") != null) {
                    gioiTinh = rs.getString("gioiTinh").trim();
                }
                KhachHang khachHang = new KhachHang(id, ma, hoTen, soDienThoai, diaChi, email, trangThai, gioiTinh);
                lstkhachHang.add(khachHang);
            }
            return lstkhachHang;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemKhachHang(KhachHang khachHang) {
        KhachHang kh = this.GetSoDienThoai(khachHang.getSoDienThoai());
        if (kh != null) {
            return -1;
        }
        int row = JDBCHelper.executeUpdate(SQL_INSERT, khachHang.getMa(), khachHang.getHoTen(), khachHang.getSoDienThoai(), khachHang.getDiaChi(), khachHang.getEmail(), khachHang.getGioiTinh());
        return row;
    }

    @Override
    public int CapNhatKhachHang(KhachHang khachHang) {
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, khachHang.getHoTen(), khachHang.getSoDienThoai(), khachHang.getDiaChi(), khachHang.getEmail(), khachHang.getGioiTinh(), khachHang.getId());
        return row;
    }

    @Override
    public int XoaKhachHang(UUID id) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, id);
        return row;
    }

    @Override
    public KhachHang GetSoDienThoai(String sdtKhachHang) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(KHACHHANG_SELECTBYSDT, sdtKhachHang);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id").trim());
                String ma = rs.getString("ma").trim();
                String hoTen = rs.getString("hoTen").trim();
                String soDienThoai = null;
                if (rs.getString("sdt") != null) {
                    soDienThoai = rs.getString("sdt").trim();
                }
                String diaChi = null;
                if (rs.getString("diaChi") != null) {
                    diaChi = rs.getString("diaChi").trim();
                }
                String email = null;
                if (rs.getString("email") != null) {
                    email = rs.getString("email").trim();
                }
                int trangThai = rs.getInt("trangThai");
                String gioiTinh = null;
                if (rs.getString("gioiTinh") != null) {
                    gioiTinh = rs.getString("gioiTinh").trim();
                }
                KhachHang khachHang = new KhachHang(id, ma, hoTen, soDienThoai, diaChi, email, trangThai, gioiTinh);
                return khachHang;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public String GetTenKhachHang(UUID idKhachHang) {
        try {
            List<KhachHang> lstkhachHang = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(TEN_SELECTBYID, idKhachHang);
            while (rs.next()) {
                String hoTen = rs.getString("hoTen").trim();
                return hoTen;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<KhachHang> GetKhachHang(String str) {
        try {
            List<KhachHang> lstkhachHang = new ArrayList<>();
            String sql = "Select * from tb_KhachHang where sdt like '%" + str + "%' or HoTen like '%" + str + "%'";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id").trim());
                String ma = rs.getString("ma").trim();
                String hoTen = rs.getString("hoTen").trim();
                String soDienThoai = null;
                if (rs.getString("sdt") != null) {
                    soDienThoai = rs.getString("sdt").trim();
                }
                String diaChi = null;
                if (rs.getString("diaChi") != null) {
                    diaChi = rs.getString("diaChi").trim();
                }
                String email = null;
                if (rs.getString("email") != null) {
                    email = rs.getString("email").trim();
                }
                int trangThai = rs.getInt("trangThai");
                String gioiTinh = null;
                if (rs.getString("gioiTinh") != null) {
                    gioiTinh = rs.getString("gioiTinh").trim();
                }
                KhachHang khachHang = new KhachHang(id, ma, hoTen, soDienThoai, diaChi, email, trangThai, gioiTinh);
                lstkhachHang.add(khachHang);
            }
            return lstkhachHang;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public int SoDiem(UUID idKhachHang) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(DIEM_SELECTBYID, idKhachHang);
            while (rs.next()) {
                int soDiem = rs.getInt("soDiemDangCo");
                return soDiem;
            }
            return 0;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public KhachHang GetId(UUID idKhachHang) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(KHACHHANG_SELECTBYID, idKhachHang);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id").trim());
                String ma = rs.getString("ma").trim();
                String hoTen = rs.getString("hoTen").trim();
                String soDienThoai = null;
                if (rs.getString("sdt") != null) {
                    soDienThoai = rs.getString("sdt").trim();
                }
                String diaChi = null;
                if (rs.getString("diaChi") != null) {
                    diaChi = rs.getString("diaChi").trim();
                }
                String email = null;
                if (rs.getString("email") != null) {
                    email = rs.getString("email").trim();
                }
                int trangThai = rs.getInt("trangThai");
                String gioiTinh = null;
                if (rs.getString("gioiTinh") != null) {
                    gioiTinh = rs.getString("gioiTinh").trim();
                }
                KhachHang khachHang = new KhachHang(id, ma, hoTen, soDienThoai, diaChi, email, trangThai, gioiTinh);
                return khachHang;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

//    public static void main(String[] args) {
//        KhachHangRepository kh = new KhachHangRepository();
//        UUID idKH = UUID.fromString("BF151AB9-72F9-4D39-8D0A-0793593B59DA");
//        
//        KhachHang k = kh.GetId(idKH);
//        System.out.println(k.getId());
//        
//    }
}
