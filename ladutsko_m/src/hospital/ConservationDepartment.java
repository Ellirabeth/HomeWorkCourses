package hospital;

import objects.Patient;
import services.ServiceFactory;
import services.ServiceType;

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
