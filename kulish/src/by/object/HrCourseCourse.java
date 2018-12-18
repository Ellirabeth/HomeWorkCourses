package by.object;

import by.educationCenter.course.Course;
import by.student.AdultStudent;
import by.utility.RandomLife;

public class HrCourseCourse {

    static HrCourseCourse hrCourseCourse;

    public void fill(Course course) {
        int uid = 0;
        final int studentCount = RandomLife.RandomPeople();
        for (int i = 0; i < studentCount; i++) {
            if (course.getStudentLimitCount() <= i) {
                break;
            }
            course.getStudentList().add(new AdultStudent(uid++));
        }
        if (course.getStudentLimitCount() < studentCount) {
            System.out.printf("overLoad course by %d students. Need more group for %d student\n", course.getStudentLimitCount(), studentCount - course.getStudentLimitCount());
        }
        if (studentCount > 0) {
            course.getEducationCenter().addCourse(course);
        }
    }

    public static HrCourseCourse getInstance() {
        if (hrCourseCourse == null) {
            hrCourseCourse = new HrCourseCourse();
        }
        return hrCourseCourse;
    }
}
