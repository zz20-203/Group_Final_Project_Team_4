/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrderQueue;

import Business.Enterprise.DeliveryDepartment.Destination;
import Business.UserAccount.UserAccount;

/**
 *
 * @author raunak
 */
public class CoffeeOrderRequest extends OrderRequest{
    
    private boolean approval = false;
    private UserAccount approvedBy;
    
    private String orderType;
    
    //order number
    private static int count = 1;
    private int orderNumber;
    
    //Jerry
    //Destination to allow deliveries
    
    Destination destination;
    
    public CoffeeOrderRequest() { //constructor
      
        orderNumber = count;
        count++;
        
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    //Jerry
    //Destination to allow deliveries
    
    public Destination getDestination() {
        return destination;
    }

    public void setDestination(){
        // Initialize destination if it is null
        if (this.destination == null) {
            this.destination = new Destination(0, "[In-Store]");
        } else {
            this.destination.setRegion(0);
            this.destination.setAddress("[In-Store]");        
        }
    }
    
    public void setDestination(int region, String address) {
        
        // Initialize destination if it is null
        if (this.destination == null) {
            this.destination = new Destination(region, address);
        }
        
        // Added null check for orderType, just to be safe
        if (this.orderType != null && this.orderType.contentEquals("Dine-In")){
            this.destination.setRegion(0);
            this.destination.setAddress("[In-Store]");
        }
        
        else {
            this.destination.setRegion(region);
            this.destination.setAddress(address);            
        }
        
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.getOrderNumber());
    }
    
}