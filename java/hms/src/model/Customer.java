package model;

public abstract class Customer {
    private String id;
    private String name;
    private String phoneNumber;
    private String cccd;
    private int timeStayed = 0;
    private int moneySpended = 0;
    private customerType type;
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
}
