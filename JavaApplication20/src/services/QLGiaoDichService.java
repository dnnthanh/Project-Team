package services;

import java.util.List;
import java.util.UUID;
import repositorys.GiaoDichRepository;
import repositorys.GuiGiaoDich;
import viewmodels.QLGiaoDich;

/**
 *
 * @author Ngọc Thanh
 */
public class QLGiaoDichService implements GuiQLGiaoDich {

    private GuiGiaoDich guiGiaoDich;

    public QLGiaoDichService() {
        this.guiGiaoDich = new GiaoDichRepository();
    }
    
    
    @Override
    public List<QLGiaoDich> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int ThemQLGiaoDich(QLGiaoDich qlgd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int XoaQLGiaoDich(UUID idGiaoDich) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int CapNhatQLGiaoDich(QLGiaoDich qlgd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UUID GetId(String ten) {
        return this.guiGiaoDich.GetId(ten);
    }

    @Override
    public String GetTen(UUID id) {
        return this.guiGiaoDich.tenGiaoDich(id);
    }

}
