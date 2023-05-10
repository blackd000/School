USE master;
GO


/****** Object: Database QuanLyNhanVien ******/
IF DB_ID('QuanLyNhanVien') IS NOT NULL
	DROP DATABASE QuanLyNhanVien;
GO

CREATE DATABASE QuanLyNhanVien;
GO

USE QuanLyNhanVien;
GO


/****** Object: Tables ******/
CREATE TABLE PhongBan
(
    MaPhongBan INT NOT NULL IDENTITY(1,1),
    TenPhongBan NVARCHAR(50) NOT NULL,
    SoLuongNhanVien SMALLINT NULL,
    NgayNhanChuc SMALLDATETIME NOT NULL DEFAULT GETDATE(),
    MaNhanVien INT NOT NULL,

    CONSTRAINT PK_PhongBan PRIMARY KEY (MaPhongBan)
);
GO

CREATE TABLE DuAn
(
    MaDuAn INT NOT NULL IDENTITY(1,1),
    TenDuAn NVARCHAR(100) NOT NULL,
    NgayBatDau SMALLDATETIME NOT NULL DEFAULT GETDATE(),
    NgayKetThuc SMALLDATETIME NOT NULL DEFAULT '25/04/2025',
    TrangThaiDuAn BIT NOT NULL DEFAULT 0,
    MoTa NTEXT NOT NULL,

    CONSTRAINT PK_DuAn PRIMARY KEY (MaDuAn)
);
GO

CREATE TABLE NhanVien
(
    MaNhanVien INT NOT NULL IDENTITY(1,1),
    HoTen NVARCHAR(80) NOT NULL,
    NgaySinh SMALLDATETIME NOT NULL,
    SoDienThoai VARCHAR(11) NOT NULL,
    QueQuan NVARCHAR(20) NOT NULL,
    Luong MONEY NOT NULL DEFAULT 0 CHECK (Luong >= 0),
    MaPhongBan INT NOT NULL,
    MaPhuong INT NOT NULL,
    MaHoTen INT NOT NULL,

    CONSTRAINT PK_NhanVien PRIMARY KEY (MaNhanVien)
);
GO

CREATE TABLE Tinh
(
    MaTinh INT NOT NULL IDENTITY(1,1),
    TenTinh NVARCHAR(20),

    CONSTRAINT PK_Tinh PRIMARY KEY (MaTinh)
);
GO

CREATE TABLE Quan
(
    MaQuan INT NOT NULL IDENTITY(1,1),
    TenQuan NVARCHAR(20),
    MaTinh INT NOT NULL,

    CONSTRAINT PK_Quan PRIMARY KEY (MaQUan)
);
GO

CREATE TABLE Phuong
(
    MaPhuong INT NOT NULL IDENTITY(1,1),
    TenPhuong NVARCHAR(30),
    MaQuan INT NOT NULL,

    CONSTRAINT PK_Phuong PRIMARY KEY (MaPhuong)
);
GO

CREATE TABLE HoTen
(
    MaHoTen INT NOT NULL IDENTITY(1,1),
    Ho NVARCHAR(20) NOT NULL,
    TenDem NVARCHAR(20) NOT NULL,
    Ten NVARCHAR(20) NOT NULL,

    CONSTRAINT PK_HoTen PRIMARY KEY (MaHoTen)
);
GO

CREATE TABLE BangCap
(
    MaBangCap INT NOT NULL IDENTITY(1,1),
    MaNhanVien INT NOT NULL,

    CONSTRAINT PK_BangCap PRIMARY KEY (MaNhanVien, MaBangCap)
);
GO

CREATE TABLE PhanCong
(
    MaNhanVien INT NOT NULL,
    MaDuAn INT NOT NULL,
    ThoiGian SMALLDATETIME NOT NULL,

    CONSTRAINT PK_PhanCong PRIMARY KEY (MaNhanVien, MaDuAn)
);
GO


/****** ALTER TABLE ******/
ALTER TABLE PhongBan
ADD CONSTRAINT FK_TruongPhong
FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien);
GO

ALTER TABLE NhanVien
ADD CONSTRAINT FK_PhongBanNhanVien
FOREIGN KEY (MaPhongBan) REFERENCES PhongBan(MaPhongBan);
GO

ALTER TABLE NhanVien
ADD CONSTRAINT FK_PhuongNhanVien
FOREIGN KEY (MaPhuong) REFERENCES Phuong(MaPhuong);
GO

ALTER TABLE NhanVien
ADD CONSTRAINT FK_HoTenNhanVien
FOREIGN KEY (MaHoTen) REFERENCES HoTen(MaHoTen);
GO

ALTER TABLE Phuong
ADD CONSTRAINT FK_QuanPhuong
FOREIGN KEY (MaQuan) REFERENCES Quan(MaQuan);
GO

ALTER TABLE Quan
ADD CONSTRAINT FK_TinhQuan
FOREIGN KEY (MaTinh) REFERENCES Tinh(MaTinh);
GO

ALTER TABLE BangCap
ADD CONSTRAINT FK_NhanVienBangCap
FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
ON DELETE CASCADE;
GO

ALTER TABLE PhanCong
ADD CONSTRAINT FK_DuAnPhanCong
FOREIGN KEY (MaDuAn) REFERENCES DuAn(MaDuAn);
GO

ALTER TABLE PhanCong
ADD CONSTRAINT FK_NhanVienPhanCong
FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien);
GO


/****** INDEXES ******/
CREATE INDEX IX_PhongBan_MaNhanVien ON PhongBan (MaNhanVien);
GO

CREATE INDEX IX_NhanVien_MaPhongBan ON NhanVien (MaPhongBan);
GO

CREATE INDEX IX_NhanVien_MaPhuong ON NhanVien (MaPhuong);
GO

CREATE INDEX IX_Phuong_MaQuan ON Phuong (MaQuan);
GO

CREATE INDEX IX_Quan_MaTinh ON Quan (MaTinh);
GO

CREATE INDEX IX_NhanVien_MaHoTen ON NhanVien (MaHoTen);
GO

CREATE INDEX IX_BangCap_MaNhanVien ON BangCap (MaNhanVien);
GO

CREATE INDEX IX_PhanCong_MaDuAn ON PhanCong (MaDuAn);
GO

CREATE INDEX IX_PhanCong_MaNhanVien ON PhanCong (MaNhanVien);
GO


/****** VIEW ******/
CREATE OR ALTER VIEW VW_ThongTinNhanVien 
AS
SELECT NhanVien.MaNhanVien, NhanVien.HoTen, NhanVien.NgaySinh, NhanVien.Luong, NhanVien.SoDienThoai, 
    Phuong.TenPhuong, Quan.TenQuan, Tinh.TenTinh,
    PhongBan.TenPhongBan FROM NhanVien 
        JOIN Phuong ON Phuong.MaPhuong = NhanVien.MaPhuong
        JOIN Quan ON Quan.MaQuan = Phuong.MaQuan
        JOIN Tinh ON Tinh.MaTinh = Quan.MaTinh
        JOIN PhongBan ON PhongBan.MaPhongBan = NhanVien.MaPhongBan;
GO

CREATE OR ALTER VIEW VW_ThongTinDuAn
AS
SELECT DuAn.MaDuAn, DuAn.TenDuAn, DuAn.MoTa, DuAn.NgayKetThuc,
    NhanVien.MaNhanVien, NhanVien.HoTen, PhanCong.ThoiGian FROM DuAn
        JOIN PhanCong ON PhanCong.MaDuAn = DuAn.MaDuAn
        JOIN NhanVien ON PhanCong.MaNhanVien = NhanVien.MaNhanVien;
GO


/****** PROCEDURE ******/
CREATE OR ALTER PROC PR_TimKiemNhanVien
    @MaNhanVien INT = -1,
    @HoTen NVARCHAR(40) = NULL,
    @MaPhongBan INT = -1
AS 
BEGIN
    SELECT * FROM NhanVien
        WHERE 
        (MaNhanVien = @MaNhanVien OR MaNhanVien = -1)
        AND (HoTen LIKE '%' + @HoTen + '%' OR @HoTen IS NULL)
        AND (MaPhongBan = @MaPhongBan OR @MaPhongBan = -1);
END
GO

-- EXECUTE PR_TimKiemNhanVien @MaNhanVien = 1;
-- EXECUTE PR_TimKiemNhanVien @HoTen = 'Nguyen Van A';
-- EXECUTE PR_TimKiemNhanVien;


CREATE OR ALTER PROC PR_ThemNhanVien
    @HoTen NVARCHAR(40) = NULL,
    @NgaySinh SMALLDATETIME = NULL,
    @SoDienThoai VARCHAR(11) = NULL,
    @Luong MONEY = 0,
    @MaPhuong INT = -1,
    @MaPhongBan INT = -1
AS 
IF NOT EXISTS(SELECT * FROM PhongBan WHERE MaPhongBan = @MaPhongBan)
    BEGIN
        PRINT 'Phong ban khong hop le!'
        RETURN 1
    END
IF NOT EXISTS(SELECT * FROM Phuong WHERE MaPhuong = @MaPhuong)
    BEGIN
        PRINT 'Dia chi khong hop le!'
        RETURN 2
    END
IF @NgaySinh > GETDATE() OR @NgaySinh IS NULL
    BEGIN
        PRINT 'Ngay sinh khong hop le!'
        RETURN 3
    END
IF @HoTen IS NULL
    BEGIN
        PRINT 'Ho ten khong duoc de trong!'
        RETURN 4
    END
IF @SoDienThoai IS NULL
    BEGIN
        PRINT 'So dien thoai khong duoc de trong!'
        RETURN 5
    END
IF @Luong <= 0
    BEGIN
        PRINT 'Luong khong hop le!'
        RETURN 6
    END
INSERT NhanVien (HoTen, NgaySinh, SoDienThoai, Luong, MaPhongBan, MaPhuong) 
        VALUES(@HoTen, @NgaySinh, @SoDienThoai, @Luong, @MaPhongBan, @MaPhuong)
IF @@ERROR <> 0
    BEGIN
        PRINT 'Loi them nhan vien!'
        RETURN 7
    END
RETURN 0
GO


/****** TRIGGER ******/
-- 1 nhan vien co the lam toi da 2 du an cung luc
CREATE TRIGGER TR_SoDuAn ON PhanCong
FOR INSERT AS
IF (SELECT COUNT(*)
    FROM PhanCong 
    JOIN NhanVien ON NhanVien.MaNhanVien = PhanCong.MaNhanVien
    JOIN DuAn ON DuAn.MaDuAn = PhanCong.MaDuAn
    WHERE DuAn.NgayKetThuc < GETDATE()) > 2
    BEGIN
        PRINT 'Nhan vien khong the lam nhieu hon 2 du an cung luc!'
        ROLLBACK TRAN
    END
GO