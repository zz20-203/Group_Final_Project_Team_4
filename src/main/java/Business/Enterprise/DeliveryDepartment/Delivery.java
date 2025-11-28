/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise.DeliveryDepartment;

/**
 *
 * @author Luciela us Biktria
 */
public class Delivery {
    Rider rider;
    Order order;
    Destination destination;
    
    int dateTimeSent;
    int dateTimeArrived;
    
    public Delivery(Order o, Destination d, Rider r) {
        order = o;
        destination = d;
        rider = r;
        
    }

    public Rider getRider() {
        return rider;
    }

    public Order getOrder() {
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
