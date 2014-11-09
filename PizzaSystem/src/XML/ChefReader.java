package XML;

import Contollers.Chef;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Amanda on 11/9/2014.
 */
public class ChefReader {
    Chef c;
    String temp;
    ArrayList<Chef> chefList;

    public void parseFile() {
        chefList = new ArrayList<Chef>();
        SAXParserFactory s = SAXParserFactory.newInstance();
        try {
            SAXParser parser = s.newSAXParser();
            handler handler = new handler();
            parser.parse("Chefs.xml", handler);
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
            if (qName.equalsIgnoreCase("Chef")) {
                temp = "";
                c = new Chef();
                c.setID(Integer.parseInt(atts.getValue("type")));
            }
        }
        public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("Chef")) {
                chefList.add(c);
            } else if (qName.equalsIgnoreCase("name")) c.setName(temp);

        }
        public void characters(char[] chars, int s, int l) {
            temp = new String(chars, s, l);
        }
    }


    public static void main(String[] args) {
        ChefReader cr = new ChefReader();
        cr.parseFile();
        for(Chef c: cr.chefList) {
            System.out.println(c.getName());
        }
    }

}
