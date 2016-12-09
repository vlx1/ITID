import dao.OwnersDao;
import factories.ServiceFactory;
import service.UaOService;

import java.io.IOException;

/**
 * Created by Viktor on 28.11.2016.
 */
public class Program {
    public static void main(String[] args) {
        UaOService userService = ServiceFactory.getInstance().getService();
        try {
            boolean answer = userService.isOwnerRegistered("John");
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //OwnersDao ownersDao
    }
}

