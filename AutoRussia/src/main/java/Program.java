import com.mysql.fabric.jdbc.FabricMySQLDriver;
import factories.ServiceFactory;
import service.UsersAndAutosService;

import java.io.IOException;
import java.sql.*;


/**
 * Created by Viktor on 20.11.2016.
 */
public class Program {


    public static void main(String[] args) {
        UsersAndAutosService userService = ServiceFactory.getInstance().getService();
        try {
            boolean answer = userService.isOwnerRegistered("John");
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
