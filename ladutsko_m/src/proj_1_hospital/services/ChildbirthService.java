package proj_1_hospital.services;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
class ChildbirthService implements Service {
    @Override
    public ServiceType getServiceType() {
        return ServiceType.CHILDBIRTH;
    }

    @Override
    public void execute() {
        System.out.println("Execution of childbirth.");
    }
}

