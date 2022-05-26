use quanlysinhvien;

select * 
from subject
where Credit = (select max(Credit) from subject);

select subject.SubId,SubName,Credit,Status
from subject join mark on subject.SubId = mark.SubId
where Mark = (select max(Mark) from mark);

select student.StudentId, StudentName, Address, Phone, Mark
from student join mark on student.StudentId=mark.StudentId 
order by Mark