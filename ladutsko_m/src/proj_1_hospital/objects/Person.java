package proj_1_hospital.objects;

import proj_1_hospital.services.ServiceType;

public interface Person {
    String getName();
    ServiceType getAim();
    void setAim(ServiceType aim);
    int getInsuranceNumber();
}
