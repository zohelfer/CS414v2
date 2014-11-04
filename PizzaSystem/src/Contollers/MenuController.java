package Contollers;

import java.util.HashSet;
/**
 * Created by yabsubu12 on 10/23/14.
 */
public class MenuController {
    private static MenuController ourInstance = new MenuController();

    public static MenuController getInstance() {
        return ourInstance;
    }

    private HashSet<MenuItem> menuItems;
    private Reader fileReader;
    private Writer fileWriter;

    private MenuController() {
        fileReader = new Reader();
        fileWriter = new Writer();
        menuItems = new HashSet<MenuItem>();
        menuItems = fileReader.readMenu();
    }

    //Pretty much a "getMenu()"
    public HashSet<MenuItem> freshMenu() { return fileReader.readMenu(); }

    // Called at the start of menu adding process
    public HashSet<MenuItem> loadMenu(){
        return this.menuItems;
    }

    // Add item is clicked
    // Returns False: Item already exists
    public boolean addItem(String n, double p, ItemType type){
        MenuItem newMi = new MenuItem(n,p,type);
        for(MenuItem m : menuItems){
            if(m.equals(newMi)){
                return false;
            }
        }
        menuItems.add(newMi);
        return true;
    }

    // Remove item is clicked
    // Returns False: Item did not exist in set
    public boolean removeItem(String n, double p, ItemType type){
        MenuItem lookingFor = new MenuItem(n,p,type);
        for(MenuItem m : this.menuItems){
            if(m.equals(lookingFor)){
                this.menuItems.remove(m);
                return true;
            }
        }
        return false;
    }

    // Save menu is pressed
    // Returns False: Menu could not be saved (try again?)
    public boolean saveMenu(){
        return fileWriter.writeMenu(menuItems);
    }

    // Edit is pressed
    // Returns False: New item already exists
    public boolean editItem(String oldName, String newName, double newP, ItemType type){
        MenuItem newMI = new MenuItem(newName, newP, type);
        for(MenuItem mi: menuItems){
            if(oldName.equals(mi.getName())){
                menuItems.remove(mi);
                return menuItems.add(newMI);
            }
        }
        return false;
    }

    // Resets to an empty order
    public void resetInstance(){
        menuItems = new HashSet<MenuItem>();
    }

//    public boolean createCoupon(String code, String menuItem, int discountAmount){
//
//    }

}
