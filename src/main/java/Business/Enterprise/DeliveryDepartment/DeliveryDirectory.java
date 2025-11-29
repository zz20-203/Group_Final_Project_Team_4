/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise.DeliveryDepartment;

import Business.OrderQueue.CoffeeOrderRequest;
import java.util.ArrayList;

/**
 *
 * @author Luciela us Biktria
 */
public class DeliveryDirectory {
    private ArrayList<Delivery> deliveries;
    
    public DeliveryDirectory(){
        deliveries = new ArrayList<Delivery>();
    }
    
    public ArrayList<Delivery> getDeliveryList() {
        return deliveries;
    }
    
    public void addDelivery(Delivery d) {
        // Remove existing delivery for this order if it exists to allow updates
        Delivery existing = findDeliveryByOrder(d.getOrder());
        if (existing != null) {
            deliveries.remove(existing);
        }
        deliveries.add(d);
    }
    
    public Delivery findDeliveryByOrder(CoffeeOrderRequest order) {
        for (Delivery d : deliveries) {
            if (d.getOrder().equals(order)) {
                return d;
            }
        }
        return null;
    }
}