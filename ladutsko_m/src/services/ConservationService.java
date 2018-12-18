package services;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
final class ConservationService implements Service {
    @Override
    public ServiceType getServiceType() {
        return ServiceType.CONSERVATION;
    }

    @Override
    public void execute() {
        System.out.println("Execution of conservation.");
    }
}
