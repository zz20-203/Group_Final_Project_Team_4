/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import Business.Enterprise.CoffeeChainEnterprise;
import Business.Enterprise.FoodSupplyEnterprise;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.CafeOperation.getValue())){
            organization = new CafeOperationOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CafeManagement.getValue())){
            organization = new CafeManagementOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Warehouse.getValue())){
            organization = new WarehouseOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Logistics.getValue())){
            organization = new LogisticsOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}