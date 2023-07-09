package repositorys;

import domainmodels.HoaDon;
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
public class HoaDonRepository implements GuiHoaDon {

    final String SQL_ALL_HOADON = "SELECT *FROM TB_HOADON WHERE IDNHANVIEN =  ? order by Ten asc";
    final String SQL_ALL = "SELECT *FROM TB_HOADON WHERE TRANGTHAI = ? AND IDNHANVIEN =  ? order by Ten asc";
    final String SQL_INSERT = "INSERT INTO [dbo].[tb_HoaDon]([Ma], [Ten],[IdKhachHang],[IdNhanVien],[IdGiaoDich],[NgayThanhToan],[SoDiemTieu]\n"
            + ",[TongTien],[HoTen],[SoDienThoai],[DiaChi],[NgayNhanHangMongMuon],[NgayBatDauGiaoHang],[NgayNhanHangThanhCong]\n"
            + ",[MoTa])\n"
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String SQL_DELETE = "UPDATE TB_HOADON SET TRANGTHAI = -1 WHERE ID = ?";
    final String SQL_UPDATE = "UPDATE [dbo].[tb_HoaDon]\n"
            + "SET [Ma] = ?, [IdKhachHang] = ?,[IdNhanVien] = ?,[IdGiaoDich] = ?,[NgayThanhToan] = ?,[SoDiemTieu] = ?,[TongTien] = ?,[KieuBan] = ?,[HoTen] = ?,\n"
            + "[SoDienThoai] = ?,[DiaChi] = ?,[NgayNhanHangMongMuon] = ?,[NgayBatDauGiaoHang] = ?,[NgayNhanHangThanhCong] = ?,[MoTa] = ?,"
            + "[TrangThai] = ?,[SoTienChuyenKhoan] = ?, [SoTienKhachDua] = ?, [PhiShip] = ?\n"
            + " WHERE [Id] = ?";
    final String HOADONSELECTBYID = "select *from tb_hoadon where id = ?";

    private GuiNhanVien guiNhanVien;
    private GuiKhachHang guiKhachHang;

    public HoaDonRepository() {
        this.guiKhachHang = new KhachHangRepository();
        this.guiNhanVien = new NhanVienRepository();
    }

    @Override
    public List<HoaDon> getAll(int trangThaiHoaDon, UUID idNhanVien) {
        try {
            List<HoaDon> lstHoaDon = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL, trangThaiHoaDon, idNhanVien);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                String ma = rs.getString("Ma").trim();
                String ten = rs.getString("ten").trim();

                UUID idKhachHang = null;
                if (rs.getString("Idkhachhang") != null) {
                    idKhachHang = UUID.fromString(rs.getString("IdKhachHang"));
                }
                UUID idnv = null;
                if (rs.getString("IdNhanVien") != null) {
                    idnv = UUID.fromString(rs.getString("IdNhanVien"));
                }
                UUID idGiaoDich = null;
                if (rs.getString("Idgiaodich") != null) {
                    idGiaoDich = UUID.fromString(rs.getString("Idgiaodich"));
                }
                String ngayTao = rs.getString("ngayTao");
                String ngayThanhToan = null;
                if (rs.getString("ngayThanhtoan") != null) {
                    ngayThanhToan = rs.getString("ngayThanhtoan").trim();
                }
                Integer soDiemTieu = null;
                if (rs.getString("sodiemtieu") != null) {
                    soDiemTieu = Integer.parseInt(rs.getString("sodiemtieu"));
                }
                Double tongTien = null;
                if (rs.getString("tongtien") != null) {
                    tongTien = Double.parseDouble(rs.getString("tongtien"));
                }
                Integer kieuBan = null;
                if (rs.getString("kieuban") != null) {
                    kieuBan = Integer.parseInt(rs.getString("kieuban"));
                }
                String hoTen = null;
                if (rs.getString("hoTen") != null) {
                    hoTen = rs.getString("hoTen").trim();
                }
                String soDienThoai = null;
                if (rs.getString("sodienthoai") != null) {
                    soDienThoai = rs.getString("sodienthoai").trim();
                }
                String diachi = null;
                if (rs.getString("diaChi") != null) {
                    hoTen = rs.getString("diaChi").trim();
                }
                Date ngayNhanHangMongMuon = null;
                if (rs.getString("ngaynhanhangmongmuon") != null) {
                    ngayNhanHangMongMuon = rs.getDate("ngaynhanhangmongmuon");
                }
                Date ngayBatDauGiaoHang = null;
                if (rs.getString("ngayBatDauGiaoHang") != null) {
                    ngayBatDauGiaoHang = rs.getDate("ngayBatDauGiaoHang");
                }
                Date ngayNhanHangThanhCong = null;
                if (rs.getString("ngayNhanHangThanhCong") != null) {
                    ngayNhanHangThanhCong = rs.getDate("ngayNhanHangThanhCong");
                }
                String moTa = null;
                if (rs.getString("mota") != null) {
                    moTa = rs.getString("moTa").trim();
                }
                int trangThai = rs.getInt("trangthai");
                double soTienChuyenKhoan = rs.getDouble("sotienchuyenkhoan");
                double SoTienKhachDua = rs.getDouble("SoTienKhachDua");
                double phiShip = rs.getDouble("phiShip");
                HoaDon hoaDon = new HoaDon(id, ma, ten, idKhachHang, idnv, idGiaoDich, ngayTao, ngayThanhToan, soDiemTieu, tongTien, kieuBan, hoTen, soDienThoai, diachi, ngayNhanHangMongMuon, ngayBatDauGiaoHang, ngayNhanHangThanhCong, moTa, trangThai, soTienChuyenKhoan, SoTienKhachDua, phiShip);
                lstHoaDon.add(hoaDon);
            }
            return lstHoaDon;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemHoaDon(HoaDon hd) {
        int row = JDBCHelper.executeUpdate(SQL_INSERT, hd.getMa(), hd.getTen(), hd.getIdKhachHang(), hd.getIdNhanVien(), hd.getIdGiaoDich(),
                hd.getNgayThanhToan(), hd.getSoDiemTieu(), hd.getTongTien(), hd.getHoTen(),
                hd.getSoDienThoai(), hd.getDiaChi(), hd.getNgayNhanHangMongMuon(), hd.getNgayBatDauGiao(), hd.getNgayNhanHangThanhCong(),
                hd.getMoTa());
        return row;
    }

    @Override
    public int XoaHoaDon(UUID idHoaDon) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, idHoaDon);
        return row;
    }

    @Override
    public int CapNhatHoaDon(HoaDon hd) {
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, hd.getMa(), hd.getIdKhachHang(), hd.getIdNhanVien(), hd.getIdGiaoDich(), hd.getNgayThanhToan(), hd.getSoDiemTieu(), hd.getTongTien(), hd.getKieuBan(),
                hd.getHoTen(), hd.getSoDienThoai(), hd.getDiaChi(), hd.getNgayNhanHangMongMuon(), hd.getNgayBatDauGiao(),
                hd.getNgayNhanHangThanhCong(), hd.getMoTa(), hd.getTrangThai(), hd.getSoTienChuyenKhoan(), hd.getSoTienKhachDua(), hd.getPhiShip(), hd.getId());
        return row;
    }

    @Override
    public List<HoaDon> getAll(UUID idNhanVien) {
        try {
            List<HoaDon> lstHoaDon = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL_HOADON, idNhanVien);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                String ma = rs.getString("ma").trim();
                String ten = rs.getString("ten").trim();

                UUID idKhachHang = null;
                if (rs.getString("Idkhachhang") != null) {
                    idKhachHang = UUID.fromString(rs.getString("IdKhachHang"));
                }
                UUID idnv = null;
                if (rs.getString("IdNhanVien") != null) {
                    idnv = UUID.fromString(rs.getString("IdNhanVien"));
                }
                UUID idGiaoDich = null;
                if (rs.getString("Idgiaodich") != null) {
                    idGiaoDich = UUID.fromString(rs.getString("Idgiaodich"));
                }
                String ngayTao = rs.getString("ngayTao");
                String ngayThanhToan = null;
                if (rs.getString("ngayThanhtoan") != null) {
                    ngayThanhToan = rs.getString("ngayThanhtoan").trim();
                }
                Integer soDiemTieu = null;
                if (rs.getString("sodiemtieu") != null) {
                    soDiemTieu = Integer.parseInt(rs.getString("sodiemtieu"));
                }
                Double tongTien = null;
                if (rs.getString("tongtien") != null) {
                    tongTien = Double.parseDouble(rs.getString("tongtien"));
                }
                Integer kieuBan = null;
                if (rs.getString("kieuban") != null) {
                    kieuBan = Integer.parseInt(rs.getString("kieuban"));
                }
                String hoTen = null;
                if (rs.getString("hoTen") != null) {
                    hoTen = rs.getString("hoTen").trim();
                }
                String soDienThoai = null;
                if (rs.getString("sodienthoai") != null) {
                    soDienThoai = rs.getString("sodienthoai").trim();
                }
                String diachi = null;
                if (rs.getString("diaChi") != null) {
                    hoTen = rs.getString("diaChi").trim();
                }
                Date ngayNhanHangMongMuon = null;
                if (rs.getString("ngaynhanhangmongmuon") != null) {
                    ngayNhanHangMongMuon = rs.getDate("ngaynhanhangmongmuon");
                }
                Date ngayBatDauGiaoHang = null;
                if (rs.getString("ngayBatDauGiaoHang") != null) {
                    ngayBatDauGiaoHang = rs.getDate("ngayBatDauGiaoHang");
                }
                Date ngayNhanHangThanhCong = null;
                if (rs.getString("ngayNhanHangThanhCong") != null) {
                    ngayNhanHangThanhCong = rs.getDate("ngayNhanHangThanhCong");
                }
                String moTa = null;
                if (rs.getString("mota") != null) {
                    moTa = rs.getString("moTa").trim();
                }

                int trangThai = rs.getInt("trangthai");
                double soTienChuyenKhoan = rs.getDouble("sotienchuyenkhoan");
                double SoTienKhachDua = rs.getDouble("SoTienKhachDua");
                double phiShip = rs.getDouble("phiShip");
                HoaDon hoaDon = new HoaDon(id, ma, ten, idKhachHang, idnv, idGiaoDich, ngayTao, ngayThanhToan, soDiemTieu, tongTien, kieuBan, hoTen, soDienThoai, diachi, ngayNhanHangMongMuon, ngayBatDauGiaoHang, ngayNhanHangThanhCong, moTa, trangThai, soTienChuyenKhoan, SoTienKhachDua, phiShip);
                lstHoaDon.add(hoaDon);
            }
            return lstHoaDon;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public HoaDon GetHoaDon(UUID id) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(HOADONSELECTBYID, id);
            while (rs.next()) {
                String ma = rs.getString("ma").trim();
                String ten = rs.getString("ten").trim();

                UUID idKhachHang = null;
                if (rs.getString("Idkhachhang") != null) {
                    idKhachHang = UUID.fromString(rs.getString("IdKhachHang"));
                }
                UUID idnv = null;
                if (rs.getString("IdNhanVien") != null) {
                    idnv = UUID.fromString(rs.getString("IdNhanVien"));
                }
                UUID idGiaoDich = null;
                if (rs.getString("Idgiaodich") != null) {
                    idGiaoDich = UUID.fromString(rs.getString("Idgiaodich"));
                }
                String ngayTao = rs.getString("ngayTao");
                String ngayThanhToan = null;
                if (rs.getString("ngayThanhtoan") != null) {
                    ngayThanhToan = rs.getString("ngayThanhtoan").trim();
                }
                Integer soDiemTieu = null;
                if (rs.getString("sodiemtieu") != null) {
                    soDiemTieu = Integer.parseInt(rs.getString("sodiemtieu"));
                }
                Double tongTien = null;
                if (rs.getString("tongtien") != null) {
                    tongTien = Double.parseDouble(rs.getString("tongtien"));
                }
                Integer kieuBan = null;
                if (rs.getString("kieuban") != null) {
                    kieuBan = Integer.parseInt(rs.getString("kieuban"));
                }
                String hoTen = null;
                if (rs.getString("hoTen") != null) {
                    hoTen = rs.getString("hoTen").trim();
                }
                String soDienThoai = null;
                if (rs.getString("sodienthoai") != null) {
                    soDienThoai = rs.getString("sodienthoai").trim();
                }
                String diachi = null;
                if (rs.getString("diaChi") != null) {
                    hoTen = rs.getString("diaChi").trim();
                }
                Date ngayNhanHangMongMuon = null;
                if (rs.getString("ngaynhanhangmongmuon") != null) {
                    ngayNhanHangMongMuon = rs.getDate("ngaynhanhangmongmuon");
                }
                Date ngayBatDauGiaoHang = null;
                if (rs.getString("ngayBatDauGiaoHang") != null) {
                    ngayBatDauGiaoHang = rs.getDate("ngayBatDauGiaoHang");
                }
                Date ngayNhanHangThanhCong = null;
                if (rs.getString("ngayNhanHangThanhCong") != null) {
                    ngayNhanHangThanhCong = rs.getDate("ngayNhanHangThanhCong");
                }
                String moTa = null;
                if (rs.getString("mota") != null) {
                    moTa = rs.getString("moTa").trim();
                }

                int trangThai = rs.getInt("trangthai");
                double soTienChuyenKhoan = rs.getDouble("sotienchuyenkhoan");
                double SoTienKhachDua = rs.getDouble("SoTienKhachDua");
                double phiShip = rs.getDouble("phiShip");
                HoaDon hoaDon = new HoaDon(id, ma, ten, idKhachHang, idnv, idGiaoDich, ngayTao, ngayThanhToan, soDiemTieu, tongTien, kieuBan, hoTen, soDienThoai, diachi, ngayNhanHangMongMuon, ngayBatDauGiaoHang, ngayNhanHangThanhCong, moTa, trangThai, soTienChuyenKhoan, SoTienKhachDua, phiShip);
                return hoaDon;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
//
//    @Override
//    public int CapNhatTrangThaiHoaDon(HoaDon hd) {
//        String sql = "exec update_TrangThai '" + hd.getNgayBatDauGiao() + "','" + hd.getNgayNhanHangThanhCong() + "'";
//        int row = JDBCHelper.executeUpdate(sql, hd.getNgayBatDauGiao(), hd.getNgayNhanHangThanhCong());
//        return row;
//    }

//    public static void main(String[] args) {
//        HoaDonRepository hd = new HoaDonRepository();
//        UUID idNhanVien = UUID.fromString("B4F86210-EA85-4931-9979-8F9A42983DCA");
//        List<HoaDon> lst = hd.getAll(idNhanVien);
//        for (HoaDon hoaDon : lst) {
//            System.out.println(hoaDon.getSoTienKhachDua());
//        }
//    }
}
