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
public class setTest {
    private UserService testingUsersService;

    @Before
    public void setTestingUsersService() throws Exception {
        testingUsersService = ServiceFactory.getInstance().getUsersService();
    }

    @Test
    public void testGetUser() throws IOException {
        User expected = new User(1, "Alexander", "alex_killa", "killa");
        User actual = testingUsersService.getUser(1);

        assertEquals(expected,actual);
    }
}
