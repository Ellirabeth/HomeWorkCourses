package lesson_01_Hospital.humanAbstractFactory.Male;

import lesson_01_Hospital.humanAbstractFactory.FactoryProducer;
import lesson_01_Hospital.humanAbstractFactory.Human;
import lesson_01_Hospital.humanAbstractFactory.HumanFactory;

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
