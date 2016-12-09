import factories.ServiceFactory;
import model.Owner;
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
 * Created by Viktor on 08.12.2016.
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    UaOService userService;

    private List<Owner> tmpList;

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        getServletContext().getRequestDispatcher("/adduser.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String city = request.getParameter("city");

        Owner owner = new Owner(id, name, age, city);
        userService.addOwner(owner);
    }
}
