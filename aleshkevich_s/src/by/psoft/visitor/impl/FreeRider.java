package by.psoft.visitor.impl;

import by.psoft.visitor.interfaces.Passenger;
import by.psoft.visitor.interfaces.Visitor;

public class FreeRider implements Passenger {

    private String name;

    public FreeRider(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFreeRider(this);
    }
}
