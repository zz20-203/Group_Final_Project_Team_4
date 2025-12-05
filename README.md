# Group_Final_Project_Team_4
# Ecosystem — Coffee Chain + Supply Chain + Delivery Chain  

## Team Information  
- **Li Zhang** (NUID: 003189807) — CoffeeChain Enterprise (Store Operations & Management)  
- **Shaowei Li** (NUID: 002066350) — FoodSupply Enterprise (Warehouse & Logistics)  
- **Jerry Xu** (NUID: 003155254) — Delivery Enterprise (Dispatch, Riders, Analytics)  

GitHub repository (final project):  
`https://github.com/zz20-203/Group_Final_Project_Team_4`

---

## Project Overview  

### Project Title  
**Ecosystem (Coffee Chain + Supply Chain + Delivery Chain)**  

### Problem Statement  
Modern cafe chains usually treat store orders, warehouse restocking, and last-mile delivery as **separate systems**. That causes:

- Delayed communication between store and supplier  
- Manual coordination between warehouse, logistics, and riders  
- Inefficient restocking due to poor visibility into inventory  
- Limited cross-enterprise automation and analytics  

This project builds a unified **Swing-based enterprise ecosystem** that connects:

1. **CoffeeChain Enterprise** — in-store order taking, drink preparation, inventory and store management  
2. **FoodSupply Enterprise** — warehouse handling, stock preparation, and logistics transportation  
3. **Delivery Enterprise** — delivery dispatch, rider assignment, delivery tracking, and analytics  

Orders and work requests can move across **organizations, enterprises, and roles** in a single integrated EcoSystem.

---

## System Architecture (High Level)

### Network  
A single **Network** hosts all enterprises and organizations, sharing users and work queues.

### Enterprises (3 total)  
- **CoffeeChain Enterprise**  
  - FrontDesk Department  
  - Barista Department  
  - StoreManagement Department  

- **FoodSupply Enterprise**  
  - Warehouse Department  
  - Logistics Department  

- **Delivery Enterprise**  
  - Delivery Department  
  - Analytics Department  

### Organizations (7 total)  

| Organization              | Enterprise    | Responsibility                                      |
|---------------------------|--------------|----------------------------------------------------|
| Customer Service Dept     | CoffeeChain   | Accept drink orders and create work requests       |
| Beverage Production Org   | CoffeeChain   | Prepare drinks, update drink status                |
| StoreManagement Dept      | CoffeeChain   | Manage store inventory, submit restock requests    |
| Warehouse Dept            | FoodSupply    | Handle restock requests, prepare materials         |
| Logistics Dept            | FoodSupply    | Ship restock materials and track shipment          |
| Delivery Dept             | Delivery      | Assign riders and manage delivery lifecycle        |
| Analytics Dept            | Delivery      | Build analytics reports for riders/orders          |

### Unique Roles (8 total, excluding admins)  

- **Store Manager** – StoreManagement Dept  
- **Front Desk Staff** – Operation / Customer Service  
- **Barista** – Beverage Production  
- **Warehouse Keeper** – Warehouse  
- **Logistics Dispatcher** – Logistics  
- **Delivery Dispatcher** – Delivery  
- **Rider** – Delivery  
- **Data Analyst** – Analytics  

Each enterprise also has its own **Enterprise Admin**, and the whole EcoSystem is overseen by a **System Admin**.

---

## Key Objectives  

- Integrate **store operations, supply chain, and delivery** into a single EcoSystem  
- Implement **role-based access** so each user only sees tools relevant to their job  
- Support **cross-organization and cross-enterprise work requests** end-to-end  
- Provide **analytics** on delivery and order performance for the Analytics Dept  
- Build a maintainable Java **Swing + CardLayout** UI on top of the domain model  

---

## Key Features  

- Central **EcoSystem** with Network, Enterprises, Organizations, Users, Roles, and WorkQueues  
- Role-based Swing UI: each role logs in and sees its own **Work Area Panel**  
- Cross-enterprise workflows tying together **CoffeeChain**, **FoodSupply**, and **Delivery**  
- Work request tracking with status updates as requests move across departments  
- Delivery management: assign riders, update delivery status, and complete deliveries  
- Analytics: generate high-level reports on deliveries and riders (Analytics Dept)  

---

## Installation & Setup Instructions  

### Prerequisites  

- Java **JDK 17** or higher (8+ is usually fine, but we developed on a modern JDK)  
- IDE: **NetBeans** (recommended), IntelliJ IDEA, or Eclipse  
- No external libraries required besides standard Java Swing  

### Setup Steps  

1. **Clone** the repository  
   ```bash
   git clone https://github.com/zz20-203/Group_Final_Project_Team_4.git
   ```
2. **Open** the project in your IDE (NetBeans project structure is already included).  
3. Locate the main entry class (for example `MainJFrame.java` or `Main.java`) in the UI package.  
4. **Run** the main class. The Swing login window should appear.  

If necessary, update the project SDK/JDK in your IDE’s Project Settings so it points to your installed JDK.

---

## Authentication & Access Control  

### Authentication  

- Users log in from the **Main Frame / Login Panel**.  
- Credentials are checked against the `UserAccountDirectory` stored in the EcoSystem.  
- On successful login, the system loads the correct work area for that user’s role and enterprise.

### Authorization  

Each `UserAccount` has an associated **Role** and **Organization** (and indirectly, an Enterprise). That controls:

- Which menus and buttons are visible  
- Which tables and entities can be edited  
- Which work requests can be created / approved / updated  

Typical roles & scopes:

| Role                | Typical Actions                                                                         |
|---------------------|-----------------------------------------------------------------------------------------|
| System Admin        | Manage networks, enterprises, orgs, and global user accounts                            |
| Enterprise Admin    | Manage organizations and users within a single enterprise                               |
| Store Manager       | View inventory, create restock requests, confirm material receipts                      |
| Front Desk Staff    | Create coffee orders (work requests) from customer orders                               |
| Barista             | Process drink orders, update preparation status                                         |
| Warehouse Keeper    | See incoming restock requests, prepare materials, hand off to Logistics                 |
| Logistics Dispatcher| Plan shipment, update shipping status, confirm delivery to store                        |
| Delivery Dispatcher | Receive drink-ready info, assign riders, manage delivery lifecycle                      |
| Rider               | View assigned deliveries, complete delivery and update status                           |
| Data Analyst        | Generate statistics and reports about riders and deliveries                             |

---

## Work Requests & End-to-End Flows  

The system uses `WorkRequest` subclasses to connect organizations. The main flows are:

1. **Create Drink Order**  
   - *Front Desk → Barista* (same enterprise, cross-organization)  
2. **Complete Drink Preparation / Notify Delivery**  
   - *Barista → Delivery Dispatcher* (cross-enterprise)  
3. **Request Inventory Restock**  
   - *Store Manager → Warehouse Keeper* (cross-enterprise)  
4. **Material Shipment & Delivery**  
   - *Warehouse Keeper → Logistics Dispatcher* (same enterprise, cross-organization)  
5. **Confirm Material Receipt**  
   - *Logistics Dispatcher → Store Manager* (cross-enterprise)  
6. **Assign Rider for Delivery**  
   - *Delivery Dispatcher → Rider* (same organization)  

These work requests drive the main UI workflows.

---

## Features Implemented (By Area)

### CoffeeChain Enterprise – Li Zhang  

- **Front Desk / Customer Service**  
  - Create drink orders for customers  
  - Forward drink requests to Barista via work requests  

- **Beverage Production (Barista)**  
  - View incoming drink orders  
  - Update preparation status / mark as ready  
  - Notify Delivery Dispatcher when drinks are ready for delivery  

- **Store Management**  
  - View current inventory  
  - Create **Restock** requests to the Warehouse  
  - Confirm material receipts after Logistics delivers supplies  

### FoodSupply Enterprise – Shaowei Li  

- **Warehouse Dept**  
  - Receive restock requests from Store Management  
  - Check/prepare materials for shipment  
  - Create shipment work requests to Logistics  

- **Logistics Dept**  
  - Receive shipment requests from Warehouse  
  - Organize transportation and track status  
  - Confirm delivery to the store, generating a confirmation back to Store Management  

### Delivery Enterprise – Jerry Xu  

- **Delivery Dept (Dispatcher & Riders)**  
  - Receive “drink ready” or “delivery needed” requests from CoffeeChain  
  - Assign riders to orders  
  - Update delivery status (e.g., assigned → picked up → delivered)  

- **Analytics Dept**  
  - Access historical delivery data  
  - Generate rider/order performance reports (e.g., completed deliveries, delays)  

---

## Usage Instructions  

### How to Log In  

1. Run the application and wait for the login window.  
2. Enter username and password for one of the seeded demo accounts (System Admin, Enterprise Admins, Store Manager, etc.).  
3. On successful login, you’ll be routed automatically to the appropriate **Work Area** panel for that role.  

## Test Login Credentials

### System Admin
| Role          | Username | Password |
|---------------|----------|----------|
| System Admin  | sa       | 1        |

### CoffeeChain Enterprise
| Role              | Username | Password |
|-------------------|----------|----------|
| Enterprise Admin  | ca       | 1        |
| Front Desk        | fd       | 1        |
| Barista           | b        | 1        |
| Store Manager     | sm       | 1        |

### FoodSupply Enterprise
| Role                 | Username | Password |
|----------------------|----------|----------|
| Enterprise Admin     | fa       | 1        |
| Warehouse Keeper     | wh       | 1        |
| Logistics Dispatcher | ld       | 1        |

### Delivery Enterprise
| Role                 | Username | Password |
|----------------------|----------|----------|
| Enterprise Admin     | da       | 1        |
| Delivery Dispatcher  | dd       | 1        |
| Rider                | r        | 1        |


### Example Workflows (Short)  

- **Store Manager** → Create Restock Request → Warehouse Keeper → Logistics Dispatcher → Confirm Receipt  
- **Front Desk Staff** → Create Drink Order → Barista → Delivery Dispatcher → Rider → Customer  
- **Data Analyst** → Open Analytics Panel → Generate Delivery/Rider Reports  

### Complete Workflow Example – Drink Order to Delivery  

1. **Front Desk Staff**  
   - Logs in and creates a **Drink Order** work request.  
2. **Barista**  
   - Sees the order, prepares the drink, updates order status.  
   - On completion, sends a **Delivery Request** to the Delivery Dispatcher.  
3. **Delivery Dispatcher**  
   - Views ready-for-delivery orders, assigns them to a **Rider**.  
4. **Rider**  
   - Logs in, checks assigned deliveries, picks up the drink, and marks as delivered.  
5. **Data Analyst**  
   - Later can run a report that includes this delivery for performance analysis.  

### Complete Workflow Example – Inventory Restock  

1. **Store Manager**  
   - Logs in, views inventory, creates **Restock Inventory** request when stock is low.  
2. **Warehouse Keeper**  
   - Receives the request, prepares materials, sends **Shipment Request** to Logistics.  
3. **Logistics Dispatcher**  
   - Ships materials to the store and marks shipment as delivered.  
4. **Store Manager**  
   - Confirms receipt, which closes the restock workflow.  

---

## Testing Guide (High Level)

Create or use demo accounts for each of the main roles and test:

- **Login success / failure** (correct vs incorrect credentials)  
- **Role separation** (e.g., Store Manager should not see System Admin tools)  
- **End-to-end flows**:  
  - Drink order → Barista → Delivery → Rider  
  - Restock request → Warehouse → Logistics → Store confirmation  

You can log intermediate statuses in console output or Swing dialogs to validate the flow.

---

## Challenges & Solutions  

### Challenges  

- Designing cross-enterprise workflows without creating cyclic dependencies  
- Keeping `WorkRequest` models generic while still supporting specific flows  
- Coordinating multiple roles and UIs in a single Swing application  
- Making the ecosystem extendable (add new enterprises/roles later)  

### Solutions  

- Introduced a clear **EcoSystem → Network → Enterprise → Organization** hierarchy  
- Kept work queues at the organization level so requests can move cleanly  
- Used role-based panels with CardLayout to isolate each role’s workflow  
- Iterated on UML class, component, and sequence diagrams to validate design  

---

## Future Enhancements  

- Add persistent storage adapters (e.g., real DB or file-based) and auditing logs  
- Improve UI styling and usability (icons, theming, better error messages)  
- Add customer-facing ordering channel (e.g., web or mobile front-end)  
- Add more analytics (per-store performance, inventory turnover, SLA metrics)  

---

## Contribution Breakdown  

- **Li Zhang**: CoffeeChain enterprise design and implementation, class diagrams, store workflows  
- **Shaowei Li**: FoodSupply enterprise (warehouse + logistics), restock workflows, diagrams and documentation  
- **Jerry Xu**: Delivery enterprise (dispatcher, riders, analytics), delivery workflows, reporting logic  
- All members contributed to integration, refactoring, bug fixing, and final presentation.  

