package by.psoft.hospital.familyfactory.interfaces;

import by.psoft.hospital.family.enums.Nationality;
import by.psoft.hospital.family.impl.Family;
import by.psoft.hospital.family.impl.Husband;
import by.psoft.hospital.family.interfaces.IFamily;
import by.psoft.hospital.family.interfaces.IPerson;

public interface IFamilyFactory {

    default IFamily createFamily() {
        return new Family(createNationality(), createHusband(), createWife());
    }

    Nationality createNationality();

    Husband createHusband();

    IPerson createWife();
}
