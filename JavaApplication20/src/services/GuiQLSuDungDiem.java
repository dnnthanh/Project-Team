package services;

import java.util.List;
import viewmodels.QLSuDungDiem;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiQLSuDungDiem {

    List<QLSuDungDiem> getAll();

    int TienQuyDiem(double tienHoaDon, int trangThai); // trạng thái 1

    double DiemQuyTien(int soDiemDangCo, int trangThai); // trạng thái -1

    int ThemLichSuSuDungDiem(QLSuDungDiem diem);
}
