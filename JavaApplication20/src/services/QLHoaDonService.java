package services;

import domainmodels.HoaDon;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import repositorys.GuiHoaDon;
import repositorys.GuiKhachHang;
import repositorys.GuiNhanVien;
import repositorys.HoaDonRepository;
import repositorys.KhachHangRepository;
import repositorys.NhanVienRepository;
import viewmodels.QLHoaDon;
import viewmodels.QLHoaDonChiTiet;

/**
 *
 * @author Ngọc Thanh
 */
public class QLHoaDonService implements GuiQLHoaDon {

    private GuiHoaDon guiHoaDon;
    private GuiNhanVien guiNhanVien;
    private GuiKhachHang guiKhachHang;

    public QLHoaDonService() {
        this.guiHoaDon = new HoaDonRepository();
        this.guiNhanVien = new NhanVienRepository();
        this.guiKhachHang = new KhachHangRepository();
    }

    @Override
    public List<QLHoaDon> getAll(int trangThaiHoaDon, UUID idNhanVien) {
        List<HoaDon> lstHoaDon = this.guiHoaDon.getAll(trangThaiHoaDon, idNhanVien);
        List<QLHoaDon> lstQLHoaDon = new ArrayList<>();
        for (HoaDon hd : lstHoaDon) {
            try {
                UUID Id = hd.getId();
                String Ma = hd.getMa();
                String Ten = hd.getTen();
                UUID IdKhachHang = hd.getIdKhachHang();
                String tenKhachHang = "Khách lẻ";
                if (IdKhachHang != null) {
                    tenKhachHang = this.guiKhachHang.GetTenKhachHang(IdKhachHang);
                }
                UUID IdNhanVien = null;
                if (hd.getIdNhanVien() != null) {
                    IdNhanVien = hd.getIdNhanVien();
                }
                String tenNhanVien = "Không có";
                if (IdNhanVien != null) {
                    tenNhanVien = this.guiNhanVien.GetTenNhanVien(IdNhanVien);
                }
                UUID IdGiaoDich = hd.getIdGiaoDich();
                String NgayTao = hd.getNgayTao();
                String NgayThanhToan = hd.getNgayThanhToan();
                Integer SoDiemTieu = hd.getSoDiemTieu();
                Double TongTien = hd.getTongTien();
                Integer KieuBan = hd.getKieuBan();
                String hoTen = hd.getHoTen();
                String soDienThoai = hd.getSoDienThoai();
                String diaChi = hd.getDiaChi();
                Date ngayNhanHangMongMuon = hd.getNgayNhanHangMongMuon();
                Date ngayBatDauGiao = hd.getNgayBatDauGiao();
                Date ngayNhanHangThanhCong = hd.getNgayNhanHangThanhCong();
                String moTa = hd.getMoTa();
                double soTienChuyenKhoan = hd.getSoTienChuyenKhoan();
                int trangThai = hd.getTrangThai();
                double soTienKhachDua = hd.getSoTienKhachDua();
                double phiShip = hd.getPhiShip();
                QLHoaDon qlhd = new QLHoaDon(Id, Ma, Ten, IdKhachHang, tenKhachHang, IdNhanVien, tenNhanVien, IdGiaoDich, NgayTao, NgayThanhToan, SoDiemTieu, TongTien, KieuBan, hoTen, soDienThoai, diaChi, ngayNhanHangMongMuon, ngayBatDauGiao, ngayNhanHangThanhCong, moTa, soTienChuyenKhoan, trangThai, soTienKhachDua, phiShip);
                lstQLHoaDon.add(qlhd);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lstQLHoaDon;
    }

    @Override
    public int ThemQLHoaDon(QLHoaDon qlhd) {
        UUID id = qlhd.getId();
        String ma = qlhd.getMa();
        String ten = qlhd.getTen();
        UUID idKhachHang = qlhd.getIdKhachHang();
        UUID idNhanVien = qlhd.getIdNhanVien();
        UUID idGiaoDich = qlhd.getIdGiaoDich();
        String ngayTao = qlhd.getNgayTao();
        String ngayThanhToan = qlhd.getNgayThanhToan();
        Integer soDiemTieu = qlhd.getSoDiemTieu();
        Double tongTien = qlhd.getTongTien();
        Integer kieuBan = qlhd.getKieuBan();
        String hoTen = qlhd.getHoTen();
        String soDienThoai = qlhd.getSoDienThoai();
        String diachi = qlhd.getDiaChi();
        Date ngayNhanHangMongMuon = qlhd.getNgayNhanHangMongMuon();
        Date ngayBatDauGiaoHang = qlhd.getNgayBatDauGiao();
        Date ngayNhanHangThanhCong = qlhd.getNgayNhanHangThanhCong();
        String moTa = qlhd.getMoTa();
        int trangThai = 0;
        double soTienChuyenKhoan = qlhd.getSoTienChuyenKhoan();
        double soTienKhachDua = qlhd.getSoTienKhachDua();
        double phiShip = qlhd.getPhiShip();
        HoaDon hoaDon = new HoaDon(id, ma, ten, idKhachHang, idNhanVien, idGiaoDich, ngayTao, ngayThanhToan, soDiemTieu, tongTien, kieuBan, hoTen, soDienThoai, diachi, ngayNhanHangMongMuon, ngayBatDauGiaoHang, ngayNhanHangThanhCong, moTa, trangThai, soTienChuyenKhoan, soTienKhachDua, phiShip);
        return this.guiHoaDon.ThemHoaDon(hoaDon);
    }

    @Override
    public int XoaQLHoaDon(UUID idHoaDon) {
        return this.guiHoaDon.XoaHoaDon(idHoaDon);
    }

    @Override
    public int CapNhatHoaDon(QLHoaDon qlhd) {
        UUID id = qlhd.getId();
        String ma = qlhd.getMa();
        String ten = qlhd.getTen();
        UUID idKhachHang = qlhd.getIdKhachHang();
        UUID idNhanVien = qlhd.getIdNhanVien();
        UUID idGiaoDich = qlhd.getIdGiaoDich();
        String ngayTao = null;
        String ngayThanhToan = qlhd.getNgayThanhToan();
        Integer soDiemTieu = qlhd.getSoDiemTieu();
        Double tongTien = qlhd.getTongTien();
        Integer kieuBan = qlhd.getKieuBan();
        String hoTen = qlhd.getHoTen();
        String soDienThoai = qlhd.getSoDienThoai();
        String diachi = qlhd.getDiaChi();
        Date ngayNhanHangMongMuon = qlhd.getNgayNhanHangMongMuon();
        Date ngayBatDauGiaoHang = qlhd.getNgayBatDauGiao();
        Date ngayNhanHangThanhCong = qlhd.getNgayNhanHangThanhCong();
        String moTa = qlhd.getMoTa();
        int trangThai = qlhd.getTrangThai();
        double soTienChuyenKhoan = qlhd.getSoTienChuyenKhoan();
        double soTienKhachDua = qlhd.getSoTienKhachDua();
        double phiShip = qlhd.getPhiShip();
        HoaDon hoaDon = new HoaDon(id, ma, ten, idKhachHang, idNhanVien, idGiaoDich, ngayTao, ngayThanhToan, soDiemTieu, tongTien, kieuBan, hoTen, soDienThoai, diachi, ngayNhanHangMongMuon, ngayBatDauGiaoHang, ngayNhanHangThanhCong, moTa, trangThai, soTienChuyenKhoan, soTienKhachDua, phiShip);
        return this.guiHoaDon.CapNhatHoaDon(hoaDon);
    }

    @Override
    public List<QLHoaDon> getAll(UUID idNhanVien) {
        List<HoaDon> lstHoaDon = this.guiHoaDon.getAll(idNhanVien);
        List<QLHoaDon> lstQLHoaDon = new ArrayList<>();
        for (HoaDon hd : lstHoaDon) {
            try {
                UUID Id = hd.getId();
                String Ma = hd.getMa();
                String Ten = hd.getTen();
                UUID IdKhachHang = hd.getIdKhachHang();
                String tenKhachHang = "Khách lẻ";
                if (IdKhachHang != null) {
                    tenKhachHang = this.guiKhachHang.GetTenKhachHang(IdKhachHang);
                }
                UUID IdNhanVien = null;
                if (hd.getIdNhanVien() != null) {
                    IdNhanVien = hd.getIdNhanVien();
                }
                String tenNhanVien = "Không có";
                if (IdNhanVien != null) {
                    tenNhanVien = this.guiNhanVien.GetTenNhanVien(IdNhanVien);
                }
                UUID IdGiaoDich = hd.getIdGiaoDich();
                String NgayTao = hd.getNgayTao();
                String NgayThanhToan = hd.getNgayThanhToan();
                Integer SoDiemTieu = hd.getSoDiemTieu();
                Double TongTien = hd.getTongTien();
                Integer KieuBan = hd.getKieuBan();
                String hoTen = hd.getHoTen();
                String soDienThoai = hd.getSoDienThoai();
                String diaChi = hd.getDiaChi();
                Date ngayNhanHangMongMuon = hd.getNgayNhanHangMongMuon();
                Date ngayBatDauGiao = hd.getNgayBatDauGiao();
                Date ngayNhanHangThanhCong = hd.getNgayNhanHangThanhCong();
                String moTa = hd.getMoTa();
                double soTienChuyenKhoan = hd.getSoTienChuyenKhoan();
                int trangThai = hd.getTrangThai();
                double soTienKhachDua = hd.getSoTienKhachDua();
                double phiShip = hd.getPhiShip();
                QLHoaDon qlhd = new QLHoaDon(Id, Ma, Ten, IdKhachHang, tenKhachHang, IdNhanVien, tenNhanVien, IdGiaoDich, NgayTao, NgayThanhToan, SoDiemTieu, TongTien, KieuBan, hoTen, soDienThoai, diaChi, ngayNhanHangMongMuon, ngayBatDauGiao, ngayNhanHangThanhCong, moTa, soTienChuyenKhoan, trangThai, soTienKhachDua, phiShip);
                lstQLHoaDon.add(qlhd);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lstQLHoaDon;
    }

    @Override
    public QLHoaDon GetHoaDon(UUID id) {
        HoaDon hd = this.guiHoaDon.GetHoaDon(id);
        UUID Id = hd.getId();
        String Ma = hd.getMa();
        String Ten = hd.getTen();
        UUID IdKhachHang = hd.getIdKhachHang();
        String tenKhachHang = "Khách lẻ";
        if (IdKhachHang != null) {
            tenKhachHang = this.guiKhachHang.GetTenKhachHang(IdKhachHang);
        }
        UUID IdNhanVien = null;
        if (hd.getIdNhanVien() != null) {
            IdNhanVien = hd.getIdNhanVien();
        }
        String tenNhanVien = "Không có";
        if (IdNhanVien != null) {
            tenNhanVien = this.guiNhanVien.GetTenNhanVien(IdNhanVien);
        }
        UUID IdGiaoDich = hd.getIdGiaoDich();
        String NgayTao = hd.getNgayTao();
        String NgayThanhToan = hd.getNgayThanhToan();
        Integer SoDiemTieu = hd.getSoDiemTieu();
        Double TongTien = hd.getTongTien();
        Integer KieuBan = hd.getKieuBan();
        String hoTen = hd.getHoTen();
        String soDienThoai = hd.getSoDienThoai();
        String diaChi = hd.getDiaChi();
        Date ngayNhanHangMongMuon = hd.getNgayNhanHangMongMuon();
        Date ngayBatDauGiao = hd.getNgayBatDauGiao();
        Date ngayNhanHangThanhCong = hd.getNgayNhanHangThanhCong();
        String moTa = hd.getMoTa();
        double soTienChuyenKhoan = hd.getSoTienChuyenKhoan();
        int trangThai = hd.getTrangThai();
        double soTienKhachDua = hd.getSoTienKhachDua();
        double phiShip = hd.getPhiShip();
        QLHoaDon qlhd = new QLHoaDon(Id, Ma, Ten, IdKhachHang, tenKhachHang, IdNhanVien, tenNhanVien, IdGiaoDich, NgayTao, NgayThanhToan, SoDiemTieu, TongTien, KieuBan, hoTen, soDienThoai, diaChi, ngayNhanHangMongMuon, ngayBatDauGiao, ngayNhanHangThanhCong, moTa, soTienChuyenKhoan, trangThai, soTienKhachDua, phiShip);
        return qlhd;
    }

//    public static void main(String[] args) {
//        QLHoaDonService qlhd = new QLHoaDonService();
//        UUID idNhanVien = UUID.fromString("B4F86210-EA85-4931-9979-8F9A42983DCA");
//        List<QLHoaDon> lst = qlhd.getAll(idNhanVien);
//        for (QLHoaDon qLHoaDon : lst) {
//            System.out.println(qLHoaDon.getSoTienKhachDua());
//        }
//    }
}
