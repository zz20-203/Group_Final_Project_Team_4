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
    private int id;
    private String firstName;
    private String lastName;
    
    private int[] regions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int[] getRegions() {
        return regions;
    }

    public void setRegions(int[] regions) {
        this.regions = regions;
    }
    
    @Override
    public String toString(){
        return Integer.toString(id);
    }
}
