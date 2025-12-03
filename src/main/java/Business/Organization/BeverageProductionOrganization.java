/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.BaristaRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author madison
 */
public class BeverageProductionOrganization extends Organization {

    public BeverageProductionOrganization() {
        super(Organization.Type.BeverageProduction.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new BaristaRole());
        return roles;
    }
}
