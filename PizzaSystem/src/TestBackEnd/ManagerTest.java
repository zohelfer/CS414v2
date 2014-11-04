package TestBackEnd;

import Contollers.Manager;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by yabsubu12 on 10/23/14.
 */
public class ManagerTest {
    @Test
    public void testToString() throws Exception {
        Manager aManager = new Manager("Yaba", 329);
        assertEquals(aManager.toString(), "Yaba~329");
    }
}
