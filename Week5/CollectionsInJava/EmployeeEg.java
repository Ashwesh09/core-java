package Week5.CollectionsInJava;

import java.util.*;
class Employee implements Comparable<Employee>{
    protected long   employeeId;
    protected String firstName;
    protected String lastName;
    
    public Employee(long employeeId, String firstName, String lastName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (employeeId ^ (employeeId >>> 32));
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        return result;
    }

    @Override
    public int compareTo(Employee other){  
        if(this.employeeId > other.employeeId)
            return 1;
        else if (this.employeeId < other.employeeId)
            return -1;
        else 
            return 0;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (employeeId != other.employeeId)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\nEmployee Id : " + employeeId + "  Full Name : " + firstName + " " + lastName;
    }
    
}

public class EmployeeEg {
    public static void main(String[] args) {
        Employee e1 = new Employee(1232131,"ABC", "XYZ");
        Employee e2 = new Employee(1232132,"DEF", "UVW");
        Employee e3 = new Employee(1232133,"GHI", "RST");
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.forEach(System.out::println);
        Employee eSample1 = new Employee(1232131, "ABC", "XYZ");
        for (Employee e : employees) {
            if (e.equals(e1))
                System.out.println("\nEmployess" + e + "\nis equal to" + eSample1);
        }
        if (e1.compareTo(eSample1) == 1) 
            System.out.println("e1 id greater that eSample1");
        else if(e1.compareTo(eSample1) == -1)
            System.out.println("e1 id lesser that eSample1");
        else 
            System.out.println("e1 id is equal to eSample1");
        Employee[] eArr = new Employee[5];
        for(int i=0; i<5; i++)
            eArr[i] = new Employee((long) (Math.random() * ((50 - 1) + 1)), "ABC", "XYZ");
        System.out.println("Before sort:");
        for (Employee e : eArr) {
            System.out.print(e.getEmployeeId()+ " ");
        }
        for (int i = 0; i < eArr.length; i++) {
            for (int j = 0; j < eArr.length -i- 1; j++) {
                if (eArr[j].compareTo(eArr[j + 1]) == 1) {
                    Employee temp = eArr[j];
                    eArr[j] = eArr[j + 1];
                    eArr[j + 1] = temp;
                }
            }
        }
        System.out.println("\nAfter sort:");
        for (Employee e : eArr) {
            System.out.println(e);
        }
        }
    }
