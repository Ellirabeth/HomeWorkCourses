package proj_1_hospital.services;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
final class AppointmentService implements Service {

    @Override
    public ServiceType getServiceType() {
        return ServiceType.APPOINTMENT;
    }

    @Override
    public void execute() {
        System.out.println("Execution of doctor`s appointment.");
    }
}

