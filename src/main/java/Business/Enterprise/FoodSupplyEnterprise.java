package Business.Enterprise;

import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * FoodSupplyEnterprise represents the supplier company that manages
 * warehouse and logistics for the coffee chain.
 */
public class FoodSupplyEnterprise extends Enterprise {

    public FoodSupplyEnterprise(String name) {
        super(name, EnterpriseType.FoodSupply);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return new ArrayList<>();
    }
    @Override
    public ArrayList<Organization.Type> getSupportedOrganizationTypes() {
        ArrayList<Organization.Type> types = new ArrayList<>();
        types.add(Organization.Type.Warehouse);
        types.add(Organization.Type.Logistics);
        return types;
    }
}