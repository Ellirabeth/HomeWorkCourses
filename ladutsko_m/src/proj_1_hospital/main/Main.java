package proj_1_hospital.main;

import proj_1_hospital.hospital.Hospital;
import proj_1_hospital.objects.Person;
import proj_1_hospital.objects.PersonImpl;
import proj_1_hospital.services.ServiceType;



public final class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        Person p1 = new PersonImpl("1", ServiceType.APPOINTMENT, 1);
        Person p2 = new PersonImpl("2", ServiceType.CHILDBIRTH, 2);
        Person p3 = new PersonImpl("3", ServiceType.CONSERVATION, 3);
        Person p4 = new PersonImpl("4", ServiceType.CONSERVATION, 4);
        Person p5 = new PersonImpl("5", ServiceType.CHILDBIRTH, 5);
        Person p6 = new PersonImpl("6", ServiceType.APPOINTMENT, 6);
        Person p7 = new PersonImpl("7", ServiceType.CHILDBIRTH, 7);
        Person p8 = new PersonImpl("8", ServiceType.APPOINTMENT, 8);
        Person p9 = new PersonImpl("9", ServiceType.CONSERVATION, 9);
        Person p10 = new PersonImpl("10", ServiceType.CONSERVATION, 10);
        Person p11= new PersonImpl("11", ServiceType.APPOINTMENT, 11);

        hospital.serve(p1);
        hospital.serve(p2);
        hospital.serve(p3);
        hospital.serve(p4);
        hospital.serve(p5);
        hospital.serve(p6);
        hospital.serve(p7);
        hospital.serve(p8);
        hospital.serve(p9);
        hospital.serve(p10);
        hospital.serve(p11);

        p1.setAim(ServiceType.CHILDBIRTH);
        p2.setAim(ServiceType.APPOINTMENT);
        p3.setAim(ServiceType.APPOINTMENT);
        p4.setAim(ServiceType.CONSERVATION);
        p5.setAim(ServiceType.APPOINTMENT);
        p6.setAim(ServiceType.CHILDBIRTH);

        hospital.serve(p1);
        hospital.serve(p2);
        hospital.serve(p3);
        hospital.serve(p4);
        hospital.serve(p5);
        hospital.serve(p6);

        hospital.report();



    }

}
