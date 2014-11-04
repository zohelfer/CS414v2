package TestBackEnd;

import Contollers.ItemType;
import Contollers.MenuItem;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by yabsubu12 on 10/23/14.
 */
public class MenuItemTest {
    @Test
    public void testIsSpecial1() throws Exception {
        MenuItem anItem = new MenuItem("Pizza", 6.5, ItemType.SPECIAL);
        assertEquals(ItemType.SPECIAL, anItem.getType());
    }

    @Test
    public void testIsSpecial2() throws Exception {
        MenuItem anItem = new MenuItem("Pizza", 6.5, ItemType.PIZZA);
        assertFalse(anItem.getType() == ItemType.SPECIAL);
    }

    @Test
    public void testChangeType1() throws Exception {
        MenuItem anItem = new MenuItem("Pizza", 6.5, ItemType.PIZZA);
        anItem.changeType(ItemType.SPECIAL);
        assertEquals(ItemType.SPECIAL, anItem.getType());
    }

    @Test
    public void testChangeType2() throws Exception {
        MenuItem anItem = new MenuItem("Pizza", 6.5, ItemType.SPECIAL);
        anItem.changeType(ItemType.PIZZA);
        assertEquals(ItemType.PIZZA, anItem.getType());
    }

    @Test
    public void testEquals1() throws Exception {
        MenuItem anItem = new MenuItem("Pizza", 6.5, ItemType.SPECIAL);
        MenuItem anItem2 = new MenuItem("Pizza", 6.5, ItemType.SPECIAL);
        assertEquals(true, anItem.equals(anItem2));
    }

    @Test
    public void testEquals2() throws Exception {
        MenuItem anItem = new MenuItem("Pizza", 6.5, ItemType.SPECIAL);
        MenuItem anItem2 = new MenuItem("Pasta", 6.5, ItemType.SPECIAL);
        assertEquals(false, anItem.equals(anItem2));
    }

    @Test
    public void testToString() throws Exception {
        MenuItem anItem = new MenuItem("Pizza", 6.5, ItemType.SPECIAL);
        assertEquals("Pizza 6.5 SPECIAL", anItem.toString());
    }
}
