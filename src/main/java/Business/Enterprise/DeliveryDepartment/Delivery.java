/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise.DeliveryDepartment;

import Business.OrderQueue.CoffeeOrderRequest;
import java.util.stream.IntStream;

/**
 *
 * @author Luciela us Biktria
 */
public class Delivery {
    Rider rider;
    CoffeeOrderRequest order;
    Destination destination;
    
    int dateTimeSent;
    int dateTimeArrived;
    
    public Delivery(CoffeeOrderRequest o, Rider r) {
        order = o;
        destination = o.getDestination();
        rider = r;
        
        if (destination.getRegion() == 0) {
            throw new IllegalArgumentException("This destination is In-Store and cannot be delivered to.");
        }
        
        if (IntStream.of(rider.getRegions()).anyMatch(x -> x == destination.getRegion())){
            throw new IllegalArgumentException("This rider does not currently perform deliveries to the region of this delivery.");
        }
    }

    public Rider getRider() {
        return rider;
    }

    public CoffeeOrderRequest getOrder() {
        return order;
    }

    public Destination getDestination() {
        return destination;
    }

    public int getDateTimeSent() {
        return dateTimeSent;
    }

    public void setDateTimeSent(int dateTimeSent) {
        this.dateTimeSent = dateTimeSent;
    }

    public int getDateTimeArrived() {
        return dateTimeArrived;
    }

    public void setDateTimeArrived(int dateTimeArrived) {
        this.dateTimeArrived = dateTimeArrived;
    }
}
