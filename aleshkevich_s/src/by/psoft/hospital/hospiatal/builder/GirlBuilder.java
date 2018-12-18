package by.psoft.hospital.hospiatal.builder;

import by.psoft.hospital.family.enums.EyeColor;
import by.psoft.hospital.family.enums.Gender;
import by.psoft.hospital.family.enums.HairColor;
import by.psoft.hospital.family.impl.Person;
import by.psoft.hospital.family.interfaces.IFamily;
import by.psoft.hospital.family.interfaces.IPerson;

public class GirlBuilder implements ChildBuilder {

    private String name = "Jane Daw";

    private EyeColor eyeColor = EyeColor.BLUE;

    private HairColor hairColor = HairColor.BLACK;

    @Override
    public void genName(IFamily family) {
        switch (family.getNationality()) {
            case RUSSIAN: name = "Olga"; break;
            case ITALIAN: name = "Daniela"; break;
            case SWEDISH: name = "Ingrid"; break;
            case CHINESE: name = "Yulin"; break;
        }
    }

    @Override
    public void genEyeColor(IFamily family) {
        EyeColor fatherEyeColor = family.getHusband().getEyeColor();
        EyeColor matherEyeColor = family.getWife().getEyeColor();

        if (matherEyeColor.isDominant() || fatherEyeColor.isRecessive()) {
            eyeColor = matherEyeColor;
        } else {
            eyeColor = fatherEyeColor;
        }
    }

    @Override
    public void genHairColor(IFamily family) {
        HairColor fatherHairColor = family.getHusband().getHairColor();
        HairColor matherHairColor = family.getWife().getHairColor();

        if (matherHairColor.isDominant() || fatherHairColor.isRecessive()) {
            hairColor = matherHairColor;
        } else {
            hairColor = fatherHairColor;
        }
    }

    @Override
    public IPerson getChild() {
        return new Person(name, Gender.FEMALE, eyeColor, hairColor);
    }
}
