/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.DeliveryRole;

import Business.Enterprise.DeliveryDepartment.Rider;
import Business.Enterprise.DeliveryDepartment.RiderDirectory;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luciela us Biktria
 */
public class ManageRiderJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private RiderDirectory riderDirectory;
    private JCheckBox[] regionCheckBoxes;
    
    // Placeholder constants
    private final String PHONE_PLACEHOLDER = "Enter a 10-digit phone number, including area code, without hyphens or parentheses";
    private final String ID_PLACEHOLDER = "numerical only";
    
    private boolean isCreationMode = false;

    /**
     * Creates new form ManageRiderJPanel
     */
    public ManageRiderJPanel(JPanel userProcessContainer, RiderDirectory riderDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.riderDirectory = riderDirectory;
        
        regionCheckBoxes = new JCheckBox[] {
            chkRiderRegion1, chkRiderRegion2, chkRiderRegion3, chkRiderRegion4, 
            chkRiderRegion5, chkRiderRegion6, chkRiderRegion7, chkRiderRegion8, 
            chkRiderRegion9, chkRiderRegion10
        };
        
        populateTable();
        
        // Add listener to table to populate fields on selection
        tblRiders.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // Check if we are in view mode (buttons say Edit/New)
                if (!event.getValueIsAdjusting() && tblRiders.getSelectedRow() >= 0) {
                     // Only populate if not in Edit/New mode
                     if (tblRiders.isEnabled()) {
                        Rider selectedRider = (Rider) tblRiders.getValueAt(tblRiders.getSelectedRow(), 0);
                        populateFields(selectedRider);
                     }
                }
            }
        });
    }
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblRiders.getModel();
        model.setRowCount(0);
        
        for (Rider r : riderDirectory.getEmployeeList()) {
            Object[] row = new Object[3];
            row[0] = r; // Uses Rider.toString() which returns ID as String
            row[1] = r.getFirstName() + " " + r.getLastName();
            row[2] = r.getPhoneNumber(); 
            model.addRow(row);
        }
    }
    
    private void populateFields(Rider r) {
        txtRiderID.setForeground(Color.BLACK);
        txtRiderPhoneNum.setForeground(Color.BLACK);
        
        txtRiderID.setText(String.valueOf(r.getId()));
        txtRiderPhoneNum.setText(String.valueOf(r.getPhoneNumber()));
        txtRiderFirstName.setText(r.getFirstName());
        txtRiderLastName.setText(r.getLastName());
        
        // Populate Checkboxes
        for (JCheckBox chk : regionCheckBoxes) {
            chk.setSelected(false);
        }
        
        if (r.getRegions() != null) {
            for (int region : r.getRegions()) {
                if (region >= 1 && region <= 10) {
                    regionCheckBoxes[region - 1].setSelected(true);
                }
            }
        }
    }
    
    private void setFieldsEnabled(boolean enabled) {
        txtRiderID.setEnabled(enabled);
        txtRiderPhoneNum.setEnabled(enabled);
        txtRiderFirstName.setEnabled(enabled);
        txtRiderLastName.setEnabled(enabled);
        
        for (JCheckBox chk : regionCheckBoxes) {
            chk.setEnabled(enabled);
        }
    }
    
    private void clearFields() {
        txtRiderID.setText("");
        txtRiderPhoneNum.setText("");
        txtRiderFirstName.setText("");
        txtRiderLastName.setText("");
        
        // Restore default colors
        txtRiderID.setForeground(Color.BLACK);
        txtRiderPhoneNum.setForeground(Color.BLACK);
        
        for (JCheckBox chk : regionCheckBoxes) {
            chk.setSelected(false);
        }
    }
    
    // Helper to set placeholders when entering edit/new mode
    private void setPlaceholders() {
        if (txtRiderID.getText().isEmpty() || isCreationMode) {
             txtRiderID.setText(ID_PLACEHOLDER);
             txtRiderID.setForeground(Color.GRAY);
        }
        if (txtRiderPhoneNum.getText().isEmpty() || isCreationMode) {
            txtRiderPhoneNum.setText(PHONE_PLACEHOLDER);
            txtRiderPhoneNum.setForeground(Color.GRAY);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRiders = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnNewCancel = new javax.swing.JButton();
        btnEditSave = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblRiderID = new javax.swing.JLabel();
        lblRiderPhoneNum = new javax.swing.JLabel();
        lblRiderFirstName = new javax.swing.JLabel();
        lblRiderLastName = new javax.swing.JLabel();
        lblAccountUsername = new javax.swing.JLabel();
        lblAccountPassword = new javax.swing.JLabel();
        lblRiderRegions = new javax.swing.JLabel();
        chkRiderRegion1 = new javax.swing.JCheckBox();
        chkRiderRegion2 = new javax.swing.JCheckBox();
        chkRiderRegion3 = new javax.swing.JCheckBox();
        chkRiderRegion4 = new javax.swing.JCheckBox();
        chkRiderRegion5 = new javax.swing.JCheckBox();
        chkRiderRegion6 = new javax.swing.JCheckBox();
        chkRiderRegion7 = new javax.swing.JCheckBox();
        chkRiderRegion8 = new javax.swing.JCheckBox();
        chkRiderRegion9 = new javax.swing.JCheckBox();
        chkRiderRegion10 = new javax.swing.JCheckBox();
        txtRiderID = new javax.swing.JTextField();
        txtRiderPhoneNum = new javax.swing.JTextField();
        txtRiderFirstName = new javax.swing.JTextField();
        txtRiderLastName = new javax.swing.JTextField();
        txtAccountUsername = new javax.swing.JTextField();
        txtAccountPassword = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRiders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rider ID", "Rider Name", "Phone Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRiders);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 430, 550));

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, -1, -1));

        btnNewCancel.setText("New");
        btnNewCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCancelActionPerformed(evt);
            }
        });
        add(btnNewCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 80, -1));

        btnEditSave.setText("Edit");
        btnEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSaveActionPerformed(evt);
            }
        });
        add(btnEditSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, 80, -1));

        lblTitle.setText("Rider Management & Registration");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        lblRiderID.setText("Rider ID");
        add(lblRiderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        lblRiderPhoneNum.setText("Rider Phone Number");
        add(lblRiderPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        lblRiderFirstName.setText("Rider First Name");
        add(lblRiderFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        lblRiderLastName.setText("Rider Last Name");
        add(lblRiderLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, -1, -1));

        lblAccountUsername.setText("Account Username");
        add(lblAccountUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, -1));

        lblAccountPassword.setText("Account Password");
        add(lblAccountPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));

        lblRiderRegions.setText("Rider Delivery Regions");
        add(lblRiderRegions, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, -1, -1));

        chkRiderRegion1.setText("Region 1");
        chkRiderRegion1.setEnabled(false);
        add(chkRiderRegion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, -1, -1));

        chkRiderRegion2.setText("Region 2");
        chkRiderRegion2.setEnabled(false);
        add(chkRiderRegion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, -1, -1));

        chkRiderRegion3.setText("Region 3");
        chkRiderRegion3.setEnabled(false);
        add(chkRiderRegion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, -1, -1));

        chkRiderRegion4.setText("Region 4");
        chkRiderRegion4.setEnabled(false);
        add(chkRiderRegion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, -1, -1));

        chkRiderRegion5.setText("Region 5");
        chkRiderRegion5.setEnabled(false);
        add(chkRiderRegion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, -1, -1));

        chkRiderRegion6.setText("Region 6");
        chkRiderRegion6.setEnabled(false);
        add(chkRiderRegion6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, -1, -1));

        chkRiderRegion7.setText("Region 7");
        chkRiderRegion7.setEnabled(false);
        add(chkRiderRegion7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, -1, -1));

        chkRiderRegion8.setText("Region 8");
        chkRiderRegion8.setEnabled(false);
        add(chkRiderRegion8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, -1, -1));

        chkRiderRegion9.setText("Region 9");
        chkRiderRegion9.setEnabled(false);
        add(chkRiderRegion9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, -1, -1));

        chkRiderRegion10.setText("Region 10");
        chkRiderRegion10.setEnabled(false);
        add(chkRiderRegion10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 470, -1, -1));

        txtRiderID.setEnabled(false);
        txtRiderID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRiderIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRiderIDFocusLost(evt);
            }
        });
        add(txtRiderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 230, -1));

        txtRiderPhoneNum.setEnabled(false);
        txtRiderPhoneNum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRiderPhoneNumFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRiderPhoneNumFocusLost(evt);
            }
        });
        add(txtRiderPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 230, -1));

        txtRiderFirstName.setEnabled(false);
        add(txtRiderFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 230, -1));

        txtRiderLastName.setEnabled(false);
        add(txtRiderLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 230, -1));

        txtAccountUsername.setEnabled(false);
        add(txtAccountUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 230, -1));

        txtAccountPassword.setEnabled(false);
        add(txtAccountPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 230, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNewCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCancelActionPerformed
        if (btnNewCancel.getText().equals("New")) {
            // -- Switch to New Mode --
            isCreationMode = true;
            
            // UI Logic
            btnNewCancel.setText("Cancel");
            btnEditSave.setText("Save");
            
            tblRiders.setEnabled(false);
            tblRiders.clearSelection();
            
            clearFields();
            setFieldsEnabled(true);
            setPlaceholders();
            
        } else {
            // -- Cancel Action --
            // Revert state
            isCreationMode = false;
            
            btnNewCancel.setText("New");
            btnEditSave.setText("Edit");
            
            tblRiders.setEnabled(true);
            setFieldsEnabled(false);
            
            // Check if there was a previous selection to restore
            if (tblRiders.getSelectedRow() >= 0) {
                 Rider selected = (Rider) tblRiders.getValueAt(tblRiders.getSelectedRow(), 0);
                 populateFields(selected);
            } else {
                clearFields();
            }
        }
    }//GEN-LAST:event_btnNewCancelActionPerformed

    private void btnEditSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSaveActionPerformed
        if (btnEditSave.getText().equals("Edit")) {
            // -- Switch to Edit Mode --
            int selectedRow = tblRiders.getSelectedRow();
            if (selectedRow < 0) {
                 JOptionPane.showMessageDialog(this, "Please select a rider to edit.");
                 return;
            }
            
            isCreationMode = false;
            
            btnEditSave.setText("Save");
            btnNewCancel.setText("Cancel");
            
            tblRiders.setEnabled(false);
            setFieldsEnabled(true);
            
            // Populate fields again just to be safe, though they should be filled
            Rider selected = (Rider) tblRiders.getValueAt(selectedRow, 0);
            populateFields(selected);
            setPlaceholders(); 
            
        } else {
            // -- Save Action --
            
            // Validation
            String idTxt = txtRiderID.getText();
            String phoneTxt = txtRiderPhoneNum.getText();
            String fName = txtRiderFirstName.getText();
            String lName = txtRiderLastName.getText();
            
            // Check placeholders
            if (idTxt.equals(ID_PLACEHOLDER)) idTxt = "";
            if (phoneTxt.equals(PHONE_PLACEHOLDER)) phoneTxt = "";
            
            if (idTxt.isBlank() || phoneTxt.isBlank() || fName.isBlank() || lName.isBlank()) {
                JOptionPane.showMessageDialog(this, "All fields are required.");
                return;
            }
            
            long id;
            try {
                id = Long.parseLong(idTxt);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Rider ID must be numerical.");
                return;
            }
            
            long phone;
            try {
                phone = Long.parseLong(phoneTxt);
                if (String.valueOf(phone).length() != 10) {
                    JOptionPane.showMessageDialog(this, "Phone number must be exactly 10 digits.");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Phone number must be numerical.");
                return;
            }
            
            ArrayList<Integer> selectedRegions = new ArrayList<>();
            for (int i = 0; i < regionCheckBoxes.length; i++) {
                if (regionCheckBoxes[i].isSelected()) {
                    selectedRegions.add(i + 1); // Regions are 1-indexed
                }
            }
            
            if (selectedRegions.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select at least one region.");
                return;
            }
            
            int[] regionsArr = selectedRegions.stream().mapToInt(i -> i).toArray();
            
            if (isCreationMode) {
                // Create new rider
                riderDirectory.createRider(id, fName, lName, phone, regionsArr);
                
                JOptionPane.showMessageDialog(this, "Rider created successfully.");
                isCreationMode = false;
                
            } else {
                // Edit Mode
                Rider r = (Rider) tblRiders.getValueAt(tblRiders.getSelectedRow(), 0);
                r.setId(id);
                r.setPhoneNumber(phone);
                r.setFirstName(fName);
                r.setLastName(lName);
                r.setRegions(regionsArr);
                
                JOptionPane.showMessageDialog(this, "Rider updated successfully.");
            }
            
            // Revert UI
            populateTable();
            tblRiders.setEnabled(true);
            setFieldsEnabled(false);
            btnEditSave.setText("Edit");
            btnNewCancel.setText("New");
            
            // Restore selection if edit
            if (!isCreationMode) {
                 tblRiders.clearSelection();
                 clearFields();
            }
        }
    }//GEN-LAST:event_btnEditSaveActionPerformed

    private void txtRiderIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRiderIDFocusGained
        if (txtRiderID.getText().equals(ID_PLACEHOLDER)) {
            txtRiderID.setText("");
            txtRiderID.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtRiderIDFocusGained

    private void txtRiderIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRiderIDFocusLost
        if (txtRiderID.getText().isEmpty() && (isCreationMode || btnEditSave.getText().equals("Save"))) {
            txtRiderID.setText(ID_PLACEHOLDER);
            txtRiderID.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtRiderIDFocusLost

    private void txtRiderPhoneNumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRiderPhoneNumFocusGained
        if (txtRiderPhoneNum.getText().equals(PHONE_PLACEHOLDER)) {
            txtRiderPhoneNum.setText("");
            txtRiderPhoneNum.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtRiderPhoneNumFocusGained

    private void txtRiderPhoneNumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRiderPhoneNumFocusLost
        if (txtRiderPhoneNum.getText().isEmpty() && (isCreationMode || btnEditSave.getText().equals("Save"))) {
            txtRiderPhoneNum.setText(PHONE_PLACEHOLDER);
            txtRiderPhoneNum.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtRiderPhoneNumFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEditSave;
    private javax.swing.JButton btnNewCancel;
    private javax.swing.JCheckBox chkRiderRegion1;
    private javax.swing.JCheckBox chkRiderRegion10;
    private javax.swing.JCheckBox chkRiderRegion2;
    private javax.swing.JCheckBox chkRiderRegion3;
    private javax.swing.JCheckBox chkRiderRegion4;
    private javax.swing.JCheckBox chkRiderRegion5;
    private javax.swing.JCheckBox chkRiderRegion6;
    private javax.swing.JCheckBox chkRiderRegion7;
    private javax.swing.JCheckBox chkRiderRegion8;
    private javax.swing.JCheckBox chkRiderRegion9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAccountPassword;
    private javax.swing.JLabel lblAccountUsername;
    private javax.swing.JLabel lblRiderFirstName;
    private javax.swing.JLabel lblRiderID;
    private javax.swing.JLabel lblRiderLastName;
    private javax.swing.JLabel lblRiderPhoneNum;
    private javax.swing.JLabel lblRiderRegions;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblRiders;
    private javax.swing.JTextField txtAccountPassword;
    private javax.swing.JTextField txtAccountUsername;
    private javax.swing.JTextField txtRiderFirstName;
    private javax.swing.JTextField txtRiderID;
    private javax.swing.JTextField txtRiderLastName;
    private javax.swing.JTextField txtRiderPhoneNum;
    // End of variables declaration//GEN-END:variables
}