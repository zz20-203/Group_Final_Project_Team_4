/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Enterprise.AnalyticsDepartment.ReportDirectory;
import Business.Role.AnalystRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Luciela us Biktria
 */
public class AnalystOrganization extends Organization {
    
    private ReportDirectory reportDirectory;
    
    public AnalystOrganization() {
        super(Organization.Type.Analyst.getValue());
        reportDirectory = new ReportDirectory();
    }

    public ReportDirectory getReportDirectory() {
        return reportDirectory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AnalystRole());
        return roles;
    }
}