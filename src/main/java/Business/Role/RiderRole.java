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
import javax.swing.JLabel;

/**
 *
 * @author Luciela us Biktria
 */
public class RiderRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        // Placeholder for the Rider Work Area
        JPanel panel = new JPanel();
        panel.add(new JLabel("Welcome Rider! Work Area under construction."));
        return panel;
    }
    
    @Override
    public String toString(){
        return "Rider";
    }
}