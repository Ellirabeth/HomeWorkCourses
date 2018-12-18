package hospital;

import services.ServiceType;

final class ChildbirthDepartment extends DepartmentBase {
    private static ChildbirthDepartment instance;

    private ChildbirthDepartment(){
        super(ServiceType.CHILDBIRTH);
    }

    public static synchronized ChildbirthDepartment getInstance() {
        if (instance == null) {
            instance = new ChildbirthDepartment();
        }
        return instance;
    }
}
