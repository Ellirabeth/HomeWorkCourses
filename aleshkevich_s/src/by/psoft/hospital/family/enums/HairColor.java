package by.psoft.hospital.family.enums;

public enum HairColor {

    BLACK(true),

    GINGER(false),

    BROWN(false),

    BLOND(false);

    private boolean isDominant;

    HairColor(boolean argDominant) {
        this.isDominant = argDominant;
    }

    public boolean isDominant() {
        return isDominant;
    }

    public boolean isRecessive() {
        return !isDominant;
    }
}
