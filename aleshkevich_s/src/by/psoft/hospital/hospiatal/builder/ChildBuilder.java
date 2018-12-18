package by.psoft.hospital.hospiatal.builder;

import by.psoft.hospital.family.interfaces.IFamily;
import by.psoft.hospital.family.interfaces.IPerson;

public interface ChildBuilder {

    void genName(IFamily family);

    void genEyeColor(IFamily family);

    void genHairColor(IFamily family);

    IPerson getChild();
}
