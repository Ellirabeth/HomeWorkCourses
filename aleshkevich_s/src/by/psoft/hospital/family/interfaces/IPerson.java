package by.psoft.hospital.family.interfaces;

import by.psoft.hospital.family.enums.EyeColor;
import by.psoft.hospital.family.enums.Gender;
import by.psoft.hospital.family.enums.HairColor;

public interface IPerson {

    String getName();

    Gender getGender();

    EyeColor getEyeColor();

    HairColor getHairColor();
}
