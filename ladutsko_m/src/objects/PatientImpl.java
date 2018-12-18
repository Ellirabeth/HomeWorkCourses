package objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import services.Service;

@EqualsAndHashCode
@ToString
public final class PatientImpl implements Patient {
    private Person person;
    private Service service;

    public PatientImpl(Person person){
        this.person = person;
    }

    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public void serve() {
        System.out.printf("Patient " + getName() + " - %d: \n", getInsuranceNumber());
        service.execute();
    }

    @Override
    public int getInsuranceNumber() {
        return person.getInsuranceNumber();
    }

    @Override
    public Service getService() {
        return service;
    }

    @Override
    public void setService(Service service) {
        this.service = service;
    }
}
