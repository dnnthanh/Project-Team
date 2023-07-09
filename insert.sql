use Application_Nhom6
go

---------- INSERT BẢNG CHỨC VỤ ----------
insert into tb_ChucVu(Ma, Ten)
values ('QL',N'Quản Lý')

insert into tb_ChucVu(Ma, Ten)
values ('NV',N'Nhân Viên')

select *from tb_ChucVu

---------- INSERT BẢNG CỬA HÀNG ----------
insert into tb_CuaHang(Ma, Ten, DiaChi, ThanhPho)
values ('CH01', N'Family Mart', N'Xã Xuân Canh, Huyện Đông Anh, Thành phố Hà Nội', N'Hà Nội')

select *from tb_CuaHang

---------- INSERT BẢNG NHÂN VIÊN ----------
select *from tb_NhanVien

insert into tb_NhanVien (Ma, HoTen, SoDienThoai, matkhau, NgaySinh, DiaChi, GioiTinh, IdChucVu, IdCuaHang, IdNQL)
VALUES('hainv180923',N'Nguyễn Văn Hải','0823092723','hai872301','19900210',N'Bắc Từ Liêm - Hà Nội',N'Nam',
'CA37F6CA-8CA8-44C1-A3EB-A3D5D745893D','A739B7CA-8E4C-48EC-B918-4E689E9B93CF',NULL)

insert into tb_NhanVien (Ma, HoTen, SoDienThoai, matkhau, NgaySinh, DiaChi, GioiTinh, IdChucVu, IdCuaHang, IdNQL)
VALUES('thaodt231901',N'Đặng Thị Thảo','0971235723','thao1012','19961210',N'Đông Anh - Hà Nội',N'Nữ',
'6C93B458-94C2-4176-AFEC-DE15E853E999','A739B7CA-8E4C-48EC-B918-4E689E9B93CF','2ADE49D3-D7DC-47A8-8061-5B5BDE51906B')


insert into tb_NhanVien (Ma, HoTen, SoDienThoai, matkhau, NgaySinh, DiaChi, GioiTinh, IdChucVu, IdCuaHang, IdNQL)
VALUES('thudt102587',N'Đặng Thị Thu','0418235723','thu1002','19930210',N'Thuận An - Bình Dương',N'Nữ',
'6C93B458-94C2-4176-AFEC-DE15E853E999','A739B7CA-8E4C-48EC-B918-4E689E9B93CF','2ADE49D3-D7DC-47A8-8061-5B5BDE51906B')

insert into tb_NhanVien (Ma, HoTen, SoDienThoai, matkhau, NgaySinh, DiaChi, GioiTinh, IdChucVu, IdCuaHang, IdNQL)
VALUES('manhnv210295',N'Nguyễn Văn Mạnh','0912362723','manh1001','1998-01-10',N'Bắc Từ Liêm - Hà Nội',N'Nam',
'6C93B458-94C2-4176-AFEC-DE15E853E999','A739B7CA-8E4C-48EC-B918-4E689E9B93CF','2ADE49D3-D7DC-47A8-8061-5B5BDE51906B')

update tb_NhanVien set HoTen=?, GioiTinh=?, NgaySinh=?, DiaChi=?,
MatKhau=?, IdChucVu=? where Id=?

update tb_NhanVien set DiaChi =N'Thanh Oai - Hà Nội' where Ma='thudt102587'
select nv.SoDienThoai, nv.MatKhau, nv.IdChucVu from tb_NhanVien as nv

select *from tb_NhanVien 
where SoDienThoai =?, MatKhau=?

select *from tb_NhanVien where trangThai = 1 and IdNQL is not NULL


------------Bang Mau Sac -----------------------

Insert into tb_mausac (Ma,Ten) values ('MS005',N'Đen')
Insert into tb_mausac (Ma,Ten) values ('MS001',N'Xám')
Insert into tb_mausac (Ma,Ten) values ('MS002',N'Trắng')
Insert into tb_mausac (Ma,Ten) values ('MS003',N'Vàng Đất')
Insert into tb_mausac (Ma,Ten) values ('MS004',N'Xanh lam')
Insert into tb_mausac (Ma,Ten) values ('MS006',N'Đỏ')



------------Bang NSX -----------------------
Insert into tb_nsx (Ma,Ten) values ('NSX001','Adidas')
Insert into tb_nsx (Ma,Ten) values ('NSX002','Nike')
Insert into tb_nsx (Ma,Ten) values ('NSX003','Uniqlo')
Insert into tb_nsx (Ma,Ten) values ('NSX004','The North Face')
Insert into tb_nsx (Ma,Ten) values ('NSX005','Giovani')

-----Insert Size------
insert into tb_Size(Ma,Ten) values('S001','S')
insert into tb_Size(Ma,Ten) values('S002','M')
insert into tb_Size(Ma,Ten) values('S003','XXL')
insert into tb_Size(Ma,Ten) values('S004','XL')
insert into tb_Size(Ma,Ten) values('S005','L')

-----Insert Phong Cach---
Insert into tb_PhongCach(Ma,Ten) values('PC001',N'Hàn Quốc')
Insert into tb_PhongCach(Ma,Ten) values('PC002',N'Hiện đại')
Insert into tb_PhongCach(Ma,Ten) values('PC003',N'Cổ điển')
Insert into tb_PhongCach(Ma,Ten) values('PC004',N'Đường phố')
Insert into tb_PhongCach(Ma,Ten) values('PC005',N'Thể thao')

select *from tb_Mau
------------Bang Mau  -----------------------
Insert into tb_Mau (Ma,Ten) values ('M001',N'Trơn')
Insert into tb_Mau(Ma,Ten) values ('M002',N'Họa Tiết')
Insert into tb_Mau (Ma,Ten) values ('M003',N'Chấm bi')
Insert into tb_Mau (Ma,Ten) values ('M004',N'Sọc caro')
Insert into tb_Mau(Ma,Ten) values ('M005',N'In')

------ bảng chất liệu ------
insert into tb_ChatLieu(Ma, Ten)
values ('len001',N'Len')

insert into tb_ChatLieu(Ma, Ten)
values ('da1010',N'Da')

insert into tb_ChatLieu(Ma, Ten)
values ('ni2893',N'Nỉ')

insert into tb_ChatLieu(Ma, Ten)
values ('du9393',N'Dù')

insert into tb_ChatLieu(Ma, Ten)
values ('cotton0099',N'Cotton')

------ bảng sản phẩm -------
insert into tb_SanPham(Ma, Ten)
values ('khoaclen123',N'Áo Khoác len zip khoá tay')

insert into tb_SanPham(Ma, Ten)
values ('khoacda234',N'Áo khoác dạ unique')

insert into tb_SanPham(Ma, Ten)
values ('khoacni289',N'Áo Khoác nỉ mùa đông')

insert into tb_SanPham(Ma, Ten)
values ('khoacdu939',N'Áo Khoác dù thông minh')

insert into tb_SanPham(Ma, Ten)
values ('khoaccotton009',N'Áo Khoác cotton sport')

------ bảng chất liệu ------
insert into tb_ChatLieu(Ma, Ten)
values ('len001',N'Len')

insert into tb_ChatLieu(Ma, Ten)
values ('da1010',N'Da')

insert into tb_ChatLieu(Ma, Ten)
values ('ni2893',N'Nỉ')

insert into tb_ChatLieu(Ma, Ten)
values ('du9393',N'Dù')

insert into tb_ChatLieu(Ma, Ten)
values ('cotton0099',N'Cotton')

------ bảng khách hàng--------
select *from tb_KhachHang
insert into tb_KhachHang (ma,HoTen,sdt,DiaChi,email,GioiTinh) values('tuan123456',N'Nguyễn Thanh Tuấn','0123456789',N'Hà Nội','nttuan@gmail.com',N'Nam')
insert into tb_KhachHang (ma,HoTen,sdt,DiaChi,email,GioiTinh) values('thanh26546',N'Nguyễn Dương Thanh','0156784390',N'Hải Phòng','ndthanh@gmail.com',N'Nam')
insert into tb_KhachHang (ma,HoTen,sdt,DiaChi,email,GioiTinh) values('anh234516',N'Nguyễn Vân Anh','0129876543',N'Hà Nam','nvananh@gmail.com',N'Nữ')
insert into tb_KhachHang (ma,HoTen,sdt,DiaChi,email,GioiTinh) values('van201203',N'Ngô Thanh Vân','0187456239',N'Đà Nẵng','ntvan@gmail.com',N'Nữ')
insert into tb_KhachHang (ma,HoTen,sdt,DiaChi,email,GioiTinh) values('mai261890',N'Hà Tuyết Mai','0985728167',N'Hoàn Kiếm , Hà Nội','htmai@gmail.com',N'Nữ')
insert into tb_KhachHang (ma,HoTen,sdt,DiaChi,email,GioiTinh) values('nam025763',N'Nguyễn Phương Nam','0347768955',N'Gia Lâm , Hà Nội','npn@gmail.com',N'Nam')
insert into tb_KhachHang (ma,HoTen,sdt,DiaChi,email,GioiTinh) values('chien564178',N'Đàm Anh Chiến','0974563302',N'Long Biên , Hà Nội','dachien@gmail.com',N'Nam')
insert into tb_KhachHang (ma,HoTen,sdt,DiaChi,email,GioiTinh) values('khoi540927',N'Lâm Duy Khôi','0225794624',N'Mỹ Đình , Hà Nội','ldkhoi@gmail.com',N'Nam')

------ bảng sản phẩm -------
insert into tb_SanPham(Ma, Ten)
values ('khoaclen123',N'Áo Khoác len zip khoá tay')

insert into tb_SanPham(Ma, Ten)
values ('khoacda234',N'Áo khoác da unique')

insert into tb_SanPham(Ma, Ten)
values ('khoacni289',N'Áo Khoác nỉ mùa đông')

insert into tb_SanPham(Ma, Ten)
values ('khoacdu939',N'Áo Khoác dù thông minh')

insert into tb_SanPham(Ma, Ten)
values ('khoaccotton009',N'Áo Khoác cotton sport')

insert into tb_SanPham(Ma, Ten)
values ('khoaclen257',N'Áo Khoác len phong cách đường phố')

insert into tb_SanPham(Ma, Ten)
values ('khoacda904',N'Áo khoác da lịch lãm')

insert into tb_SanPham(Ma, Ten)
values ('khoacdu349',N'Áo Khoác dù chống nước mưa hai lớp')

insert into tb_SanPham(Ma, Ten)
values ('khoaccotton111',N'Áo Khoác cotton mùa thu')

insert into tb_SanPham(Ma, Ten)
values ('khoacda144',N'Áo Khoác da cá xấu')

------------Bang Giao Dich ----------------------------------
Insert into tb_GiaoDich (Ma,Ten) values ('GD001',N'Chuyển khoản')
Insert into tb_GiaoDich(Ma,Ten) values ('GD002',N'Chuyển khoản + Tiền mặt')
Insert into tb_GiaoDich (Ma,Ten) values ('GD003',N'Tiền mặt')


------------Bang chi tiết sản phẩm ----------------------------------

----------- Nike -----------------

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('3ED4C070-0F8B-4509-A724-02661D461FD4','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'1B8A577D-F28D-4E52-8F85-B240D4EAF830','khoacda144den.png',100, 450000, 500000,N'Áo khoác da cá sấu Xu hướng nam mùa xuân và mùa thu Dấu hiệu thời trang đẹp trai in áo khoác da giản dị oversize rộng rãi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('3ED4C070-0F8B-4509-A724-02661D461FD4','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'1B8A577D-F28D-4E52-8F85-B240D4EAF830','khoacda144xam.png',120, 500000, 600000,N'Áo khoác da cá sấu Xu hướng nam mùa xuân và mùa thu Dấu hiệu thời trang đẹp trai in áo khoác da giản dị oversize rộng rãi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('3ED4C070-0F8B-4509-A724-02661D461FD4','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'1B8A577D-F28D-4E52-8F85-B240D4EAF830','khoacda144trang.png',120, 500000, 600000,N'Áo khoác da cá sấu Xu hướng nam mùa xuân và mùa thu Dấu hiệu thời trang đẹp trai in áo khoác da giản dị oversize rộng rãi'
)


insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('3ED4C070-0F8B-4509-A724-02661D461FD4','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'1B8A577D-F28D-4E52-8F85-B240D4EAF830','khoacda144xam.png',120, 700000, 800000,N'Áo khoác da cá sấu Xu hướng nam mùa xuân và mùa thu Dấu hiệu thời trang đẹp trai in áo khoác da giản dị oversize rộng rãi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('3ED4C070-0F8B-4509-A724-02661D461FD4','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'1B8A577D-F28D-4E52-8F85-B240D4EAF830','khoacda144trang.png',90, 800000, 1000000,N'Áo khoác da cá sấu Xu hướng nam mùa xuân và mùa thu Dấu hiệu thời trang đẹp trai in áo khoác da giản dị oversize rộng rãi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('3ED4C070-0F8B-4509-A724-02661D461FD4','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'1B8A577D-F28D-4E52-8F85-B240D4EAF830','khoacda144den.png',90, 800000, 1000000,N'Áo khoác da cá sấu Xu hướng nam mùa xuân và mùa thu Dấu hiệu thời trang đẹp trai in áo khoác da giản dị oversize rộng rãi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('3ED4C070-0F8B-4509-A724-02661D461FD4','BCABD497-5B84-4C42-A802-33CE65B31C9F','FBB09F73-98FA-456F-910D-3CF223A96AAD'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'1B8A577D-F28D-4E52-8F85-B240D4EAF830','khoacda144xanhlam.png',90, 500000, 700000,N'Áo khoác da cá sấu Xu hướng nam mùa xuân và mùa thu Dấu hiệu thời trang đẹp trai in áo khoác da giản dị oversize rộng rãi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('3ED4C070-0F8B-4509-A724-02661D461FD4','BCABD497-5B84-4C42-A802-33CE65B31C9F','FBB09F73-98FA-456F-910D-3CF223A96AAD'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'1B8A577D-F28D-4E52-8F85-B240D4EAF830','khoacda144xanhlam.png',200, 1000000, 1300000,N'Áo khoác da cá sấu Xu hướng nam mùa xuân và mùa thu Dấu hiệu thời trang đẹp trai in áo khoác da giản dị oversize rộng rãi'
)



insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('4D0B5116-4F56-4C0C-82CA-297A9DBDCEE4','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoacdu939den.png',150, 300000, 4500000,N'Sản phẩm phù hợp với mọi thời tiết và là sản phẩm must-have item trong tủ đồ mọi người ạ'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('4D0B5116-4F56-4C0C-82CA-297A9DBDCEE4','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoacdu939xam.png',150, 320000, 4700000,N'Sản phẩm phù hợp với mọi thời tiết và là sản phẩm must-have item trong tủ đồ mọi người ạ'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('4D0B5116-4F56-4C0C-82CA-297A9DBDCEE4','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoacdu939trang.png',150, 320000, 4700000,N'Sản phẩm phù hợp với mọi thời tiết và là sản phẩm must-have item trong tủ đồ mọi người ạ'
)


insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('4D0B5116-4F56-4C0C-82CA-297A9DBDCEE4','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoacdu939den.png',150, 500000, 600000,N'Sản phẩm phù hợp với mọi thời tiết và là sản phẩm must-have item trong tủ đồ mọi người ạ'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('4D0B5116-4F56-4C0C-82CA-297A9DBDCEE4','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoacdu939xam.png',150, 480000, 5900000,N'Sản phẩm phù hợp với mọi thời tiết và là sản phẩm must-have item trong tủ đồ mọi người ạ'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('4D0B5116-4F56-4C0C-82CA-297A9DBDCEE4','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoacdu939trang.png',150, 520000, 6200000,N'Sản phẩm phù hợp với mọi thời tiết và là sản phẩm must-have item trong tủ đồ mọi người ạ'
)




insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaclen257xam.png',150, 450000, 500000,N'Nếu chán sự đơn giản thì khoác lên mình 1 chiếc áo phối caro thì bao nhấn luôn ạ
nhìn lạ lạ, yêu yêu sao'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaclen257trang.png',150, 400000, 450000,N'Nếu chán sự đơn giản thì khoác lên mình 1 chiếc áo phối caro thì bao nhấn luôn ạ
nhìn lạ lạ, yêu yêu sao'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaclen257den.png',100, 300000, 450000,N'Nếu chán sự đơn giản thì khoác lên mình 1 chiếc áo phối caro thì bao nhấn luôn ạ
nhìn lạ lạ, yêu yêu sao'
)


insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaclen257xam.png',100, 500000, 550000,N'Nếu chán sự đơn giản thì khoác lên mình 1 chiếc áo phối caro thì bao nhấn luôn ạ
nhìn lạ lạ, yêu yêu sao'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaclen257trang.png',150, 480000, 550000,N'Nếu chán sự đơn giản thì khoác lên mình 1 chiếc áo phối caro thì bao nhấn luôn ạ
nhìn lạ lạ, yêu yêu sao'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaclen257den.png',100, 420000, 450000,N'Nếu chán sự đơn giản thì khoác lên mình 1 chiếc áo phối caro thì bao nhấn luôn ạ
nhìn lạ lạ, yêu yêu sao'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','156715A6-03F8-40F4-AF38-5516D3E02376','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaclen257xam.png',100, 20000, 280000,N'Nếu chán sự đơn giản thì khoác lên mình 1 chiếc áo phối caro thì bao nhấn luôn ạ
nhìn lạ lạ, yêu yêu sao'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','156715A6-03F8-40F4-AF38-5516D3E02376','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaclen257trang.png',150, 210000, 250000,N'Nếu chán sự đơn giản thì khoác lên mình 1 chiếc áo phối caro thì bao nhấn luôn ạ
nhìn lạ lạ, yêu yêu sao'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','156715A6-03F8-40F4-AF38-5516D3E02376','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaclen257den.png',100, 220000, 300000,N'Nếu chán sự đơn giản thì khoác lên mình 1 chiếc áo phối caro thì bao nhấn luôn ạ
nhìn lạ lạ, yêu yêu sao'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','89681530-55ED-4160-9339-84B1FAAE891D','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaclen257xam.png',100, 10000, 150000,N'Nếu chán sự đơn giản thì khoác lên mình 1 chiếc áo phối caro thì bao nhấn luôn ạ
nhìn lạ lạ, yêu yêu sao'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','89681530-55ED-4160-9339-84B1FAAE891D','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaclen257trang.png',150, 110000, 150000,N'Nếu chán sự đơn giản thì khoác lên mình 1 chiếc áo phối caro thì bao nhấn luôn ạ
nhìn lạ lạ, yêu yêu sao'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','89681530-55ED-4160-9339-84B1FAAE891D','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaclen257den.png',100, 120000, 200000,N'Nếu chán sự đơn giản thì khoác lên mình 1 chiếc áo phối caro thì bao nhấn luôn ạ
nhìn lạ lạ, yêu yêu sao'
)



insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('7280B5A4-A27A-4BBC-92A1-563B37506731','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'78839D21-386A-465E-85B1-7929A441D6F4','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaccotton009xam.png',100, 30000, 350000,N'khoác cotton chất mát nhẹ có co giãn lên phom đẹp mặc thoải mái thấm hút mồ hôi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'78839D21-386A-465E-85B1-7929A441D6F4','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaccotton009trang.png',150, 310000, 350000,N'khoác cotton chất mát nhẹ có co giãn lên phom đẹp mặc thoải mái thấm hút mồ hôi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'78839D21-386A-465E-85B1-7929A441D6F4','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaccotton009den.png',100, 320000, 400000,N'khoác cotton chất mát nhẹ có co giãn lên phom đẹp mặc thoải mái thấm hút mồ hôi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','5F1A6709-C138-46B1-87B6-83A02A04729D'
,'78839D21-386A-465E-85B1-7929A441D6F4','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaccotton009vangdat.png',100, 320000, 400000,N'khoác cotton chất mát nhẹ có co giãn lên phom đẹp mặc thoải mái thấm hút mồ hôi'
)



insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('7280B5A4-A27A-4BBC-92A1-563B37506731','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'78839D21-386A-465E-85B1-7929A441D6F4','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaccotton009xam.png',100, 400000, 450000,N'khoác cotton chất mát nhẹ có co giãn lên phom đẹp mặc thoải mái thấm hút mồ hôi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'78839D21-386A-465E-85B1-7929A441D6F4','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaccotton009trang.png',150, 410000, 450000,N'khoác cotton chất mát nhẹ có co giãn lên phom đẹp mặc thoải mái thấm hút mồ hôi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'78839D21-386A-465E-85B1-7929A441D6F4','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaccotton009den.png',100, 420000, 500000,N'khoác cotton chất mát nhẹ có co giãn lên phom đẹp mặc thoải mái thấm hút mồ hôi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','5F1A6709-C138-46B1-87B6-83A02A04729D'
,'78839D21-386A-465E-85B1-7929A441D6F4','D883D70B-419B-48D1-9AFA-71024F0271D7','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaccotton009vangdat.png',100, 420000, 500000,N'khoác cotton chất mát nhẹ có co giãn lên phom đẹp mặc thoải mái thấm hút mồ hôi'
)



insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('7280B5A4-A27A-4BBC-92A1-563B37506731','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'78839D21-386A-465E-85B1-7929A441D6F4','89681530-55ED-4160-9339-84B1FAAE891D','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaccotton009xam.png',100, 100000, 150000,N'khoác cotton chất mát nhẹ có co giãn lên phom đẹp mặc thoải mái thấm hút mồ hôi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'78839D21-386A-465E-85B1-7929A441D6F4','89681530-55ED-4160-9339-84B1FAAE891D','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaccotton009trang.png',150, 110000, 150000,N'khoác cotton chất mát nhẹ có co giãn lên phom đẹp mặc thoải mái thấm hút mồ hôi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'78839D21-386A-465E-85B1-7929A441D6F4','89681530-55ED-4160-9339-84B1FAAE891D','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaccotton009den.png',100, 120000, 180000,N'khoác cotton chất mát nhẹ có co giãn lên phom đẹp mặc thoải mái thấm hút mồ hôi'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('2690E45B-C964-4F1E-A76E-2FB863E7C39B','BCABD497-5B84-4C42-A802-33CE65B31C9F','5F1A6709-C138-46B1-87B6-83A02A04729D'
,'78839D21-386A-465E-85B1-7929A441D6F4','89681530-55ED-4160-9339-84B1FAAE891D','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoaccotton009vangdat.png',100, 120000, 160000,N'khoác cotton chất mát nhẹ có co giãn lên phom đẹp mặc thoải mái thấm hút mồ hôi'
)



insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('F7B4DC3F-CF79-49B5-842A-73426702D94D','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoacni289xam.png',100, 200000, 250000,N'Áo khoác nỉ thu đông COLLAR form rộng họa tiết UNF túi hộp 2 bên có hai màu be và xanh dương thời trang phong cách unisex'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('F7B4DC3F-CF79-49B5-842A-73426702D94D','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoacni289trang.png',150, 210000, 250000,N'Áo khoác nỉ thu đông COLLAR form rộng họa tiết UNF túi hộp 2 bên có hai màu be và xanh dương thời trang phong cách unisex'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('F7B4DC3F-CF79-49B5-842A-73426702D94D','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','BCF0769F-926B-43F7-8DE9-0C2FF07BC6AC','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoacni289den.png',100, 220000, 280000,N'Áo khoác nỉ thu đông COLLAR form rộng họa tiết UNF túi hộp 2 bên có hai màu be và xanh dương thời trang phong cách unisex'
)


insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('F7B4DC3F-CF79-49B5-842A-73426702D94D','BCABD497-5B84-4C42-A802-33CE65B31C9F','B8762357-0B20-43AB-B826-06CC4F5CF873'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','156715A6-03F8-40F4-AF38-5516D3E02376','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoacni289xam.png',100, 100000, 150000,N'Áo khoác nỉ thu đông COLLAR form rộng họa tiết UNF túi hộp 2 bên có hai màu be và xanh dương thời trang phong cách unisex'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('F7B4DC3F-CF79-49B5-842A-73426702D94D','BCABD497-5B84-4C42-A802-33CE65B31C9F','5BE366ED-7C61-42DE-BF31-4867A2CBE658'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','156715A6-03F8-40F4-AF38-5516D3E02376','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoacni289trang.png',150, 110000, 150000,N'Áo khoác nỉ thu đông COLLAR form rộng họa tiết UNF túi hộp 2 bên có hai màu be và xanh dương thời trang phong cách unisex'
)

insert into tb_ChiTietSanPham (IdSanPham, IdNSX, IdMauSac, IdPhongCach, IdSize, IdMau, IdChatLieu, HinhAnh, SoLuong, GiaNhap, GiaBan, MoTa)
values('F7B4DC3F-CF79-49B5-842A-73426702D94D','BCABD497-5B84-4C42-A802-33CE65B31C9F','7AFABCD9-690D-4C34-AEEB-465C93352621'
,'07BE939B-2B39-489F-9D1F-993C687C43A5','156715A6-03F8-40F4-AF38-5516D3E02376','8097D030-486B-49CB-9C27-6969F5532619'
,'8691177A-73B7-4564-B2B6-71578F004E18','khoacni289den.png',100, 120000, 180000,N'Áo khoác nỉ thu đông COLLAR form rộng họa tiết UNF túi hộp 2 bên có hai màu be và xanh dương thời trang phong cách unisex'
)


delete from tb_ChiTietSanPham where TrangThai=1