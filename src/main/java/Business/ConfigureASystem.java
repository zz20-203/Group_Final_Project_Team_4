package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.AdminRole;
import Business.Role.DoctorRole;
import Business.Role.LabAssistantRole;
import Business.Role.LabManagerRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
//        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
//        
//        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sa", "1", employee, new SystemAdminRole());
//        UserAccount labManager = system.getUserAccountDirectory().createUserAccount("lm", "1", employee, new LabManagerRole());
        
        // 1. 创建一个 Network
        Network network = system.createAndAddNetwork();
        network.setName("Default Network");

        // 2. 在 Network 里创建一个 Hospital Enterprise
        EnterpriseDirectory enterpriseDirectory = network.getEnterpriseDirectory();
        HospitalEnterprise hospital = (HospitalEnterprise) enterpriseDirectory
                .createAndAddEnterprise("Test Hospital", Enterprise.EnterpriseType.Hospital);

        // 3. 在 Hospital 里创建 Doctor 和 Lab 两个 Organization
        OrganizationDirectory orgDir = hospital.getOrganizationDirectory();
        DoctorOrganization doctorOrg = (DoctorOrganization) orgDir.createOrganization(Organization.Type.Doctor);
        LabOrganization labOrg = (LabOrganization) orgDir.createOrganization(Organization.Type.Lab);

        // ====== A. System Admin（系统级别）======
        Employee sysEmp = system.getEmployeeDirectory().createEmployee("System Admin");
        UserAccount sysAdminUA = system.getUserAccountDirectory()
                .createUserAccount("sa", "1", sysEmp, new SystemAdminRole());

        // ====== B. Hospital Admin（Enterprise Admin）======//cafe admin
        Employee entAdminEmp = hospital.getEmployeeDirectory().createEmployee("Hospital Admin");
        UserAccount entAdminUA = hospital.getUserAccountDirectory()
                .createUserAccount("ha", "1", entAdminEmp, new AdminRole());

        // ====== C. Doctor（医生）======//front desk
        Employee doctorEmp = doctorOrg.getEmployeeDirectory().createEmployee("Doctor One");
        UserAccount doctorUA = doctorOrg.getUserAccountDirectory()
                .createUserAccount("d", "1", doctorEmp, new DoctorRole());

        // ====== D. Lab Assistant（实验室助理）======//store staff
        Employee labAssistantEmp = labOrg.getEmployeeDirectory().createEmployee("Lab Assistant One");
        UserAccount labAssistantUA = labOrg.getUserAccountDirectory()
                .createUserAccount("la", "1", labAssistantEmp, new LabAssistantRole());

        // ====== E. Lab Manager（实验室经理）======//store manager
        Employee labManagerEmp = labOrg.getEmployeeDirectory().createEmployee("Lab Manager One");
        UserAccount labManagerUA = labOrg.getUserAccountDirectory()
                .createUserAccount("lm", "1", labManagerEmp, new LabManagerRole());

        
        return system;
    }
    
}
