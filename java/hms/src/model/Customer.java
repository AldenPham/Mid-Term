package model;
import model.enums.*;


public class Customer {
    private String id;
    private String name;
    private String phoneNumber;
    private String cccd;
    private int timeStayed = 0;
    private int moneySpended = 0;
    private customerType type;

    //Constructor
    public Customer(String id,
                    String name,
                    String phoneNumber,
                    String cccd,
                    customerType type
    ){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cccd = cccd;
        this.type = type;
    }

    public String get_id(){
        return id;
    }
}
