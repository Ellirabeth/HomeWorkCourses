package hospital;

import objects.Patient;
import services.ServiceType;

final class AppointmentDepartment extends DepartmentBase{
    private static AppointmentDepartment instance;

    private AppointmentDepartment(){
        super(ServiceType.APPOINTMENT);
    }

    public static synchronized AppointmentDepartment getInstance() {
        if (instance == null) {
            instance = new AppointmentDepartment();
        }
        return instance;
    }
}
