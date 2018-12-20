package humanAbstractFactory.Male;

import humanAbstractFactory.FactoryProducer;
import humanAbstractFactory.Human;
import humanAbstractFactory.HumanFactory;

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
