package repositorys;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilitys.JDBCHelper;

/**
 *
 * @author Ngọc Thanh
 */
public class DoanhThuRepository implements GuiDoanhThu {

    final String SQL_DOANHTHU_TUAN = "select hd.TongTien from  tb_HoaDon as hd\n"
            + "where hd.NgayTao BETWEEN DATEADD(day, -7, GETDATE()) AND GETDATE()\n"
            + "and TrangThai = 1";

    final String SQL_DOANHTHU_NGAY_SANG = "select hd.TongTien from  tb_HoaDon as hd\n"
            + "where convert(int, CONVERT(char(2), getdate(),8)) between 7 and 11.59\n"
            + "and TrangThai = 1 and convert(char(10),hd.NgayTao, 105) = convert(char(10), GETDATE(), 105)";

    final String SQL_DOANHTHU_NGAY_TRUA = "select hd.TongTien from  tb_HoaDon as hd\n"
            + "where convert(int, CONVERT(char(2), getdate(),8)) between 12 and 17.59\n"
            + "and TrangThai = 1 and convert(char(10),hd.NgayTao, 105) = convert(char(10), GETDATE(), 105)";

    final String SQL_DOANHTHU_NGAY_TOI = "select hd.TongTien from  tb_HoaDon as hd\n"
            + "where convert(int, CONVERT(char(2), getdate(),8)) between 18 and 21.59\n"
            + "and TrangThai = 1 and convert(char(10),hd.NgayTao, 105) = convert(char(10), GETDATE(), 105)";

    final String SQL_DOANHTHU_NGAY = "select hd.TongTien from  tb_HoaDon as hd\n"
            + "where convert(char(10), ?, 105) = convert(char(10),hd.NgayTao, 105)\n"
            + "and TrangThai = 1";

    final String SQL_7Ngay = "select *from LayBayNgay()";

    @Override
    public List<Double> GetDoanhThuTrong1Tuan() {
        try {
            ResultSet res = JDBCHelper.executeQuery(SQL_DOANHTHU_TUAN);
            List<Double> lstTong = new ArrayList<>();
            while (res.next()) {
                double tien = res.getDouble("tongTien");
                lstTong.add(tien);
            }
            return lstTong;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public double GetDoanhThuBuoiSang() {
        try {
            ResultSet res = JDBCHelper.executeQuery(SQL_DOANHTHU_NGAY_SANG);
            double tongTien = 0;
            while (res.next()) {
                double tien = res.getDouble("tongTien");
                tongTien += tien;
            }
            return tongTien;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public double GetDoanhThuBuoiTrua() {
        try {
            ResultSet res = JDBCHelper.executeQuery(SQL_DOANHTHU_NGAY_TRUA);
            double tongTien = 0;
            while (res.next()) {
                double tien = res.getDouble("tongTien");
                tongTien += tien;
            }
            return tongTien;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public double GetDoanhThuBuoiToi() {
        try {
            ResultSet res = JDBCHelper.executeQuery(SQL_DOANHTHU_NGAY_TOI);
            double tongTien = 0;
            while (res.next()) {
                double tien = res.getDouble("tongTien");
                tongTien += tien;
            }
            return tongTien;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public double GetDoanhThu1Ngay(String s) {
        try {
            ResultSet res = JDBCHelper.executeQuery(SQL_DOANHTHU_NGAY, s);
            double tongTien = 0;
            while (res.next()) {
                double tien = res.getDouble("tongTien");
                tongTien += tien;
            }
            return tongTien;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<String> Lay7NgayTruocDo() {
        try {
            ResultSet res = JDBCHelper.executeQuery(SQL_7Ngay);
            List<String> lstNgay = new ArrayList<>();
            while (res.next()) {
                String ngay = res.getString("Ngay1");
                lstNgay.add(ngay);
                ngay = res.getString("Ngay2");
                lstNgay.add(ngay);
                ngay = res.getString("Ngay3");
                lstNgay.add(ngay);
                ngay = res.getString("Ngay4");
                lstNgay.add(ngay);
                ngay = res.getString("Ngay5");
                lstNgay.add(ngay);
                ngay = res.getString("Ngay6");
                lstNgay.add(ngay);
                ngay = res.getString("Ngay7");
                lstNgay.add(ngay);
            }
            return lstNgay;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

//    public static void main(String[] args) {
//        DoanhThuRepository dt = new DoanhThuRepository();
//        List<String> lst = dt.Lay7NgayTruocDo();
//        for (String string : lst) {
//            System.out.println(string);
//        }
//    }
}
