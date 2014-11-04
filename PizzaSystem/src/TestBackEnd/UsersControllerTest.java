package TestBackEnd;

import Contollers.UsersController;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersControllerTest {

    private UsersController uc = UsersController.getInstance();

    private void createUser(int quantity){

    }

    @Test
    public void testGetInstance() throws Exception {
        uc = UsersController.getInstance();
        assertNotNull(uc);
    }

    @Test
    public void testCreateNewCust() throws Exception {
        int initS = uc.getCustomerCount();
        uc.createNewCust("Yab","222", "My home", "myemail@email.com", "Password");
        assertEquals(initS +1 , uc.getCustomerCount());
    }

    @Test
    public void testgetCustomer(){

    }
}