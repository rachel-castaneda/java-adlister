import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);

    } // ends the public class for the servlet

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

            if (username != null && password != null) {
            if (username.equals("user") && password.equals("password")) {
                response.sendRedirect("/profile.jsp?username="+username);
            } else {
                response.sendRedirect("/login.jsp");
            }

        } // if statement establishing that username and password are not null

    } // temp user and password made to interact with login for now

}

