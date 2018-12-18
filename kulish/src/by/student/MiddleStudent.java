package by.student;

import by.pattern.Visitor;

public class MiddleStudent extends Student {

    public MiddleStudent(int uid) {
        super(uid);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
