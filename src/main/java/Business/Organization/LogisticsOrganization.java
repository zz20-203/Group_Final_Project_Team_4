/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;
import Business.Role.LogisticsDispatcherRole;

import Business.Role.Role;
import java.util.ArrayList;

/**
 * Organization representing the logistics/transportation department in FoodSupply.
 */
public class LogisticsOrganization extends Organization {

    public LogisticsOrganization() {
        super(Organization.Type.Logistics.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LogisticsDispatcherRole());
        return roles;
    }
}