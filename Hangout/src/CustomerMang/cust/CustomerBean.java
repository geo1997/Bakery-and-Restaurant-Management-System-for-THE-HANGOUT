/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerMang.cust;

/**
 *
 * @author Priyan
 */
public class CustomerBean {
    private String id;
    private String name;
    private String tp;
    private String totalExp;
    private String email;
    private String address;
    
    public CustomerBean(String id,String name,String tp,String email,String address,String totalExp) {
        this.id = id;
        this.name = name;
        this.tp = tp;
        this.email=email;
        this.address=address;
        this.totalExp = totalExp;
    }
    
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }    
    
    public String getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(String totalExp) {
        this.totalExp = totalExp;
    } 
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    } 

}
