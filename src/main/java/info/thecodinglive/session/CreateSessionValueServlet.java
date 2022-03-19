package info.thecodinglive.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/createSessionValue")
public class CreateSessionValueServlet extends HttpServlet {
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
        session.setAttribute("jpub", "book");
        out.println("session created");
        out.println("<a href='readSessionValue'>세션 값 읽기</a>");
        
        out.println("</body>");
        out.println("</html>");
    }
}
