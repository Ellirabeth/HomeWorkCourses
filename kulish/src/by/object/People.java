package by.object;

import by.pattern.IVisitor;
import by.pattern.Visitor;
import lombok.ToString;

@ToString
public class People implements IVisitor {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
