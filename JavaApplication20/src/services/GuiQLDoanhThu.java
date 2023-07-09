package services;

import java.util.List;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiQLDoanhThu {

    List<Double> GetDoanhThuTrong1Tuan();

    double GetDoanhThuBuoiSang();

    double GetDoanhThuBuoiTrua();

    double GetDoanhThuBuoiToi();

    double GetDoanhThu1Ngay(String s);

    List<String> Lay7NgayTruocDo();
}
