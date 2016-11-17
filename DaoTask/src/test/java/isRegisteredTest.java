import dao.UserDao;
import dao.UserDaoFileImpl;
import org.junit.Before;
import org.junit.Test;
import service.UserService;
import service.UsersService;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Viktor on 17.11.2016.
 */
public class isRegisteredTest {
    private UserDao testingUserDao;
    private UserService testingUsersService;

    @Before
    public void setTestingUsersService() throws Exception {
        testingUserDao = new UserDaoFileImpl();
        testingUsersService = new UsersService(testingUserDao);
    }

    @Test
    public void testIsRegistered() throws Exception{
        boolean expected = true;

        boolean actual = testingUsersService.isRegistered("Boris");

        assertEquals(expected, actual);
    }

}
