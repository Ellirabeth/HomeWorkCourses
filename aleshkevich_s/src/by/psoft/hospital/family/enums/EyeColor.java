package by.psoft.hospital.family.enums;

public enum EyeColor {

    BLUE(true),

    BROWN(true),

    GRAY(false),

    GREEN(false);

    private boolean isDominant;

    EyeColor(boolean argDominant) {
        this.isDominant = argDominant;
    }

    public boolean isDominant() {
        return isDominant;
    }

    public boolean isRecessive() {
        return !isDominant;
    }
}
