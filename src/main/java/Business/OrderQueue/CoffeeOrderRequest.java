/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrderQueue;

import Business.UserAccount.UserAccount;

/**
 *
 * @author raunak
 */
public class CoffeeOrderRequest extends OrderRequest{
    
    private boolean approval = false;
    private UserAccount approvedBy;
    
    //order number
    private static int count = 1;
    private int orderNumber;
    
    public CoffeeOrderRequest() { //constructor
      
        orderNumber = count;
        count++;
        
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    @Override
    public String toString() {
        return getMessage();
    }
    
//    public String getTestResult() {
//        return testResult;
//    }
//
//    public void setTestResult(String testResult) {
//        this.testResult = testResult;
//    }
    
    
}
