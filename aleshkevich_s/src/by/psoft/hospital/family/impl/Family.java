package by.psoft.hospital.family.impl;

import by.psoft.hospital.family.enums.Nationality;
import by.psoft.hospital.family.interfaces.IFamily;
import by.psoft.hospital.family.interfaces.IPerson;

import java.util.ArrayList;
import java.util.List;

public class Family implements IFamily {

    private Nationality nationality;

    private Husband husband;

    private IPerson wife;

    private List<IPerson> children = new ArrayList<>();

    public Family(Nationality nationality, Husband argHusband, IPerson argWife) {
        this.nationality = nationality;
        this.husband = argHusband;
        this.wife = argWife;
    }

    @Override
    public Nationality getNationality() {
        return nationality;
    }

    @Override
    public Husband getHusband() {
        return husband;
    }

    @Override
    public IPerson getWife() {
        return wife;
    }

    @Override
    public void addChild(IPerson child) {
        children.add(child);
    }
}
