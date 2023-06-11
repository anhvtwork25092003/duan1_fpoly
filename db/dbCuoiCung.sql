﻿create database NHOM8_SACH_FINALYES
use NHOM8_SACH_FINALYES


-- CHAY LAN 1
-- auto ma sach
CREATE FUNCTION AUTO_MASACH()
RETURNS VARCHAR(12)
AS
BEGIN
    DECLARE @ID VARCHAR(12)
    DECLARE @MAX_MA VARCHAR(12)
    DECLARE @MA_NUM INT

    SELECT @MAX_MA = MAX(MA) FROM SACH

    SET @MA_NUM = COALESCE((SELECT MAX(CONVERT(INT, SUBSTRING(MA, 3, LEN(MA)))) + 1 FROM SACH), 1)

    SET @ID = 'SA' + CAST(@MA_NUM AS VARCHAR(10))

    RETURN @ID
END
-- CHAY LAN 2
IF OBJECT_ID('SACH') IS NOT NULL
DROP TABLE SACH
GO
CREATE TABLE SACH(
	ID int Identity not null PRIMARY KEY,
	Ma VARCHAR(20) UNIQUE DEFAULT DBO.AUTO_MASACH() ,
	TENSACH nvarchar(80),
	IdNXB INT,
	MOTA NVARCHAR(50) DEFAULT NULL,
	GIANHAP DECIMAL(20,0) DEFAULT 0,
	GIABAN DECIMAL(20,0) DEFAULT 0,
	TRANGTHAI BIT DEFAULT 0,
	IMAGELINK nvarchar(80),
	MAVACH varchar(50)
	)

-- CHAY LAN 3
-- FUNCTION AUTO MATG
CREATE FUNCTION AUTO_MATG()
RETURNS VARCHAR(12)
AS
BEGIN
    DECLARE @ID VARCHAR(12)
    DECLARE @MAX_MA VARCHAR(12)
    DECLARE @MA_NUM INT

    SELECT @MAX_MA = MAX(MA) FROM TACGIA

    SET @MA_NUM = COALESCE((SELECT MAX(CONVERT(INT, SUBSTRING(MA, 3, LEN(MA)))) + 1 FROM TACGIA), 1)

    SET @ID = 'TG' + CAST(@MA_NUM AS VARCHAR(10))

    RETURN @ID
END
-- CHAY LAN 4
CREATE TABLE TACGIA (
ID int identity PRIMARY KEY ,
Ma VARCHAR(20) UNIQUE DEFAULT DBO.AUTO_MATG() ,
TEN NVARCHAR(50) DEFAULT NULL,
TRANGTHAI INT DEFAULT 0
)
-- CHAY LAN 5
IF OBJECT_ID('SACH_TACGIA') IS NOT NULL
DROP TABLE SACH_TACGIA
GO
CREATE TABLE SACH_TACGIA
(
ID_TG int NOT NULL,
ID_SACH int NOT NULL,
CONSTRAINT FK_SACHTG_SACH FOREIGN KEY(ID_SACH) REFERENCES SACH,
CONSTRAINT FK_SACHTG_TACGIA FOREIGN KEY(ID_TG) REFERENCES TACGIA,
CONSTRAINT PK_SACHTG PRIMARY KEY(ID_SACH,ID_TG)
)
-- CHAY LAN 6
CREATE FUNCTION AUTO_MATL()
RETURNS VARCHAR(12)
AS
BEGIN
    DECLARE @ID VARCHAR(12)
    DECLARE @MAX_MA VARCHAR(12)
    DECLARE @MA_NUM INT

    SELECT @MAX_MA = MAX(MA) FROM THELOAI

    SET @MA_NUM = COALESCE((SELECT MAX(CONVERT(INT, SUBSTRING(MA, 3, LEN(MA)))) + 1 FROM THELOAI), 1)

    SET @ID = 'TL' + CAST(@MA_NUM AS VARCHAR(10))

    RETURN @ID
END
-- CHAY LAN 7

CREATE TABLE THELOAI(
ID int identity PRIMARY KEY ,
MA VARCHAR(20) UNIQUE  DEFAULT DBO.AUTO_MATL() ,
TEN NVARCHAR(80) DEFAULT NULL,
TRANGTHAI INT DEFAULT 0
)

-- CHAY LAN 8
IF OBJECT_ID('SACH_THELOAI') IS NOT NULL
DROP TABLE SACH_THELOAI
GO
CREATE TABLE SACH_THELOAI(
	ID_SACH int not null,
	ID_TL int not null,
	CONSTRAINT PK_SACHTL PRIMARY KEY(ID_sach,ID_TL) ,
	CONSTRAINT FK_SachTL_SACH FOREIGN KEY(ID_sach) REFERENCES SACH(ID),
	CONSTRAINT FK_SACHTL_Theloai FOREIGN KEY(ID_TL) REFERENCES THELOAI(ID)
	)
-- CHAY LAN 9
CREATE FUNCTION AUTO_MANXB()
RETURNS VARCHAR(12)
AS
BEGIN
    DECLARE @ID VARCHAR(12)
    DECLARE @MAX_MA VARCHAR(12)
    DECLARE @MA_NUM INT

    SELECT @MAX_MA = MAX(MA) FROM NXB

    SET @MA_NUM = COALESCE((SELECT MAX(CONVERT(INT, SUBSTRING(MA, 3, LEN(MA)))) + 1 FROM NXB), 1)

    SET @ID = 'NX' + CAST(@MA_NUM AS VARCHAR(10))

    RETURN @ID
END
-- CHAY LAN 10
CREATE TABLE NXB(
ID int identity PRIMARY KEY ,
Ma VARCHAR(20) UNIQUE  DEFAULT DBO.AUTO_MANXB() ,
TEN NVARCHAR(50) DEFAULT NULL,
TRANGTHAI INT DEFAULT 0
)
-- CHAY LAN 11
CREATE FUNCTION AUTO_MAND()
RETURNS VARCHAR(12)
AS
BEGIN
    DECLARE @ID VARCHAR(12)
    DECLARE @MAX_MA VARCHAR(12)
    DECLARE @MA_NUM INT

    SELECT @MAX_MA = MAX(MA) FROM NGUOIDUNG

    SET @MA_NUM = COALESCE((SELECT MAX(CONVERT(INT, SUBSTRING(MA, 3, LEN(MA)))) + 1 FROM NGUOIDUNG), 1)

    SET @ID = 'ND' + CAST(@MA_NUM AS VARCHAR(10))

    RETURN @ID
END
-- CHAYLAN 12
IF OBJECT_ID('NGUOIDUNG') IS NOT NULL
DROP TABLE NGUOIDUNG 
GO
CREATE TABLE NGUOIDUNG(
ID int identity PRIMARY KEY ,
MA VARCHAR(20) UNIQUE DEFAULT DBO.AUTO_MAND(),
HOTEN NVARCHAR(50) DEFAULT NULL,
EMAIL NVARCHAR(30) DEFAULT NULL,
GIOITINH BIT DEFAULT 0,
NGAYSINH DATE DEFAULT NULL,
DIACHI NVARCHAR(100) DEFAULT NULL,
SDT VARCHAR(30) DEFAULT NULL,
MATKHAU VARCHAR(MAX) DEFAULT NULL,
CHUCVU Nvarchar(10),
ImageLINK nvarchar(100) null,
TRANGTHAI bit DEFAULT 0
)
INSERT INTO NGUOIDUNG(HOTEN, MATKHAU, CHUCVU) VALUEs(N'admin', '20102003', N'Quản Lý')
-- CHAY LAN 13
select* from hoadon
CREATE FUNCTION AUTO_MAKH()
RETURNS VARCHAR(12)
AS
BEGIN
    DECLARE @ID VARCHAR(12)
    DECLARE @MAX_MA VARCHAR(12)
    DECLARE @MA_NUM INT

    SELECT @MAX_MA = MAX(MAKH) FROM KHACHHANG

    SET @MA_NUM = COALESCE((SELECT MAX(CONVERT(INT, SUBSTRING(MAKH, 3, LEN(MAKH)))) + 1 FROM KHACHHANG), 1)

    SET @ID = 'KH' + CAST(@MA_NUM AS VARCHAR(10))

    RETURN @ID
END
-- CHAY LAN 14
CREATE TABLE KHACHHANG(
	ID int identity PRIMARY KEY ,
	MAKH VARCHAR(20) UNIQUE DEFAULT DBO.AUTO_MAKH(),
	HOTEN NVARCHAR(50) NOT NULL,
	SDT VARCHAR(11) NULL,
	EMAIL VARCHAR(50) NULL,
	TRANGTHAI bit DEFAULT 0
)
insert into khachhang(hoten, sdt) values(N'Khách Lẻ', 0)
-- CHAY LAN 15 
CREATE FUNCTION AUTO_MAHD()
RETURNS VARCHAR(12)
AS
BEGIN
    DECLARE @ID VARCHAR(12)
    DECLARE @MAX_MA VARCHAR(12)
    DECLARE @MA_NUM INT

    SELECT @MAX_MA = MAX(MA) FROM HOADON

    SET @MA_NUM = COALESCE((SELECT MAX(CONVERT(INT, SUBSTRING(MA, 3, LEN(MA)))) + 1 FROM HOADON), 1)

    SET @ID = 'HD' + CAST(@MA_NUM AS VARCHAR(10))

    RETURN @ID
END
-- CHAY LAN 16
IF OBJECT_ID('HOADON') IS NOT NULL
DROP TABLE HOADON
GO
CREATE TABLE HOADON(
ID INT IDENTITY PRIMARY KEY ,
IDKH INT,
IDND INT,
MA VARCHAR(20) UNIQUE DEFAULT DBO.AUTO_MAHD(),
TONGTIEN decimal(10,2),
IDKHUYENMAI INT,
TONGTIENSAUKHUYENMAI DECIMAL(10,2),
NgayTao DATE DEFAULT NULL,
TrangThai BIT DEFAULT 0,
)
-- CHAY LAN 17
IF OBJECT_ID('HOADONCT') IS NOT NULL
DROP TABLE HOADONCT 
GO
CREATE TABLE HOADONCT(
ID INT IDENTITY PRIMARY KEY,
IDSACH INT,
IDHD INT,
DonGia decimal(10,2),
SoLuong INT,
THANHTIEN decimal(10,2)
)
-- CHAY LAN 18
CREATE FUNCTION AUTO_MAKM()
RETURNS VARCHAR(12)
AS
BEGIN
    DECLARE @ID VARCHAR(12)
    DECLARE @MAX_MA VARCHAR(12)
    DECLARE @MA_NUM INT

    SELECT @MAX_MA = MAX(MAKM) FROM KHUYENMAI

    SET @MA_NUM = COALESCE((SELECT MAX(CONVERT(INT, SUBSTRING(MAKM, 3, LEN(MAKM)))) + 1 FROM KHUYEMAI), 1)

    SET @ID = 'KM' + CAST(@MA_NUM AS VARCHAR(10))

    RETURN @ID
END
-- CHAY LAN 19
IF OBJECT_ID('KHUYENMAI') IS NOT NULL
DROP TABLE KHUYENMAI
GO
CREATE TABLE KHUYENMAI
(
	ID int Identity PRIMARY KEY not null,
	MAKM VARCHAR(50) UNIQUE DEFAULT DBO.AUTO_MAKM(),
	TENKM nvarChar(100),
	CHIETKHAU INT ,
	NGAYAPDUNG DATETIME,
	NGAYKETTHUC DATETIME,
	TRANGTHAI bit DEFAULT 0
)
-- CHAY LAN 20

-- SAHCCT-NNXB
ALTER TABLE SACH ADD FOREIGN KEY (IdNXB) REFERENCES NXB(Id)
-- HoaDonBan - NguoiDung
ALTER TABLE HoaDon ADD FOREIGN KEY(IDND) REFERENCES NguoiDung(Id)
-- HoaDonBan - KhachHang
ALTER TABLE HoaDon ADD FOREIGN KEY(IdKH) REFERENCES KhachHang(Id)
-- ChiTietHoaDon - SachChiTiet
ALTER TABLE HoaDonCT ADD FOREIGN KEY(IdSach) REFERENCES SACH(Id)
-- ChiTietHoaDon - HoaDonBan
ALTER TABLE HoaDonCT ADD FOREIGN KEY(IdHD) REFERENCES HoaDon(Id)
-- HOADON-KHUYENMAI
ALTER TABLE HoaDon ADD FOREIGN KEY(IDKHUYENMAI) REFERENCES KHUYENMAI(Id)