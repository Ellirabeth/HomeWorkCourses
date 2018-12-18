package by.student;

import by.pattern.Visitor;
import lombok.ToString;

@ToString(callSuper = true)
public class AdultStudent extends Student {

    public AdultStudent(int uid) {
        super(uid);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
