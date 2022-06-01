/* Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt
 đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.*/
 use  QuanLynghiduongFurama;
 
SELECT
	*
FROM
	nhan_vien
WHERE
	SUBSTRING_INDEX(ho_ten, ' ', - 1)
	REGEXP '^[HTK]'
	AND LENGTH(ho_ten) <= 25;
    
select * from khach_hang 
where YEAR(now()) - YEAR(ngay_sinh) between 18 and 50 
AND (dia_chi like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%');

select  ho_ten, count(ho_ten) as so_lan_dat_phong
from khach_hang 
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where ten_loai_khach = 'diamond'
group by khach_hang.ma_khach_hang
order by so_lan_dat_phong;







