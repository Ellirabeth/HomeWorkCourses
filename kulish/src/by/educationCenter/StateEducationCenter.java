package by.educationCenter;

import by.educationCenter.course.Course;
import by.educationCenter.course.CourseBuilder;
import by.educationCenter.course.CourseType;
import by.pattern.IStudentIterator;
import by.student.AdultStudent;
import by.student.Student;
import by.utility.RandomLife;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class StateEducationCenter implements IEducationCenter {

    @Getter
    List<Course> courseList = new ArrayList<>();

    @Override
    public Course createCourse() {
        return new CourseBuilder().reset().setEducationCenter(this).setDurationWeek(5).setSubject("Programmng").setCourseType(CourseType.Free)
                .setStudentLimitCount(RandomLife.RandomPeople()).build();
    }

    @Override
    public void sessionExecute() {
        IStudentIterator iterator = createHqStudentIterator(0);
        while (iterator.hasNext()) {
            final Student next = iterator.getNext();
            next.setAverageGradePoint(RandomLife.RandomMark());
        }

    }

    @Override
    public void resultCourses(double averageGradePoint) {
        IStudentIterator iterator = createHqStudentIterator(averageGradePoint);
        int number = 1;
        System.out.printf("best student with mark >= %.1f:\n---------\n", averageGradePoint);
        while (iterator.hasNext()) {
            final Student next = iterator.getNext();
            System.out.printf("%d. #%d with mark=%.1f\n", number++, next.getUid(), next.getAverageGradePoint());
        }
        if(number == 1) {
            System.out.println("bad course, no that student!");
        }

    }

    private IStudentIterator createHqStudentIterator(double averageGradePoint) {
        return new HqStudentIterator(this, averageGradePoint);
    }

    @Override
    public void info() {
        System.out.println("State education center:");
    }

    @Override
    public void addCourse(Course course) {
        courseList.add(course);
    }
}
