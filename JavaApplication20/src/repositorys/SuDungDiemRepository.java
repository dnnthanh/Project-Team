package repositorys;

import domainmodels.QuyDoiDiem;
import domainmodels.SuDungDiem;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class SuDungDiemRepository implements GuiSuDungDiem {

    final String SQL_ALL = "select *from tb_SuDungDiem";
    private GuiQuyDoiDiem guiQuyDoi;
    final String SQL_THEM = "insert into tb_SuDungDiem (IdQuyDoiDiem, IdHoaDon, IdDiem, SoDiem, TrangThai)\n"
            + "values (?,?,?,?,?)";

    public SuDungDiemRepository() {
        this.guiQuyDoi = new QuyDoiDiemRepository();
    }

    @Override
    public List<SuDungDiem> getAll() {
        try {
            List<SuDungDiem> lstSuDungDiem = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                UUID idHoaDon = UUID.fromString(rs.getString("idHoaDon"));
                UUID idQuyDoiDiem = UUID.fromString(rs.getString("idQuyDoiDiem"));
                UUID idDiem = UUID.fromString(rs.getString("idDiem"));
                int soDiem = rs.getInt("soDiem");
                int trangThai = rs.getInt("trangThai");

                SuDungDiem suDungDiem = new SuDungDiem(id, idQuyDoiDiem, idHoaDon, idDiem, soDiem, trangThai);
                lstSuDungDiem.add(suDungDiem);
            }
            return lstSuDungDiem;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    // Tiền quy ra điểm
    @Override
    public int TienQuyDiem(double tienHoaDon, int trangThai) {
        QuyDoiDiem quyDoiDiem = this.guiQuyDoi.GetQuyDoiDiem(trangThai);

        double soTien = quyDoiDiem.getSoTien();
        int soDiem = quyDoiDiem.getSoDiem();

        int soDiemCong = (int) (tienHoaDon * soDiem / soTien);
        return soDiemCong;
    }

    // Điểm quy tiền
    @Override
    public double DiemQuyTien (int soDiemDangCo, int trangThai) {
        QuyDoiDiem quyDoiDiem = this.guiQuyDoi.GetQuyDoiDiem(trangThai);

        double soTien = quyDoiDiem.getSoTien();
        int soDiem = quyDoiDiem.getSoDiem();

        double soTienTru = (int) (soDiemDangCo * soTien / soDiem);
        return soTienTru;
    }

    @Override
    public int ThemLichSuSuDung(SuDungDiem suDungDiem) {
        int row = JDBCHelper.executeUpdate(SQL_THEM, suDungDiem.getIdQuyDoiDiem(), suDungDiem.getIdHoaDon(), suDungDiem.getIdDiem(), suDungDiem.getSoDiem(), suDungDiem.getTrangThai());
        return row;
    }

}
