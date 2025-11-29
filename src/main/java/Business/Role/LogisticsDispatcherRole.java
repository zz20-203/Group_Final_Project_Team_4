/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import Business.Organization.LogisticsOrganization;
import ui.LogisticsRole.LogisticsDispatcherWorkAreaJPanel;


/**
 * Role for the logistics dispatcher in FoodSupply.
 */
public class LogisticsDispatcherRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                UserAccount account,
                                Organization organization,
                                Enterprise enterprise,
                                EcoSystem business) {
        return new LogisticsDispatcherWorkAreaJPanel(
                userProcessContainer,
                account,
                (LogisticsOrganization) organization,
                enterprise,
                business
        );
    }

    @Override
    public String toString() {
        return "LogisticsDispatcher";
    }
}