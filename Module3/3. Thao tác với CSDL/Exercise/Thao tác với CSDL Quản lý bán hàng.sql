use quanlybanhang;

insert into customer(cName, cAge)
value ('Minh Quan', 10),
		('Ngoc Oanh', 20),
		('Hong Ha', 50);
        
insert into orderproduct(cID, oDate, oTotalPrice)
values	(1,'2006/3/21 00:00:00',12500),
		(2,'2006/3/21 00:00:00',15600),
        (1,'2006/3/21 00:00:00',11370);

insert into product(pName,pPrice)
value ('May Giat',3),
('Tu Lanh',5),
('dieu hoa', 3),
		('quat', 3),
		('bep dien', 3);
        
        
insert into orderdetail(oID,pID, odQTY)
values 	(1,1,3),
		(1,3,3),
		(2,4,3),
		(3,1,3),
		(2,2,3),
		(3,5,3);
        
select oID, oDate, oTotalPrice
from quanlybanhang.orderproduct;

select distinct customer.cID, cName, cAge, pName
from customer join orderproduct on customer.cID = orderproduct.cID
 join orderdetail on orderproduct.oID = orderdetail.oID join product 
 on orderdetail.pID = product.pID; 
 
 select *
 from customer left join quanlybanhang.orderproduct on customer.cID = oderproduct.cID where oID is null;
 
 





        

