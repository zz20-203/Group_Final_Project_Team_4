/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;
import Business.Role.WarehouseKeeperRole;

import Business.Role.Role;
import java.util.ArrayList;

/**
 * Organization representing the warehouse department in FoodSupply.
 */
public class WarehouseOrganization extends Organization {

    public WarehouseOrganization() {
        super(Organization.Type.Warehouse.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new WarehouseKeeperRole());
        return roles;
    }
}
