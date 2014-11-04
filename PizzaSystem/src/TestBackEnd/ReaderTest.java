package TestBackEnd;

import Contollers.*;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Hashtable;

public class ReaderTest extends TestCase {

    public Writer writer = new Writer();
    public Reader reader = new Reader();

    public void testReadMenu() throws Exception {
        HashSet<MenuItem> m = new HashSet<MenuItem>();
        m.add(new MenuItem("Pepperoni", 3.5, ItemType.SPECIAL));
        m.add(new MenuItem("Cheese", 5.0, ItemType.PIZZA));
        writer.writeMenu(m);
        HashSet<MenuItem> m2 = reader.readMenu();
        assertEquals(m2.size(), m.size());
    }

    public void testReadIncomplete() throws Exception {
        Hashtable<MenuItem, Integer> orders = new Hashtable<MenuItem, Integer>();
        orders.put(new MenuItem("Pepperoni", 3.5, ItemType.SPECIAL), 4);
        orders.put(new MenuItem("Cheese", 5.0, ItemType.PIZZA), 7);
        writer.writeIncompleteOrders(orders);
        Hashtable<MenuItem, Integer> orders2 = reader.readIncomplete();
        assertEquals(orders2.size(), orders.size());
    }

    public void testReadCustomer() throws Exception {
        HashSet<Customer> c = new HashSet<Customer>();
        c.add(new Customer("Yab","222", "My home", "myemail@email.com", 34));
        c.add(new Customer("Nik","324", "My home", "myemail@email.com", 36));
        writer.writeCustomer(c);
        HashSet<Customer> c2 = reader.readCustomer();
        assertEquals(c2.size(), c.size());
    }

    public void testReadLogin() throws Exception {
        Hashtable<String, String> logins = new Hashtable<String, String>();
        logins.put("yaba", "hunter1");
        logins.put("nik36232", "taco");
        writer.writeLogin(logins);
        Hashtable<String, String> logins2 = reader.readLogin();
        assertEquals(logins2.size(), logins.size());
    }
}