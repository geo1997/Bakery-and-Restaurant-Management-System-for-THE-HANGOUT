package RestuarantBakery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BEYOND
 */
public class Bill {
    
    private String name;
    private int qty;
    private float ppu;
    private float cost;

    public Bill(String name, int qty, float ppu, float cost) {
        this.name = name;
        this.qty = qty;
        this.ppu = ppu;
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPpu(float ppu) {
        this.ppu = ppu;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public float getPpu() {
        return ppu;
    }

    public float getCost() {
        return cost;
    }
    
    
}
