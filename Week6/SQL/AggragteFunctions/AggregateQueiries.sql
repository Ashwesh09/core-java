use hr;

--Q1.
SELECT COUNT(DISTINCT job_ID) as `No of jobs available`FROM employees;

--Q2.
SELECT SUM(Salary) as Salary_Payable FROM employees;

--Q3.
SELECT MIN(Salary) as Min_salary from employees;

--Q4.
SELECT MAX(Salary) as Max_salary_Of_Prog from employees WHERE job_Id LIKE '%PROG';

--Q5.
SELECT AVG(Salary)as AVG_Salary ,COUNT(DEPARTMENT_ID) as WORKING_IN_90 FROM employees WHERE DEPARTMENT_ID = 90;

---Q6.
SELECT MAX(Salary) as MAX_SAL, MIN(Salary) as MIN_SAL, SUM(Salary) as SUM_SAL, AVG(Salary) as AVG_SAL from employees;

--Q7.
SELECT COUNT(job_Id) as No_of_Employees, job_id as JOB FROM employees group by job_Id;

---Q8.
SELECT (MAX(Salary) - MIN(Salary) ) as Diff_MAX_MIN from employees;

---Q9.
SELECT MANAGER_ID, Salary as Lowest_paid_emp 
from employees e1 
GROUP BY manager_id;
 
---Q10.
SELECT department_id,SUM(Salary) as Salary_Payable 
FROM employees
GROUP BY department_id;