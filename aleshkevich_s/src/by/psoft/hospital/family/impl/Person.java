package by.psoft.hospital.family.impl;

import by.psoft.hospital.family.enums.EyeColor;
import by.psoft.hospital.family.enums.Gender;
import by.psoft.hospital.family.enums.HairColor;
import by.psoft.hospital.family.interfaces.IPerson;

public class Person implements IPerson {

    private String name;

    private Gender gender;

    private EyeColor eyeColor;

    private HairColor hairColor;

    public Person(String name, Gender gender, EyeColor eyeColor, HairColor hairColor) {
        this.name = name;
        this.gender = gender;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public EyeColor getEyeColor() {
        return eyeColor;
    }

    @Override
    public HairColor getHairColor() {
        return hairColor;
    }
}
