/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.StoreManagerRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class CafeManagementOrganization extends Organization{

    public CafeManagementOrganization() {
        super(Organization.Type.CafeMgmt.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new StoreManagerRole());
        return roles;
    }
     
   
    
    
}
