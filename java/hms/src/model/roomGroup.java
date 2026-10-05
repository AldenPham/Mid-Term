package model;
import model.enums.*;
public class roomGroup {
    private String groupName;
    private String groupId;
    private roomType type;

    public roomGroup(String groupName,
                     String groupId,
                     roomType type
    ){
        this.groupName = groupName;
        this.groupId = groupId;
        this.type = type;
    }

    public roomType getType() {
        return type;
    }
}
