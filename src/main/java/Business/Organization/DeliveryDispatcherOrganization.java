/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Enterprise.DeliveryDepartment.DeliveryDirectory;
import Business.Enterprise.DeliveryDepartment.RiderDirectory;
import Business.Role.DeliveryDispatcherRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Luciela us Biktria
 */
public class DeliveryDispatcherOrganization extends Organization {
    
    private RiderDirectory riderDirectory;
    private DeliveryDirectory deliveryDirectory;
    
    public DeliveryDispatcherOrganization() {
        super(Organization.Type.Dispatch.getValue());
        riderDirectory = new RiderDirectory();
        deliveryDirectory = new DeliveryDirectory();
    }

    public RiderDirectory getRiderDirectory() {
        return riderDirectory;
    }

    public DeliveryDirectory getDeliveryDirectory() {
        return deliveryDirectory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DeliveryDispatcherRole());
        return roles;
    }
}