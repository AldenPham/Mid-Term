package service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import model.*;
import model.enums.*;
import model.enums.roomStatus;

public class hotelService {
    private List<Customer> customers;
    private List<Room> rooms;
    private List<RentalContract> contracts;
    private List<Invoice> invoices;

    // ===== Constructor
    public hotelService() {
        customers = new ArrayList<>();
        rooms = new ArrayList<>();
        contracts = new ArrayList<>();
        invoices = new ArrayList<>();
    }

    // ===== ADD CUSTOMER
    public boolean addCustomer(Customer customer){

        customers.add(customer);

        return true;
    }

    // ===== FIND CUSTOMER
    public Customer findCustomer(String customerId){
        for(Customer a : customers){
            if(a.get_id().equals(customerId)){
                return a;
            }
        }

        return null;
    }


    // ===== FIND Contract by Customer
    public List<RentalContract> findContractByCustomer(Customer customer){
        List<RentalContract> result = new ArrayList<>();
        for(RentalContract c : contracts){
            if(c.getCustomer().equals(customer) && c.getStatus() == contractStatus.onGoing){
                result.add(c);
            }
        }

        return result;
    }


    // ===== ADD ROOM
    public boolean addRoom(Room room){
        rooms.add(room);
        return true;
    }

    // ===== FIND ROOM
    public Room findRoom(String roomId){
        for(Room a : rooms){
            if(a.getRoomId().equals(roomId)){
                return a;
            }
        }

        return null;
    }

    // ===== BOOK ROOM 
    public boolean bookRoom(String roomId, 
                            String customerId,
                            LocalDateTime startTime,
                            LocalDateTime endTime){
        // Check startTime and endTime is valid or no
        if(startTime.isAfter(endTime) || startTime.isEqual(endTime)){
            System.out.println("Invalid start time or end time");
            return false;
        }

        // Find customer and room
        Customer customer = findCustomer(customerId);
        Room room = findRoom(roomId);

        //Check customer and room status
        if(customer == null){
            System.out.println("Customer not found");
            return false;
        }

        if(room == null){
            System.out.println("Room not found");
            return false;
        }

        if(room.getRoomStatus() != roomStatus.AVAILABLE){
            System.out.println("Room is already booked");
            return false;
        }
        else{
            // Change room status to booked
            room.setRoomStatus(roomStatus.BOOKED);
            // Create a new rental contract
            RentalContract contract = new RentalContract(
                "C" + (contracts.size() + 1),
                customer,
                room,
                startTime,
                endTime);

            // Add the contract to the list of contracts
            contracts.add(contract);
            
            System.out.println("Room booked successfully");
        }

        return true;
    }


    // ===== Check IN
    public boolean checkIn(Customer customer, LocalDateTime checkInTime){
        // Find the contract that stand under customerName
        List<RentalContract> customerContracts = findContractByCustomer(customer);

        // If can't find the contract, return false
        if(customerContracts.isEmpty()){
            System.out.println("No contract found for this customer");
            return false;
        }

        // Display the contracts and ask for contract ID
        System.out.println("Customer has the following contracts:");
        for(RentalContract c : customerContracts){
            System.out.println(c.toString());
        }
        System.out.println("Please enter the contract ID to check in:");
        Console console = System.console();
        
        // Read the contract ID from the console
        String contractId = console.readLine();

        RentalContract contract = null;

        while (contract == null) {

            for (RentalContract c : customerContracts) {
                if (c.getContractId().equals(contractId)) {
                    contract = c;
                    break;
                }
            }

            if (contract == null) {
                System.out.println("Contract not found. Try again:");
                contractId = console.readLine();
            }
        }

        // Check if the check-in time is valid
        if(checkInTime.isBefore(contract.getStartTime()) || checkInTime.isAfter(contract.getEndTime())){
            System.out.println("Invalid check-in time");
            return false;
        }  

        // Set the check-in time for the contract
        contract.setCheckInTime(checkInTime);

        return true;
    }
    
    // ===== Check OUT
    public boolean checkOut(Customer customer, LocalDateTime checkOutTime){
        // Find the contract that stand under customerName
        List<RentalContract> customerContracts = findContractByCustomer(customer);

        // If can't find the contract, return false
        if(customerContracts.isEmpty()){
            System.out.println("No contract found for this customer");
            return false;
        }

        // Display the contracts and ask for contract ID
        System.out.println("Customer has the following contracts:");
        for(RentalContract c : customerContracts){
            System.out.println(c.toString());
        }
        System.out.println("Please enter the contract ID to check in:");
        Console console = System.console();
        
        // Read the contract ID from the console
        String contractId = console.readLine();

        RentalContract contract = null;

        while (contract == null) {

            for (RentalContract c : customerContracts) {
                if (c.getContractId().equals(contractId)) {
                    contract = c;
                    break;
                }
            }

            if (contract == null) {
                System.out.println("Contract not found. Try again:");
                contractId = console.readLine();
            }
        }

        // Check if the check-out time is valid
        if(checkOutTime.isBefore(contract.getCheckInTime())){
            System.out.println("Invalid check-out time");
            return false;
        }

        // Set the check-out time for the contract
        contract.setCheckOutTime(checkOutTime);
        contract.endContract();

        return true;
    }

    // ===== Calculate bill
    public double calculateRoomFee(RentalContract contract){
        
        long days = contract.getEndTime().toLocalDate().toEpochDay() - contract.getStartTime().toLocalDate().toEpochDay();

        return (double) days * contract.getRoom().getRoomPrice();
    }
    public double calculateOverstayFee(RentalContract contract){
        long days = contract.getCheckOutTime().toLocalDate().toEpochDay() - contract.getEndTime().toLocalDate().toEpochDay();

        return contract.getOverStayFeePerDay() * (double) days;
    }
    public double calculateUtilityFee(RentalContract contract){
        return 0.0;
    }

    // ===== CREATE INVOICE
    public void createInvoice(RentalContract contract,
                             Customer payer,
                             paymentType paymentType) {

        double roomFee = calculateRoomFee(contract);
        double overstayFee = calculateOverstayFee(contract);
        double utilityFee = calculateUtilityFee(contract);

        double deposit = roomFee * 0.10;

        double total = roomFee + overstayFee + utilityFee;

        Invoice invoice = new Invoice(
            "I" + (invoices.size() + 1),
            payer,
            contract,
            paymentType,
            roomFee,
            overstayFee,
            utilityFee,
            deposit,
            total
        );

        invoices.add(invoice);

        System.out.println(invoice.toString());
    }
}



    
