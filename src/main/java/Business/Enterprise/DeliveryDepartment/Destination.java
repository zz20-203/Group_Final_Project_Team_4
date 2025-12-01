/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise.DeliveryDepartment;

import java.util.Objects;

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

    public void setRegion(int region) {
        this.region = region;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Destination that = (Destination) obj;
        return Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}