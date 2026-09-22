package vn.ute.oop;

import java.io.Console;

public class cStandard extends abs_Room {
    public cStandard(String roomId, int roomCapacity){
        super(roomId, roomCapacity);
    }

    @Override 
    public String getInfo(){
        return toString();
    }
}
