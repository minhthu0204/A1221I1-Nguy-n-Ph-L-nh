create database IF NOT exists QuanLyBanHang;

use QuanLyBanHang;

create table IF NOT exists Customer(
cID int not null auto_increment primary key,
cName varchar(50),
cAge int
);

create table IF NOT exists OrderProduct (
oID int not null auto_increment primary key,
oDate datetime,
oTotalPrice double,
cID int,
foreign key(cID) references Customer(cID) 
);

create table IF NOT exists Product (
pID int not null auto_increment primary key,
pName varchar(50),
pPrice double
);

create table IF NOT exists OrderDetail(
oID int not null,
pID int not null,
odQTY int not null,
foreign key(oID) references  OrderProduct(oID),
foreign key(pID) references Product(pID)
);