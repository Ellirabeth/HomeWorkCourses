package by.educationCenter.course;

import by.educationCenter.IEducationCenter;
import by.educationCenter.course.Course;

public class PaidCourse extends Course {

    public PaidCourse(IEducationCenter educationCenter, String subject, int weekNumber, int studentLimitCount) {
        super(educationCenter, subject, weekNumber, studentLimitCount);
    }
}
