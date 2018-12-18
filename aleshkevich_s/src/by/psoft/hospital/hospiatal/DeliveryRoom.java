package by.psoft.hospital.hospiatal;

import by.psoft.hospital.family.enums.Gender;
import by.psoft.hospital.family.interfaces.IFamily;
import by.psoft.hospital.family.interfaces.IPerson;
import by.psoft.hospital.hospiatal.builder.BoyBuilder;
import by.psoft.hospital.hospiatal.builder.ChildBuilder;
import by.psoft.hospital.hospiatal.builder.GirlBuilder;
import by.psoft.hospital.hospiatal.builder.Midwife;
import by.psoft.hospital.hospiatal.observer.Observer;
import by.psoft.hospital.hospiatal.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRoom implements Subject {

    List<Observer> observers;

    public DeliveryRoom() {
        observers = new ArrayList<>();
    }

    public void takeDelivery(IFamily family) {
        Gender gender = Gender.values()[(int) (Math.random() * 2.0)];
        ChildBuilder childBuilder = gender == Gender.MALE ? new BoyBuilder() : new GirlBuilder();

        Midwife midwife = new Midwife(family);
        midwife.setChildBuilder(childBuilder);
        midwife.takeDelivery();
        IPerson child = midwife.getChild();

        System.out.println(String.format("\nJust born %s %s, eyes %s, hair %s",
                child.getGender() == Gender.MALE ? "boy" : "girl", child.getName(),
                child.getEyeColor().name().toLowerCase(), child.getHairColor().name().toLowerCase()));

        notifyObservers(family);
        removeObserver(family.getHusband());
        family.addChild(child);
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(IFamily family) {
        for (Observer o : observers) {
            o.handle(family);
        }
    }
}
