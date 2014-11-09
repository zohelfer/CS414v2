package XML;

import Contollers.Chef;
import org.w3c.dom.Element;

/**
 * Created by Amanda on 11/9/2014.
 */
public class ChefWriter extends XmlWriter {

    @Override
    public void createDOM() {
        Element root = DOM.createElement("Customers");
        DOM.appendChild(root);

        Chef t = new Chef("Test1", 1);
        Element e = createElement(t);
        root.appendChild(e);
    }

    @Override
    public Element createElement(Object object) {
        Element e = null;
        if(object instanceof Chef) {
            e = DOM.createElement("Chef");
            Chef m = (Chef) object;
            //Sets the type of menu item. EX: Pizza, Drink, Special
            e.setAttribute("type", Integer.toString(m.getID()));

            //Sets the name of the customer.
            Element name = DOM.createElement("name");
            org.w3c.dom.Text nameText = DOM.createTextNode(m.getName());
            name.appendChild(nameText);
            e.appendChild(name);
        }
        return e;
    }

    public static void main(String[] args) {
        ChefWriter cw = new ChefWriter();
        cw.printToFile("Chefs.xml");
    }
}
