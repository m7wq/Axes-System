package org.m7moud.skypvpt.Axes;

public class Axe {

    String name;
    Object enchAndLevel[];
    Boolean inShop;
    int cost;


    

    public Axe(String name, Object[] enchAndLevel, Boolean inShop, int cost) {
        this.name = name;
        this.enchAndLevel = enchAndLevel;
        this.inShop = inShop;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Boolean getInShop() {
        return inShop;
    }

    public void setInShop(Boolean inShop) {
        this.inShop = inShop;
    }

    public Object[] getEnchAndLevel() {
        return enchAndLevel;
    }

    public void setEnchAndLevel(Object[] enchAndLevel) {
        this.enchAndLevel = enchAndLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
