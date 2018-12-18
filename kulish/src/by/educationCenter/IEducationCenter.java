package by.educationCenter;

import by.educationCenter.course.Course;
import by.object.HrCourseCourse;

import java.util.List;

public interface IEducationCenter {
    Course createCourse();

    void sessionExecute();

    void resultCourses(double averageGradePoint);

    void info();

    default HrCourseCourse getHrCourseManager() {
        return HrCourseCourse.getInstance();
    }

    List<Course> getCourseList();

    void addCourse(Course course);
}
