package repositorys;

import java.util.List;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiDoanhThu {

    //List<Double> GetDoanhThuTrongNgay();

    double GetDoanhThuBuoiSang();

    double GetDoanhThuBuoiTrua();

    double GetDoanhThuBuoiToi();

    List<Double> GetDoanhThuTrong1Tuan();
    
    double GetDoanhThu1Ngay(String s);
    
    List<String> Lay7NgayTruocDo();

}
