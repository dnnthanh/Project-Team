package services;

import domainmodels.DiemKhachHang;
import domainmodels.KhachHang;
import java.util.UUID;
import repositorys.DiemKhachHangRepository;
import repositorys.GuiDiemKhachHang;
import repositorys.GuiKhachHang;
import repositorys.KhachHangRepository;
import viewmodels.QLDiemKhachHang;

/**
 *
 * @author Ngọc Thanh
 */
public class QLDiemKhachHangService implements GuiQLDiemKhachHang {

    private GuiDiemKhachHang guiDiemKhachHang;

    public QLDiemKhachHangService() {
        this.guiDiemKhachHang = new DiemKhachHangRepository();
    }

    @Override
    public int CapNhatDiem(QLDiemKhachHang diemKhachHang) {
        UUID id = diemKhachHang.getId();
        UUID idKhacHang = diemKhachHang.getIdKhachHang();
        int soDiem = diemKhachHang.getSoDiem();
        int trangThai = 1;
        DiemKhachHang dkh = new DiemKhachHang(id, idKhacHang, soDiem, trangThai);
        return this.guiDiemKhachHang.CapNhatDiem(dkh);
    }

    @Override
    public int SoDiemHienTai(UUID idKhachHang) {
        return this.guiDiemKhachHang.SoDiemHienTai(idKhachHang);
    }

    @Override
    public QLDiemKhachHang GetDiem(UUID idKhachHang) {
        DiemKhachHang diemKhachHang = this.guiDiemKhachHang.GetDiem(idKhachHang);

        UUID id = diemKhachHang.getId();
        int soDiem = diemKhachHang.getSoDiemDangCo();
        QLDiemKhachHang qldkh = new QLDiemKhachHang(id, idKhachHang, soDiem);
        return qldkh;
    }

    @Override
    public int ThemDiemKhachHangMoi(QLDiemKhachHang diemKhachHang) {
        UUID id = diemKhachHang.getId();
        UUID idKhacHang = diemKhachHang.getIdKhachHang();
        int soDiem = diemKhachHang.getSoDiem();
        int trangThai = 1;
        DiemKhachHang dkh = new DiemKhachHang(id, idKhacHang, soDiem, trangThai);
        return this.guiDiemKhachHang.ThemDiemKhachHangMoi(dkh);
    }

}
