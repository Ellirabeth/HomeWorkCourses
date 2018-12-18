package by.educationCenter;

import by.educationCenter.course.Course;
import by.pattern.IStudentIterator;
import by.student.AdultStudent;
import by.student.Student;

import java.util.ArrayList;
import java.util.List;

public class HqStudentIterator implements IStudentIterator {
    private int curIndex = 0;
    private List<Student> list = new ArrayList<>();

    public HqStudentIterator(IEducationCenter educationCenter, double averageGradePoint) {
        list.clear();
        for (Course course : educationCenter.getCourseList()) {
            for (AdultStudent student : course.getStudentList()) {
                if (student.getAverageGradePoint() >= averageGradePoint) {
                    list.add(student);
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return curIndex < list.size();
    }

    @Override
    public Student getNext() {
        if (curIndex >= list.size()) {
            return null;
        }
        return list.get(curIndex++);
    }

    @Override
    public void reset() {
        curIndex = 0;
    }
}
