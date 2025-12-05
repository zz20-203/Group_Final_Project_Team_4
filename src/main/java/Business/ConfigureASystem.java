package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.CoffeeChainEnterprise;
import Business.Enterprise.DeliveryDepartment.Delivery;
import Business.Enterprise.DeliveryDepartment.Rider;
import Business.Network.Network;
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
import Business.Organization.CustomerServiceOrganization;
import Business.Organization.BeverageProductionOrganization;


// Delivery Imports
import Business.Enterprise.DeliveryEnterprise;
import Business.Organization.AnalystOrganization;
import Business.OrderQueue.CoffeeOrderRequest;
import Business.Organization.DeliveryDispatcherOrganization;
import Business.Role.AnalystRole;
import Business.Role.DeliveryDispatcherRole;
import Business.Role.RiderRole;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rrheg
 */

/*
 * Test Login (username / password):
 * System Admin:            sa / 1
 * 
 * CoffeeChain Enterprise:

 * Enterprise Admin:        ca / 1
 * Front Desk:              fd / 1
 * Barista:                 b  / 1
 * Store Manager:           sm / 1
 * 
 * FoodSupply Enterprise:

 * Enterprise Admin:        fa / 1
 * Warehouse Keeper:        wh / 1
 * Logistics Dispatcher:    ld / 1
 * 
 * Delivery Enterprise:

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
                .createAndAddEnterprise("Main Coffee Store", Enterprise.EnterpriseType.CoffeeChain);

        // 3. In CoffeeChain Enterprise, create 2 CafeOp, CafeMgmt Organizations
        OrganizationDirectory cafeOrgDir = CoffeeChain.getOrganizationDirectory();
        CustomerServiceOrganization custServiceOrg = (CustomerServiceOrganization) cafeOrgDir.createOrganization(Organization.Type.CustomerService);
        BeverageProductionOrganization bevProdOrg = (BeverageProductionOrganization) cafeOrgDir.createOrganization(Organization.Type.BeverageProduction);
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

        // c. Front Desk 
        Employee frontDeskEmp = custServiceOrg.getEmployeeDirectory().createEmployee("Front Desk One");
        UserAccount frontDeskUA = custServiceOrg.getUserAccountDirectory()
                .createUserAccount("fd", "1", frontDeskEmp, new FrontDeskRole());

        // d. Barista 
        Employee baristaEmp = bevProdOrg.getEmployeeDirectory().createEmployee("Barista One");
        UserAccount baristaUA = bevProdOrg.getUserAccountDirectory()
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
        
	//  Test Rider 

        int[] testRiderRegions = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Give test rider all regions to prevent assignment errors
        Rider testRider = deliveryDispatchOrg.getRiderDirectory().createRider(101L, "Test", "Rider", 9876543210L, testRiderRegions);
        
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
        
        
        // test cases (not faker):

        
        // 1. dine in
        CoffeeOrderRequest dineInOrder = new CoffeeOrderRequest();
        dineInOrder.setMessage("Latte"); 
        dineInOrder.setOrderType("Dine-in");
        dineInOrder.setDestination(); 
        dineInOrder.setStatus("Sent"); 
        dineInOrder.setSender(frontDeskUA);
        
        // add to queues
        bevProdOrg.getWorkQueue().getWorkRequestList().add(dineInOrder); 
        frontDeskUA.getWorkQueue().getWorkRequestList().add(dineInOrder); 
        
        
        // 2. delivery
        CoffeeOrderRequest deliveryOrder = new CoffeeOrderRequest();
        deliveryOrder.setMessage("Americano"); 
        deliveryOrder.setOrderType("Delivery");
       
        deliveryOrder.setDestination(1, "123 Java Street, Object City"); 
        
        deliveryOrder.setStatus("Ready"); 
        
        deliveryOrder.setSender(frontDeskUA);
        
        // add to queues
        bevProdOrg.getWorkQueue().getWorkRequestList().add(deliveryOrder);
        frontDeskUA.getWorkQueue().getWorkRequestList().add(deliveryOrder);
        
        
        // 3. delivery - sent status
        CoffeeOrderRequest deliveryOrderSent = new CoffeeOrderRequest();
        deliveryOrderSent.setMessage("Mocha"); 
        deliveryOrderSent.setOrderType("Delivery");
        deliveryOrderSent.setDestination(2, "456 Code Lane, Region 2"); 
        deliveryOrderSent.setStatus("Sent"); 
        deliveryOrderSent.setSender(frontDeskUA);
        
        bevProdOrg.getWorkQueue().getWorkRequestList().add(deliveryOrderSent);
        frontDeskUA.getWorkQueue().getWorkRequestList().add(deliveryOrderSent);
        
        
    populateFakeData(custServiceOrg, bevProdOrg, warehouseOrg, logisticsOrg, deliveryDispatchOrg, 
                         storeManagerUA, frontDeskUA, baristaUA, warehouseUA, logisticsUA);
        
        return system;
    }
    
    private static void populateFakeData(CustomerServiceOrganization custOrg, 
                                         BeverageProductionOrganization bevOrg,
                                         WarehouseOrganization wareOrg,
                                         LogisticsOrganization logOrg, 
                                         DeliveryDispatcherOrganization deliveryOrg,
                                         UserAccount storeManagerUA,
                                         UserAccount frontDeskUA,
                                         UserAccount baristaUA,
                                         UserAccount warehouseUA, 
                                         UserAccount logisticsUA) { 
        
        Faker faker = new Faker();
        Random rand = new Random();

        // 1. create employees 
        for (int i = 0; i < 5; i++) {
            custOrg.getEmployeeDirectory().createEmployee(faker.name().fullName());
            bevOrg.getEmployeeDirectory().createEmployee(faker.name().fullName());
        }
        
        // 2. create extra riders
                
        for (int i = 0; i < 5; i++) {
            String fName = faker.name().firstName();
            String lName = faker.name().lastName();
            long id = 200 + i;
            int[] regions = {rand.nextInt(10)+1, rand.nextInt(10)+1}; 
            deliveryOrg.getRiderDirectory().createRider(id, fName, lName, 9876543210L, regions);
            deliveryOrg.getEmployeeDirectory().createEmployee(fName + " " + lName);
        }
        
        ArrayList<Rider> availableRiders = deliveryOrg.getRiderDirectory().getEmployeeList();

        // A: supply orders 

        String[] supplyItems = {
            "Coffee - Dark Roast", "Coffee - Medium Roast", "Coffee - Light Roast", 
            "Coffee - Espresso", "Coffee - Decaf", 
            "Cups - Small (12oz)", "Cups - Medium (16oz)", "Cups - Large (20oz)", 
            "Milk - Whole", "Milk - Skim", "Milk - Almond", "Milk - Oat", "Other"
        };
        
        // 6 Defined Statuses
        String[] supplyStatuses = {
            "Sent to Warehouse",        //1.
            "Prepared in Warehouse",    //2.receiver: wh
            "Sent to Logistics",        //3.receiver: wh
            "Out for Delivery",         //4.receiver: ld, has tracking
            "Delivered to Store",       //5.receiver: ld, has tracking
            "Received by Store"         //6.receiver: ld, has tracking
        };
        
        for (int i = 0; i < 30; i++) {
            SupplyOrderRequest request = new SupplyOrderRequest();
            request.setItemName(supplyItems[rand.nextInt(supplyItems.length)]);            
            request.setStoreName("Main Coffee Store");
            request.setQuantity(faker.number().numberBetween(20, 200));
            request.setSender(storeManagerUA); // sender always is store manager
            
            // Randomly select status 
            int statusIndex = rand.nextInt(supplyStatuses.length);
            String currentStatus = supplyStatuses[statusIndex];
            request.setStatus(currentStatus);
            
            // based on status
            if (statusIndex == 0) {
                // 1. Sent to Warehouse / no receiver
                wareOrg.getWorkQueue().getWorkRequestList().add(request);
                
            } else if (statusIndex == 1 || statusIndex == 2) {
                // 2. Prepared in Warehouse; 3. Sent to Logistics
                // receiver: wh
                request.setReceiver(warehouseUA);
                
                if (statusIndex == 2) {
                    logOrg.getWorkQueue().getWorkRequestList().add(request);
                }
                wareOrg.getWorkQueue().getWorkRequestList().add(request);
                
            } else {
                // 4. Out for Delivery, 5. Delivered to Store, 6. Received by Store
                // receiver: ld, has tracking
                request.setReceiver(logisticsUA);
                request.setTrackingNumber(faker.code().ean8());
                
                logOrg.getWorkQueue().getWorkRequestList().add(request);
                wareOrg.getWorkQueue().getWorkRequestList().add(request);
            }
            
            storeManagerUA.getWorkQueue().getWorkRequestList().add(request);
        }


        // B: coffee orders 
        String[] coffeeMenu = { "Americano", "Latte", "Mocha", "Espresso" };
        String[] orderTypes = { "Dine-in", "Delivery" };
        
        for (int i = 0; i < 100; i++) {
            CoffeeOrderRequest order = new CoffeeOrderRequest();
            
            String drink = coffeeMenu[rand.nextInt(coffeeMenu.length)];
            order.setMessage(drink); 
            
            String type = orderTypes[rand.nextInt(orderTypes.length)];
            order.setOrderType(type);
            
            if ("Delivery".equals(type)) {
                int region = rand.nextInt(10) + 1;
                String address = faker.address().streetAddress();
                order.setDestination(region, address);
            } else {
                order.setDestination(); 
            }
            
            order.setSender(frontDeskUA);
            
            // status: Sent, Pending, Ready
            int statusRoll = rand.nextInt(10);
            
            if (statusRoll == 0 || statusRoll == 1) {
                // 1. Sent (receiver: waiting)
                order.setStatus("Sent");
                order.setReceiver(null); 
                
            } 
            else if (statusRoll < 4 ) {
                // 2. Pending (receiver: barista)
                order.setStatus("Pending");
                order.setReceiver(baristaUA); 
                
            } 
            else if (statusRoll < 6) {
                // 3. Ready (receiver: barista)
                order.setStatus("Ready");
                order.setReceiver(baristaUA);
            }
            else if (statusRoll < 8) {
                // Assigned / In-Progress
                order.setStatus("In-Progress");
                Rider r = availableRiders.get(rand.nextInt(availableRiders.size()));
                    
                try {
                    Delivery d = new Delivery(order, r);
                    // Start time: 30-60 mins ago
                    d.setDateTimeSent(System.currentTimeMillis() - (rand.nextInt(3600000) + 1800000));
                    deliveryOrg.getDeliveryDirectory().addDelivery(d);
                } catch (Exception e) { /* Ignore region mismatches for fakes */ }        
            } 
            else {
                // Delivered
                order.setStatus("Delivered");
                Rider r = availableRiders.get(rand.nextInt(availableRiders.size()));

                try {
                    Delivery d = new Delivery(order, r);
                    long startTime = System.currentTimeMillis() - (rand.nextInt(7200000) + 3600000);
                    long duration = rand.nextInt(3000000) + 600000;
                    d.setDateTimeSent(startTime);
                    d.setDateTimeArrived(startTime + duration);

                    deliveryOrg.getDeliveryDirectory().addDelivery(d);
                } catch (Exception e) {}
            }
            bevOrg.getWorkQueue().getWorkRequestList().add(order);
            frontDeskUA.getWorkQueue().getWorkRequestList().add(order);
            
            if (order.getReceiver() != null) {
                baristaUA.getWorkQueue().getWorkRequestList().add(order);
            }
        }
    }
}