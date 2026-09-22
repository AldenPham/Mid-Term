package vn.ute.oop;

public class cBilling {
    private String billId;
    private abs_Customer payer;
    public cBilling(String billId, abs_Customer payer){
        this.billId = billId;
        this.payer = payer;
    }
    
    public String get_BillId(){
        return billId;
    }
}
