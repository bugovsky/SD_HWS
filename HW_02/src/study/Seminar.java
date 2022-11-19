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

    public ArrayList<Student> getListOfStudentWithMarks() {
        ArrayList<Student> studentsWithMarks = new ArrayList<>();
        for (Student student : this.students.keySet()) {
            if (this.students.get(student) != null) {
                studentsWithMarks.add(student);
            }
        }
        return studentsWithMarks;
    }

    public Map<Student,Integer> getStudentsAndMarks() {
        Map<Student, Integer> studentsWithMarks = new HashMap<>();
        for (Student student : this.students.keySet()) {
            if (this.students.get(student) != null) {
                studentsWithMarks.put(student, this.students.get(student));
            }
        }
        return studentsWithMarks;
    }
}
