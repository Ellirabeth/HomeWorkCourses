package by.psoft.hospital.hospiatal.observer;

import by.psoft.hospital.family.interfaces.IFamily;

public interface Subject {

    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(IFamily family);
}
