/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.List;
import repositorys.DoanhThuRepository;
import repositorys.GuiDoanhThu;

/**
 *
 * @author Ngọc Thanh
 */
public class QLDoanhThuService implements GuiQLDoanhThu {

    private GuiDoanhThu guiDoanhThu;

    public QLDoanhThuService() {
        this.guiDoanhThu = new DoanhThuRepository();
    }

    
    
//    @Override
//    public List<Double> GetDoanhThuTrongNgay() {
//        return this.guiDoanhThu.GetDoanhThuTrongNgay();
//    }
    @Override
    public List<Double> GetDoanhThuTrong1Tuan() {
        return this.guiDoanhThu.GetDoanhThuTrong1Tuan();
    }

    @Override
    public double GetDoanhThuBuoiSang() {
        return this.guiDoanhThu.GetDoanhThuBuoiSang();
    }

    @Override
    public double GetDoanhThuBuoiTrua() {
        return this.guiDoanhThu.GetDoanhThuBuoiTrua();
    }

    @Override
    public double GetDoanhThuBuoiToi() {
        return this.guiDoanhThu.GetDoanhThuBuoiToi();
    }

    @Override
    public double GetDoanhThu1Ngay(String s) {
        return this.guiDoanhThu.GetDoanhThu1Ngay(s);
    }

    @Override
    public List<String> Lay7NgayTruocDo() {
        return this.guiDoanhThu.Lay7NgayTruocDo();
    }

}
