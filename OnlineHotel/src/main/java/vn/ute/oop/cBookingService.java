package vn.ute.oop;

import java.time.LocalDate;
import java.util.*;

public class cBookingService {
    private final Map<String, abs_Room> room_List = new LinkedHashMap<>(); //List phòng
    private final Map<String, abs_Customer> customer_List = new LinkedHashMap<>(); //List khách hàng
    private final List<cBilling> billList = new ArrayList<>(); //Tính tiền dựa theo bill
    private static int billCounter = 0;

    // ====================== ADD customer các thứ =========================
    public void addCustomer(abs_Customer customer){
        if(customer_List.putIfAbsent(customer.get_CustomerId(), customer) != null){
            throw new IllegalArgumentException("Trung ma khach hang");
        }
    }

    public void addRoom(abs_Room room){
        if(room_List.putIfAbsent(room.get_RoomId(), room) != null){
            throw new IllegalArgumentException("Trung ma phong");
        }
    }

    private cBilling findBill(String id){
        for(int i = 0; i < billList.size(); i++){
            if(billList.get(i).get_BillId().equals(id)){
                return billList.get(i);
            }
        }
        throw new IllegalArgumentException("Khong tim thay bill co ma: " + id);
    }


    //======================== Logic app ================================
    private boolean fail(String action, String reason){
        System.out.println("["+ action + "] have failed - " + reason);
        return false;
    }
    private boolean success(String action, String what){
        System.out.println("["+ action + "] have succeed " + what);
        return true;
    }

    public boolean bookRoom(String customerId, String roomId, LocalDate date){
        abs_Customer customer = customer_List.get(customerId);
        abs_Room room = room_List.get(roomId);

        if(customer == null){ //Khách hàng đang muốn book ko có trong danh sách
            return fail("BOOK ROOM", "Can't find customer");
        }
        if(room == null){ //Phòng muốn book không tìm thấy
            return fail("BOOK ROOM", "None existing room");
        }

        //Phòng có còn tróng để book ko?
        iBookable bookable = room;
        if(!bookable.isEmpty()){
            return fail("BOOK ROOM", "phong " + roomId +" khong con trong");
        }

        //BOOK PHong
        cBilling bill = new cBilling(String.format("B%04d", billCounter), customer); 
        bookable.checkIn();
        billList.add(bill);
        billCounter++;
        return success("BOOK PHONG", roomId);
    }
}
