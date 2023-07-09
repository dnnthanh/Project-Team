create database Application_Nhom6
go 

use Application_Nhom6
go

select *from tb_nhanvien

------------- Bảng Size -------------
create table tb_Size
(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	Ma CHAR(20) not null UNIQUE,
	Ten NVARCHAR(MAX) not null ,
	TrangThai int null default 1,
);

alter table tb_Size
add constraint PK_Size
primary key(ID)

------------- Bảng NSX -------------
create table tb_NSX
(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	Ma CHAR(20) not null UNIQUE,
	Ten NVARCHAR(MAX) not null ,
	TrangThai int null default 1,
);

alter table tb_NSX
add constraint PK_NSX
primary key(ID)

------------- Bảng Mau Sac -------------
create table tb_MauSac
(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	Ma CHAR(20) not null UNIQUE,
	Ten NVARCHAR(MAX) not null ,
	TrangThai int null default 1,
);

alter table tb_MauSac
add constraint PK_MauSac
primary key(ID)
------------- Bảng San Pham -------------
create table tb_SanPham
(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	Ma CHAR(20) not null UNIQUE,
	Ten NVARCHAR(MAX) not null ,
	TrangThai int null default 1,
);

alter table tb_SanPham
add constraint PK_SanPham
primary key(ID)
------------- Bảng chất Liệu -------------
create table tb_ChatLieu
(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	Ma CHAR(20) not null UNIQUE,
	Ten NVARCHAR(MAX) not null ,
	TrangThai int null default 1,
);

alter table tb_ChatLieu
add constraint PK_ChatLieu
primary key(ID)
------------- Bảng mau -------------
create table tb_Mau
(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	Ma CHAR(20) not null UNIQUE,
	Ten NVARCHAR(MAX) not null ,
	TrangThai int null default 1,
);

alter table tb_Mau
add constraint PK_Mau
primary key(ID)
------------- Bảng Phong cách -------------
create table tb_PhongCach
(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	Ma CHAR(20) not null UNIQUE,
	Ten NVARCHAR(MAX) not null ,
	TrangThai int null default 1,
);

alter table tb_PhongCach
add constraint PK_PhongCach
primary key(ID)
------------- Bảng Giao Dich -------------
create table tb_GiaoDich
(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	Ma CHAR(20) not null UNIQUE,
	Ten NVARCHAR(MAX) not null ,
	TrangThai int null default 1, -- 1: trả trực tiếp && 2: quẹt thẻ && 3:trực tiếp + quẹt thẻ
);

alter table tb_GiaoDich
add constraint PK_GiaoDich
primary key(ID)
------------- Bảng chức vụ -------------
create table tb_ChucVu
(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	Ma CHAR(20) not null UNIQUE,
	Ten NVARCHAR(MAX) not null ,
	TrangThai int null default 1,
);
alter table tb_ChucVu
add constraint PK_ChucVu
primary key(ID)
------------- Bảng cửa hàng -------------
create table tb_CuaHang
(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	Ma CHAR(20) not null UNIQUE,
	Ten NVARCHAR(MAX) not null ,
	DiaChi nvarchar (max),
	ThanhPho nvarchar (MAX),
	TrangThai int null default 1,
);

alter table tb_CuaHang
add constraint PK_CuaHang
primary key(ID)
----------------------- Tạo bang chi tiet san pham --------------------
Create table tb_ChiTietSanPham(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null,
	IdSanPham UNIQUEIDENTIFIER not null,
	IdNSX UNIQUEIDENTIFIER not null,
	IdMauSac UNIQUEIDENTIFIER not null,
	IdPhongCach UNIQUEIDENTIFIER not null,
	IdSize UNIQUEIDENTIFIER not null,
	IdMau UNIQUEIDENTIFIER not null,
	IdChatLieu UNIQUEIDENTIFIER not null,
	HinhAnh char(50) not null,
	SoLuong int not null,
	GiaNhap float not null ,
	GiaBan float not null ,
	MoTa nvarchar (max) null,
	TrangThai int null default 1,
);

alter table tb_ChiTietSanPham
add constraint PK_ChiTietSanPham
primary key(ID)

alter table tb_ChiTietSanPham
add constraint FK_CTSP_SanPham
foreign key (IdSanPham)
references tb_SanPham(ID)

alter table tb_ChiTietSanPham
add constraint FK_CTSP_NhaSanXuat
foreign key (IdNSX)
references tb_NSX(ID)

alter table tb_ChiTietSanPham
add constraint FK_CTSP_MauSac
foreign key (IdMauSac)
references tb_MauSac(ID)

alter table tb_ChiTietSanPham
add constraint FK_CTSP_PhongCach
foreign key (IdPhongCach)
references tb_PhongCach(ID)

alter table tb_ChiTietSanPham
add constraint FK_CTSP_Size
foreign key (IdSize)
references tb_Size(ID)

alter table tb_ChiTietSanPham
add constraint FK_CTSP_Mau
foreign key (IdMau)
references tb_Mau(ID)

alter table tb_ChiTietSanPham
add constraint FK_CTSP_ChatLieu
foreign key (IdChatLieu)
references tb_ChatLieu(ID)

------------- Bảng nhân viên -------------
create table tb_NhanVien
(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	Ma char(20) not null,
	HoTen nvarchar(200) not null,
	GioiTinh nvarchar(20) not null,
	NgaySinh date not null,
	DiaChi nvarchar(Max) null,
	SoDienThoai char(10) not null unique,
	MatKhau char(20) not null,
	IdChucVu UNIQUEIDENTIFIER not null,
	IdCuaHang UNIQUEIDENTIFIER null,
	IdNQL UNIQUEIDENTIFIER DEFAULT  null,
	TrangThai int null default 1, -- nghỉ việc / đang làm
);

alter table tb_NhanVien
add constraint PK_NhanVien
primary key(ID);

alter table tb_NhanVien
add constraint FK_NV_ChucVu
foreign key (IdChucVu)
references tb_ChucVu(ID)

alter table tb_NhanVien
add constraint FK_NV_CuaHang
foreign key (IdCuaHang)
references tb_CuaHang(ID)

alter table tb_NhanVien
add constraint FK_NV_NhanVien
foreign key (IdNQL)
references tb_NhanVien(ID) 

------------------------Bang KhachHang-------------------

Create table tb_KhachHang(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null,
	Ma CHAR(20) not null,
	HoTen NVARCHAR(200) not null,
	SDT char(10) null,
	DiaChi nvarchar (max) null,
	Email char(100) null,
	TrangThai int null default 1,
);

   
alter table tb_KhachHang
add constraint PK_KhachHang
primary key(ID)

------------- Bảng Diem -------------
create table tb_Diem
(
	ID UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	IdkhachHang UNIQUEIDENTIFIER not null,
	SoDiemDangco int,
	TrangThai int null default 1,
);
alter table tb_Diem
add constraint PK_Diem
primary key(ID);

alter table tb_Diem
add constraint FK_Diem_KhachHang
foreign key (IdKhachHang)
references tb_KhachHang(ID)

------------- Bảng Quy Doi Diem -------------
create table tb_QuyDoiDiem
(
	ID UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	SoDiemCanQuyDoi int,
	SoTienQuyRa float,
	TrangThai int null default 1, -- 1: lần đầu, 2: update lần 1
);
alter table tb_QuyDoiDiem
add constraint PK_QuyDoiDiem
primary key(ID);

----------------------- Tạo bang Hoa Don --------------------
Create table tb_HoaDon
(
	Id UNIQUEIDENTIFIER DEFAULT NEWID() not null,
	Ma char (50),
	Ten nvarchar (200) null,
	IdChiTietSanPham UNIQUEIDENTIFIER null,
	IdKhachHang UNIQUEIDENTIFIER null,
	IdNhanVien UNIQUEIDENTIFIER null,
	IdGiaoDich UNIQUEIDENTIFIER null,
	NgayTao date default getDate(),
	NgayThanhToan date null,
	SoDiemTieu int null,
	TongTien float null,
	KieuBan int null,

	---------- Phục vụ giao hàng -------------
	HoTen nvarchar(200) null,
	SoDienThoai char(10) null,
	DiaChi nvarchar(200) null,
	NgayNhanHangMongMuon date null,
	NgayBatDauGiaoHang date null,
	NgayNhanHangThanhCong date null,
	MoTa nvarchar(Max) null,
	SoTienNhan float null,
	TinhTrang int null, -- đang giao(0), vẫn trong kho(-1), giao thành công(1)
	-----------------------------------------
	TrangThai int null default 0, -- 0: đang treo, -1: hủy, 1 thành công
)
alter table tb_HoaDon
add constraint PK_HoaDon
primary key(ID)

alter table tb_HoaDon
add constraint FK_HD_ChiTietSanPham
foreign key (IdChiTietSanPham)
references tb_ChiTietSanPham(ID)

alter table tb_HoaDon
add constraint FK_HD_NhanVien
foreign key (IdNhanVien)
references tb_NhanVien(ID)

alter table tb_HoaDon
add constraint FK_HD_KhachHang
foreign key (IdKhachHang)
references tb_KhachHang(ID)

alter table tb_HoaDon
add constraint FK_HD_GiaoDich
foreign key (IdGiaoDich)
references tb_GiaoDich(ID)

----------------------- Tạo bang Hoa Don Chi Tiet --------------------
create table tb_HoaDonChiTiet
(	
	ID UNIQUEIDENTIFIER DEFAULT NEWID() not null,
	IdHoaDon UNIQUEIDENTIFIER null,
	IdChiTietSP UNIQUEIDENTIFIER null,
	SoLuong INT,
	DonGia float,
	TrangThai int,
);

alter table tb_HoaDonChiTiet
add constraint PK_HoaDonChiTiet
primary key(ID)

alter table tb_HoaDonChiTiet
add constraint FK_HDCT_HoaDon
foreign key (IdHoaDon)
references tb_HoaDon(ID)

alter table tb_HoaDonChiTiet
add constraint FK_HDCT_ChiTietSanPham
foreign key (IdChiTietSP)
references tb_ChiTietSanPham(ID)

------------- Bảng Su Dung Diem -------------
create table tb_SuDungDiem
(
	ID UNIQUEIDENTIFIER DEFAULT NEWID() not null ,
	IdQuyDoiDiem UNIQUEIDENTIFIER not null,
	IdDiem UNIQUEIDENTIFIER not null,
	IdHoaDon UNIQUEIDENTIFIER not null,
	SoDiem int null,
	TrangThai int null,
);
alter table tb_SuDungDiem
add constraint PK_SuDungDiem
primary key(ID);

alter table tb_SuDungDiem
add constraint FK_SDD_Diem
foreign key (IdDiem)
references tb_Diem(ID)

alter table tb_SuDungDiem
add constraint FK_SDD_QuyDoiDiem
foreign key (IdQuyDoiDiem)
references tb_QuyDoiDiem(ID)

alter table tb_SuDungDiem
add constraint FK_SDD_HoaDon
foreign key (IdHoaDon)
references tb_HoaDon(ID)

ALTER TABLE tb_HoaDon
ADD SoTienChuyenKhoan float default 0

alter table tb_khachhang
add GioiTinh nvarchar(15) null

ALTER TABLE tb_HoaDonChiTiet
ADD CONSTRAINT TrangThai_default
DEFAULT 1 FOR TrangThai;


ALTER TABLE tb_HoaDonChiTiet
ADD CONSTRAINT TrangThai_default
DEFAULT 1 FOR TrangThai;

select *from tb_HoaDon

ALTER TABLE dbo.[tb_hoadon]
ALTER COLUMN NgayTao datetime

ALTER TABLE dbo.[tb_hoadon]
ALTER COLUMN NgayThanhToan datetime

ALTER TABLE dbo.[tb_hoadon]
ADD CONSTRAINT NgayTao_default
DEFAULT getdate() FOR NgayTao;

ALTER TABLE dbo.[tb_hoadon]
ADD CONSTRAINT KieuBan_default
DEFAULT 0 FOR KieuBan; -- Bán tại cửa hàng

ALTER TABLE dbo.[tb_hoadon]
DROP COLUMN tinhtrang;

ALTER TABLE dbo.[tb_diem]
ADD CONSTRAINT SoDiemDangCo_default
DEFAULT 0 FOR SoDiemDangCo; -- Khi tạo khách hàng auto 0 điểm

-- tiền quy ra điểm: trạng thái là 1 (100k: 10điểm) -> 1k: 0.1 điểm
-- điểm quy ra tiền: trạng thái là -1 (1điểm: 1k)

-- Sử dụng điểm: trạng thái 1: insert thêm điểm, -1: insert trừ điểm


ALTER TABLE tb_HoaDon
ADD SoTienKhachDua float

------------------------ Những hàm hỗ trợ -------------------------------

select hd.Ma as N'Mã hóa đơn',sp.Ten as N'Tên sản phẩm',
			hdct.SoLuong as N'Số lượng', hdct.DonGia as N'Đơn giá', hdct.SoLuong*hdct.DonGia as N'Thành tiền',
			hd.NgayTao as N'Ngày tạo', nv.HoTen as N'Tên nhân viên',
			(
				select dbo.TenKhachHang (hd.IdKhachHang)
			)
			as N'Tên khách hàng',
			(
				select dbo.SoDienThoai (hd.IdKhachHang)
			)
			as N'Số điện thoại',
			(
				select dbo.diachi (hd.IdKhachHang)
			)
			as N'Địa chỉ'
			from tb_SanPham as sp join tb_ChiTietSanPham as ctsp
			on sp.Id = ctsp.IdSanPham join tb_HoaDonChiTiet as hdct
			on hdct.IdChiTietSP = ctsp.Id join tb_HoaDon as hd
			on hd.Id = hdct.IdHoaDon join tb_NhanVien as nv
			on nv.Id = hd.IdNhanVien


			 ---- Tìm tên khách hàng ----
CREATE FUNCTION TenKhachHang (@IdKhachHang UNIQUEIDENTIFIER)
returns nvarchar(100)
as
begin
	declare @ten nvarchar(100)
	if(not exists(select * from tb_khachhang where id = @idkhachhang))
		begin
			set @ten =  N'Khách Lẻ'
		end
	else
		begin
			set @ten = (select hoten from tb_khachhang where id = @idkhachhang)
		end
	return @ten
end
	
	---- Tìm số điện thoại khách hàng ----
alter FUNCTION SoDienThoai (@IdKhachHang UNIQUEIDENTIFIER)
returns nvarchar(100)
as
begin
	declare @sdt char(10)
	if(not exists(select * from tb_khachhang where id = @idkhachhang))
		begin
			set @sdt =  N'Không Có'
		end
	else
		begin
			set @sdt = (select DiaChi from tb_khachhang where id = @idkhachhang)
		end
	return @sdt
end

	---- Tìm địa chỉ khách hàng ----
CREATE FUNCTION DiaChi (@IdKhachHang UNIQUEIDENTIFIER)
returns nvarchar(100)
as
begin
	declare @diachi nvarchar(100)
	if(not exists(select * from tb_khachhang where id = @idkhachhang))
		begin
			set @diachi =  N'Không Có'
		end
	else
		begin
			set @diachi = (select SDT from tb_khachhang where id = @idkhachhang)
		end
	return @diachi
end

select hd.TongTien from  tb_HoaDon as hd
where convert(char(10),hd.NgayTao, 105) between '01-12-2022' and '11-12-2022'
and TrangThai = 1


select top(10)* from tb_HoaDon as hd
order by hd.NgayTao desc


