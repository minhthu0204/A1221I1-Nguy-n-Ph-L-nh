USE QuanLySinhVien;

select StudentName
from student
where StudentName like "h%";

select *
from class
where StartDate like "_____12%";

select *
from subject
where Credit between 3 and 5 ;

update student 
set classID = '2' where studentName = 'Hung';


select  s.StudentName, sub.SubName, m.Mark
from student s  join mark m  on s.StudentId = m.StudentId join subject sub  on m.SubId = sub.SubId
order by m.Mark desc, s.StudentId ;