package repositorys;

import domainmodels.HoaDonChiTiet;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class HoaDonCTRepository implements GuiHoaDonChiTiet {

    private GuiChiTietSanPham guiChiTietSP;

    public HoaDonCTRepository() {
        this.guiChiTietSP = new ChiTietSPRepository();
    }

    final String SQL_ALL = "SELECT *FROM TB_HOADONCHITIET WHERE IDHOADON = ? and TrangThai = 1 and soluong > 0";
    final String SQL_INSERT = "INSERT INTO [dbo].[tb_HoaDonChiTiet]\n"
            + "([IdHoaDon],[IdChiTietSP],[SoLuong],[DonGia])\n"
            + "VALUES(?,?,?,?)";
    final String KIEMTRA = "SELECT *FROM TB_HOADONCHITIET where IdHoaDon = ? AND IdChiTietSP = ?";
    final String SQL_UPDATE = "update tb_hoadonchitiet set soluong = ? where idchitietsp = ? and idhoadon = ?";
    final String SQL_SOLUONG = "SELECT *FROM TB_HOADONCHITIET where IdHoaDon = ? AND IdChiTietSP = ?";
    final String SQL_DELETE = "update tb_hoadonchitiet set TrangThai = -1 where IdHoaDon = ?";
    final String SQL_DELETEELEMENT = "update tb_hoadonchitiet set TrangThai = -1 where IdHoaDon = ? and IdChiTietSp = ?";
    //final String SQL_UPDATEQR = "update tb_hoadonchitiet set soluong = soluong + 1 where idchitietsp = ? and idhoadon = ?";

    @Override
    public List<HoaDonChiTiet> getAll(UUID idHoaDon) {
        try {
            List<HoaDonChiTiet> lstHoaDonChiTiet = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL, idHoaDon);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                UUID idhd = UUID.fromString(rs.getString("idHoaDon"));
                UUID idCTSP = null;
                if (rs.getString("IdChiTietSP") != null) {
                    idCTSP = UUID.fromString(rs.getString("IdChiTietSP"));
                }
                Integer soLuong = null;
                if (rs.getString("soLuong") != null) {
                    soLuong = Integer.parseInt(rs.getString("soLuong"));
                }

                Double giaBan = null;
                if (rs.getString("donGia") != null) {
                    giaBan = Double.parseDouble(rs.getString("donGia"));
                }

                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(id, idHoaDon, idCTSP, soLuong, giaBan);
                lstHoaDonChiTiet.add(hoaDonChiTiet);
            }
            return lstHoaDonChiTiet;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemSanPhamVaoHoaDonChiTiet(HoaDonChiTiet hdct) {
        int row = 0;
        boolean chk = this.KiemTraSanPham(hdct.getIdHoaDon(), hdct.getIdChiTietSanPham());
        if (chk == false) {
            return this.CapNhatSanPham(hdct);
        }
        row = JDBCHelper.executeUpdate(SQL_INSERT, hdct.getIdHoaDon(), hdct.getIdChiTietSanPham(), hdct.getSoLuong(), hdct.getDonGia());
        return row;
    }

    @Override
    public boolean KiemTraSanPham(UUID idHoaDon, UUID IdChiTietSanPham) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(KIEMTRA, idHoaDon, IdChiTietSanPham);
            while (rs.next()) {
                return false; // đã tồn tại sản phẩm
            }
            return true; // chưa tồn tại sản phẩm
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public int CapNhatSanPham(HoaDonChiTiet hdct) {
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, hdct.getSoLuong(), hdct.getIdChiTietSanPham(), hdct.getIdHoaDon());
        return row;
    }

    @Override
    public int SoLuongSanPhamTrongHoaDon(UUID idHoaDon, UUID idChiTietSanPham) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(SQL_SOLUONG, idHoaDon, idChiTietSanPham);
            while (rs.next()) {
                Integer soLuong = null;
                if (rs.getString("soLuong") != null) {
                    soLuong = Integer.parseInt(rs.getString("soLuong"));
                    return soLuong;
                }
                return 0;
            }
            return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public int XoaToanBoSanPham(UUID idHoaDon) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, idHoaDon);
        return row;
    }

    @Override
    public int XoaMotSanPham(UUID idHoaDon, UUID idChiTietSanPham) {
        int row = JDBCHelper.executeUpdate(SQL_DELETEELEMENT, idHoaDon, idChiTietSanPham);
        return row;
    }

//    @Override
//    public int ThemSanPhamBangQR(HoaDonChiTiet hdct) {
//        int row = 0;
//        boolean chk = this.KiemTraSanPham(hdct.getIdHoaDon(), hdct.getIdChiTietSanPham());
//        if (chk == false) {
//            return JDBCHelper.executeUpdate(SQL_UPDATEQR, hdct.getSoLuong(), hdct.getIdChiTietSanPham(), hdct.getIdHoaDon());
//        }
//        row = JDBCHelper.executeUpdate(SQL_INSERT, hdct.getIdHoaDon(), hdct.getIdChiTietSanPham(), hdct.getSoLuong(), hdct.getDonGia());
//        return row;
//    }
}
