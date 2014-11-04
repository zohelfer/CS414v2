package TestBackEnd;

/**
 * Created by nljohnso on 10/29/14.
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ChefTest.class, CustomerTest.class, ManagerTest.class, MenuControllerTest.class, MenuItemTest.class, OrderControllerTest.class, ReaderTest.class, UsersControllerTest.class, WriterTest.class })
public class TestAll {

}
