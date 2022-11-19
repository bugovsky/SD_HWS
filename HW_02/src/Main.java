import study.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static void askStudents(ArrayList<Student> groupList, Seminar seminar) {
        ArrayList<Student> absentStudents = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter help if you need instructions\nElse ask students");
        System.out.print("\nEnter command: ");
        String command = input.nextLine();
        while (!"end".equalsIgnoreCase(command)) {
            switch (command.toLowerCase()) {
                case "help" -> System.out.println("""
                        1. ask - ask student
                        2. list - print list of students with marks
                        3. end - end of lesson""");
                case "ask" -> {
                    int studentNumber = (int) (Math.random() * groupList.size());
                    Student chosenStudent = groupList.get(studentNumber);
                    while (seminar.getMark(chosenStudent) != null || absentStudents.contains(chosenStudent)) {
                        studentNumber = (int) (Math.random() * groupList.size());
                        chosenStudent = groupList.get(studentNumber);
                    }
                    System.out.println("Student " + chosenStudent.getName() + " answers");
                    System.out.println("Is the student present?");
                    command = input.nextLine();
                    while (!"y".equalsIgnoreCase(command) && !"n".equalsIgnoreCase(command)) {
                        System.out.println("""
                                Wrong command!
                                Enter y or Y, if student is present
                                Else print n or N""");
                        command = input.nextLine();
                    }
                    if ("y".equalsIgnoreCase(command)) {
                        int mark = (int) Math.round(Math.random() * 10);
                        System.out.println("Student's mark: " + mark);
                        seminar.setMark(chosenStudent, mark);
                    } else {
                        System.out.println("Student is absent");
                        absentStudents.add(chosenStudent);
                    }
                }
                case "list" -> {
                    Map<Student, Integer> studentsWithMarks = seminar.getStudentsAndMarks();
                    for (Student student : studentsWithMarks.keySet()) {
                        System.out.println(student.getName() + " - " + studentsWithMarks.get(student));
                    }
                    if (studentsWithMarks.isEmpty()) {
                        System.out.println("There is no students with marks");
                    }
                }
                default -> System.out.println("Wrong command!");
            }
            if (absentStudents.size() == groupList.size()) {
                System.out.println("\nThere are no students at lesson.. it doesn't seems right");
                break;
            }
            if (seminar.getListOfStudentWithMarks().size() + absentStudents.size() == groupList.size()) {
                System.out.println("\nAll students got marks");
                Map<Student, Integer> studentsWithMarks = seminar.getStudentsAndMarks();
                for (Student student : studentsWithMarks.keySet()) {
                    System.out.println(student.getName() + " - " + studentsWithMarks.get(student));
                }
                break;
            }
            System.out.print("\nEnter command: ");
            command = input.nextLine();
        }
        System.out.println("\nThe seminar is over");
    }
    public static void main(String[] args) {
        ArrayList<Student> groupList = new ArrayList<>();
        groupList.add(new Student("John"));
        groupList.add(new Student("Andrew"));
        groupList.add(new Student("Mary"));
        groupList.add(new Student("Peter"));
        groupList.add(new Student("Ivan"));
        groupList.add(new Student("Tony"));
        groupList.add(new Student("Ryan"));
        groupList.add(new Student("Tyler"));
        groupList.add(new Student("Christian"));
        groupList.add(new Student("Tomas"));
        Seminar seminar = new Seminar(groupList,1);
        askStudents(groupList, seminar);
    }
}
