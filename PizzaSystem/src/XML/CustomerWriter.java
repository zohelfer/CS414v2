package XML;

import Contollers.Chef;
import org.w3c.dom.Element;
import Contollers.Customer;

/**
 * Created by Amanda on 11/9/2014.
 */
public class CustomerWriter extends XmlWriter{

    @Override
    public void createDOM() {
        Element root = DOM.createElement("Customers");
        DOM.appendChild(root);

        Customer a = new Customer("Test1", "555-867-5309", "123 Main", "A@a.com", 1);
        Customer z = new Customer("Test2", "555-555-5555", "124 Main", "B@a.com", 2);

        Element e = createElement(a);
        root.appendChild(e);
        e = createElement(z);
        root.appendChild(e);
    }

    @Override
    public Element createElement(Object object) {
        Element e = null;
        if(object instanceof Customer) {
            e = DOM.createElement("Customer");
            Customer m = (Customer) object;
            //Sets the type of menu item. EX: Pizza, Drink, Special
            e.setAttribute("type", "Customer");

            //Sets the name of the customer.
            Element name = DOM.createElement("name");
            org.w3c.dom.Text nameText = DOM.createTextNode(m.getName());
            name.appendChild(nameText);
            e.appendChild(name);

            //Sets the Customer's ID.
            Element id = DOM.createElement("id");
            org.w3c.dom.Text i = DOM.createTextNode(Integer.toString(m.getID()));
            id.appendChild(i);
            e.appendChild(id);

            //Set the Customer's phone number.
            Element p = DOM.createElement("phone");
            org.w3c.dom.Text phone = DOM.createTextNode(m.getPhone());
            p.appendChild(phone);
            e.appendChild(p);

            //Set the customer's Email
            Element email = DOM.createElement("email");
            org.w3c.dom.Text em = DOM.createTextNode(m.getEmail());
            email.appendChild(em);
            e.appendChild(email);

            //Set the Customer's address
            Element address = DOM.createElement("address");
            org.w3c.dom.Text addr = DOM.createTextNode(m.getAddress());
            address.appendChild(addr);
            e.appendChild(address);
        }
        return e;
    }

    public static void main(String[] args) {
        CustomerWriter cw = new CustomerWriter();
        cw.printToFile("Customers.xml");

    }
}
