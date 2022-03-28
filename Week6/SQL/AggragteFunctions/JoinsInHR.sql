use hr;

---Q1.
SELECT d.Department_name,l.location_id, l.street_address,l.city,l.state_province,(SELECT Country_name from countries where country_id = l.country_id) as Country
from departments d inner join locations l 
using (location_id);

---Q2.
SELECT concat(first_name," ",last_name) as Name, Department_id, Department_name 
from employees inner join departments 
using (DEPARTMENT_ID);

---Q3.
SELECT concat(first_name," ",last_name) as Name ,(SELECT job_title from jobs where job_id = e.job_id) as JOB, department_id 
from employees e inner join departments d
using (department_id)
Where d.location_id = (Select location_id from locations where city = 'London');


---Q4.
SELECT e1.employee_id,e1.last_name , e1.manager_id , e2.last_name
from employees e1
INNER JOIN employees e2
ON e1.manager_id = e2.employee_id; 

---Q5.
select CONCAT(first_name, " ", last_name) as name,hire_date
from employees 
where hire_date > (select hire_date FROM employees where last_name="Jones");

---Q6.
SELECT COUNT(department_id) as `No of Employees`, department_name 
from employees 
inner join departments 
using (department_id)
GROUP BY DEPARTMENT_ID;


---Q7.
SELECT Employee_id, job_title, (DAY(end_date) - DAY(start_date)) as `No of Days` 
from job_history e
inner join jobs
using (job_id)
where department_id = 90; 


---Q8.
SELECT e1.department_id,CONCAT(e1.first_name, " ",e1.last_name) as name, e2.first_name 
from employees e1 inner join
employees e2 on e1.manager_id=e2.employee_id;

---Q9.
SELECT department_name,CONCAT(first_name, " ",last_name) as manager,city 
from employees e
inner join departments d 
using(department_id) 
inner join locations
using(location_id) 
where e.employee_id=d.manager_id;

---Q10.
SELECT job_title, AVG(salary) as Avg_salary
FROM employees
inner join jobs using (job_id) 
group by job_id;

---Q11.
SELECT job_title,CONCAT(first_name, " ",last_name) as `Name`, (salary - min_salary) as Diff_In_Sal 
FROM employees inner join jobs 
using (job_id);

---Q12.
SELECT CONCAT(first_name, " ",last_name)as Name,job_history.* FROM job_history
INNER JOIN employees
using (job_id)
WHERE salary > 10000;


---Q13.
SELECT department_name,CONCAT(first_name, " ",last_name) as Name, hire_date, salary
FROM employees
INNER JOIN departments d
using (department_id)
WHERE (NOW() - YEAR(Hire_Date)) > 15
AND employee_id=d.manager_id;



SELECT Salary from employees e1 WHERE 9 = (SELECT DISTINCT COUNT(salary) from employees e2 WHERE e2.salary > e1.salary);

SELECT DISTINCT Salary from Employees order by salary DESC Limit 1 offset 7;



select CONCAT(e2.first_name, " ",e2.last_name) as name
from employees e1 inner join
employees e2 on e1.manager_id=e2.employee_id;


SELECT CONCAT(first_name, " ",last_name) from employees where manager_id IS NULL;