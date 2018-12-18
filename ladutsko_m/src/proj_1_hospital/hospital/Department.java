package proj_1_hospital.hospital;

import proj_1_hospital.objects.Patient;
import proj_1_hospital.services.ServiceType;

public interface Department {
    ServiceType getServiceType();
    boolean serve(Patient patient);
}
