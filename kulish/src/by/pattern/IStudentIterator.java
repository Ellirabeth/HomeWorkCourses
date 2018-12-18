package by.pattern;

import by.student.Student;

public interface IStudentIterator {
    boolean hasNext();

    Student getNext();

    void reset();
}