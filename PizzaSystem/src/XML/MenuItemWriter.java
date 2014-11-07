package XML;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import Contollers.ItemType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

import Contollers.MenuItem;



/**
 * Created by Amanda on 11/6/2014.
 * Adapted using tutorial found here:
 * http://www.java-samples.com/showtutorial.php?tutorialid=152
 */
public class MenuItemWriter implements XmlWriterInterface {

    Document DOM;
    DocumentBuilderFactory d;

    public MenuItemWriter() {
        createDocument();

    }

    //Create a new Document object
    public void createDocument() {
        d = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = d.newDocumentBuilder();
            DOM = db.newDocument();
        } catch(ParserConfigurationException p) {
            System.exit(0);
        }
    }
    //Create the DOM tree
    public void createDOM() {
    Element root = DOM.createElement("Menu");
    DOM.appendChild(root);

    //Add some test data to the tree
        MenuItem mi = new MenuItem("Pepperoni", 11.99, ItemType.PIZZA);
        MenuItem m = new MenuItem("Pepsi", 2.50, ItemType.DRINK);

        Element e = createMIElement(mi);
        root.appendChild(e);
        e = createMIElement(m);
        root.appendChild(e);
    }
    public void printToFile() {
        try {
                Transformer t = TransformerFactory.newInstance().newTransformer();
                t.setOutputProperty(OutputKeys.INDENT, "yes");
                t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                Result o = new StreamResult(new File("Menu.xml"));
                Source i = new DOMSource(DOM);
                t.transform(i, o);
        } catch(TransformerException te) {
            System.out.println("Transformer exception");
            System.exit(1);

        }
    }

    public Element createMIElement(MenuItem m) {
        Element e = DOM.createElement("MenuItem");

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

        return e;
    }

    public static void main(String [] args) {
        MenuItemWriter m = new MenuItemWriter();
        m.createDOM();
        m.printToFile();


    }
}
