 use  QuanLynghiduongFurama;
 /* 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt
 đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.*/
SELECT
	*
FROM
	nhan_vien
WHERE
	SUBSTRING_INDEX(ho_ten, ' ', - 1)
	REGEXP '^[HTK]'
	AND LENGTH(ho_ten) <= 25;
 /* 3.	Hiển thị thông tin của tất cả
 khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/   
select * from khach_hang 
where YEAR(now()) - YEAR(ngay_sinh) between 18 and 50 
AND (dia_chi like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%');

 /* 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp 
 xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.	*/  
select  ho_ten, count(ho_ten) as so_lan_dat_phong
from khach_hang 
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where ten_loai_khach = 'diamond'
group by khach_hang.ma_khach_hang
order by so_lan_dat_phong;

 /*5. 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong,
 ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, 
 với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
 cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).	 */  
select khach_hang.ma_khach_hang, ho_ten, ten_loai_khach,hop_dong.ma_hop_dong,ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, sum(chi_phi_thue + gia*so_luong) as so_tien
from khach_hang 
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by ma_hop_dong;

 /*	6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ
 chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).*/  
select ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
from dich_vu 
join loai_dich_vu on dich_vu.ma_loai_dich_vu= loai_dich_vu.ma_loai_dich_vu
 where not exists (select ma_dich_vu from hop_dong
 where (hop_dong.ngay_lam_hop_dong between "2021-01-01" and "2021-03-31") and hop_dong.ma_dich_vu= dich_vu.ma_dich_vu);
 
  /*7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue,
  ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách
  hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021. */  
 select hop_dong.ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
from hop_dong 
join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu= loai_dich_vu.ma_loai_dich_vu
where exists(select ngay_lam_hop_dong from hop_dong where year(ngay_lam_hop_dong)= 2020 and hop_dong.ma_dich_vu= dich_vu.ma_dich_vu )
and not exists(select ngay_lam_hop_dong from hop_dong where year(ngay_lam_hop_dong)= 2021 and hop_dong.ma_dich_vu= dich_vu.ma_dich_vu );

 /* 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau*/  
select ho_ten
from khach_hang
group by ho_ten;

select ho_ten
from khach_hang
union
select ho_ten
from khach_hang;

select distinct ho_ten
from khach_hang;






