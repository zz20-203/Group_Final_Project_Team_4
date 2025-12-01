/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

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
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        
        if (type != null) {
            switch (type) {
                case CafeOperation -> {
                    organization = new CafeOperationOrganization();
                    organizationList.add(organization);
                }
                case CafeManagement -> {
                    organization = new CafeManagementOrganization();
                    organizationList.add(organization);
                }
                case Warehouse -> {
                    organization = new WarehouseOrganization();
                    organizationList.add(organization);
                }
                case Logistics -> {
                    organization = new LogisticsOrganization();
                    organizationList.add(organization);
                }
                case Dispatch -> {
                    organization = new DeliveryDispatcherOrganization();
                    organizationList.add(organization);
                }
                default -> {
                }
            }
        }
        
        return organization;
    }
}