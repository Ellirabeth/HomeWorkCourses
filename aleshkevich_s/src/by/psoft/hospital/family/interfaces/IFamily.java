package by.psoft.hospital.family.interfaces;

import by.psoft.hospital.family.enums.Nationality;
import by.psoft.hospital.family.impl.Husband;

public interface IFamily {

    Nationality getNationality();

    Husband getHusband();

    IPerson getWife();

    void addChild(IPerson child);
}
