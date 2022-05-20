create database IF NOT exists QuanLyBanHang;

use QuanLyBanHang;

create table IF NOT exists Customer(
cID int primary key,
cName varchar(50),
cAge int
);

create table IF NOT exists `Order` (
oID int primary key,
oDate datetime,
oTotalPrice double,
cID int,
foreign key(cID) references Customer(cID) 
);

create table IF NOT exists Product (
pID int primary key,
pName varchar(50),
pPrice double
);

create table IF NOT exists OrderDetail(
oID int,
pID int,
odQTY int,
foreign key(oID) references `Order`(oID),
foreign key(pID) references Product(pID)
);