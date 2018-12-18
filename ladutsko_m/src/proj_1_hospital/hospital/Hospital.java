package proj_1_hospital.hospital;

import java.util.HashMap;
import java.util.Map;

import proj_1_hospital.objects.Patient;
import proj_1_hospital.objects.Person;
import proj_1_hospital.services.Service;
import proj_1_hospital.services.ServiceType;

public final class Hospital {
    private final Registration registration;
    private final static Map<ServiceType, Department> DEPARTMENTS;
    static {
        DEPARTMENTS = new HashMap<>();
        DEPARTMENTS.put(ServiceType.APPOINTMENT, AppointmentDepartment.getInstance());
        DEPARTMENTS.put(ServiceType.CHILDBIRTH, ChildbirthDepartment.getInstance());
        DEPARTMENTS.put(ServiceType.CONSERVATION, ConservationDepartment.getInstance());
    }

    public Hospital(){
        this.registration = new Registration();
    }

    public void serve(Person person){
        Patient currentPatient = registration.registerPatient(person);
        while (currentPatient.getService() != null){
            Service lastService = currentPatient.getService();

            if(DEPARTMENTS.get(lastService
                    .getServiceType())
                    .serve(currentPatient)){
                System.out.printf("Patient %s is undergoing %s procedure.\n", currentPatient.getName(), lastService.getServiceType().toString());
                registration.registerComplitedService(currentPatient.getInsuranceNumber(), lastService);
            }
            else {
                System.out.printf("Patient " + currentPatient.getName() + " was wrong registered.\n");
            }
        }

        System.out.printf("Patient " + currentPatient.getName() + " has been discharged.\n");
        System.out.printf("-------------------------------------------------------\n");
    }

    public void report(){
        registration.report();
    }
}
