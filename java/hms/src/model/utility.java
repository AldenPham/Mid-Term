package model;

public class utility {
    String utilityName;
    String utilityId;
    double utilityPrice;

    public utility(String utilityName, String utilityId, double utilityPrice) {
        this.utilityName = utilityName;
        this.utilityId = utilityId;
        this.utilityPrice = utilityPrice;
    }

    public String getUtilityName() {
        return utilityName;
    }

    public String getUtilityId() {
        return utilityId;
    }

    public double getUtilityPrice() {
        return utilityPrice;
    }

    public String toString() {
        return "utility{" +
                "utilityName='" + utilityName + '\'' +
                ", utilityId='" + utilityId + '\'' +
                ", utilityPrice=" + utilityPrice +
                '}';
    }
}
