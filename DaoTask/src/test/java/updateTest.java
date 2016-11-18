import factories.ServiceFactory;
import model.User;
import org.junit.Before;
import org.junit.Test;
import service.UserService;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Viktor on 18.11.2016.
 */
public class updateTest {
    private UserService testingUsersService;

    @Before
    public void setTestingUsersService() throws Exception {
        testingUsersService = ServiceFactory.getInstance().getUsersService();
    }

    @Test
    public void testGetUser() throws IOException {
        User expected = new User(2, "BorisEl", "borisElLogin", "1991SE");
        testingUsersService.updateUser(new User(2, "BorisEl", "borisElLogin", "1991SE"));
        User actual = testingUsersService.getUser(2);

        assertEquals(expected,actual);
    }
}
