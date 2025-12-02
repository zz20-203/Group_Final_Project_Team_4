/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FrontDeskRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class CustomerServiceOrganization extends Organization{

    public CustomerServiceOrganization() {
        super(Organization.Type.CustomerService.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FrontDeskRole());
        return roles;
    }
     
}