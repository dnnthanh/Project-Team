package repositorys;

import domainmodels.ChiTietSanPham;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class ChiTietSPRepository implements GuiChiTietSanPham {

    private GuiSanPham guiSanPham;
    private GuiChatLieu guiChatLieu;
    private GuiMau guiMau;
    private GuiMauSac guiMauSac;
    private GuiNhaSanXuat guiNhaSanXuat;
    private GuiSize guiSize;
    private GuiPhongCach guiPhongCach;

    public ChiTietSPRepository() {
        this.guiSanPham = new SanPhamRepository();
        this.guiChatLieu = new ChatLieuRepository();
        this.guiMau = new MauRepository();
        this.guiMauSac = new MauSacRepository();
        this.guiNhaSanXuat = new NhaSanXuatRepository();
        this.guiSize = new SizeRepository();
        this.guiPhongCach = new PhongCachRepository();
    }
    final String SQL_ALL = "select *from tb_ChiTietSanPham where TrangThai = 1";
    final String SQL_INSERT = "INSERT INTO [dbo].[tb_ChiTietSanPham]\n"
            + "([IdSanPham],[IdNSX],[IdMauSac],[IdPhongCach],[IdSize],[IdMau],[IdChatLieu],\n"
            + "[HinhAnh],[SoLuong],[GiaNhap],[GiaBan],[MoTa]\n"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    final String SQL_DELETE = "update tb_ChiTietSanPham set trangthai = -1 where id = ?";
    final String SQL_UPDATE = "UPDATE [dbo].[tb_ChiTietSanPham]\n"
            + "SET [IdSanPham]=?,[IdNSX]=?,[IdMauSac]=?,[IdPhongCach]=?,[IdMau]=?,[IdChatLieu]=?,[HinhAnh]=?,[SoLuong]=?,[GiaNhap]=?,\n"
            + "[GiaBan]=?,[MoTa]=?,[TrangThai]=?\n"
            + "WHERE [Id] = ?";

    final String TENSP = "SELECT *FROM tb_ChiTietSanPham where ID = ?";
    final String SOLUONG_UPDATE = "update tb_ChiTietSanPham set SoLuong = SoLuong - ? where Id = ?";
    final String SQL_SOLUONG = "select *from tb_ChiTietSanPham where Id = ?";
    final String CTSPSELECTBYID = "select *from tb_ChiTietSanPham where Id = ?";

    @Override
    public List<ChiTietSanPham> getAll() {
        try {
            List<ChiTietSanPham> lstChiTietSanPham = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id").trim());
                UUID IdSanPham = UUID.fromString(rs.getString("idsanpham").trim());;
                UUID IdNSX = UUID.fromString(rs.getString("idnsx").trim());;
                UUID IdMauSac = UUID.fromString(rs.getString("idmausac").trim());;
                UUID IdPhongCach = UUID.fromString(rs.getString("idphongcach").trim());;
                UUID IdSize = UUID.fromString(rs.getString("idsize").trim());;
                UUID IdMau = UUID.fromString(rs.getString("idmau").trim());;
                UUID IdChatLieu = UUID.fromString(rs.getString("idchatlieu").trim());;
                String HinhAnh = rs.getString("hinhanh").trim();
                int SoLuong = rs.getInt("soluong");
                double GiaNhap = rs.getDouble("gianhap");
                double GiaBan = rs.getDouble("giaban");
                String MoTa = rs.getString("MoTa").trim();
                int TrangThai = rs.getInt("trangthai");

                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(id, IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa, TrangThai);
                lstChiTietSanPham.add(chiTietSanPham);
            }
            return lstChiTietSanPham;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemChiTietSanPham(ChiTietSanPham sp) {
        int row = JDBCHelper.executeUpdate(SQL_INSERT, sp.getIdSanPham(), sp.getIdNSX(), sp.getIdMauSac(), sp.getIdPhongCach(), sp.getIdSize(), sp.getIdMau(), sp.getIdChatLieu(),
                sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan(), sp.getMoTa());
        return row;
    }

    @Override
    public int XoaChiTietSanPham(UUID id) {
        int row = JDBCHelper.executeUpdate(SQL_DELETE, id);
        return row;
    }

    @Override
    public int CapNhatChiTietSanPham(ChiTietSanPham sp) {
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, sp.getIdSanPham(), sp.getIdNSX(), sp.getIdMauSac(), sp.getIdPhongCach(), sp.getIdSize(), sp.getIdMau(), sp.getIdChatLieu(),
                sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan(), sp.getMoTa(), sp.getTrangThai(), sp.getId());
        return row;
    }

    @Override
    public String TenSanPham(UUID idSanPham) {
        return this.guiSanPham.GetTenSanPham(idSanPham);
    }

    @Override
    public String TenNSX(UUID idNhaSanXuat) {
        return this.guiNhaSanXuat.GetTenNSX(idNhaSanXuat);
    }

    @Override
    public String TenMauSac(UUID idMauSac) {
        return this.guiMauSac.GetTenMauSac(idMauSac);
    }

    @Override
    public String TenPhongCach(UUID idPhongCach) {
        return this.guiPhongCach.GetTenPhongCach(idPhongCach);
    }

    @Override
    public String TenSize(UUID idSize) {
        return this.guiSize.GetTenSize(idSize);
    }

    @Override
    public String TenMau(UUID idMau) {
        return this.guiMau.GetTenMau(idMau);
    }

    @Override
    public String TenChatLieu(UUID idChatLieu) {
        return this.guiChatLieu.GetTenChatLieu(idChatLieu);
    }

    @Override
    public String TenSP(UUID idChiTietSanPham) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(TENSP, idChiTietSanPham);
            while (rs.next()) {
                UUID IdSanPham = UUID.fromString(rs.getString("idsanpham").trim());;
                return this.TenSanPham(IdSanPham);
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int UpdateSoLuong(int soLuong, UUID id) {
        int soSanPham = this.GetSoLuong(id);
        if (soLuong > soSanPham) {
            return -1; // quá cho phép
        }
        int row = JDBCHelper.executeUpdate(SOLUONG_UPDATE, soLuong, id);
        return row;
    }

    @Override
    public int GetSoLuong(UUID id) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(SQL_SOLUONG, id);
            while (rs.next()) {
                int SoLuong = rs.getInt("soluong");
                return SoLuong;
            }
            return 0;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<ChiTietSanPham> GetCTSP(String s) {
        try {
            String sql = "select *from tb_ChiTietSanPham as ctsp\n"
                    + "where ctsp.IdSanPham in\n"
                    + "(select sp.Id from tb_SanPham as sp where sp.Ten like '%" + s + "%')";
            List<ChiTietSanPham> lstChiTietSanPham = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id").trim());
                UUID IdSanPham = UUID.fromString(rs.getString("idsanpham").trim());;
                UUID IdNSX = UUID.fromString(rs.getString("idnsx").trim());;
                UUID IdMauSac = UUID.fromString(rs.getString("idmausac").trim());;
                UUID IdPhongCach = UUID.fromString(rs.getString("idphongcach").trim());;
                UUID IdSize = UUID.fromString(rs.getString("idsize").trim());;
                UUID IdMau = UUID.fromString(rs.getString("idmau").trim());;
                UUID IdChatLieu = UUID.fromString(rs.getString("idchatlieu").trim());;
                String HinhAnh = rs.getString("hinhanh").trim();
                int SoLuong = rs.getInt("soluong");
                double GiaNhap = rs.getDouble("gianhap");
                double GiaBan = rs.getDouble("giaban");
                String MoTa = rs.getString("MoTa").trim();
                int TrangThai = rs.getInt("trangthai");

                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(id, IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa, TrangThai);
                lstChiTietSanPham.add(chiTietSanPham);
            }
            return lstChiTietSanPham;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public ChiTietSanPham GetChiTietSanPham(UUID id) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(CTSPSELECTBYID, id);
            while (rs.next()) {
                UUID IdSanPham = UUID.fromString(rs.getString("idsanpham").trim());;
                UUID IdNSX = UUID.fromString(rs.getString("idnsx").trim());;
                UUID IdMauSac = UUID.fromString(rs.getString("idmausac").trim());;
                UUID IdPhongCach = UUID.fromString(rs.getString("idphongcach").trim());;
                UUID IdSize = UUID.fromString(rs.getString("idsize").trim());;
                UUID IdMau = UUID.fromString(rs.getString("idmau").trim());;
                UUID IdChatLieu = UUID.fromString(rs.getString("idchatlieu").trim());;
                String HinhAnh = rs.getString("hinhanh").trim();
                int SoLuong = rs.getInt("soluong");
                double GiaNhap = rs.getDouble("gianhap");
                double GiaBan = rs.getDouble("giaban");
                String MoTa = rs.getString("MoTa").trim();
                int TrangThai = rs.getInt("trangthai");

                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(id, IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa, TrangThai);
                return chiTietSanPham;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
