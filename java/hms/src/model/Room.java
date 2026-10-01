package model;

public abstract class Room {
    private String roomLocation;
    private String roomId;
    private int roomCapacity;
    private roomGroup inGroup;
    private roomStatus status;
    private double roomPrice;

    public Room(String roomLocation,
                String roomId,
                int roomCapacity,
                roomGroup inGroup,
                roomStatus status,
                double roomPrice
    ){
        this.roomLocation = roomLocation;
        this.roomId = roomId;
        this.roomCapacity = roomCapacity;
        this.inGroup = inGroup;
        this.status = status;
        this.roomPrice = roomPrice;
    }

}
