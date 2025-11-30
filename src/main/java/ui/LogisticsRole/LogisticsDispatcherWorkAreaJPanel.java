/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.LogisticsRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.LogisticsOrganization;
import Business.OrderQueue.OrderRequest;
import Business.OrderQueue.SupplyOrderRequest;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class LogisticsDispatcherWorkAreaJPanel extends javax.swing.JPanel {

    private final JPanel userProcessContainer;
    private final UserAccount account;
    private final LogisticsOrganization organization;
    private final Enterprise enterprise;
    private final EcoSystem business;

    public LogisticsDispatcherWorkAreaJPanel(JPanel userProcessContainer,
                                             UserAccount account,
                                             LogisticsOrganization organization,
                                             Enterprise enterprise,
                                             EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        
        populateTable();

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLogisticsRequests = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnOutForDelivery = new javax.swing.JButton();
        btnDelivered = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblTitle.setText("Logictics Dispatcher Work Area");

        tblLogisticsRequests.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblLogisticsRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", null, null, null, null},
                {"", "", null, null, null, null},
                {"", "", null, null, null, null},
                {"", "", null, null, null, null},
                {"", "", null, null, null, null},
                {"", "", null, null, null, null}
            },
            new String [] {
                "Order", "Store", "Item", "Quantity", "Sender", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLogisticsRequests);
        if (tblLogisticsRequests.getColumnModel().getColumnCount() > 0) {
            tblLogisticsRequests.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnOutForDelivery.setText("For Delivery");
        btnOutForDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutForDeliveryActionPerformed(evt);
            }
        });

        btnDelivered.setText("Delivered");
        btnDelivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveredActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOutForDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelivered, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(392, 392, 392))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOutForDelivery)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelivered)
                .addContainerGap(102, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnOutForDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutForDeliveryActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblLogisticsRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an order first.");
            return;
        }

        SupplyOrderRequest sReq = (SupplyOrderRequest) tblLogisticsRequests.getValueAt(selectedRow, 0);

        sReq.setStatus("Out for Delivery");
        sReq.setReceiver(account); 

        populateTable();

    }//GEN-LAST:event_btnOutForDeliveryActionPerformed

    private void btnDeliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveredActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblLogisticsRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an order first.");
            return;
        }

        SupplyOrderRequest sReq = (SupplyOrderRequest) tblLogisticsRequests.getValueAt(selectedRow, 0);

        sReq.setStatus("Delivered to Store");

        // back into store manager’s queue so they see final status
        if (sReq.getSender() != null &&
            !sReq.getSender().getWorkQueue().getWorkRequestList().contains(sReq)) {
            sReq.getSender().getWorkQueue().getWorkRequestList().add(sReq);
        }

        JOptionPane.showMessageDialog(this, "Order marked as delivered.");
        populateTable();

    }//GEN-LAST:event_btnDeliveredActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelivered;
    private javax.swing.JButton btnOutForDelivery;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblLogisticsRequests;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        
        DefaultTableModel model = (DefaultTableModel) tblLogisticsRequests.getModel();
        model.setRowCount(0); 

        for (OrderRequest req : organization.getWorkQueue().getWorkRequestList()) {
            if (req instanceof SupplyOrderRequest) {
                SupplyOrderRequest sReq = (SupplyOrderRequest) req;

                Object[] row = new Object[6];
                row[0] = sReq;
                row[1] = sReq.getStoreName();
                row[2] = sReq.getItemName();
                row[3] = sReq.getQuantity();
                row[4] = (sReq.getSender() == null) ? "" : sReq.getSender().getUsername();
                row[5] = sReq.getStatus();

                model.addRow(row);
            }
        }
        
    }
}
