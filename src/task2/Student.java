package task2;

public class Student {
    private int id, marks;
    private String name;


    Student(int id, int marks, String name) {
        this.id = id;
        this.marks = marks;
        this.name = name;
    }


    public int getID() {return id;}
    public void setID(int id) {
        if (id < 0) {System.out.println("Student ID cannot be negative"); return;}
        if(this.getID() == id) {System.out.println("Student ID is the same"); return;}
        System.out.println("Student's ID(" + this.getID() + ") is set to " + id);
        this.id = id;
    }

    public int getMarks() {return marks;}
    public void setMarks(int marks) {
        if(this.getMarks() == marks) {System.out.println("Marks are the same"); return;}
        this.marks = marks;
    }

    public String getName() {return name;}
    public void setName(String name) {
        if(this.getName().equals(name)) {System.out.println("Name is the same"); return;}
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student s)
            return s.getID() == this.id;//<<Pattern variable>> instead of: if(obj instanceof task2.Student){ task2.Student s = (task2.Student) obj; return s.getID() == this.id;}
        return false;
    }

    @Override
    public String toString() {
        return "task2.Student [id=" + id + ", marks=" + marks + ", name=" + name + "]";
    }
}