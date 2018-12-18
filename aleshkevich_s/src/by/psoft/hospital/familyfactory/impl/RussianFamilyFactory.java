package by.psoft.hospital.familyfactory.impl;

import by.psoft.hospital.family.enums.EyeColor;
import by.psoft.hospital.family.enums.Gender;
import by.psoft.hospital.family.enums.HairColor;
import by.psoft.hospital.family.enums.Nationality;
import by.psoft.hospital.family.impl.Husband;
import by.psoft.hospital.family.impl.Person;
import by.psoft.hospital.family.interfaces.IPerson;
import by.psoft.hospital.familyfactory.interfaces.IFamilyFactory;

public class RussianFamilyFactory implements IFamilyFactory {

    @Override
    public Nationality createNationality() {
        return Nationality.RUSSIAN;
    }

    @Override
    public Husband createHusband() {
        return new Husband("Ivan", Gender.MALE, EyeColor.GRAY, HairColor.GINGER,
                "Oh My God! I will drink all week!");
    }

    @Override
    public IPerson createWife() {
        return new Person("Maria", Gender.FEMALE, EyeColor.GREEN, HairColor.BLOND);
    }
}
