package TestBackEnd;

import Contollers.Customer;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by yabsubu12 on 10/23/14.
 */
public class CustomerTest {


    @Test
    public void testToString() throws Exception {
        Customer aCustomer1 = new Customer("Yaba", "222", "My home", "myemail@email.com", 34);
        assertEquals(aCustomer1.toString(), "Yaba~222~My home~myemail@email.com~34");
    }

    @Test
    public void testEquals1() throws Exception {
        Customer aCustomer1 = new Customer("Yaba", "222", "My home", "myemail@email.com", 34);
        Customer aCustomer2 = new Customer("Yaba", "222", "My home", "myemail@email.com", 34);
        assertEquals(aCustomer1.equals(aCustomer2), true);
    }

    @Test
    public void testEquals2() throws Exception {
        Customer aCustomer1 = new Customer("Yaba", "222", "My home", "myemail@email.com", 34);
        Customer aCustomer2 = new Customer("Yaba", "223", "My home", "myemail@email.com", 35);
        assertEquals(aCustomer1.getID() == aCustomer2.getID(), false);
    }
}
