package Hospital.humanAbstractFactory.Male;

import Hospital.humanAbstractFactory.FactoryProducer;
import Hospital.humanAbstractFactory.Human;
import Hospital.humanAbstractFactory.HumanFactory;

public class MaleMesomorphHuman extends Human {
    private String name;

    public MaleMesomorphHuman(int id) {
        super(FactoryProducer.HumanType.MALE, HumanFactory.HumanBodyType.MESOMORPH, id);
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
