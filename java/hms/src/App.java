import java.time.LocalDateTime;

import model.*;
import model.enums.*;
import service.hotelService;

public class App {

    public static void main(String[] args) {

        hotelService hotel = new hotelService();

        // =========================================================
        // 1. CREATE UTILITIES
        // =========================================================

        utility wifi = new utility(
            "WiFi",
            "U01",
            10.0
        );

        utility breakfast = new utility(
            "Breakfast",
            "U02",
            20.0
        );

        // =========================================================
        // 2. CREATE ROOM GROUP
        // =========================================================

        roomGroup deluxeGroup = new roomGroup(
            "Deluxe Room",
            "RG01",
            roomType.DELUXE
        );

        deluxeGroup.addUtility(wifi);
        deluxeGroup.addUtility(breakfast);

        // =========================================================
        // 3. CREATE ROOM
        // =========================================================

        Room room101 = new Room(
            "1st Floor",
            "R101",
            2,
            deluxeGroup,
            roomStatus.AVAILABLE,
            100.0
        );

        hotel.addRoom(room101);

        // =========================================================
        // 4. CREATE CUSTOMER
        // =========================================================

        Customer customer = new Customer(
            "KH01",
            "Alden",
            "0900000000",
            "012345678901",
            customerType.REGULAR
        );

        hotel.addCustomer(customer);

        System.out.println("===== INITIAL DATA =====");
        System.out.println(customer);
        System.out.println(room101);

        // =========================================================
        // 5. BOOK ROOM
        // =========================================================

        LocalDateTime startTime =
            LocalDateTime.of(2026, 10, 5, 14, 0);

        LocalDateTime endTime =
            LocalDateTime.of(2026, 10, 8, 12, 0);

        System.out.println("\n===== BOOK ROOM =====");

        boolean booked = hotel.bookRoom(
            "R101",
            "KH01",
            startTime,
            endTime
        );

        System.out.println("Booking result: " + booked);
        System.out.println("Room status: " + room101.getRoomStatus());

        // =========================================================
        // 6. FIND CONTRACT
        // =========================================================

        RentalContract contract =
            hotel.findContractById("C0");

        System.out.println("\n===== CONTRACT =====");
        System.out.println(contract);

        // =========================================================
        // 7. CHECK IN
        // =========================================================

        System.out.println("\n===== CHECK IN =====");

        LocalDateTime checkInTime =
            LocalDateTime.of(2026, 10, 5, 15, 0);

        boolean checkedIn =
            hotel.checkIn("C0", checkInTime);

        System.out.println("Check-in result: " + checkedIn);

        // =========================================================
        // 8. CHECK OUT
        // =========================================================
        // Checkout one day after planned end
        // so we can test overstay fee.

        System.out.println("\n===== CHECK OUT =====");

        LocalDateTime checkOutTime =
            LocalDateTime.of(2026, 10, 9, 12, 0);

        boolean checkedOut =
            hotel.checkOut("C0", checkOutTime);

        System.out.println("Check-out result: " + checkedOut);
        System.out.println("Room status: " + room101.getRoomStatus());

        // =========================================================
        // 9. CALCULATE FEES
        // =========================================================

        System.out.println("\n===== FEES =====");

        System.out.println(
            "Room fee: " +
            hotel.calculateRoomFee(contract)
        );

        System.out.println(
            "Overstay fee: " +
            hotel.calculateOverstayFee(contract)
        );

        System.out.println(
            "Utility fee: " +
            hotel.calculateUtilityFee(contract)
        );

        // =========================================================
        // 10. CREATE INVOICE
        // =========================================================

        System.out.println("\n===== CREATE INVOICE =====");

        hotel.createInvoice(
            contract,
            customer,
            paymentType.CASH
        );

        // =========================================================
        // 11. TEST DUPLICATE INVOICE
        // =========================================================

        System.out.println("\n===== DUPLICATE INVOICE TEST =====");

        hotel.createInvoice(
            contract,
            customer,
            paymentType.CARD
        );

        // =========================================================
        // 12. TEST DUPLICATE CHECK-IN
        // =========================================================

        System.out.println("\n===== DUPLICATE CHECK-IN TEST =====");

        hotel.checkIn(
            "C0",
            LocalDateTime.of(2026, 10, 5, 16, 0)
        );

        // =========================================================
        // 13. TEST CHECKOUT AGAIN
        // =========================================================

        System.out.println("\n===== DUPLICATE CHECK-OUT TEST =====");

        hotel.checkOut(
            "C0",
            LocalDateTime.of(2026, 10, 10, 12, 0)
        );

        // =========================================================
        // 14. FINAL STATE
        // =========================================================

        System.out.println("\n===== FINAL STATE =====");

        System.out.println("Contract:");
        System.out.println(contract);

        System.out.println("\nRoom:");
        System.out.println(room101);
    }
}