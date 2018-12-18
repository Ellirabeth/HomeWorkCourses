package proj_1_hospital.hospital;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import proj_1_hospital.objects.Patient;
import proj_1_hospital.objects.PatientImpl;
import proj_1_hospital.objects.Person;
import proj_1_hospital.services.Service;
import proj_1_hospital.services.ServiceFactory;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public final class Registration {
    private DataBase dataBase = DataBase.getInstance();

    public Patient registerPatient(Person person){
        Service requiredService = ServiceFactory.getService(person.getAim());
        if(dataBase.PATIENTS.containsKey(person.getInsuranceNumber())){
            Patient currentPatient = dataBase.PATIENTS.get(person.getInsuranceNumber());
            currentPatient.setService(requiredService);
            System.out.printf("Patient %s is already present in the database.\n", currentPatient.getName());
            return dataBase.PATIENTS.get(person.getInsuranceNumber());
        }
        else {
            Patient newPatient = new PatientImpl(person);
            newPatient.setService(requiredService);
            dataBase.PATIENTS.put(newPatient.getInsuranceNumber(), newPatient);

            dataBase.COMPLITED_PATIENT_SERVICES.put(newPatient.getInsuranceNumber(), new ArrayList<>());
            System.out.printf("Person %s has been registered as new patient.\n", newPatient.getName());
            return newPatient;
        }
    }

    public void registerComplitedService(int insuranceNumber, Service service){
        List<Service> complitedservices = dataBase.COMPLITED_PATIENT_SERVICES.get(insuranceNumber);
        if(complitedservices == null){
            throw new IllegalArgumentException("Registration.registerComplitedService() - invalid insurance number: " + insuranceNumber);
        }
        complitedservices.add(service);
        Patient patient = dataBase.PATIENTS.get(insuranceNumber);
        System.out.printf("Patient %s completed %s procedure.\n", patient.getName(), service.getServiceType().toString());
    }

    public void report(){
        List<Service> currentPatientServices;
        for (Map.Entry<Integer, Patient> entry : dataBase.PATIENTS.entrySet()){
            currentPatientServices = dataBase.COMPLITED_PATIENT_SERVICES.get(entry.getKey());
            System.out.printf("Patient %s, ID - %d. Completed procedure for all time:\n", entry.getValue().getName(), entry.getKey());
            for (Service service : currentPatientServices){
                System.out.printf("\t- %s\n", service.getServiceType().toString());
            }
            System.out.printf("##########\n");
        }
    }

}
