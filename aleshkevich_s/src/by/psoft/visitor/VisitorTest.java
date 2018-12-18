package by.psoft.visitor;

import by.psoft.visitor.impl.Comptroller;
import by.psoft.visitor.impl.FreeRider;
import by.psoft.visitor.impl.GoodPassenger;
import by.psoft.visitor.interfaces.Passenger;
import by.psoft.visitor.interfaces.Visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorTest {

    public static void main(String[] args) {
        List<Passenger> bus = new ArrayList<>();

        bus.add(new GoodPassenger("Nikolay"));
        bus.add(new FreeRider("Vova"));
        bus.add(new GoodPassenger("Olga"));
        bus.add(new GoodPassenger("Vika"));
        bus.add(new FreeRider("Dmitriy"));

        Visitor comptroller = new Comptroller();
        bus.forEach(passenger -> passenger.accept(comptroller));
    }
}
