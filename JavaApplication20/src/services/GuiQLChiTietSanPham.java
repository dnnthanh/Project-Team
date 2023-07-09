package services;

import java.util.List;
import java.util.UUID;
import viewmodels.QLChiTietSanPham;

public interface GuiQLChiTietSanPham {

    List<QLChiTietSanPham> getAll();

//    int ThemQLChiTietSanPham(QLChiTietSanPham qLChiTietSanPham);
//
//    int XoaQLChiTietSanPham(QLChiTietSanPham qLChiTietSanPham);
//
//    int SuaQlChiTietSanPham(QLChiTietSanPham qLChiTietSanPham);
    int UpdateSoLuong(int soLuong, UUID id);

    List<QLChiTietSanPham> getCTSP(String s);
    
    QLChiTietSanPham GetQLChiTietSanPham (UUID id);
    
    String TenSP(UUID id);
}
