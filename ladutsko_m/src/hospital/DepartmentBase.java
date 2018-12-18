package hospital;
import objects.Patient;
import services.ServiceType;

abstract class DepartmentBase implements Department {
    private ServiceType serviceType;

    protected DepartmentBase(ServiceType serviceType){
        this.serviceType = serviceType;
    }

    @Override
    public ServiceType getServiceType(){
        return serviceType;
    }

    @Override
    public boolean serve(Patient patient) {
        if(patient.getService().getServiceType() == getServiceType()){
            System.out.printf(this.getClass().getName() + ": ");
            patient.serve();
            patient.setService(null);
            return true;
        }else {
            return true;
        }
    }
}
