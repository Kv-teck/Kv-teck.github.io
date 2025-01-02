create database hethongquanly;

drop DATABASE hethongquanly;

use hethongquanly;
create table Students
(
    id         integer primary key auto_increment,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    birth_date DATE,
    email      VARCHAR(100)
);

create table Courses
(
    id                 integer primary key auto_increment,
    course_name        VARCHAR(100),
    course_description TEXT
);

create table Enrollments
(
    id              integer primary key auto_increment,
    student_id      INT,
    course_id       INT,
    enrollment_date DATE,
    first_name      int not null
);


insert into Students
(first_name, last_name, birth_date, email)
VALUES ('khiet', 'thanh', '2003-05-28', 'khiet@gmail.com'),
       ('khiet', 'thanh', '2003-05-28', 'khiet@gmail.com'),
       ('khiet', 'thanh', '2003-05-28', 'khiet@gmail.com'),
       ('khiet', 'thanh', '2003-05-28', 'khiet@gmail.com'),
       ('khiet', 'thanh', '2003-05-28', 'khiet@gmail.com');

select *
from Students;

insert into Courses
(course_name, course_description)
values ('001', 'lopjava'),
       ('002', 'lopC++'),
       ('003', 'lopC#');

select *
from Courses;

alter table Enrollments
    add foreign key (student_id) references Students (id);
alter table Enrollments
    add foreign key (course_id) references Courses (id);

insert into Enrollments(student_id, course_id, enrollment_date)
VALUES (1, 1, '2024-12-05'),
       (1, 2, '2024-10-05'),
       (1, 3, '2024-09-05'),
       (2, 1, '2024-08-05'),
       (3, 2, '2024-07-05');

select *
from Enrollments;

# Truy vấn dữ liệu:
select first_name, last_name, email
from Students;
select course_name, course_description
from Courses;

select *
from Students
where birth_date > '2000-01-01'
  AND email LIKE '%example%';

# Cập nhật dữ liệu:

update Students
set email = 'vukhiet@gmail.com'
where id = 1;

select *
from Students;

update Courses
set course_description = 'Lập Trình Cơ Bản'
where id = 1;

select *
from Courses;

# Xóa dữ liệu:
delete
from Students
where id not in (select student_id from Enrollments);

select * from Students;

delete
from Courses
where id not in (select course_id from Enrollments);

select * from Courses;


