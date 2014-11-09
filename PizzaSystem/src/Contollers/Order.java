package Contollers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yabsubu12 on 11/4/14.
 */
public class Order {

    private int id;
    private ArrayList<MenuItem> items;

    public Order(int id){
        this.id = id;
        items = new ArrayList<MenuItem>();
    }

    public List<MenuItem> getItems(){
        return items;
    }

    public void addItem(MenuItem mi){
        items.add(mi);
    }

    /**
     * Removes an item from the order
     * @param mi - The MenuItem to remove
     * @return True if the item existed in the order
     */
    public boolean removeItem(MenuItem mi){
        return items.remove(mi);
    }

    public int getQuantity(MenuItem mi){
        int quantity = 0;
        for(MenuItem m : items){
            if(mi.equals(m)){
                quantity++;
            }
        }
        return quantity;
    }

    @Override
    public String toString() {
        return "Order " + id + ": " + items.size();
    }
}
