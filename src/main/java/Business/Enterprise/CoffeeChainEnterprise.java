/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class CoffeeChainEnterprise extends Enterprise {
    
    public CoffeeChainEnterprise(String name){
        super(name,EnterpriseType.CoffeeChain);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    @Override
    public ArrayList<Organization.Type> getSupportedOrganizationTypes() {
        ArrayList<Organization.Type> types = new ArrayList<>();
        types.add(Organization.Type.CafeOperation);
        types.add(Organization.Type.CafeManagement);
        return types;
}
}


