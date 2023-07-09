package repositorys;

import domainmodels.DiemKhachHang;
import java.util.UUID;
import utilitys.JDBCHelper;
import java.sql.ResultSet;

/**
 *
 * @author Ngọc Thanh
 */
public class DiemKhachHangRepository implements GuiDiemKhachHang {

    final String SQL_UPDATE = "update tb_diem set SoDiemDangCo = ? where IdKhachHang = ?";
    final String SODIEM = "select *from tb_diem where idKhachHang = ?";
    final String DIEMSELECTBYIDKH = "select *from tb_diem where idKhachHang = ?";
    final String SQL_THEM = "insert into tb_diem (IDkhachhang) values (?)";

    @Override
    public int CapNhatDiem(DiemKhachHang diemKhachHang) {
        int row = JDBCHelper.executeUpdate(SQL_UPDATE, diemKhachHang.getSoDiemDangCo(), diemKhachHang.getIdKhachHang());
        return row;
    }

    @Override
    public int SoDiemHienTai(UUID idKhachHang) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(SODIEM, idKhachHang);
            while (rs.next()) {
                int soDiemDangCo = rs.getInt("soDiemDangCo");
                return soDiemDangCo;
            }
            return 0;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public DiemKhachHang GetDiem(UUID idKhachHang) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(DIEMSELECTBYIDKH, idKhachHang);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                int soDiem = rs.getInt("soDiemDangCo");
                int trangThai = rs.getInt("trangThai");

                DiemKhachHang diemKhachHang = new DiemKhachHang(id, idKhachHang, soDiem, trangThai);
                return diemKhachHang;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemDiemKhachHangMoi(DiemKhachHang diemKhachHang) {
        int row = JDBCHelper.executeUpdate(SQL_THEM, diemKhachHang.getIdKhachHang());
        return row;
    }
}
