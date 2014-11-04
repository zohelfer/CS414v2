package TestBackEnd;

import Contollers.Customer;
import Contollers.ItemType;
import Contollers.MenuItem;
import Contollers.Writer;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Hashtable;



public class WriterTest extends TestCase {

    public Writer writer = new Writer();

    public void testWriteMenu() throws Exception {
        HashSet<MenuItem> m = new HashSet<MenuItem>();
        m.add(new MenuItem("Pepperoni", 3.5, ItemType.SPECIAL));
        m.add(new MenuItem("Cheese", 5.0, ItemType.PIZZA));
        assertTrue(writer.writeMenu(m));
    }

    public void testWriteIncompleteOrders() throws Exception {
        Hashtable<MenuItem, Integer> orders = new Hashtable<MenuItem, Integer>();
        orders.put(new MenuItem("Pepperoni", 3.5, ItemType.SPECIAL), 4);
        orders.put(new MenuItem("Cheese", 5.0, ItemType.PIZZA), 7);
        assertTrue(writer.writeIncompleteOrders(orders));
    }

    public void testWriteCustomer() throws Exception {
        HashSet<Customer> c = new HashSet<Customer>();
        c.add(new Customer("Yab","222", "My home", "myemail@email.com", 34));
        c.add(new Customer("Nik","324", "My home", "myemail@email.com", 36));
        assertTrue(writer.writeCustomer(c));
    }

    public void testWriteLogin() throws Exception {
        Hashtable<String, String> logins = new Hashtable<String, String>();
        logins.put("yaba", "hunter1");
        logins.put("nik36232", "taco");
        assertTrue(writer.writeLogin(logins));
    }
}