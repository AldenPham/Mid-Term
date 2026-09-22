package vn.ute.oop;

public abstract class abs_Room implements  iBookable{
    private final String roomId;
    private final int roomCapacity; 
    private int roomAvailable;

    //Constructor
    public abs_Room(String roomId, int roomCapacity){
        this.roomId = roomId;
        this.roomCapacity = roomCapacity;
        this.roomAvailable = roomCapacity;
    }

    //ABSTRACT METHOD
    public abstract String getInfo();
    

    //method
    public String get_RoomId(){
        return roomId;
    }

    @Override 
    public boolean isEmpty(){
        return roomAvailable > 0;
    };

    @Override 
    public void checkIn(){
        if(roomAvailable >= roomCapacity){
            throw new IllegalStateException("No more room to check in");
        }
        roomAvailable--;
    };

    @Override 
    public void checkOut(){
        if(roomAvailable <= 0){
            throw new IllegalStateException("No room occupied to check out");
        }
        roomAvailable++;
    };
}