package proj_1_hospital.hospital;

import proj_1_hospital.objects.Patient;
import proj_1_hospital.services.ServiceFactory;
import proj_1_hospital.services.ServiceType;

final class ConservationDepartment extends DepartmentBase {
    private static ConservationDepartment instance;

    private ConservationDepartment(){
        super(ServiceType.CONSERVATION);
    }

    public static synchronized ConservationDepartment getInstance() {
        if (instance == null) {
            instance = new ConservationDepartment();
        }
        return instance;
    }

    @Override
    public boolean serve(Patient patient) {
        if(patient.getService().getServiceType() == getServiceType()){
            System.out.printf("ConservationDepartment: ");
            patient.serve();
            patient.setService(ServiceFactory.getService(ServiceType.CHILDBIRTH));
            return true;
        }else {
            return true;
        }


    }
}
