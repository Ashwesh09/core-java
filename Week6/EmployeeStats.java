package Week6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee
{
    int id;
    String name; 
    int age;
    String gender; 
    String department;  
    int yearOfJoining;
    double salary;
      
    
    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() 
    {
        return id;
    }
      
    public String getName() 
    {
        return name;
    }
      
    public int getAge() 
    {
        return age;
    }
      
    public String getGender() 
    {
        return gender;
    }
      
    public String getDepartment() 
    {
        return department;
    }
      
    public int getYearOfJoining() 
    {
        return yearOfJoining;
    }
      
    public double getSalary() 
    {
        return salary;
    }
      
    @Override
    public String toString() 
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }
}
public class EmployeeStats {
    public static void main(String[] args) {
        Employee emp1 = new Employee(3, "Vishal Singhal", 34, "male", "HR", 2013, 300000);
        Employee emp2 = new Employee(4, "Amitabh Singh", 35, "male", "Admin", 2014, 500000);
        Employee emp3 = new Employee(5, "Vivek Bhati", 28, "male", "Admin", 2017, 500000);
        Employee emp4 = new Employee(6, "Vipul Diwan", 34, "male", "Account", 2014, 200000);
        Employee emp5 = new Employee(7, "Satish Kumar", 29, "male", "Account", 2017, 75000);
        Employee emp6 = new Employee(8, "Geetika Chauhan", 30, "female", "Admin", 2016, 90000);
        List<Employee> employees = Arrays.asList(emp1, emp2, emp3,emp4, emp5, emp6);
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting())));
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary))));
        System.out.println(employees.stream().max((e1, e2) -> (int)(e1.getSalary() - e2.getSalary())));
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getAge))));
        System.out.println(employees.stream().max((e1, e2) -> (e1.getYearOfJoining() - e2.getYearOfJoining())));
        System.out.println(employees.stream().min((e1, e2) -> (e1.getAge() - e2.getAge())));
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting())));
    }
}
