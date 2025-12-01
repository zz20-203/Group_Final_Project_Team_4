/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise.DeliveryDepartment;

import java.util.ArrayList;

/**
 *
 * @author Luciela us Biktria
 */
public class DestinationDirectory {
    private ArrayList<Destination> destinationList;

    public DestinationDirectory() {
        destinationList = new ArrayList<>();
    }

    public ArrayList<Destination> getDestinationList() {
        return destinationList;
    }
    
    public void addDestination(Destination d) {
        // Prevent duplicates based on address
        for(Destination existing : destinationList) {
            if(existing.getAddress().equalsIgnoreCase(d.getAddress())) {
                return;
            }
        }
        destinationList.add(d);
    }
    
    public Destination findDestination(String address) {
        for(Destination d : destinationList) {
            if(d.getAddress().equalsIgnoreCase(address)) {
                return d;
            }
        }
        return null;
    }
}