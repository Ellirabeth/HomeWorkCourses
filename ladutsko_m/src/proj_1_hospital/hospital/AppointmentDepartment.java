package proj_1_hospital.hospital;

import proj_1_hospital.services.ServiceType;

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
