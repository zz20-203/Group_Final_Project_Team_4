package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.CoffeeChainEnterprise;
import Business.Network.Network;
import Business.Organization.CafeOperationOrganization;
import Business.Organization.CafeManagementOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.CafeAdminRole;
import Business.Role.FrontDeskRole;
import Business.Role.BaristaRole;
import Business.Role.StoreManagerRole;
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

        // 2. 在 Network 里创建一个 CoffeeChain Enterprise
        EnterpriseDirectory enterpriseDirectory = network.getEnterpriseDirectory();
        CoffeeChainEnterprise CoffeeChain = (CoffeeChainEnterprise) enterpriseDirectory
                .createAndAddEnterprise("CoffeeChain", Enterprise.EnterpriseType.CoffeeChain);

        // 3. 在 CoffeeChain 里创建 CafeOp, CafeMgmt 2个 Organization
        OrganizationDirectory cafeOrgDir = CoffeeChain.getOrganizationDirectory();
        CafeOperationOrganization cafeOpOrg = (CafeOperationOrganization) cafeOrgDir.createOrganization(Organization.Type.CafeOperation);
        CafeManagementOrganization cafeMgmtOrg = (CafeManagementOrganization) cafeOrgDir.createOrganization(Organization.Type.CafeManagement);
        
        
        //4. have some employees 
        //5. create user account
        
        
        // ====== A. System Admin（系统级别）======
        Employee sysEmp = system.getEmployeeDirectory().createEmployee("System Admin");
        UserAccount sysAdminUA = system.getUserAccountDirectory()
                .createUserAccount("sa", "1", sysEmp, new SystemAdminRole());

        // ====== B. Cafe Admin（Enterprise Admin）======// Hospital Admin（Enterprise Admin）
        Employee cafeAdminEmp = CoffeeChain.getEmployeeDirectory().createEmployee("Cafe Admin");
        UserAccount cafeAdminUA = CoffeeChain.getUserAccountDirectory()
                .createUserAccount("ca", "1", cafeAdminEmp, new CafeAdminRole());

        // ====== C. Front Desk Staff ======// Doctor（医生）
        Employee frontDeskEmp = cafeOpOrg.getEmployeeDirectory().createEmployee("Doctor One");
        UserAccount frontDeskUA = cafeOpOrg.getUserAccountDirectory()
                .createUserAccount("fd", "1", frontDeskEmp, new FrontDeskRole());

        // ====== D. Barista ======// Lab Assistant（实验室助理）
        Employee baristaEmp = cafeOpOrg.getEmployeeDirectory().createEmployee("Lab Assistant One");
        UserAccount baristaUA = cafeOpOrg.getUserAccountDirectory()
                .createUserAccount("b", "1", baristaEmp, new BaristaRole());

        // ====== E. Store Manager ======// Lab Manager（实验室经理）
        Employee storeManagerEmp = cafeMgmtOrg.getEmployeeDirectory().createEmployee("Lab Manager One");
        UserAccount storeManagerUA = cafeMgmtOrg.getUserAccountDirectory()
                .createUserAccount("sm", "1", storeManagerEmp, new StoreManagerRole());

        
        return system;
    }
    
}
