package Hospital.humanAbstractFactory.Male;

import Hospital.humanAbstractFactory.FactoryProducer;
import Hospital.humanAbstractFactory.Human;
import Hospital.humanAbstractFactory.HumanFactory;

public class MaleEctomorphHuman extends Human {
    private String name;

    public MaleEctomorphHuman(int id) {
        super(FactoryProducer.HumanType.MALE, HumanFactory.HumanBodyType.ECTOMORPH, id);

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
