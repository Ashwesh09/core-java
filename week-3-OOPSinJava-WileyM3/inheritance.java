class Person extends Object {
    String name;

    Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }
}

class Employee extends Person {

    double salary;
    int yearOfJoining;
    String UAN;

    Employee(String name, double salary, int yearOfJoining, String UAN) {
        super(name);
        this.salary = salary;
        this.yearOfJoining = yearOfJoining;
        this.UAN = UAN;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getyearOfJoining() {
        return yearOfJoining;
    }
    public void setyearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }
    public String getUAN() {
        return UAN;
    }

    public void setUAN(String UAN) {
        this.UAN = UAN;
    }
    @Override
    public String toString() {
        return "Employee [Name="+name+" UAN=" + UAN + ", salary=" + salary + ", yearOfJoining=" + yearOfJoining + "]";
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
        if (UAN == null) {
            if (other.UAN != null)
                return false;
        } else if (!UAN.equals(other.UAN))
            return false;
        if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
            return false;
        if (yearOfJoining != other.yearOfJoining)
            return false;
        return true;
    }
    
}


public class inheritance {
    public static void main(String[] args) {
        Person p = new Person("Ajit");
        Employee e1 = new Employee("Ashwesh",23650.15,2022,"IND123");
        Employee e2 = new Employee("Ashwesh",23650.15,2022,"IND123");
        if (e1.equals(p)) {
            System.out.println("Yes p & e1 they are equal.");
        }
        else if (e2.equals(p)) {
            System.out.println("Yes p & e2 they are equal.");
        }
        else if (e2.equals(e1)) {
            System.out.println("Yes e1 and e2 are equal.");
        }
        else {
            System.out.println("No object is equal");
        }
        System.out.println("Information e1:\n" + e1.toString() + "\nInformation e2:\n" + e2.toString()
                + "\nInformation p:" + p.toString()); //Print all details
         
    }
}

