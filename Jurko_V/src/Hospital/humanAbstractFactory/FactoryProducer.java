package Hospital.humanAbstractFactory;

import Hospital.humanAbstractFactory.Male.MaleHumanFactory;

public class FactoryProducer {

    public enum HumanType {
        MALE("MALE"),
        FEMALE("FEMALE");

        private String text;

        HumanType(String argText) {
            this.text = argText;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static HumanFactory getFactory(HumanType choice) {
        switch (choice) {
            case MALE:
                return new MaleHumanFactory();
//            case FEMALE:
//                return new FemaleHumanFactory();
            default:
                throw new IllegalArgumentException("Illegal choice: " + choice);
        }
    }
}
