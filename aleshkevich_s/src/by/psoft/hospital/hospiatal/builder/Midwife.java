package by.psoft.hospital.hospiatal.builder;

import by.psoft.hospital.family.interfaces.IFamily;
import by.psoft.hospital.family.interfaces.IPerson;

public class Midwife {

    private ChildBuilder childBuilder;

    private IFamily family;

    public Midwife(IFamily family) {
        this.family = family;
    }

    public void setChildBuilder(ChildBuilder cb) {
        childBuilder = cb;
    }

    public void takeDelivery() {
        childBuilder.genName(family);
        childBuilder.genEyeColor(family);
        childBuilder.genHairColor(family);
    }

    public IPerson getChild() {
        return childBuilder.getChild();
    }
}
