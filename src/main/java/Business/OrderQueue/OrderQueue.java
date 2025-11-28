/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrderQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrderQueue {
    
    private ArrayList<OrderRequest> workRequestList;

    public OrderQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<OrderRequest> getWorkRequestList() {
        return workRequestList;
    }
}