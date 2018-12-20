package proj_1_hospital.services;

public final class ServiceFactory {
    private static final Service APPOINTMENT  = new AppointmentService();
    private static final Service CHILDBIRTH = new ChildbirthService();
    private static final Service CONSERVATION = new ConservationService();

    private ServiceFactory(){}

    public static Service getService(ServiceType type){
        switch (type){
            case CHILDBIRTH: return CHILDBIRTH;
            case APPOINTMENT: return APPOINTMENT;
            case CONSERVATION: return CONSERVATION;
            default: throw new IllegalArgumentException("ServiceFactory - unexpected service type.");
        }
    }
}
