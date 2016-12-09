import factories.ServiceFactory;
import model.Owner;
import service.UaOService;
import dao.OwnersDao;
import factories.ServiceFactory;
import service.UaOService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Viktor on 05.12.2016.
 */
@WebServlet("/all")
public class MainServlet extends HttpServlet  {


    UaOService userService;

    private List<Owner> tmpList;
/*
    public MainServlet() throws IOException {
        UaOService userService = ServiceFactory.getInstance().getService();

        tmpList =userService.getAllUsers();
    }
    */

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
            userService = ServiceFactory.getInstance().getService();
            tmpList = userService.getAllUsers();
        } catch (ServletException e) {
            throw new IllegalStateException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setAttribute("user_list", tmpList);
        getServletContext().getRequestDispatcher("/getpage.jsp").forward(req, resp);
    }
}