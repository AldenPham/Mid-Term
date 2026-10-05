package model;
import model.enums.*;
import java.util.List;
import java.util.ArrayList;

public class roomGroup {
    private String groupName;
    private String groupId;
    private roomType type;
    private List<utility> utilities;

    public roomGroup(String groupName,
                     String groupId,
                     roomType type
    ){
        this.groupName = groupName;
        this.groupId = groupId;
        this.type = type;
        this.utilities = new ArrayList<utility>();
    }

    public roomType getType() {
        return type;
    }

    public List<utility> getUtilities() {
        return utilities;
    }

    public void addUtility(utility utility) {
        utilities.add(utility);
    }

    public String toString() {
        return "roomGroup{" +
                "groupName='" + groupName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", type=" + type +
                ", utilities=" + utilities +
                '}';
    }
}
