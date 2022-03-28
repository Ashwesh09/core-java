package Week5.CollectionsInJava;

import java.util.*;
import java.util.stream.*;
class Student {
    private String name;
    private int id;
    private String subject;

    double percentage;

    public Student(String name, int id, String subject, double percentage) {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return name + "-" + id + "-" + subject + "-" + percentage;
    }
}
public class StudentStaticstics {
    public static void main(String[] args) {
        Student student1 = new Student("Dinesh", 1, "Algorithms", 75);
        Student student2 = new Student("Arnav", 2, "Automata", 55);
        Student student3 = new Student("Anamika", 3, "Databases", 80);
        Student student4 = new Student("Vishal", 4, "Networking", 40);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        Map<Boolean, List<Student>> stdsLessThanSixty = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getPercentage() > 60));
        System.out.println("Students less < 60 are: \n" + stdsLessThanSixty);
        List<Student> top3 = students.stream().sorted((st1, st2) -> (int) (st2.getPercentage() - st1.getPercentage()))
                .limit(3).toList();
        System.out.println("Top 3 students are: " + top3);
        Map<String, Double> nameAndperc = students.stream()
                .collect(Collectors.toMap(Student::getName, Student::getPercentage));
        System.out.println("Students with marks:" + nameAndperc);
        Set<String> subjects = students.stream().map(Student::getSubject).collect(Collectors.toSet());
        System.out.println("Subjects are : " + subjects);
        System.out.println(
                "Highest Marks : " + students.stream().mapToDouble(Student::getPercentage).max().getAsDouble());
        System.out
                .println("Lowest Marks : " + students.stream().mapToDouble(Student::getPercentage).min().getAsDouble());
        System.out.println(
                "Average Marks : " + students.stream().mapToDouble(Student::getPercentage).average().getAsDouble());
        System.out.println("Total students are: " + students.size());
        Map<String, Student> groupingBySubject = students.stream().collect(Collectors.toMap(Student::getSubject, s->s));
        System.out.println("Students with based on subject: " + groupingBySubject);
    }
}
