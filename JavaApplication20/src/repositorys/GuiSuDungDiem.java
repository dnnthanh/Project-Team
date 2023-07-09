package repositorys;

import domainmodels.QuyDoiDiem;
import domainmodels.SuDungDiem;
import java.util.List;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiSuDungDiem {

    List<SuDungDiem> getAll();

    int TienQuyDiem(double tienHoaDon, int trangThai); // trạng thái 1

    double DiemQuyTien(int soDiemDangCo, int trangThai); // trạng thái -1

    int ThemLichSuSuDung(SuDungDiem suDungDiem);
}
