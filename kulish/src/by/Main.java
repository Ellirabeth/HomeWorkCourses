package by;

import by.anno.PatternInfo;
import by.educationCenter.course.Course;
import by.educationCenter.IEducationCenter;
import by.educationCenter.StateEducationCenter;
import by.educationCenter.СommercialEducationCenter;
import by.object.People;
import by.pattern.Visitor;
import by.student.AdultStudent;
import by.student.Student;
import by.utility.RandomLife;

public class Main {

    private static IEducationCenter educationCenter;

    public static void main(String[] args) {
        final double averageGradePoint = 4.2;

        System.out.println("Hello peoples! Let's work...");
        VisitorPatternExecute();

        //Одиночка — это порождающий паттерн, который гарантирует существование только одного объекта определённого класса,
        // а также позволяет достучаться до этого объекта из любого места программы.
        if(RandomLife.RandomState()) {
            educationCenter = new СommercialEducationCenter();
        } else {
            educationCenter = new StateEducationCenter();
        }

        //Фабричный метод — это порождающий паттерн проектирования, который решает проблему создания различных продуктов,
        // без указания конкретных классов продуктов.
        Course course = educationCenter.createCourse();
        educationCenter.getHrCourseManager().fill(course);
        educationCenter.info();
        //используем общий метод для курса платного/бесплатной обучения из соответствующего вуза
        course.printStudents();

        educationCenter.sessionExecute();
        educationCenter.resultCourses(averageGradePoint);
    }

    @PatternInfo("Visitor")
    private static void VisitorPatternExecute() {
        printStart(false);
        Student student = new Student(0);
        AdultStudent astudent = new AdultStudent(1);
        People people = new People();
        Visitor visitor = new Visitor();
        //visitor.visit(student);
        people.accept(visitor);
        student.accept(visitor);
        astudent.accept(visitor);
        printStart(true);
    }

    private static void printStart(boolean end) {
        try {
            if(end) {
                System.out.println("======================================");
            } else {
                System.out.printf("======================================\nprint by.pattern progress execute for by.pattern: %s\n",
                        //LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME).replace('T',' '),
                        Main.class.getDeclaredMethod(Thread.currentThread().getStackTrace()[2].getMethodName()).getAnnotation(PatternInfo.class).value());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
