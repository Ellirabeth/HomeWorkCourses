package lesson_01_Hospital.humanAbstractFactory.Male;

import lesson_01_Hospital.humanAbstractFactory.FactoryProducer;
import lesson_01_Hospital.humanAbstractFactory.Human;
import lesson_01_Hospital.humanAbstractFactory.HumanFactory;

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
