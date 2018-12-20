package lesson_01_Hospital.humanAbstractFactory;

public class Human {
    private String name;
    private int health;
    private boolean isDead;
    private int id;
    private String humanType;
    private String humanBodyType;


//    public Human () {
//        this.health = 100;
//        this.isDead = false;
//        this.name = "";
//        this.humanBodyType = "";
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getId() {
        return id;
    }

    public String getHumanType() {
        return humanType;
    }

    public String getHumanBodyType() {
        return humanBodyType;
    }

    public Human(FactoryProducer.HumanType type, HumanFactory.HumanBodyType bodyType, int id) {
        this.humanType = type.getText();
        this.humanBodyType = bodyType.name();
        this.id = id;
    }
}
