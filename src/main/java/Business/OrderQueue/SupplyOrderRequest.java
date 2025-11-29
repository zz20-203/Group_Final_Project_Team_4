/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.OrderQueue;

import Business.UserAccount.UserAccount;


/**
 *
 * @author shaoweili
 */
public class SupplyOrderRequest extends OrderRequest {

    private String storeName;      // which store is requesting
    private String itemName;       // name of material / product
    private int quantity;          // requested quantity
    private String statusDetail;   // optional extra status text

    public SupplyOrderRequest() {
        super();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    @Override
    public String toString() {
        // what shows in tables / combo boxes
        return itemName + " x" + quantity + " for " + storeName;
    }
}