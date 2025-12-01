/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise.DeliveryDepartment;

/**
 *
 * @author Luciela us Biktria
 */
public class Rider {
    private long id;
    private String firstName;
    private String lastName;
    
    private long phoneNumber;
    
    private int[] regions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int[] getRegions() {
        return regions;
    }

    public void setRegions(int[] regions) {
        this.regions = regions;
    }
    
    @Override
    public String toString(){
        return Long.toString(id);
    }
}
