package humanAbstractFactory.Male;

import humanAbstractFactory.FactoryProducer;
import humanAbstractFactory.Human;
import humanAbstractFactory.HumanFactory;

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
