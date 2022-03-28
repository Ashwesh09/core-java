class Student{
     private int rollNo;
     private String name;

     Student() {                                 
         this.rollNo = 0;
         this.name = "Student";
     }
     
     Student(int r) {                           
        this.rollNo = r;
    }

    Student(String name) {
        this.name = name;
    }
    
    Student(int r, String name) {
        this.rollNo = r;
        this.name = name;
    }

    // copy constructor  
    Student(Student s) {
        this.rollNo = s.rollNo;
        this.name = s.name;
    }

    void display(Student s) {                
        System.out.print("Name:" + s.name +
            "\nRoll No:" + s.rollNo);
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + "]";
    }

    
}
public class ConstructorOverldCopyConstr {
    public static void main(String[] args) {
        Student s2 = new Student(4);
        Student s3 = new Student("Peter Parker");
        Student s4 = new Student(3,"Ashwesh");
        s4.setName("Keanu Reeves");
        s4.setRollNo(21);
        System.out.println("Name of student with getName method:" + s3.getName()
                + "\nRoll no of student with get Roll no method:" + s2.getRollNo());
        s4.display(s4);

        Student s5 = new Student(s4);
        System.out.println("Details of student-4:: " + s4);
        System.out.println("Details of student-5:: " + s5);

    }
}
