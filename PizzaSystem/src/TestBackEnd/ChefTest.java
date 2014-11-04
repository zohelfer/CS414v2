package TestBackEnd;

import Contollers.Chef;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by yabsubu12 on 10/23/14.
 */
public class ChefTest {

    @Test
    public void testSetName() throws Exception {
        Chef aChef = new Chef("Yaba", 4288);
        aChef.setName(null);
        assertEquals(aChef.getName(), "Yaba");
    }

    @Test
    public void testToString() throws Exception {
        Chef aChef = new Chef("Yaba", 4288);
        assertEquals(aChef.toString(), "Yaba~4288");
    }
}
