package task2;

import java.util.List;
import java.util.ArrayList;

public class ManageStudents{
    private static final ArrayList<Student> students = new ArrayList<>();


    public List<Student> getStudents() {return students;}

    public void viewStudent(int id) {
        students.stream().filter(student -> student.getID() == id).findAny().ifPresentOrElse(//findAny is a terminal operation — produces Optional<task2.Student>
                System.out::println,//Method reference instead of: student -> System.out.println(student),
                () -> System.out.println("No such student(id=" + id + ")"));
    }

    public void addStudent(Student student) {
        boolean exists = students.stream().anyMatch(s -> s.getID() == student.getID());

        if(exists) {
            System.out.println("task2.Student(id=" + student.getID() + ") already present.");
        }else {
            students.add(student);
            System.out.println("task2.Student(id=" + student.getID() + ") added successfully!");
        }
    }

    public void removeStudent(int id) {
        students.stream().filter(student -> student.getID() == id).findAny().ifPresentOrElse(//findAny is a terminal operation — produces Optional<task2.Student>
                student -> {students.remove(student); System.out.println("task2.Student(id=" + id + ") has been removed.");},
                () -> System.out.println("No such student(id=" + id + ")"));
    }

    public void viewAllStudents() {
        System.out.print("\nStudents:\n");
        for(Student student : students) System.out.println(student);
        System.out.println();
    }

    public static void main(String[] args) {
        //Create
        Student s1= new Student(1,1,"S1");
        Student s2= new Student(2,1,"S2");
        Student s3= new Student(3,1,"S3");

        ManageStudents manageStudents = new ManageStudents();
        manageStudents.addStudent(s1); manageStudents.addStudent(s2); manageStudents.addStudent(s3);
        manageStudents.viewAllStudents();

        //Replace
        //I don't believe we replace Student ID's in practical scenarios

        //Update
        s1.setID(11);

        //Delete
        manageStudents.removeStudent(3);
        manageStudents.viewStudent(3);


        manageStudents.viewAllStudents();
    }
}