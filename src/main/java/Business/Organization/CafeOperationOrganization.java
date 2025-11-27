/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BaristaRole;
import Business.Role.FrontDeskRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class CafeOperationOrganization extends Organization{

    public CafeOperationOrganization() {
        super(Organization.Type.CafeOperation.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FrontDeskRole());
        roles.add(new BaristaRole());
        return roles;
    }
     
}