package XML;

import Contollers.Customer;
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
public class CustomerReader {
    Customer c;
    String temp;
    ArrayList<Customer> custList;

    public void parseFile() {
        custList = new ArrayList<Customer>();
        SAXParserFactory s = SAXParserFactory.newInstance();
        try {
            SAXParser parser = s.newSAXParser();
            handler handler = new handler();
            parser.parse("Customers.xml", handler);
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
            if (qName.equalsIgnoreCase("Customer")) {
                temp = "";
                c = new Customer();
                c.setCustID(Integer.parseInt(atts.getValue("type")));
            }
        }

        public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("Customer")) {
                custList.add(c);
            } else if (qName.equalsIgnoreCase("name")) c.setName(temp);
            else if (qName.equalsIgnoreCase("phone")) c.setPhone(temp);
            else if (qName.equalsIgnoreCase("email")) c.setEmail(temp);
            else if (qName.equalsIgnoreCase("address")) c.setAddress(temp);
        }
        public void characters(char[] chars, int s, int l) {
            temp = new String(chars, s, l);
        }
    }


    public static void main(String[] args) {
        CustomerReader cr = new CustomerReader();
        cr.parseFile();
        for(Customer c: cr.custList) {
            System.out.println(c.toString());
        }
    }

}
