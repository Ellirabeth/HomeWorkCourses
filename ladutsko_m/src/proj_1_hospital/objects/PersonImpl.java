package proj_1_hospital.objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import proj_1_hospital.services.ServiceType;


@EqualsAndHashCode
@ToString
public class PersonImpl implements Person {

    private final String name;
    private ServiceType aim;
    private final int insuranceNumber;

    public PersonImpl(String name, ServiceType aim, int insuranceNumber){
        this.name = name;
        this.aim = aim;
        this.insuranceNumber = insuranceNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ServiceType getAim() {
        return aim;
    }

    @Override
    public void setAim(ServiceType aim) {
        this.aim = aim;
    }

    @Override
    public int getInsuranceNumber() {
        return insuranceNumber;
    }
}
