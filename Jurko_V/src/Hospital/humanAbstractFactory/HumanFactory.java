package Hospital.humanAbstractFactory;

public interface HumanFactory {
    enum HumanBodyType {
        ECTOMORPH,
        MESOMORPH,
        ENDOMORPH
    }

    Human createMaleHuman(HumanBodyType type, int id);
    Human createFemaleHuman(HumanBodyType type, int id);
}
