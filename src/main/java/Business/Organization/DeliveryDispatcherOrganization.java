/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.DeliveryDispatcherRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Luciela us Biktria
 */
public class DeliveryDispatcherOrganization extends Organization {
    public DeliveryDispatcherOrganization() {
        super(Organization.Type.CafeManagement.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DeliveryDispatcherRole());
        return roles;
    }
}
