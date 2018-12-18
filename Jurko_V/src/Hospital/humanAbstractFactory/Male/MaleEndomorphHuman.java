package Hospital.humanAbstractFactory.Male;

import Hospital.humanAbstractFactory.FactoryProducer;
import Hospital.humanAbstractFactory.Human;
import Hospital.humanAbstractFactory.HumanFactory;

public class MaleEndomorphHuman extends Human {
    private String name;

    public MaleEndomorphHuman(int id) {
        super(FactoryProducer.HumanType.MALE, HumanFactory.HumanBodyType.ENDOMORPH, id);

    }

    @Override
    public void setName(String arqName) {
        this.name = arqName;
    }

    @Override
    public String getName() {
        return name;
    }
}
