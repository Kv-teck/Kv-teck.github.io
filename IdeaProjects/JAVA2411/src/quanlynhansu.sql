create DATABASE quanlynhansu;

use quanlynhansu;
CREATE TABLE departments
(
    department_id   INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    location        VARCHAR(100) NOT NULL
);

INSERT INTO departments (department_id, department_name, location)
VALUES (1, 'IT', 'Hà Nội'),
       (2, 'HR', 'TP. Hồ Chí Minh'),
       (3, 'Finance', 'Đà Nẵng');

CREATE TABLE employees
(
    employee_id   INT PRIMARY KEY,
    name          VARCHAR(100)   NOT NULL,
    position      VARCHAR(50)    NOT NULL,
    salary        DECIMAL(10, 2) NOT NULL,
    department_id INT,
    hire_date     DATE           NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments (department_id)
);

INSERT INTO employees (employee_id, name, position, salary, department_id, hire_date)
VALUES (1, 'Nguyễn Văn A', 'Developer', 1500, 1, '2020-05-01'),
       (2, 'Trần Thị B', 'Tester', 1200, 1, '2021-03-15'),
       (3, 'Lê Văn C', 'Developer', 1500, 2, '2019-08-10'),
       (4, 'Nguyễn Thị D', 'Project Manager', 2500, 2, '2020-01-20'),
       (5, 'Phạm Văn E', 'Tester', 1300, 3, '2021-07-12'),
       (6, 'Hoàng Thị F', 'Developer', 1400, 3, '2022-09-01'),
       (7, 'Đặng Văn G', 'Developer', 1500, 1, '2022-05-20'),
       (8, 'Nguyễn Văn H', 'Developer', 2000, 2, '2018-12-15');


-- c1
select d.department_name, sum(emp.salary)
from employees emp
         inner join departments d on emp.department_id = d.department_id
group by emp.department_id;
-- c2: Lọc các phòng ban có tổng lương lớn hơn 3000:
select d.department_name, sum(emp.salary) total_salary
from employees emp
         inner join departments d on emp.department_id = d.department_id
group by emp.department_id
having total_salary > 3000;
-- c3: Lấy danh sách vị trí công việc duy nhất:
select distinct employees.position
from employees;
-- c4 Lấy 3 nhân viên đầu tiên, bỏ qua 2 nhân viên đầu tiên,
/*
 offset: bắt đầu tu index nao
 limit: gioi han bao nhieu ban ghi
 */
select *
from employees
limit 3 offset 2;
-- c5 Tìm nhân viên có tên chứa “Nguyễn”:
select *
from employees
where name like '%Nguyễn%';
-- c6 Tính tổng và trung bình lương của toàn bộ nhân viên
/*
sum: tính tổng
avg: tính trung bình
 */
select sum(employees.salary) total_salary, avg(employees.salary)
from employees;
-- c7 Lấy danh sách nhân viên và tên phòng ban của họ
select emp.name, dept.department_name
from employees emp
         inner join departments dept on emp.department_id = dept.department_id;

-- c8 Lấy danh sách tất cả phòng ban và nhân viên của phòng ban đó (nếu có):
select dept.department_name, emp.name
from departments dept
         left join employees emp
                   on dept.department_id = emp.department_id;

-- 10 Tìm các nhân viên có cùng mức lương
select distinct emp.salary, emp.name
from employees emp
         inner join employees emp_same_salary on emp.salary = emp_same_salary.salary
    and emp_same_salary.employee_id != emp.employee_id;

-- 11 Tìm phòng ban có nhiều nhân viên nhất và tổng lương của phòng ban đó
select dept.department_name, count(emp.employee_id), sum(emp.salary)
from departments dept
         inner join employees emp on dept.department_id = emp.department_id
group by dept.department_name
order by count(emp.employee_id) desc
limit 1;

-- 12 Tìm nhân viên có mức lương cao nhất trong mỗi phòng ban
select dept.department_name, max(emp.salary)
from departments dept
         inner join employees emp on dept.department_id = emp.department_id
group by dept.department_name;


-- 13 Tính mức lương trung bình của từng vị trí công việc, chỉ hiển thị các vị trí có lương trung bình lớn hơn 1500
select dept.department_name, emp.position, avg(emp.salary)
from departments dept
         inner join employees emp on dept.department_id = emp.department_id
group by dept.department_name, emp.position

having avg(emp.salary) > 1500;
-- 14 Lấy danh sách nhân viên và đồng nghiệp cùng phòng ban (không bao gồm chính họ)
select distinct emp.name, dept.department_name
from departments dept
         inner join employees emp on dept.department_id = emp.department_id
group by emp.name, dept.department_name;


-- 15 Tính tổng số năm kinh nghiệm của mỗi phòng ban


-- 16 Tìm nhân viên được tuyển dụng sớm nhất trong mỗi phòng ban, bao gồm cả tên và ngày tuyển dụng


-- 17 Tìm phòng ban có tổng lương lớn nhất và hiển thị tên nhân viên, lương và phòng ban đó
select dept.department_name, emp.name, emp.salary
from departments dept
         inner join employees emp on dept.department_id = emp.department_id
where dept.department_id = (select department_id
                            from employees
                            group by department_id
                            order by sum(salary) desc
                            limit 1);

/* 18 Phân nhóm nhân viên theo bậc lương (ví dụ: < 1500, 1500-2000, > 2000) và
   tính tổng số nhân viên trong từng nhóm/-strong/-heart:>:o:-((:-h Sử dụng CASE và GROUP BY:*/


-- 19 Tìm nhân viên có tổng số lương cao nhất trong tất cả các phòng ban (bao gồm cả tên phòng ban)


-- 20 Tìm tên nhân viên có lương cao hơn mức lương trung bình của phòng ban mà họ làm việc


