/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.DeliveryRole;

import Business.EcoSystem;
import Business.Enterprise.CoffeeChainEnterprise;
import Business.Enterprise.DeliveryDepartment.Delivery;
import Business.Enterprise.DeliveryDepartment.DeliveryDirectory;
import Business.Enterprise.DeliveryDepartment.Destination;
import Business.Enterprise.DeliveryDepartment.DestinationDirectory;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CustomerServiceOrganization;
import Business.Organization.Organization;
import Business.OrderQueue.CoffeeOrderRequest;
import Business.OrderQueue.OrderRequest;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luciela us Biktria
 */
public class ManageDestinationsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private DeliveryDirectory deliveryDirectory;
    private DestinationDirectory destinationDirectory;
    
    private JRadioButton[] regionRadioButtons;
    private boolean isEditOrderMode = false;
    private boolean isEditDestMode = false;

    /**
     * Creates new form ManageDestinationsJPanel
     * @param userProcessContainer
     * @param system
     * @param deliveryDirectory
     * @param destinationDirectory
     */
    public ManageDestinationsJPanel(JPanel userProcessContainer, EcoSystem system, DeliveryDirectory deliveryDirectory, DestinationDirectory destinationDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.deliveryDirectory = deliveryDirectory;
        this.destinationDirectory = destinationDirectory;
        
        regionRadioButtons = new JRadioButton[] {
            rbtnRegion1, rbtnRegion2, rbtnRegion3, rbtnRegion4, rbtnRegion5,
            rbtnRegion6, rbtnRegion7, rbtnRegion8, rbtnRegion9, rbtnRegion10
        };
        
        populateTable();
        
        tblDestinations.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting() && tblDestinations.getSelectedRow() >= 0) {
                if (isEditOrderMode || isEditDestMode) return;
                CoffeeOrderRequest selectedOrder = (CoffeeOrderRequest) tblDestinations.getValueAt(tblDestinations.getSelectedRow(), 0);
                populateFields(selectedOrder);
            }
        });
        
        cbxAddress.addActionListener((ActionEvent e) -> {
            if (isEditOrderMode) {
                String input = (String) cbxAddress.getSelectedItem();
                if (input != null) {
                    Destination existing = destinationDirectory.findDestination(input);
                    if (existing != null) {
                        setRegionSelection(existing.getRegion());
                        setRegionsEnabled(false);
                    } else {
                        setRegionsEnabled(true);
                        btnGrpRegion.clearSelection();
                    }
                }
            }
        });
    }
    
    private ArrayList<CoffeeOrderRequest> getAllCoffeeOrders() {
        ArrayList<CoffeeOrderRequest> list = new ArrayList<>();
        for (Network n : system.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e instanceof CoffeeChainEnterprise) {
                    for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                        if (org instanceof CustomerServiceOrganization) {
                            for (OrderRequest req : org.getWorkQueue().getWorkRequestList()) {
                                if (req instanceof CoffeeOrderRequest) {
                                    list.add((CoffeeOrderRequest) req);
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblDestinations.getModel();
        model.setRowCount(0);
        
        for (CoffeeOrderRequest order : getAllCoffeeOrders()) {
            if ("Delivery".equalsIgnoreCase(order.getOrderType())) {
                Object[] row = new Object[3];
                row[0] = order; 
                row[1] = (order.getDestination() != null) ? order.getDestination().getAddress() : "N/A";
                row[2] = order.getStatus();
                model.addRow(row);
            }
        }
    }
    
    private void populateFields(CoffeeOrderRequest order) {
        txtOrderID.setText(String.valueOf(order.getOrderNumber()));
        cbxAddress.removeAllItems();
        if (order.getDestination() != null) {
            cbxAddress.addItem(order.getDestination().getAddress());
            setRegionSelection(order.getDestination().getRegion());
        } else {
            cbxAddress.setSelectedItem("");
            btnGrpRegion.clearSelection();
        }
        
        boolean canEdit = true;
        if ("Delivered".equalsIgnoreCase(order.getStatus())) {
            canEdit = false;
        }
        Delivery d = deliveryDirectory.findDeliveryByOrder(order);
        if (d != null) {
            canEdit = false;
        }
        
        btnEditOrder.setEnabled(canEdit);
        btnEditDestination.setEnabled(canEdit);
    }
    
    private void populateComboBoxWithAll() {
        cbxAddress.removeAllItems();
        for (Destination d : destinationDirectory.getDestinationList()) {
            cbxAddress.addItem(d.getAddress());
        }
    }
    
    private void setRegionSelection(int region) {
        if (region >= 1 && region <= 10) {
            regionRadioButtons[region - 1].setSelected(true);
        } else {
            btnGrpRegion.clearSelection();
        }
    }
    
    private int getSelectedRegion() {
        for (int i = 0; i < regionRadioButtons.length; i++) {
            if (regionRadioButtons[i].isSelected()) {
                return i + 1;
            }
        }
        return -1;
    }
    
    private void setRegionsEnabled(boolean enabled) {
        for (JRadioButton rbtn : regionRadioButtons) {
            rbtn.setEnabled(enabled);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrpRegion = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDestinations = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        lblOrderID = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        rbtnRegion1 = new javax.swing.JRadioButton();
        rbtnRegion2 = new javax.swing.JRadioButton();
        rbtnRegion3 = new javax.swing.JRadioButton();
        rbtnRegion4 = new javax.swing.JRadioButton();
        rbtnRegion5 = new javax.swing.JRadioButton();
        rbtnRegion6 = new javax.swing.JRadioButton();
        rbtnRegion7 = new javax.swing.JRadioButton();
        rbtnRegion8 = new javax.swing.JRadioButton();
        rbtnRegion9 = new javax.swing.JRadioButton();
        rbtnRegion10 = new javax.swing.JRadioButton();
        lblRegion = new javax.swing.JLabel();
        btnEditOrder = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtOrderID = new javax.swing.JTextField();
        cbxAddress = new javax.swing.JComboBox<>();
        btnEditDestination = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDestinations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order", "Destination", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDestinations);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 550));

        lblTitle.setText("Manage Destinations");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        lblOrderID.setText("Order ID");
        add(lblOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, -1, -1));

        lblAddress.setText("Destination Address");
        add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, -1));

        btnGrpRegion.add(rbtnRegion1);
        rbtnRegion1.setText("Region 1");
        rbtnRegion1.setEnabled(false);
        add(rbtnRegion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, -1, -1));

        btnGrpRegion.add(rbtnRegion2);
        rbtnRegion2.setText("Region 2");
        rbtnRegion2.setEnabled(false);
        add(rbtnRegion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        btnGrpRegion.add(rbtnRegion3);
        rbtnRegion3.setText("Region 3");
        rbtnRegion3.setEnabled(false);
        add(rbtnRegion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        btnGrpRegion.add(rbtnRegion4);
        rbtnRegion4.setText("Region 4");
        rbtnRegion4.setEnabled(false);
        add(rbtnRegion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, -1));

        btnGrpRegion.add(rbtnRegion5);
        rbtnRegion5.setText("Region 5");
        rbtnRegion5.setEnabled(false);
        add(rbtnRegion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));

        btnGrpRegion.add(rbtnRegion6);
        rbtnRegion6.setText("Region 6");
        rbtnRegion6.setEnabled(false);
        add(rbtnRegion6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, -1, -1));

        btnGrpRegion.add(rbtnRegion7);
        rbtnRegion7.setText("Region 7");
        rbtnRegion7.setEnabled(false);
        add(rbtnRegion7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, -1, -1));

        btnGrpRegion.add(rbtnRegion8);
        rbtnRegion8.setText("Region 8");
        rbtnRegion8.setEnabled(false);
        add(rbtnRegion8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, -1, -1));

        btnGrpRegion.add(rbtnRegion9);
        rbtnRegion9.setText("Region 9");
        rbtnRegion9.setEnabled(false);
        add(rbtnRegion9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, -1, -1));

        btnGrpRegion.add(rbtnRegion10);
        rbtnRegion10.setText("Region 10");
        rbtnRegion10.setEnabled(false);
        add(rbtnRegion10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, -1, -1));

        lblRegion.setText("Region");
        add(lblRegion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, -1));

        btnEditOrder.setText("Edit Order Destination");
        btnEditOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditOrderActionPerformed(evt);
            }
        });
        add(btnEditOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 540, 180, -1));

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, -1, -1));

        txtOrderID.setEnabled(false);
        add(txtOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 280, -1));

        cbxAddress.setEditable(true);
        cbxAddress.setEnabled(false);
        add(cbxAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 280, -1));

        btnEditDestination.setText("Edit Destination Regions");
        btnEditDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDestinationActionPerformed(evt);
            }
        });
        add(btnEditDestination, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditOrderActionPerformed
        int selectedRow = tblDestinations.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an order first.");
            return;
        }
        CoffeeOrderRequest order = (CoffeeOrderRequest) tblDestinations.getValueAt(selectedRow, 0);

        if (!isEditOrderMode) {
            isEditOrderMode = true;
            btnEditOrder.setText("Save");
            btnEditDestination.setEnabled(false);
            tblDestinations.setEnabled(false);
            cbxAddress.setEnabled(true);
            populateComboBoxWithAll();
            
            if (order.getDestination() != null) {
                cbxAddress.setSelectedItem(order.getDestination().getAddress());
                setRegionSelection(order.getDestination().getRegion());
                setRegionsEnabled(false);
            } else {
                cbxAddress.setSelectedItem("");
                btnGrpRegion.clearSelection();
                setRegionsEnabled(true);
            }
        } else {
            String addr = (String) cbxAddress.getSelectedItem();
            int reg = getSelectedRegion();
            if (addr == null || addr.isBlank()) {
                JOptionPane.showMessageDialog(this, "Address cannot be empty.");
                return;
            }
            if (reg == -1) {
                JOptionPane.showMessageDialog(this, "Please select a region.");
                return;
            }
            Destination dest = destinationDirectory.findDestination(addr);
            if (dest == null) {
                dest = new Destination(reg, addr);
                destinationDirectory.addDestination(dest);
            }
            
            if (order.getDestination() == null) {
                order.setOrderType("Delivery"); // Ensure type is correct

                order.setDestination(dest.getRegion(), dest.getAddress());
            } else {
                order.getDestination().setAddress(dest.getAddress());
                order.getDestination().setRegion(dest.getRegion());
            }
            
            isEditOrderMode = false;
            btnEditOrder.setText("Edit Order Destination");
            btnEditDestination.setEnabled(true);
            tblDestinations.setEnabled(true);
            cbxAddress.setEnabled(false);
            setRegionsEnabled(false);
            populateTable();
            populateFields(order);
        }
    }//GEN-LAST:event_btnEditOrderActionPerformed

    private void btnEditDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDestinationActionPerformed
        int selectedRow = tblDestinations.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an order to identify the destination to edit.");
            return;
        }
        CoffeeOrderRequest order = (CoffeeOrderRequest) tblDestinations.getValueAt(selectedRow, 0);
        if (order.getDestination() == null) {
            JOptionPane.showMessageDialog(this, "This order has no destination set.");
            return;
        }

        if (!isEditDestMode) {
            isEditDestMode = true;
            btnEditDestination.setText("Save");
            btnEditOrder.setEnabled(false);
            tblDestinations.setEnabled(false);
            cbxAddress.setEnabled(false); 
            cbxAddress.setSelectedItem(order.getDestination().getAddress());
            setRegionSelection(order.getDestination().getRegion());
            setRegionsEnabled(true);
        } else {
            int newReg = getSelectedRegion();
            if (newReg == -1) {
                JOptionPane.showMessageDialog(this, "Please select a region.");
                return;
            }
            String currentAddress = order.getDestination().getAddress();
            Destination dirDest = destinationDirectory.findDestination(currentAddress);
            if (dirDest != null) {
                dirDest.setRegion(newReg);
            }
            // Update all matching orders
            for (CoffeeOrderRequest co : getAllCoffeeOrders()) {
                 if (co.getDestination() != null && co.getDestination().getAddress().equalsIgnoreCase(currentAddress)) {
                     co.getDestination().setRegion(newReg);
                 }
            }
            isEditDestMode = false;
            btnEditDestination.setText("Edit Destination Regions");
            btnEditOrder.setEnabled(true);
            tblDestinations.setEnabled(true);
            setRegionsEnabled(false);
            populateTable();
            populateFields(order);
        }
    }//GEN-LAST:event_btnEditDestinationActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEditDestination;
    private javax.swing.JButton btnEditOrder;
    private javax.swing.ButtonGroup btnGrpRegion;
    private javax.swing.JComboBox<String> cbxAddress;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblRegion;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JRadioButton rbtnRegion1;
    private javax.swing.JRadioButton rbtnRegion10;
    private javax.swing.JRadioButton rbtnRegion2;
    private javax.swing.JRadioButton rbtnRegion3;
    private javax.swing.JRadioButton rbtnRegion4;
    private javax.swing.JRadioButton rbtnRegion5;
    private javax.swing.JRadioButton rbtnRegion6;
    private javax.swing.JRadioButton rbtnRegion7;
    private javax.swing.JRadioButton rbtnRegion8;
    private javax.swing.JRadioButton rbtnRegion9;
    private javax.swing.JTable tblDestinations;
    private javax.swing.JTextField txtOrderID;
    // End of variables declaration//GEN-END:variables
}