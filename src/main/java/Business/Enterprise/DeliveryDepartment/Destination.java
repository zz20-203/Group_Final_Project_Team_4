/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise.DeliveryDepartment;

/**
 *
 * @author Luciela us Biktria
 */
public class Destination {
    
    int region;
    String address;
    public Destination(int reg, String add) { 
        region = reg;
        address = add;
    }

    public int getRegion() {
        return region;
    }

    public String getAddress() {
        return address;
    }
}
