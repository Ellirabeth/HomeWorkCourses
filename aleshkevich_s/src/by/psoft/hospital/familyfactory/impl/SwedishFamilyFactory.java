package by.psoft.hospital.familyfactory.impl;

import by.psoft.hospital.family.enums.EyeColor;
import by.psoft.hospital.family.enums.Gender;
import by.psoft.hospital.family.enums.HairColor;
import by.psoft.hospital.family.enums.Nationality;
import by.psoft.hospital.family.impl.Husband;
import by.psoft.hospital.family.impl.Person;
import by.psoft.hospital.family.interfaces.IPerson;
import by.psoft.hospital.familyfactory.interfaces.IFamilyFactory;

public class SwedishFamilyFactory implements IFamilyFactory {

    @Override
    public Nationality createNationality() {
        return Nationality.SWEDISH;
    }

    @Override
    public Husband createHusband() {
        return new Husband("Lars", Gender.MALE, EyeColor.GRAY, HairColor.BLOND,
                "In the name of the king! For Sweden - at all times!");
    }

    @Override
    public IPerson createWife() {
        return new Person("Elsa", Gender.FEMALE, EyeColor.BLUE, HairColor.BLOND);
    }
}
