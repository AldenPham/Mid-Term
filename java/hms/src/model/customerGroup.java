package model;
import model.enums.*;

public class customerGroup {
    private String customerGroupId;
    private customerType type;


    //constructor
    public customerGroup(
        String customerGroupId,
        customerType type
    ){
        this.customerGroupId = customerGroupId;
        this.type = type;
    }

    public String getCustomerGroupId() {
        return customerGroupId;
    }

    public String toString() {
        return "customerGroup{" +
                "customerGroupId='" + customerGroupId + '\'' +
                ", type=" + type +
                '}';
    }   
}
