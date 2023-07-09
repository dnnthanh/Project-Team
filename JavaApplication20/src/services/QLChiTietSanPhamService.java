package services;

import domainmodels.ChiTietSanPham;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.ChiTietSPRepository;
import repositorys.GuiChiTietSanPham;
import viewmodels.QLChiTietSanPham;

public class QLChiTietSanPhamService implements GuiQLChiTietSanPham {

    private GuiChiTietSanPham guiChiTietSanPham;

    public QLChiTietSanPhamService() {
        this.guiChiTietSanPham = new ChiTietSPRepository();
    }

    @Override
    public List<QLChiTietSanPham> getAll() {
        List<ChiTietSanPham> lstChiTietSanPham = this.guiChiTietSanPham.getAll();
        List<QLChiTietSanPham> lstQLChiTietSanPham = new ArrayList<>();

        for (ChiTietSanPham ctsp : lstChiTietSanPham) {
            UUID Id = ctsp.getId();
            UUID IdSanPham = ctsp.getIdSanPham();
            String tenSanPham = this.guiChiTietSanPham.TenSanPham(IdSanPham);
            UUID IdNSX = ctsp.getIdNSX();
            String tenNSX = this.guiChiTietSanPham.TenNSX(IdNSX);
            UUID IdMauSac = ctsp.getIdMauSac();
            String tenMauSac = this.guiChiTietSanPham.TenMauSac(IdMauSac);
            UUID IdPhongCach = ctsp.getIdPhongCach();
            String tenPhongCach = this.guiChiTietSanPham.TenPhongCach(IdPhongCach);
            UUID IdSize = ctsp.getIdSize();
            String tenSize = this.guiChiTietSanPham.TenSize(IdSize);
            UUID IdMau = ctsp.getIdMau();
            String tenMau = this.guiChiTietSanPham.TenMau(IdMau);
            UUID IdChatLieu = ctsp.getIdChatLieu();
            String tenChatLieu = this.guiChiTietSanPham.TenChatLieu(IdChatLieu);
            String HinhAnh = ctsp.getHinhAnh();
            int SoLuong = ctsp.getSoLuong();
            double GiaNhap = ctsp.getGiaNhap();
            double GiaBan = ctsp.getGiaBan();
            String MoTa = ctsp.getMoTa();

            QLChiTietSanPham qlctsp = new QLChiTietSanPham(Id, IdSanPham, tenSanPham, IdNSX, tenNSX, IdMauSac, tenMauSac, IdPhongCach, tenPhongCach, IdSize, tenSize, IdMau, tenMau, IdChatLieu, tenChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa);
            lstQLChiTietSanPham.add(qlctsp);
        }
        return lstQLChiTietSanPham;
    }

//    @Override
//    public int ThemQLChiTietSanPham(QLChiTietSanPham qLChiTietSanPham) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public int XoaQLChiTietSanPham(QLChiTietSanPham qLChiTietSanPham) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public int SuaQlChiTietSanPham(QLChiTietSanPham qLChiTietSanPham) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    @Override
    public int UpdateSoLuong(int soLuong, UUID id) {
        return this.guiChiTietSanPham.UpdateSoLuong(soLuong, id);
    }

    @Override
    public List<QLChiTietSanPham> getCTSP(String s) {
        List<ChiTietSanPham> lstChiTietSanPham = this.guiChiTietSanPham.GetCTSP(s);
        List<QLChiTietSanPham> lstQLChiTietSanPham = new ArrayList<>();

        for (ChiTietSanPham ctsp : lstChiTietSanPham) {
            UUID Id = ctsp.getId();
            UUID IdSanPham = ctsp.getIdSanPham();
            String tenSanPham = this.guiChiTietSanPham.TenSanPham(IdSanPham);
            UUID IdNSX = ctsp.getIdNSX();
            String tenNSX = this.guiChiTietSanPham.TenNSX(IdNSX);
            UUID IdMauSac = ctsp.getIdMauSac();
            String tenMauSac = this.guiChiTietSanPham.TenMauSac(IdMauSac);
            UUID IdPhongCach = ctsp.getIdPhongCach();
            String tenPhongCach = this.guiChiTietSanPham.TenPhongCach(IdPhongCach);
            UUID IdSize = ctsp.getIdSize();
            String tenSize = this.guiChiTietSanPham.TenSize(IdSize);
            UUID IdMau = ctsp.getIdMau();
            String tenMau = this.guiChiTietSanPham.TenMau(IdMau);
            UUID IdChatLieu = ctsp.getIdChatLieu();
            String tenChatLieu = this.guiChiTietSanPham.TenChatLieu(IdChatLieu);
            String HinhAnh = ctsp.getHinhAnh();
            int SoLuong = ctsp.getSoLuong();
            double GiaNhap = ctsp.getGiaNhap();
            double GiaBan = ctsp.getGiaBan();
            String MoTa = ctsp.getMoTa();

            QLChiTietSanPham qlctsp = new QLChiTietSanPham(Id, IdSanPham, tenSanPham, IdNSX, tenNSX, IdMauSac, tenMauSac, IdPhongCach, tenPhongCach, IdSize, tenSize, IdMau, tenMau, IdChatLieu, tenChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa);
            lstQLChiTietSanPham.add(qlctsp);
        }
        return lstQLChiTietSanPham;
    }

    @Override
    public QLChiTietSanPham GetQLChiTietSanPham(UUID id) {
        ChiTietSanPham ctsp = this.guiChiTietSanPham.GetChiTietSanPham(id);
        UUID Id = ctsp.getId();
        UUID IdSanPham = ctsp.getIdSanPham();
        String tenSanPham = this.guiChiTietSanPham.TenSanPham(IdSanPham);
        UUID IdNSX = ctsp.getIdNSX();
        String tenNSX = this.guiChiTietSanPham.TenNSX(IdNSX);
        UUID IdMauSac = ctsp.getIdMauSac();
        String tenMauSac = this.guiChiTietSanPham.TenMauSac(IdMauSac);
        UUID IdPhongCach = ctsp.getIdPhongCach();
        String tenPhongCach = this.guiChiTietSanPham.TenPhongCach(IdPhongCach);
        UUID IdSize = ctsp.getIdSize();
        String tenSize = this.guiChiTietSanPham.TenSize(IdSize);
        UUID IdMau = ctsp.getIdMau();
        String tenMau = this.guiChiTietSanPham.TenMau(IdMau);
        UUID IdChatLieu = ctsp.getIdChatLieu();
        String tenChatLieu = this.guiChiTietSanPham.TenChatLieu(IdChatLieu);
        String HinhAnh = ctsp.getHinhAnh();
        int SoLuong = ctsp.getSoLuong();
        double GiaNhap = ctsp.getGiaNhap();
        double GiaBan = ctsp.getGiaBan();
        String MoTa = ctsp.getMoTa();

        QLChiTietSanPham qlctsp = new QLChiTietSanPham(Id, IdSanPham, tenSanPham, IdNSX, tenNSX, IdMauSac, tenMauSac, IdPhongCach, tenPhongCach, IdSize, tenSize, IdMau, tenMau, IdChatLieu, tenChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa);
        return qlctsp;
    }

    @Override
    public String TenSP(UUID id) {
        return this.guiChiTietSanPham.TenSP(id);
    }
}
