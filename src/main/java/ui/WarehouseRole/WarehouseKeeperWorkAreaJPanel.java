/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.WarehouseRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.LogisticsOrganization;
import Business.Organization.Organization;
import Business.Organization.WarehouseOrganization;
import Business.OrderQueue.OrderRequest;
import Business.OrderQueue.SupplyOrderRequest;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class WarehouseKeeperWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private WarehouseOrganization organization;
    private Enterprise enterprise;
    private EcoSystem business;

    public WarehouseKeeperWorkAreaJPanel(JPanel userProcessContainer,
                                         UserAccount account,
                                         WarehouseOrganization organization,
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
        tblSupplyRequests = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnMarkPrepared = new javax.swing.JButton();
        btnSendToLogistics = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblTitle.setText("Warehouse Keeper Work Area");

        tblSupplyRequests.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblSupplyRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null, null},
                {"", null, null, null, null, null},
                {"", null, null, null, null, null},
                {"", null, null, null, null, null},
                {"", null, null, null, null, null},
                {"", null, null, null, null, null}
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
        jScrollPane1.setViewportView(tblSupplyRequests);
        if (tblSupplyRequests.getColumnModel().getColumnCount() > 0) {
            tblSupplyRequests.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnMarkPrepared.setText("Mark Prepared");
        btnMarkPrepared.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarkPreparedActionPerformed(evt);
            }
        });

        btnSendToLogistics.setText("Send to Logistics");
        btnSendToLogistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToLogisticsActionPerformed(evt);
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
                    .addComponent(btnMarkPrepared, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendToLogistics, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(385, 385, 385))
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
                .addComponent(btnMarkPrepared)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSendToLogistics)
                .addContainerGap(102, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnMarkPreparedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkPreparedActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblSupplyRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an order first.");
            return;
        }

        SupplyOrderRequest sReq = (SupplyOrderRequest) tblSupplyRequests.getValueAt(selectedRow, 0);

        sReq.setStatus("Prepared in Warehouse");
        sReq.setReceiver(account);   // warehouse keeper

        populateTable();
        
    }//GEN-LAST:event_btnMarkPreparedActionPerformed

    private void btnSendToLogisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendToLogisticsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblSupplyRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an order first.");
            return;
        }

        SupplyOrderRequest sReq = (SupplyOrderRequest) tblSupplyRequests.getValueAt(selectedRow, 0);

        // ➜ Only allow sending when status is "Prepared in Warehouse"
        if (!"Prepared in Warehouse".equals(sReq.getStatus())) {
            JOptionPane.showMessageDialog(
                this,
                "You can send this order to Logistics only after it is marked\n" +
                "\"Prepared in Warehouse\"."
            );
            return;
        }

        // find LogisticsOrganization inside the same enterprise
        LogisticsOrganization logisticsOrg = null;
        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof LogisticsOrganization) {
                logisticsOrg = (LogisticsOrganization) org;
                break;
            }
        }

        if (logisticsOrg == null) {
            JOptionPane.showMessageDialog(this, "No Logistics organization found in this enterprise.");
            return;
        }

        sReq.setStatus("Sent to Logistics");

        if (!logisticsOrg.getWorkQueue().getWorkRequestList().contains(sReq)) {
            logisticsOrg.getWorkQueue().getWorkRequestList().add(sReq);
        }

        JOptionPane.showMessageDialog(this, "Order sent to Logistics.");
        populateTable();
        
    }//GEN-LAST:event_btnSendToLogisticsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMarkPrepared;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSendToLogistics;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblSupplyRequests;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblSupplyRequests.getModel();
        model.setRowCount(0);   // clears any design-time rows

        for (OrderRequest req : organization.getWorkQueue().getWorkRequestList()) {
            if (req instanceof SupplyOrderRequest) {
                SupplyOrderRequest sReq = (SupplyOrderRequest) req;

                Object[] row = new Object[6];
                row[0] = sReq;  // shows toString(), stores the object
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
