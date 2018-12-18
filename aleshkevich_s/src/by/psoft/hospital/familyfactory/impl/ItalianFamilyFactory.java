package by.psoft.hospital.familyfactory.impl;

import by.psoft.hospital.family.enums.EyeColor;
import by.psoft.hospital.family.enums.Gender;
import by.psoft.hospital.family.enums.HairColor;
import by.psoft.hospital.family.enums.Nationality;
import by.psoft.hospital.family.impl.Husband;
import by.psoft.hospital.family.impl.Person;
import by.psoft.hospital.family.interfaces.IPerson;
import by.psoft.hospital.familyfactory.interfaces.IFamilyFactory;

public class ItalianFamilyFactory implements IFamilyFactory {

    @Override
    public Nationality createNationality() {
        return Nationality.ITALIAN;
    }

    @Override
    public Husband createHusband() {
        return new Husband("Paolo", Gender.MALE, EyeColor.BLUE, HairColor.BROWN,
                "Mamma mia! Che felicità! Farò la pasta!");
    }

    @Override
    public IPerson createWife() {
        return new Person("Gabriella", Gender.FEMALE, EyeColor.GREEN, HairColor.BLACK);
    }
}
