package hospital;

import objects.Patient;
import services.ServiceType;

public interface Department {
    ServiceType getServiceType();
    boolean serve(Patient patient);
}
