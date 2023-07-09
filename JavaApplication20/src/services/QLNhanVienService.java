package services;

import domainmodels.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import repositorys.GuiNhanVien;
import repositorys.NhanVienRepository;
import viewmodels.QLNhanVien;

public class QLNhanVienService implements GuiQLNhanVien {

    private GuiNhanVien guiNhanVien;

    public QLNhanVienService() {
        this.guiNhanVien = new NhanVienRepository();
    }

    @Override
    public List<QLNhanVien> getAll() {
        List<NhanVien> lstNhanVien = this.guiNhanVien.getAll();
        List<QLNhanVien> lstQLNhanVien = new ArrayList<>();
        for (NhanVien nv : lstNhanVien) {
            UUID id = nv.getId();
            String ma = nv.getMa();
            String hoTen = nv.getHoTen();
            String gioiTinh = nv.getGioiTinh();
            Date ngaySinh = nv.getNgaySinh();
            String diaChi = nv.getDiaChi();
            String soDienThoai = nv.getSoDienThoai();
            String matKhau = nv.getMatKhau();
            UUID idChucVu = nv.getIdChucVu();
            String tenChucVu = this.guiNhanVien.GetTenChucVu(idChucVu);
            UUID idCuaHang = nv.getIdCuaHang();
            String tenCuaHang = this.guiNhanVien.GetTenCuaHang(idCuaHang);
            UUID idNguoiQuanLy = nv.getIdNguoiQuanLy();
            int trangThai = nv.getTrangThai();
            QLNhanVien qlnv = new QLNhanVien(id, ma, hoTen, gioiTinh, ngaySinh, diaChi, soDienThoai, matKhau, idChucVu, tenChucVu, idCuaHang, tenCuaHang, idNguoiQuanLy, trangThai);
            lstQLNhanVien.add(qlnv);
        }
        return lstQLNhanVien;
    }

    @Override
    public int ThemQLNhanVien(QLNhanVien qlnv) {
        UUID id = qlnv.getId();
        String ma = qlnv.getMa();
        String hoTen = qlnv.getHoTen();
        String gioiTinh = qlnv.getGioiTinh();
        Date ngaySinh = qlnv.getNgaySinh();
        String diaChi = qlnv.getDiaChi();
        String soDienThoai = qlnv.getSoDienThoai();
        String matKhau = qlnv.getMatKhau();
        UUID idChucVu = qlnv.getIdChucVu();
        UUID idCuaHang = qlnv.getIdCuaHang();
        UUID idNguoiQuanLy = qlnv.getIdNguoiQuanLy();

        NhanVien nhanVien = new NhanVien(id, ma, hoTen, gioiTinh, ngaySinh, diaChi, soDienThoai, matKhau, idChucVu, idCuaHang, idNguoiQuanLy, 1);
        return this.guiNhanVien.ThemNhanVien(nhanVien);
    }

    @Override
    public int XoaQLNhanVien(UUID id) {
        return this.guiNhanVien.XoaNhanVien(id);
    }

    @Override
    public int CapNhatQLNhanVien(QLNhanVien qlnv) {
        UUID id = qlnv.getId();
        String ma = qlnv.getMa();
        String hoTen = qlnv.getHoTen();
        String gioiTinh = qlnv.getGioiTinh();
        Date ngaySinh = qlnv.getNgaySinh();
        String diaChi = qlnv.getDiaChi();
        String soDienThoai = qlnv.getSoDienThoai();
        String matKhau = qlnv.getMatKhau();
        UUID idChucVu = qlnv.getIdChucVu();
        UUID idCuaHang = qlnv.getIdCuaHang();
        UUID idNguoiQuanLy = qlnv.getIdNguoiQuanLy();

        NhanVien nhanVien = new NhanVien(id, ma, hoTen, gioiTinh, ngaySinh, diaChi, soDienThoai, matKhau, idChucVu, idCuaHang, idNguoiQuanLy, 1);
        return this.guiNhanVien.CapNhatNhanVien(nhanVien);
    }

    @Override
    public List<CuaHang> GetAllCuaHang() {
        return this.guiNhanVien.GetAllCuaHang();
    }

    @Override
    public List<ChucVu> GetAllChucVu() {
        return this.guiNhanVien.GetAllChucVu();
    }

    @Override
    public QLNhanVien GetSDTNhanVien(String sdt) {
        NhanVien nv = this.guiNhanVien.GetSDTNhanVien(sdt);
        UUID id = nv.getId();
        String ma = nv.getMa();
        String hoTen = nv.getHoTen();
        String gioiTinh = nv.getGioiTinh();
        Date ngaySinh = nv.getNgaySinh();
        String diaChi = nv.getDiaChi();
        String soDienThoai = nv.getSoDienThoai();
        String matKhau = nv.getMatKhau();
        UUID idChucVu = nv.getIdChucVu();
        String tenChucVu = this.guiNhanVien.GetTenChucVu(idChucVu);
        UUID idCuaHang = nv.getIdCuaHang();
        String tenCuaHang = this.guiNhanVien.GetTenCuaHang(idCuaHang);
        UUID idNguoiQuanLy = nv.getIdNguoiQuanLy();
        int trangThai = nv.getTrangThai();
        QLNhanVien qlnv = new QLNhanVien(id, ma, hoTen, gioiTinh, ngaySinh, diaChi, soDienThoai, matKhau, idChucVu, tenChucVu, idCuaHang, tenCuaHang, idNguoiQuanLy, trangThai);
        return qlnv;
    }
}
