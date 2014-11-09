package XML;

import Contollers.ItemType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import Contollers.MenuItem;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Amanda on 11/6/2014.
 */

public class MenuItemReader {

    MenuItem mi;
    String temp;
    ArrayList<MenuItem> menu;

    public void parseFile() {
        menu = new ArrayList<MenuItem>();
        SAXParserFactory s = SAXParserFactory.newInstance();
        try {
            SAXParser parser = s.newSAXParser();
            handler handler = new handler();
            parser.parse("Menu.xml", handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class handler extends DefaultHandler {

        public void startElement(String namespaceUri, String localName, String qName, Attributes atts) throws SAXException {
            if (qName.equalsIgnoreCase("MenuItem")) {
                temp = "";
                mi = new MenuItem();
                for(int i =0; i < atts.getLength(); i++) {
                    if (atts.getValue("type").equalsIgnoreCase("pizza")) mi.changeType(ItemType.PIZZA);
                    else if (atts.getValue("type").equalsIgnoreCase("drink")) mi.changeType(ItemType.DRINK);
                    else mi.changeType(ItemType.SPECIAL);
                }
            }
        }

        public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("MenuItem")) {
              menu.add(mi);
            } else if (qName.equalsIgnoreCase("name")) mi.setName(temp);
            else if (qName.equalsIgnoreCase("price")) mi.setPrice(Double.parseDouble(temp));
        }
        public void characters(char[] chars, int s, int l) {
            temp = new String(chars, s, l);
        }
    }
}
