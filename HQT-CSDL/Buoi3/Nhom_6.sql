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
    MaPhongBan INT NOT NULL IDENTITY,
    TenPhongBan NVARCHAR(50) NOT NULL,
    SoLuongNhanVien SMALLINT NOT NULL DEFAULT 0,
    NgayNhanChuc SMALLDATETIME NOT NULL DEFAULT GETDATE(),
    MaNhanVien INT NOT NULL,

    CONSTRAINT PK_PhongBan PRIMARY KEY (MaPhongBan)
);
GO

CREATE TABLE DuAn
(
    MaDuAn INT NOT NULL IDENTITY,
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
    MaNhanVien INT NOT NULL IDENTITY,
    Ho NVARCHAR(20) NOT NULL,
    TenDem NVARCHAR(20) NOT NULL,
    Ten NVARCHAR(20) NOT NULL,
    NgaySinh SMALLDATETIME NOT NULL,
    SoDienThoai VARCHAR(11) NOT NULL,
    QueQuan NVARCHAR(20) NOT NULL,
    Luong MONEY NOT NULL DEFAULT 0 CHECK (Luong >= 0),
    MaPhongBan INT NOT NULL,
    MaPhuong INT NOT NULL,

    CONSTRAINT PK_NhanVien PRIMARY KEY (MaNhanVien)
);
GO

CREATE TABLE Tinh
(
    MaTinh INT NOT NULL,
    TenTinh NVARCHAR(20),

    CONSTRAINT PK_Tinh PRIMARY KEY (MaTinh)
);
GO

CREATE TABLE Quan
(
    MaQuan INT NOT NULL,
    TenQuan NVARCHAR(20),
    MaTinh INT NOT NULL,

    CONSTRAINT PK_Quan PRIMARY KEY (MaQUan)
);
GO

CREATE TABLE Phuong
(
    MaPhuong INT NOT NULL,
    TenPhuong NVARCHAR(30),
    MaQuan INT NOT NULL,

    CONSTRAINT PK_Phuong PRIMARY KEY (MaPhuong)
);
GO

CREATE TABLE BangCap
(
    MaBangCap INT NOT NULL IDENTITY,
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

CREATE INDEX IX_BangCap_MaNhanVien ON BangCap (MaNhanVien);
GO

CREATE INDEX IX_PhanCong_MaDuAn ON PhanCong (MaDuAn);
GO

CREATE INDEX IX_PhanCong_MaNhanVien ON PhanCong (MaNhanVien);
GO


/****** VIEW ******/
CREATE OR ALTER VIEW VW_ThongTinNhanVien 
AS
SELECT NhanVien.MaNhanVien, NhanVien.NgaySinh, NhanVien.Luong, NhanVien.SoDienThoai, 
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
    NhanVien.MaNhanVien, PhanCong.ThoiGian FROM DuAn
        JOIN PhanCong ON PhanCong.MaDuAn = DuAn.MaDuAn
        JOIN NhanVien ON PhanCong.MaNhanVien = NhanVien.MaNhanVien;
GO


/****** PROCEDURE ******/
CREATE PROCEDURE PR_ThemPhongBan
    @TenPhongBan NVARCHAR(50),
    @SoLuongNhanVien SMALLINT,
    @NgayNhanChuc SMALLDATETIME,
    @MaNhanVien INT
AS
BEGIN
    INSERT INTO PhongBan (TenPhongBan, SoLuongNhanVien, NgayNhanChuc, MaNhanVien)
    VALUES (@TenPhongBan, @SoLuongNhanVien, @NgayNhanChuc, @MaNhanVien)
END;
GO

CREATE PROCEDURE PR_CapNhatPhongBan
    @MaPhongBan INT = -1,
    @TenPhongBan NVARCHAR(50),
    @SoLuongNhanVien SMALLINT,
    @NgayNhanChuc SMALLDATETIME,
    @MaNhanVien INT
AS
IF NOT EXISTS(SELECT * FROM PhongBan WHERE MaPhongBan = @MaPhongBan)
    BEGIN
        PRINT 'Khong tim thay phong ban'
        RETURN 1
    END
BEGIN
    UPDATE PhongBan
    SET TenPhongBan = @TenPhongBan,
        SoLuongNhanVien = @SoLuongNhanVien,
        NgayNhanChuc = @NgayNhanChuc,
        MaNhanVien = @MaNhanVien
    WHERE MaPhongBan = @MaPhongBan;
END
RETURN 0;
GO

CREATE PROCEDURE PR_ThemDuAn
    @TenDuAn NVARCHAR(100),
    @NgayBatDau SMALLDATETIME,
    @NgayKetThuc SMALLDATETIME,
    @TrangThaiDuAn BIT,
    @MoTa NTEXT
AS
BEGIN
    INSERT INTO DuAn (TenDuAn, NgayBatDau, NgayKetThuc, TrangThaiDuAn, MoTa)
    VALUES (@TenDuAn, @NgayBatDau, @NgayKetThuc, @TrangThaiDuAn, @MoTa);
END;
GO

CREATE OR ALTER PROC PR_CapNhatDuAn
    @MaDuAn INT,
    @TenTenDuAn NVARCHAR(100),
    @NgayBatDau SMALLDATETIME,
    @NgayKetThuc SMALLDATETIME,
    @TrangThaiDuAn BIT,
    @MoTa NTEXT
AS
IF NOT EXISTS(SELECT * FROM DuAn WHERE MaDuAn = @MaDuAn)
    BEGIN
        PRINT 'Khong tim thay Du An'
        RETURN 1
    END;
BEGIN
    UPDATE DuAn
    SET TenDuAn = @TenTenDuAn,
		NgayBatDau = @NgayBatDau,
		NgayKetThuc = @NgayKetThuc,
		TrangThaiDuAn = @TrangThaiDuAn,
		MoTa = @MoTa
    WHERE MaDuAn = @MaDuAn;
END
RETURN 0;
GO

CREATE OR ALTER PROC PR_ThemNhanVien
    @NgaySinh SMALLDATETIME,
    @Ho NVARCHAR(20),
    @TenDem NVARCHAR(20),
    @Ten NVARCHAR(20),
    @SoDienThoai VARCHAR(11),
    @QueQuan NVARCHAR(20),
    @Luong MONEY = 0,
    @TenTinh NVARCHAR(20),
    @TenQuan NVARCHAR(20),
    @TenPhuong NVARCHAR(30),
    @MaPhongBan INT = -1,
    @MaPhuong INT = -1
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
        RETURN 4
    END
IF @SoDienThoai IS NULL
    BEGIN
        PRINT 'So dien thoai khong duoc de trong!'
        RETURN 5
    END
BEGIN
    INSERT INTO NhanVien
        (NgaySinh, Ho, TenDem, Ten, SoDienThoai, QueQuan, Luong, MaPhongBan, MaPhuong)
    VALUES
        (@NgaySinh, @Ho, @TenDem, @Ten, @SoDienThoai, @QueQuan, @Luong, @MaPhongBan, @MaPhuong);
    
    INSERT INTO Phuong (TenPhuong, MaQuan)
    SELECT @TenPhuong, MaQuan
    FROM NhanVien AS n JOIN Phuong  AS p
        ON n.MaPhuong = p.MaPhuong;

    INSERT INTO Quan (TenQuan, MaTinh)
    SELECT @TenQuan, MaTinh
    FROM Phuong AS p JOIN Quan AS q
        ON p.MaQuan = q.MaQuan;

    INSERT INTO Tinh (TenTinh)
    SELECT @TenQuan
    FROM Quan AS q JOIN Tinh AS t
        ON q.MaTinh = t.MaTinh;
END
IF @@ERROR <> 0
    BEGIN
        PRINT 'Loi them nhan vien!'
        RETURN 6
    END
RETURN 0;
GO

CREATE PROCEDURE PR_CapNhatNhanVien
    @MaNhanVien INT,
    @Ho NVARCHAR(20),
    @TenDem NVARCHAR(20),
    @Ten NVARCHAR(20),
    @NgaySinh SMALLDATETIME,
    @SoDienThoai VARCHAR(11),
    @QueQuan NVARCHAR(20),
    @Luong MONEY = 0,
    @TenPhuong NVARCHAR(30),
    @TenQuan NVARCHAR(20),
    @TenTinh NVARCHAR(20),
    @MaPhongBan INT = -1,
    @MaPhuong INT = -1
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
BEGIN
    UPDATE NhanVien
    SET NgaySinh = @NgaySinh,
        Ho = @Ho,
        TenDem = @TenDem,
        Ten = @Ten,
        SoDienThoai = @SoDienThoai,
        QueQuan = @QueQuan,
        Luong = @Luong,
        MaPhongBan = @MaPhongBan,
        MaPhuong = @MaPhuong
    WHERE MaNhanVien = @MaNhanVien;
END
IF @@ERROR <> 0
    BEGIN
        PRINT 'Loi cap nhat nhan vien!'
        RETURN 6
    END
RETURN 0;
GO

CREATE OR ALTER PROC PR_TimKiemNhanVien
    @MaNhanVien INT = -1,
    @MaPhongBan INT = -1
AS 
BEGIN
    SELECT * FROM NhanVien
    WHERE (MaNhanVien = @MaNhanVien OR MaNhanVien = -1)
        AND (MaPhongBan = @MaPhongBan OR @MaPhongBan = -1);
END;
GO

-- EXECUTE PR_TimKiemNhanVien @MaNhanVien = 1;
-- EXECUTE PR_TimKiemNhanVien;


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

CREATE TRIGGER TR_PreventDeletePhanCong ON PhanCong
INSTEAD OF DELETE
AS
BEGIN
    RAISERROR('Deletion of data from the PhanCong table is not allowed!!!.', 16, 1);
END;
GO
CREATE TABLE DeleteOrOldUpdateNhanVienTable
(
    MaNhanVien INT NOT NULL IDENTITY,
    Ho NVARCHAR(20) NOT NULL,
    TenDem NVARCHAR(20) NOT NULL,
    Ten NVARCHAR(20) NOT NULL,
    NgaySinh SMALLDATETIME NOT NULL,
    SoDienThoai VARCHAR(11) NOT NULL,
    QueQuan NVARCHAR(20) NOT NULL,
    Luong MONEY NOT NULL DEFAULT 0 CHECK (Luong >= 0),
    MaPhongBan INT NOT NULL,
    MaPhuong INT NOT NULL,
);
GO

CREATE TRIGGER TR_HoldNhanVienData ON NhanVien
FOR DELETE, UPDATE
AS
BEGIN
    INSERT INTO DeleteOrOldUpdateNhanVienTable
        (MaNhanVien, Ho, TenDem, Ten, NgaySinh, SoDienThoai, QueQuan, Luong, MaPhongBan, MaPhuong)
    SELECT MaNhanVien, Ho, TenDem, Ten, NgaySinh, SoDienThoai, QueQuan, Luong, MaPhongBan, MaPhuong
    FROM DELETED;
END;
GO
CREATE TABLE OLD_PhongBan
(
    MaPhongBan INT NOT NULL IDENTITY,
    TenPhongBan NVARCHAR(50) NOT NULL,
    SoLuongNhanVien SMALLINT NOT NULL DEFAULT 0,
    NgayNhanChuc SMALLDATETIME NOT NULL DEFAULT GETDATE(),
    MaNhanVien INT NOT NULL
);
GO

CREATE TRIGGER TR_HoldPhongBan ON PhongBan 
FOR DELETE, UPDATE
AS
BEGIN
    INSERT INTO OLD_PhongBan
        (MaPhongBan,TenPhongBan, SoLuongNhanVien, NgayNhanChuc, MaNhanVien)
    SELECT MaPhongBan, TenPhongBan, SoLuongNhanVien, NgayNhanChuc, MaNhanVien
    FROM DELETED;
END;
GO
CREATE TABLE OLD_DuAn
(
    MaDuAn INT NOT NULL IDENTITY,
    TenDuAn NVARCHAR(100) NOT NULL,
    NgayBatDau SMALLDATETIME NOT NULL DEFAULT GETDATE(),
    NgayKetThuc SMALLDATETIME NOT NULL DEFAULT '25/04/2025',
    TrangThaiDuAn BIT NOT NULL DEFAULT 0,
    MoTa NTEXT NOT NULL,
);
GO

CREATE TRIGGER TR_HoldDuAn ON DuAn
INSTEAD OF DELETE, UPDATE
AS
BEGIN
    INSERT INTO OLD_DuAn (MaDuAn ,TenDuAn, NgayBatDau, NgayKetThuc, TrangThaiDuAn, MoTa)
    SELECT MaDuAn, TenDuAn, NgayBatDau, NgayKetThuc, TrangThaiDuAn, MoTa FROM DELETED;
END;
GO