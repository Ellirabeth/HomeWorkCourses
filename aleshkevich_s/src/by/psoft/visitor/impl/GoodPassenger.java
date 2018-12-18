package by.psoft.visitor.impl;

import by.psoft.visitor.interfaces.Passenger;
import by.psoft.visitor.interfaces.Visitor;

public class GoodPassenger implements Passenger {

    private String name;

    public GoodPassenger(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitGoodPassenger(this);
    }
}
