package proj_1_hospital.objects;

import proj_1_hospital.services.Service;

public interface Patient {
    String getName();
    void serve();
    int getInsuranceNumber();
    Service getService();
    void setService(Service service);
}
