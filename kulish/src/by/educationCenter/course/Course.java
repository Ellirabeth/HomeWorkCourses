package by.educationCenter.course;

import by.educationCenter.IEducationCenter;
import by.student.AdultStudent;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

public class Course {
    @Getter
    private int studentLimitCount;

    @Getter
    IEducationCenter educationCenter;

    @Setter @Getter
    String subject;

    @Getter
    @Setter
    int weekNumber;

    @Getter
    @Setter
    private Collection<AdultStudent> studentList;

    public Course(IEducationCenter educationCenter, String subject, int weekNumber, int studentLimitCount) {
        this.educationCenter = educationCenter;
        this.studentLimitCount = studentLimitCount;
        this.subject = subject;
        this.weekNumber = weekNumber;
        studentList = new ArrayList<>(studentLimitCount);
    }

    public void printStudents() {
        if(studentList.size() > 0) {
            System.out.printf("has student %d people\n", studentList.size());
        } else {
            System.out.println("no students yet");
        }
    }

    public void printResult() {
        System.out.printf("studentCount = %d student(s)\n", getStudentLimitCount());
    }

}
