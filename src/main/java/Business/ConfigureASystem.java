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

// Delivery Imports
import Business.Enterprise.DeliveryEnterprise;
import Business.Organization.AnalystOrganization;
import Business.Organization.DeliveryDispatcherOrganization;
import Business.Role.AnalystRole;
import Business.Role.DeliveryDispatcherRole;
import Business.Role.RiderRole;

/**
 *
 * @author rrheg
 */

/*
 * TEST CREDENTIALS LIST    UN / PW
 * ===========================================
 * System Admin:            sa / 1
 * 
 * -- CoffeeChain Enterprise --
 * Enterprise Admin:        ca / 1
 * Front Desk:              fd / 1
 * Barista:                 b  / 1
 * Store Manager:           sm / 1
 * 
 * -- FoodSupply Enterprise --
 * Enterprise Admin:        fa / 1
 * Warehouse Keeper:        wh / 1
 * Logistics Dispatcher:    ld / 1
 * 
 * -- Delivery Enterprise --
 * Enterprise Admin:        da / 1
 * Delivery Dispatcher:     dd / 1
 * Rider:                   r  / 1
 * Analyst:                 an / 1
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
        
        //Delivery part:
        //Create Delivery Enterprise
        DeliveryEnterprise deliveryEnterprise = (DeliveryEnterprise) enterpriseDirectory
                .createAndAddEnterprise("FastDelivery", Enterprise.EnterpriseType.Delivery);
        
        //Organizations inside Delivery: Dispatch, Analyst
        OrganizationDirectory deliveryOrgDir = deliveryEnterprise.getOrganizationDirectory();
        DeliveryDispatcherOrganization deliveryDispatchOrg = (DeliveryDispatcherOrganization)
                deliveryOrgDir.createOrganization(Organization.Type.Dispatch);
        
        AnalystOrganization analystOrg = (AnalystOrganization)
                deliveryOrgDir.createOrganization(Organization.Type.Analyst);
        
        
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
        
        
        
        // FoodSupply part:
        // Warehouse Keeper (FoodSupply)
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
                
        // Delivery Part:
        // Delivery Dispatcher
        Employee deliveryDispatchEmp = deliveryDispatchOrg.getEmployeeDirectory().createEmployee("Delivery Dispatcher One");
        UserAccount deliveryDispatchUA = deliveryDispatchOrg.getUserAccountDirectory()
                .createUserAccount("dd", "1", deliveryDispatchEmp, new DeliveryDispatcherRole());
        
        // Delivery Admin
        Employee deliveryAdminEmp = deliveryEnterprise.getEmployeeDirectory().createEmployee("Delivery Admin One");
        UserAccount deliveryAdminUA = deliveryEnterprise.getUserAccountDirectory()
                .createUserAccount("da", "1", deliveryAdminEmp, new AdminRole());
        
        // Analyst
        Employee analystEmp = analystOrg.getEmployeeDirectory().createEmployee("Chief Analyst");
        UserAccount analystUA = analystOrg.getUserAccountDirectory()
        .createUserAccount("ana", "1", analystEmp, new AnalystRole());
        
	// ** Test Rider **
        // Create the Rider business object (ID: 101, Regions: 1,2,3)
        int[] testRiderRegions = {1, 2, 3};
        deliveryDispatchOrg.getRiderDirectory().createRider(101L, "Test", "Rider", 9876543210L, testRiderRegions);
        
        // Create the System Employee (Name for ManageAccount matching)
        Employee riderEmp = deliveryDispatchOrg.getEmployeeDirectory().createEmployee("Test Rider");
        
        // Create the User Account
        UserAccount riderUA = deliveryDispatchOrg.getUserAccountDirectory()
                .createUserAccount("r", "1", riderEmp, new RiderRole());
		
        
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