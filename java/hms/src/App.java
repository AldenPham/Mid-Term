import model.*;

public class App {
    public static void main(String[] args) throws Exception {
        roomGroup deluxeGroup = new roomGroup("deluxe group", "001", roomType.DELUXE);
        deluxeRoom room1 = new deluxeRoom("004", 
                                          "dr001", 
                                          3, deluxeGroup, 
                                          roomStatus.AVAILABLE, 
                                          30000);

        deluxeRoom room2 = new deluxeRoom("004", 
                                          "dr002", 
                                          3, deluxeGroup, 
                                          roomStatus.AVAILABLE, 
                                          30000);

        deluxeRoom room3 = new deluxeRoom("004", 
                                          "dr003", 
                                          3, deluxeGroup, 
                                          roomStatus.AVAILABLE, 
                                          30000);
    }
}
