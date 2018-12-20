package proj_1_hospital.hospital;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import proj_1_hospital.objects.Patient;
import proj_1_hospital.services.Service;


public final class DataBase {
    private static DataBase instance;
    public static final Map<Integer, Patient> PATIENTS = new HashMap<>();
    public static final Map<Integer, List<Service>> COMPLITED_PATIENT_SERVICES = new HashMap<>();

    private DataBase(){}

    public static synchronized DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }
}
