package info.thecodinglive.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/readSessionValue")
public class ReadSessionValueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>세션</title>");
        out.println("</head>");
        out.println("<body>");

        HttpSession session = req.getSession();
        String sessionValue = (String) session.getAttribute("jpub");
        out.println("session value [jpub] : " + sessionValue);

        out.println("</body>");
        out.println("</html>");
    }
}
