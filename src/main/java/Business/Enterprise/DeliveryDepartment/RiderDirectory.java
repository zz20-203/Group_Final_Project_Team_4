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
public class RiderDirectory {
    private final ArrayList<Rider> riderList;

    public RiderDirectory() {
        riderList = new ArrayList<>();
    }

    public ArrayList<Rider> getEmployeeList() {
        return riderList;
    }
    
    public Rider createRider(long id, String firstName, String lastName, long phoneNumber, int[] regions){
        Rider rider = new Rider();
        
        rider.setId(id);
        rider.setFirstName(firstName);
        rider.setLastName(lastName);
        rider.setRegions(regions);
        rider.setPhoneNumber(phoneNumber);
        
        riderList.add(rider);
        return rider;
    }
}
