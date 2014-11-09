package XML;

import Contollers.ItemType;
import org.w3c.dom.Element;

import Contollers.MenuItem;
/**
 * Created by Amanda on 11/6/2014.
 * Adapted using tutorial found here:
 * http://www.java-samples.com/showtutorial.php?tutorialid=152
 */
public class MenuItemWriter extends XmlWriter {

    public MenuItemWriter() {
        super();
    }

    @Override
    //Create the DOM tree
    public void createDOM() {
    Element root = DOM.createElement("Menu");
    DOM.appendChild(root);

    //Add some test data to the tree
        MenuItem mi = new MenuItem("Pepperoni", 11.99, ItemType.PIZZA);
        MenuItem m = new MenuItem("Pepsi", 2.50, ItemType.DRINK);
        MenuItem mm = new MenuItem("Special", 3.5, ItemType.SPECIAL);

        Element e = createElement(mi);
        root.appendChild(e);
        e = createElement(m);
        root.appendChild(e);
        e = createElement(mm);
        root.appendChild(e);
    }

    @Override
    public Element createElement(Object o) {
        Element e = DOM.createElement("MenuItem");
        if(o instanceof MenuItem) {
            MenuItem m = (MenuItem) o;
            //Sets the type of menu item. EX: Pizza, Drink, Special
            e.setAttribute("type", m.getTypeString());

            //Sets the name of the menu item.
            Element name = DOM.createElement("name");
            org.w3c.dom.Text nameText = DOM.createTextNode(m.getName());
            name.appendChild(nameText);
            e.appendChild(name);

            //Set the price of the menu item.
            Element p = DOM.createElement("price");
            org.w3c.dom.Text price = DOM.createTextNode(Double.toString(m.getPrice()));
            p.appendChild(price);
            e.appendChild(p);
            }
        return e;
    }
    public static void main(String[] args) {
        MenuItemWriter mw = new MenuItemWriter();
        mw.printToFile("Menu.xml");
    }
}
