package model.enums;

public enum roomType {
    DELUXE(1.5),
    PRESIDENT(2.0),
    STANDARD(1.0);

    private final double overstayMultiplier;

    roomType(double overstayMultiplier) {
        this.overstayMultiplier = overstayMultiplier;
    }

    public double getOverstayMultiplier() {
        return overstayMultiplier;
    }
}
