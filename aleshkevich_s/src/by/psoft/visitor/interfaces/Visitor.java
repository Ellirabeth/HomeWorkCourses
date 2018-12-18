package by.psoft.visitor.interfaces;

public interface Visitor {

    void visitGoodPassenger(Passenger passenger);

    void visitFreeRider(Passenger passenger);
}
