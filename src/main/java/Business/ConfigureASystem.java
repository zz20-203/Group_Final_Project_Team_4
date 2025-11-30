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
import Business.Role.AdminRole;
import Business.Role.FrontDeskRole;
import Business.Role.BaristaRole;
import Business.Role.StoreManagerRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import Business.Enterprise.FoodSupplyEnterprise;
import Business.Organization.WarehouseOrganization;
import Business.Organization.LogisticsOrganization;
import Business.Role.WarehouseKeeperRole;
import Business.Role.LogisticsDispatcherRole;
import Business.OrderQueue.SupplyOrderRequest;

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
        
        // 1. create a Network
        Network network = system.createAndAddNetwork();
        network.setName("Default Network");

        // 2. In Network, create a CoffeeChain Enterprise
        EnterpriseDirectory enterpriseDirectory = network.getEnterpriseDirectory();
        CoffeeChainEnterprise CoffeeChain = (CoffeeChainEnterprise) enterpriseDirectory
                .createAndAddEnterprise("CoffeeChain", Enterprise.EnterpriseType.CoffeeChain);

        // 3. In CoffeeChain Enterprise, create 2 CafeOp, CafeMgmt Organizations
        OrganizationDirectory cafeOrgDir = CoffeeChain.getOrganizationDirectory();
        CafeOperationOrganization cafeOpOrg = (CafeOperationOrganization) cafeOrgDir.createOrganization(Organization.Type.CafeOperation);
        CafeManagementOrganization cafeMgmtOrg = (CafeManagementOrganization) cafeOrgDir.createOrganization(Organization.Type.CafeManagement);
                
        //FoodSupply part:
        //Create FoodSupply enterprise
        FoodSupplyEnterprise foodSupply = (FoodSupplyEnterprise) enterpriseDirectory
                .createAndAddEnterprise("FoodSupply", Enterprise.EnterpriseType.FoodSupply);
                
        //Organizations inside FoodSupply: Warehouse + Logistics
        OrganizationDirectory foodOrgDir = foodSupply.getOrganizationDirectory();
        WarehouseOrganization warehouseOrg = (WarehouseOrganization)
                foodOrgDir.createOrganization(Organization.Type.Warehouse);
        LogisticsOrganization logisticsOrg = (LogisticsOrganization)
                foodOrgDir.createOrganization(Organization.Type.Logistics);
        
        //4. have some employees 
        //5. create user account
        
        
        // a. System Admin
        Employee sysEmp = system.getEmployeeDirectory().createEmployee("System Admin");
        UserAccount sysAdminUA = system.getUserAccountDirectory()
                .createUserAccount("sa", "1", sysEmp, new SystemAdminRole());

        // b. Cafe Admin（Enterprise Admin）
        Employee cafeAdminEmp = CoffeeChain.getEmployeeDirectory().createEmployee("CoffeeChain Admin One");
        UserAccount cafeAdminUA = CoffeeChain.getUserAccountDirectory()
                .createUserAccount("ca", "1", cafeAdminEmp, new AdminRole());

        // c.Front Desk
        Employee frontDeskEmp = cafeOpOrg.getEmployeeDirectory().createEmployee("Front Desk One");
        UserAccount frontDeskUA = cafeOpOrg.getUserAccountDirectory()
                .createUserAccount("fd", "1", frontDeskEmp, new FrontDeskRole());

        // d. Barista
        Employee baristaEmp = cafeOpOrg.getEmployeeDirectory().createEmployee("Barista One");
        UserAccount baristaUA = cafeOpOrg.getUserAccountDirectory()
                .createUserAccount("b", "1", baristaEmp, new BaristaRole());

        // e. Store Manager
        Employee storeManagerEmp = cafeMgmtOrg.getEmployeeDirectory().createEmployee("Store Manager One");
        UserAccount storeManagerUA = cafeMgmtOrg.getUserAccountDirectory()
                .createUserAccount("sm", "1", storeManagerEmp, new StoreManagerRole());
        
        
        
        //FoodSupply part:
        //Warehouse Keeper (FoodSupply)
        Employee warehouseEmp = warehouseOrg.getEmployeeDirectory().createEmployee("Warehouse Keeper One");
        UserAccount warehouseUA = warehouseOrg.getUserAccountDirectory()
                .createUserAccount("wh", "1", warehouseEmp, new WarehouseKeeperRole());

        // Logistics Dispatcher (FoodSupply)
        Employee logisticsEmp = logisticsOrg.getEmployeeDirectory().createEmployee("Logistics Dispatcher One");
        UserAccount logisticsUA = logisticsOrg.getUserAccountDirectory()
                .createUserAccount("ld", "1", logisticsEmp, new LogisticsDispatcherRole());
        
        // admin
        Employee fsAdminEmp = foodSupply.getEmployeeDirectory().createEmployee("FoodSupply Admin One");
        UserAccount fsAdminUA = foodSupply.getUserAccountDirectory()
                .createUserAccount("fa", "1", fsAdminEmp, new Business.Role.AdminRole());
        
        // Add sample SupplyOrderRequest for testing
        SupplyOrderRequest sOrder = new SupplyOrderRequest();
        sOrder.setStoreName("Main Coffee Store");
        sOrder.setItemName("Coffee Beans - Dark Roast");
        sOrder.setQuantity(100);
        sOrder.setSender(storeManagerUA);
        sOrder.setStatus("Sent to Warehouse");

        // Put the request into Warehouse organization's queue
        warehouseOrg.getWorkQueue().getWorkRequestList().add(sOrder);

        // Also track it in the Store Manager's personal queue
        storeManagerUA.getWorkQueue().getWorkRequestList().add(sOrder);
        
        return system;
    }
    
}
