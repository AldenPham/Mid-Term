package vn.ute.oop;

public abstract class abs_Customer {
    private final String customerId;

    protected abs_Customer(String customerId){
        this.customerId = customerId;
    }

    public String get_CustomerId(){
        return customerId;
    }
}
