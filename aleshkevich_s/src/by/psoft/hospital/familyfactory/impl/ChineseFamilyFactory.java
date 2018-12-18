package by.psoft.hospital.familyfactory.impl;

import by.psoft.hospital.family.enums.EyeColor;
import by.psoft.hospital.family.enums.Gender;
import by.psoft.hospital.family.enums.HairColor;
import by.psoft.hospital.family.enums.Nationality;
import by.psoft.hospital.family.impl.Husband;
import by.psoft.hospital.family.impl.Person;
import by.psoft.hospital.family.interfaces.IPerson;
import by.psoft.hospital.familyfactory.interfaces.IFamilyFactory;

public class ChineseFamilyFactory implements IFamilyFactory {

    @Override
    public Nationality createNationality() {
        return Nationality.CHINESE;
    }

    @Override
    public Husband createHusband() {
        return new Husband("Xiaolong", Gender.MALE, EyeColor.BROWN, HairColor.BLACK,
                "Our baby is like plum tree flowers!");
    }

    @Override
    public IPerson createWife() {
        return new Person("Mingzhu", Gender.FEMALE, EyeColor.GRAY, HairColor.BLACK);
    }
}
