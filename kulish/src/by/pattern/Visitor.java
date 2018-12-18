package by.pattern;

import by.object.People;
import by.student.AdultStudent;
import by.student.Student;

/**
 * Реализация класса посетитель
 */
public class Visitor {

    public void visit(People people) {
//        if (people instanceof Student) {
//            System.out.println("student " + people);
//        } else {
            System.out.println("people: " + people);
//        }
    }

    public void visit(Student student) {
        System.out.println("student: " + student);
    }

    public void visit(AdultStudent student) {
        System.out.println("adult student: " + student);
    }
}
