/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Luciela us Biktria
 */
public class DeliveryEnterprise extends Enterprise {
    /**
    * This is the delivery company and their deliveryboys/girls.
    */
    public DeliveryEnterprise(String name){
        super(name, Enterprise.EnterpriseType.Delivery);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    @Override
    public ArrayList<Organization.Type> getSupportedOrganizationTypes() {
        ArrayList<Organization.Type> types = new ArrayList<>();
        types.add(Organization.Type.Dispatch);
        return types;
    }
    
}
