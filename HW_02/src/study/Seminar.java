package study;

import java.util.*;

public class Seminar {
    private final Map<Student, Integer> students;
    private final int number;
    public Seminar(ArrayList<Student> students, int number) {
        this.students = new HashMap<>();
        for (Student student : students) {
            this.students.put(student, null);
        }
        this.number = number;
    }

    public void setMark(Student student, int mark) {
        this.students.put(student, mark);
    }
    public Integer getMark(Student student) {
        return this.students.get(student);
    }

    public void getStudentWithMarks() {
        boolean hasStudentWithMark = false;
        for (Student student : this.students.keySet()) {
            if (this.students.get(student) != null) {
                hasStudentWithMark = true;
                System.out.println(student.getName() + " - " + getMark(student));
            }
        }
        if (!hasStudentWithMark) {
            System.out.println("There are no students with mark");
        }
    }
    public ArrayList<Student> getListOfStudentWithMarks() {
        ArrayList<Student> studentsWithMarks = new ArrayList<>();
        for (Student student : this.students.keySet()) {
            if (this.students.get(student) != null) {
                studentsWithMarks.add(student);
            }
        }
        return studentsWithMarks;
    }
}
