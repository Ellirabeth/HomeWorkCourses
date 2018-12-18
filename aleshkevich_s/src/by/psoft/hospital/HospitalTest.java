package by.psoft.hospital;

import by.psoft.hospital.familyfactory.impl.ChineseFamilyFactory;
import by.psoft.hospital.familyfactory.impl.ItalianFamilyFactory;
import by.psoft.hospital.familyfactory.impl.RussianFamilyFactory;
import by.psoft.hospital.familyfactory.impl.SwedishFamilyFactory;
import by.psoft.hospital.familyfactory.interfaces.IFamilyFactory;
import by.psoft.hospital.hospiatal.MaternityHospital;

/**
 * Test of maternity hospital. Used patterns:
 * Singleton, Abstract factory, Builder, Observer,
 * Iterator, Facade, Strategy
 */
public class HospitalTest {
    public static void main(String[] args) {
        MaternityHospital hospital = MaternityHospital.getInstance();

        IFamilyFactory familyFactory = new RussianFamilyFactory();
        hospital.acceptFamily(familyFactory.createFamily());

        familyFactory = new SwedishFamilyFactory();
        hospital.acceptFamily(familyFactory.createFamily());

        familyFactory = new ItalianFamilyFactory();
        hospital.acceptFamily(familyFactory.createFamily());

        familyFactory = new ChineseFamilyFactory();
        hospital.acceptFamily(familyFactory.createFamily());

        hospital.takeDelivery();
    }
}
