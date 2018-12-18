package by.psoft.hospital.family.impl;

import by.psoft.hospital.family.enums.EyeColor;
import by.psoft.hospital.family.enums.Gender;
import by.psoft.hospital.family.enums.HairColor;
import by.psoft.hospital.family.interfaces.IFamily;
import by.psoft.hospital.hospiatal.observer.Observer;

public class Husband extends Person implements Observer {

    private String cryOfJoy;

    public Husband(String name, Gender gender, EyeColor eyeColor, HairColor hairColor, String cryOfJoy) {
        super(name, gender, eyeColor, hairColor);
        this.cryOfJoy = cryOfJoy;
    }

    public String getCryOfJoy() {
        return cryOfJoy;
    }

    public void setCryOfJoy(String cryOfJoy) {
        this.cryOfJoy = cryOfJoy;
    }

    @Override
    public void handle(IFamily family) {
        if (family.getHusband() == this) {
            System.out.println("Father cry: " + getCryOfJoy());
        }
    }
}
