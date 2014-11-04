package Contollers;

import TempPackage.Menu;

/**
 * Created by Nik on 10/2/14.
 */
public class MenuItem {

    private String name;
    private double price;
    private ItemType itemtype;

    private String starDelim = " ";

    public MenuItem(String name, double price, ItemType type) {
        this.name = name;
        this.price = price;
        this.itemtype = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemType getType() {
        return itemtype;
    }
    public String getTypeString(){
        return itemtype.name();
    }

    public void changeType(ItemType aType) {
        itemtype = aType;
    }

    public boolean equals(Object o){
        if(o instanceof MenuItem){
            MenuItem newM = (MenuItem) o;
            return this.name.equals(newM.getName());
        }
        return false;
    }

    public String toString(){
        return name + starDelim + price + starDelim + getTypeString();
    }
}
