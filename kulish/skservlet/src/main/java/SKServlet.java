import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    @WebServlet(name = "GetCities", urlPatterns = {"/GetCities"})
    public class SKServlet extends HttpServlet {

//        @Inject
//        ICityService cityService;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

//            response.setContentType("application/html;charset=UTF-8");
            response.setContentType("text/plain");

            Thread thread = Thread.currentThread();
            response.getWriter().append("Thread=" + thread.toString()+" "+thread.getName());

            //List<City> cities = cityService.getCities();
            //request.setAttribute("cities", cities);

            //RequestDispatcher dispatcher = request.getRequestDispatcher("listCities.jsp");
            //dispatcher.forward(request, response);
//            ServletOutputStream out = response.getOutputStream();
//
//            out.print("This is MyServlet");
        }
    }