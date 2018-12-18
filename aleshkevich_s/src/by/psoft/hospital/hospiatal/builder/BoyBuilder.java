package by.psoft.hospital.hospiatal.builder;

import by.psoft.hospital.family.enums.EyeColor;
import by.psoft.hospital.family.enums.Gender;
import by.psoft.hospital.family.enums.HairColor;
import by.psoft.hospital.family.impl.Person;
import by.psoft.hospital.family.interfaces.IFamily;
import by.psoft.hospital.family.interfaces.IPerson;

public class BoyBuilder implements ChildBuilder {

    private String name = "Jon Daw";

    private EyeColor eyeColor = EyeColor.BLUE;

    private HairColor hairColor = HairColor.BLACK;

    @Override
    public void genName(IFamily family) {
        switch (family.getNationality()) {
            case RUSSIAN: name = "Vladimir"; break;
            case ITALIAN: name = "Lorenzo"; break;
            case SWEDISH: name = "Karl"; break;
            case CHINESE: name = "Zhiming"; break;
        }
    }

    @Override
    public void genEyeColor(IFamily family) {
        EyeColor fatherEyeColor = family.getHusband().getEyeColor();
        EyeColor matherEyeColor = family.getWife().getEyeColor();

        if (fatherEyeColor.isDominant() || matherEyeColor.isRecessive()) {
            eyeColor = fatherEyeColor;
        } else {
            eyeColor = matherEyeColor;
        }
    }

    @Override
    public void genHairColor(IFamily family) {
        HairColor fatherHairColor = family.getHusband().getHairColor();
        HairColor matherHairColor = family.getWife().getHairColor();

        if (fatherHairColor.isDominant() || matherHairColor.isRecessive()) {
            hairColor = fatherHairColor;
        } else {
            hairColor = matherHairColor;
        }
    }

    @Override
    public IPerson getChild() {
        return new Person(name, Gender.MALE, eyeColor, hairColor);
    }
}