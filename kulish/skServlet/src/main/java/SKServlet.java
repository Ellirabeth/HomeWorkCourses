import model.User;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@WebServlet(name = "Get Thread", urlPatterns = {"/app"})
public class SKServlet extends HttpServlet {

//        @Inject
//        ICityService cityService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/plain");
        go(response.getWriter());

        //List<City> cities = cityService.getCities();
        //request.setAttribute("cities", cities);

        //RequestDispatcher dispatcher = request.getRequestDispatcher("listCities.jsp");
        //dispatcher.forward(request, response);
//            ServletOutputStream out = response.getOutputStream();
//
//            out.print("This is MyServlet");
    }

    public static void main(String[] args) throws IOException {
        SKServlet servlet = new SKServlet();
        servlet.go(System.out);
    }

    private void go(Appendable writer) throws IOException {
        SKRmiClient client = new SKRmiClient();

        User usr = new User();
        usr.setName("admin");
        usr.setPasswd("123");
        User resUser;
        Thread thread = Thread.currentThread();

        writer.append("Thread=").append(thread.toString()).append(" ").append(thread.getName());
        try {
            resUser = client.addUser(usr);
//            response.setContentType("application/html;charset=UTF-8");

            writer.append("User=").append(resUser.toString());
        } catch (InterruptedException | ExecutionException e) {
            writer.append(e.getMessage());
        }
    }
}