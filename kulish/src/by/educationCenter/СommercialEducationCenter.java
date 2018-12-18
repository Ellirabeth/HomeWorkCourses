package by.educationCenter;

import by.educationCenter.course.Course;
import by.educationCenter.course.CourseBuilder;
import by.educationCenter.course.CourseType;
import by.utility.RandomLife;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class СommercialEducationCenter implements IEducationCenter {

    @Getter
    List<Course> courseList = new ArrayList<>();

//    public static СommercialEducationCenter EducationCenter() {
//        return new СommercialEducationCenter();
//    }

    public void sessionExecute() {

    }

    @Override
    public void resultCourses(double averageGradePoint) {
        for (Course course:courseList) {
            course.printResult();
        }
    }

    @Override
    public void info() {
        System.out.println("Commercial education center:");
    }

    @Override
    public void addCourse(Course course) {
        courseList.add(course);
    }

    @Override
    public Course createCourse() {
        return new CourseBuilder().reset().setEducationCenter(this).setDurationWeek(5).setSubject("Programmng").setCourseType(CourseType.Commercial)
                .setStudentLimitCount(RandomLife.RandomPeople()).build();
    }
}
