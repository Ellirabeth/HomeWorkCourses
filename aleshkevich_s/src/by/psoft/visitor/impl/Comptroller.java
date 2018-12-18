package by.psoft.visitor.impl;

import by.psoft.visitor.interfaces.Passenger;
import by.psoft.visitor.interfaces.Visitor;

public class Comptroller implements Visitor {

    @Override
    public void visitGoodPassenger(Passenger passenger) {
        System.out.println(passenger.getName() + ", you may ride further.");
    }

    @Override
    public void visitFreeRider(Passenger passenger) {
        System.out.println(passenger.getName() + ", you must leave the bus.");
    }
}
