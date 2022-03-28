package week4;


abstract class Student {
    String name;
    String branch;
    Height height;
    protected Student(String name,Height height) {
        this.name = name;
        this.height = height;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public Height getHeight() {
        return height;
    }
    public void setHeight(Height height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Name :"+name+" Height :" + height;
    }
}

class Height {
    int feet;
    int inches;

    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    public int getFeet() {
        return feet;
    }

    public void setFeet(int feet) {
        this.feet = feet;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }
    @Override
    public String toString() {
        return feet + " ft," + inches + "in.";
    }
    
}

class EEEStudent extends Student {
    public EEEStudent(String name, Height height) {
        super(name, height);
        this.branch = "Electrical";
    }
    @Override
    public String getBranch() {
        return branch;
    }

    @Override
    public void setBranch(String branch) {
        this.branch = branch;
    }
    @Override
    public String toString() {
        return super.toString()+ " Branch : " + branch;
    }
    
}
class ECEStudent extends Student {
    public ECEStudent(String name, Height height) {
        super(name, height);
        this.branch = "Electronics";
    }

    @Override
    public String getBranch() {
        return branch;
    }

    @Override
    public void setBranch(String branch) {
        this.branch = branch;
    }

        @Override
    public String toString() {
        return super.toString()+ " Branch : " + branch;
    }
    
}

class CSEStudent extends Student {

    public CSEStudent(String name, Height height) {
        super(name, height);
        this.branch = "Computer Application";
    }
    @Override
    public String getBranch() {
        return branch;
    }
    @Override
    public void setBranch(String branch) {
        this.branch = branch;
    }
    @Override
    public String toString() {
        return super.toString()+ " Branch : " + branch;
    }
}

class StudentAdministration {
    Student[] std;
    Student temp;
    static int itr = 0;
    boolean isPrinting = false;

    public StudentAdministration(Student[] std) {
        this.std = std;
    }

    public Student[] getStd() {
        return std;
    }

    public void setStd(Student[] std) {
        this.std = std;
    }

    public int compareByHeight(Student s1, Student s2) {
        if (s1.height.getFeet() == s2.height.getFeet()) {
            if (s1.height.getInches() < s2.height.getInches())
                return -1;
            else if (s1.height.getInches() > s2.height.getInches())
                return 1;
            else
                return 0;
        } else if (s1.height.getFeet() < s2.height.getFeet())
            return -1;
        else if (s1.height.getFeet() > s2.height.getFeet())
            return 1;
        else
            return 0;
    }

    public void sortByHeight(Student[] stds) {
        for (int i = 0; i < stds.length - 1; i++) {
            for (int j = 0; j < stds.length - i - 1; j++) {
                if (compareByHeight(stds[j], stds[j + 1]) == -1) {
                    temp = stds[j];
                    stds[j] = stds[j + 1];
                    stds[j + 1] = temp;
                }
            }
        }
    }

    //Display for EEE
    public void displayEEEStudents() {
        int k = 0;
        Student[] eeeStudent = new EEEStudent[3];
        for (int i = 0; i < this.std.length; i++) {
            if (this.std[i].getBranch().equals("Electrical"))
                eeeStudent[k++] = this.std[i];
        }
        sortByHeight(eeeStudent);
        k = 0;
        synchronized (this) {
            while (k < eeeStudent.length) {
                while (itr % 3 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(eeeStudent[k++]);
                itr++;
                notifyAll();
            }
        }
    }

    //Display for ECE
    public void displayECEStudents() {
        int k = 0;
        Student[] eceStudent = new ECEStudent[2];
        for (int i = 0; i < this.std.length; i++) {
            if (this.std[i].getBranch().equals("Electronics"))
                eceStudent[k++] = this.std[i];
        }
        sortByHeight(eceStudent);
        k = 0;
        synchronized (this) {
            while (k < eceStudent.length) {
                while (itr % 3 != 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(eceStudent[k++]);
                itr++;
                notifyAll();
            }
        }
    }

    //Display for CSE
    public void displayCSEStudents() {
        int k = 0;
        Student[] cseStudent = new CSEStudent[2];
        for (int i = 0; i < this.std.length; i++) {
            if (this.std[i].getBranch().equals("Computer Application"))
                cseStudent[k++] = this.std[i];
        }
        sortByHeight(cseStudent);
        k = 0;
        synchronized (this) {
            while (k < cseStudent.length) {
                while (itr % 3 != 2) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(cseStudent[k++]);
                itr++;
                notifyAll();
            }
        }
    }
}

public class UniversityDriver {
    public static void main(String[] args) {
        Student[] stds = new Student[7];
        stds[0] = new EEEStudent("ABC", new Height(5, 3));
        stds[1] = new EEEStudent("DEF", new Height(5, 6));
        stds[2] = new ECEStudent("GHI", new Height(6, 1));
        stds[3] = new ECEStudent("JKL", new Height(6, 3));
        stds[4] = new CSEStudent("MNO", new Height(5, 5));
        stds[5] = new EEEStudent("DEF", new Height(5, 11));
        stds[6] = new CSEStudent("PQR", new Height(5, 4));
        StudentAdministration stdAdmin = new StudentAdministration(stds);
        new Thread(){
            @Override
            public void run() {
                stdAdmin.displayEEEStudents();   // EEE Thread
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                stdAdmin.displayCSEStudents();   // ECE Thread
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                stdAdmin.displayECEStudents();  // CSE Thread
            }
        }.start();
    }
}
