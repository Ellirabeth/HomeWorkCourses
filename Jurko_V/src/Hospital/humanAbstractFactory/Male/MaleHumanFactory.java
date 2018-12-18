package Hospital.humanAbstractFactory.Male;

import Hospital.humanAbstractFactory.Human;
import Hospital.humanAbstractFactory.HumanFactory;

public class MaleHumanFactory implements HumanFactory {

    @Override
    public Human createMaleHuman(HumanBodyType type, int id) {
        Human maleHuman = null;
        switch (type) {
            case ECTOMORPH:
                maleHuman = new MaleEctomorphHuman(id);
                break;
            case ENDOMORPH:
                maleHuman = new MaleEndomorphHuman(id);
                break;
            case MESOMORPH:
                maleHuman = new MaleMesomorphHuman(id);
                break;
            default:
                throw new IllegalArgumentException("Illegal body of human type: "
                        + type);
        }
        return maleHuman;
    }

    @Override
    public Human createFemaleHuman(HumanBodyType type, int id) {
        return null;
    }
}
