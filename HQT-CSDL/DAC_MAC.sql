/***** Tạo SQL Server login ID *****/
CREATE LOGIN TN WITH PASSWORD='123', DEFAULT_DATABASE = QuanLyNhanVien;
GO
CREATE LOGIN NV WITH PASSWORD='456', DEFAULT_DATABASE = QuanLyNhanVien;
GO
CREATE LOGIN QL WITH PASSWORD='789', DEFAULT_DATABASE = QuanLyNhanVien;
GO
CREATE LOGIN QLServer WITH PASSWORD='666';
GO

USE QuanLyNhanVien;
GO

/***** Tạo user database cho login id ở database này *****/
CREATE USER TN;
GO
CREATE USER NV;
GO
CREATE USER QL;
GO

/***** Phân quyền theo mức Server *****/
GRANT CREATE ANY DATABASE, ALTER ANY DATABASE, VIEW ANY DATABASE TO QLServer;
GO

/***** Phân quyền theo mức Database *****/
-- Cấp quyền tạo Procedure, function, View cho QL và TN--
GRANT CREATE PROCEDURE, CREATE FUNCTION, CREATE VIEW TO QL, TN;
GO

GRANT CREATE DATABASE, CREATE SCHEMA, CREATE TABLE TO QL;
GO

/***** Phân quyền theo mức Schema *****/
-- Cấp các quyền khác cho Quản lý
GRANT SELECT, INSERT , UPDATE, DELETE ON SCHEMA :: dbo TO QL WITH GRANT OPTION;
GO

-- -- Thu hồi quyền của Quản lý
-- REVOKE SELECT, INSERT , UPDATE, DELETE ON SCHEMA :: dbo FROM QL CASCADE;
-- GO

/***** Phân quyền theo mức Object *****/
-- Cấp quyền cho Trưởng nhóm, chỉ cho phép query ở nhân viên
GRANT SELECT, INSERT, UPDATE, DELETE ON NhanVien TO TN WITH GRANT OPTION;
GO

GRANT SELECT ON DuAn TO TN WITH GRANT OPTION;
GO

-- Dùng Role để gán vai trò SELECT của Quản lý cho Trưởng nhóm
-- Thu hồi quyền đệ quy
REVOKE SELECT ON DuAn FROM TN CASCADE;
GO

--Từ chối quyền UPDATE,INSERT,DELETE với mọi nhân viên ở mọi bảng
DENY INSERT, UPDATE, DELETE TO NV;
GO


/***** Tạo user và tạo user define server role và thêm member *****/
USE master;
GO

CREATE USER Diep FOR LOGIN QLServer;
GO

CREATE SERVER ROLE QuanTriNhanVien AUTHORIZATION QLServer;
GO

GRANT ALTER ANY LOGIN TO QuanTriNhanVien;
GO

ALTER SERVER ROLE QuanTriNhanVien ADD MEMBER Diep;
GO

ALTER SERVER ROLE dbcreator ADD MEMBER QuanTriNhanVien;
GO

/***** Tạo user define database role và thêm member *****/
USE QuanLyNhanVien;
GO

CREATE USER Dong FOR LOGIN TN;
GO
CREATE USER Duc FOR LOGIN TN;
GO
CREATE USER Duy FOR LOGIN TN;
GO

CREATE ROLE ThemNhanVien AUTHORIZATION TN;
GO

GRANT INSERT, UPDATE ON NhanVien TO ThemNhanVien;
GO
GRANT INSERT, UPDATE ON Tinh TO ThemNhanVien;
GO
GRANT INSERT, UPDATE ON Quan TO ThemNhanVien;
GO
GRANT INSERT, UPDATE ON Phuong TO ThemNhanVien;
GO

ALTER ROLE ThemNhanVien ADD MEMBER Dong;
GO
ALTER ROLE ThemNhanVien ADD MEMBER Duc;
GO
ALTER ROLE ThemNhanVien ADD MEMBER Duy;
GO

ALTER ROLE db_datareader ADD MEMBER ThemNhanVien;
GO