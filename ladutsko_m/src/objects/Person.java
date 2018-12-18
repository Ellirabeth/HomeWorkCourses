package objects;

import services.ServiceType;

public interface Person {
    String getName();
    ServiceType getAim();
    void setAim(ServiceType aim);
    int getInsuranceNumber();
}
