package TestBackEnd;

import Contollers.ItemType;
import org.junit.Test;
import Contollers.OrderController;

import static org.junit.Assert.*;

/* NOTES:
testAdd clears instance - makes testing bearable
 */
public class OrderControllerTest {

    OrderController oc = OrderController.getInstance();

    private String iName = "New";
    private double iP = 4.0;
    private ItemType isS = ItemType.SPECIAL;

    public int testAdd(int quantity){
        oc.resetInstance();
        for(int i=0; i < quantity-1; i++){
            oc.addToOrder(iName, iP, isS);
        }
        return oc.addToOrder(iName, iP, isS);
    }

    @Test
    public void testGetInstance() throws Exception {
//        System.out.println("Test 1");
        oc = OrderController.getInstance();
        assertNotNull(oc);
    }

    @Test
    public void testAddToOrder() throws Exception {
        int newQ = testAdd(1);
        assertEquals(1, newQ);
        oc.resetInstance();
    }

    @Test
    public void testSecondAddToOrder() throws Exception {
        int newQ = testAdd(2);
        assertEquals(2, newQ);
        oc.resetInstance();
    }

    @Test
    public void testGetQuantity() throws Exception{
        testAdd(3);
        assertEquals(3, oc.getQuantity(iName, iP, isS));
        oc.resetInstance();
    }

    @Test
    public void testCompleteItem1() throws Exception {
        testAdd(2);
        oc.addToOrder("Pizza", 6.4, ItemType.PIZZA);
        oc.submitOrder();
        assertTrue(oc.completeItem("Pizza", 6.4, ItemType.PIZZA));
        oc.resetInstance();
    }

    @Test
    public void testCompleteItem2() throws Exception {
        testAdd(2);
        oc.addToOrder("Soda", 5.4, ItemType.DRINK);
        oc.submitOrder();
        assertFalse(oc.completeItem("Yogurt", 6.4, ItemType.PIZZA));
        oc.resetInstance();
    }

    @Test
    public void testSendBackToKitchen1() throws Exception {
        testAdd(2);
        assertTrue(oc.sendBackToKitchen(iName, iP, isS));
        oc.resetInstance();
    }

    @Test
    public void testSendBackToKitchen2() throws Exception {
        testAdd(2);
        assertFalse(oc.sendBackToKitchen("Pizza", 6.4, ItemType.PIZZA));
        oc.resetInstance();
    }

    @Test
    public void testRemoveAllMatching() throws Exception{
        testAdd(20);
        assertEquals(true, oc.removeAllMatchingItems(iName, iP, isS));
        oc.resetInstance();
    }

    @Test
    public void testSubmitOrder() throws Exception {
        testAdd(20);
        oc.addToOrder("Another", 2332.0, ItemType.DRINK);
        assertTrue(oc.submitOrder());
        oc.resetInstance();
    }

}