package repositorys;

import domainmodels.QuyDoiDiem;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class QuyDoiDiemRepository implements GuiQuyDoiDiem {

    final String SQL_ALL = "select *from tb_QuyDoiDiem";
    final String SQL_THEM = "insert into tb_QuyDoiDiem (SoDiemCanQuyDoi, SoTienQuyRa, trangthai) values (?,?,?)";
    final String SQL_CAPNHAT = "update tb_QuyDoiDiem set SoDiemCanQuyDoi = ?, SoTienQuyRa = ?, trangThai = ? where Id = ?";
    final String ID_TRANGTHAI = "select *from tb_quydoidiem where trangthai = ?";
    final String SELECTBYTRANGTHAI = "select *from tb_quydoidiem where trangthai = ?";

    @Override
    public List<QuyDoiDiem> getAll() {
        try {
            List<QuyDoiDiem> lstQuyDoiDiem = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SQL_ALL);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                int soDiem = rs.getInt("soDiemCanQuyDoi");
                double soTien = rs.getDouble("soTienQuyRa");
                int trangThai = rs.getInt("trangThai");

                QuyDoiDiem quyDoiDiem = new QuyDoiDiem(id, soDiem, soTien, trangThai);
                lstQuyDoiDiem.add(quyDoiDiem);
            }
            return lstQuyDoiDiem;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public int ThemQuyDoiDiem(QuyDoiDiem quyDoiDiem) {
        int row = JDBCHelper.executeUpdate(SQL_THEM, quyDoiDiem.getSoDiem(), quyDoiDiem.getSoTien(), quyDoiDiem.getTrangThai());
        return row;
    }

    @Override
    public int CapNhatQuyDoiDiem(QuyDoiDiem quyDoiDiem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UUID GetId(int trangThai) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(ID_TRANGTHAI, trangThai);
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id").trim());
                return id;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public QuyDoiDiem GetQuyDoiDiem(int trangThai) {
        try {
            List<QuyDoiDiem> lstQuyDoiDiem = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(SELECTBYTRANGTHAI, trangThai);

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("Id").trim());
                int soDiem = rs.getInt("soDiemCanQuyDoi");
                double soTien = rs.getDouble("soTienQuyRa");

                QuyDoiDiem quyDoiDiem = new QuyDoiDiem(id, soDiem, soTien, trangThai);
                return quyDoiDiem;
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
