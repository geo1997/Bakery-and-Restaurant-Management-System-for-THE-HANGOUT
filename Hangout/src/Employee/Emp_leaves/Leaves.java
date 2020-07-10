/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee.Emp_leaves;

/**
 *
 * @author kgeor
 */
public class Leaves {
    
    private int id;
    private String fname;
    private String lname;
    private String type;
    private String addDate;

    public Leaves(int id, String fname, String lname, String type, String addDate) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.type = type;
        this.addDate = addDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }
    
    
     
    
    
    
}
