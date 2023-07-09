package services;

import domainmodels.QuyDoiDiem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.GuiQuyDoiDiem;
import repositorys.QuyDoiDiemRepository;
import viewmodels.QLQuyDoiDiem;

/**
 *
 * @author Ngọc Thanh
 */
public class QLQuyDoiDiemService implements GuiQLQuyDoiDiem {

    private GuiQuyDoiDiem guiQuyDoiDiem;

    public QLQuyDoiDiemService() {
        this.guiQuyDoiDiem = new QuyDoiDiemRepository();
    }

    @Override
    public List<QLQuyDoiDiem> getAll() {
        List<QuyDoiDiem> lstQuyDoiDiem = this.guiQuyDoiDiem.getAll();
        List<QLQuyDoiDiem> lstDiem = new ArrayList<>();

        for (QuyDoiDiem quyDoiDiem : lstQuyDoiDiem) {
            UUID id = quyDoiDiem.getId();
            int soDiem = quyDoiDiem.getSoDiem();
            double soTien = quyDoiDiem.getSoTien();
            int trangThai = quyDoiDiem.getTrangThai();

            QLQuyDoiDiem diem = new QLQuyDoiDiem(id, soDiem, soTien, trangThai);
            lstDiem.add(diem);
        }
        return lstDiem;
    }

    @Override
    public int ThemQuyDoiDiem(QLQuyDoiDiem diem) {
        UUID id = diem.getId();
        int soDiem = diem.getSoDiem();
        double soTien = diem.getSoTien();
        int trangThai = diem.getTrangThai();
        QuyDoiDiem quyDoiDiem = new QuyDoiDiem(id, soDiem, soTien, trangThai);
        return this.guiQuyDoiDiem.ThemQuyDoiDiem(quyDoiDiem);
    }

    @Override
    public int CapNhatQuyDoiDiem(QLQuyDoiDiem diem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UUID GetId(int trangThai) {
        return this.guiQuyDoiDiem.GetId(trangThai);
    }

}
