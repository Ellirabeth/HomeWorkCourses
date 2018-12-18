package by.student;

import by.object.People;
import by.pattern.Visitor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Student extends People {

    @Getter @Setter
    double averageGradePoint;

    @Getter @Setter
    int Uid;

    public Student(int uid) {
        setUid(uid);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


}
