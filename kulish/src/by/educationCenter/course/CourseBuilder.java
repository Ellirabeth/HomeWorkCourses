package by.educationCenter.course;

import by.educationCenter.IEducationCenter;

public class CourseBuilder {

    private int weekNumber;
    private String subject;
    private CourseType courseType;
    private int studentLimitCount;
    private IEducationCenter center;

    public CourseBuilder() {

    }


    public CourseBuilder reset() {
        weekNumber = 4; //1 month
        courseType = CourseType.Free;
        subject = null;
        studentLimitCount = 0;
        center = null;
        return this;
    }

    public CourseBuilder setDurationWeek(int weekNumber) {
        this.weekNumber = weekNumber;
        return this;
    }

    public CourseBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public CourseBuilder setCourseType(CourseType courseType ) {
        this.courseType = courseType;
        return this;
    }
    public CourseBuilder setEducationCenter(IEducationCenter center ) {
        this.center = center;
        return this;
    }

    public CourseBuilder setStudentLimitCount(int studentLimitCount) {
        this.studentLimitCount = studentLimitCount;
        return this;
    }

    public Course build() {
        switch (courseType) {
            case Free:
                return new FreeCourse(center, subject, weekNumber, studentLimitCount);
            case Commercial:
                return new PaidCourse(center, subject, weekNumber, studentLimitCount);
                default:
                    throw new IllegalArgumentException();
        }
    }
}
