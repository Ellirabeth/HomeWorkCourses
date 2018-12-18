package by.psoft.visitor.interfaces;

public interface Passenger {

    String getName();

    void accept(Visitor visitor);
}
