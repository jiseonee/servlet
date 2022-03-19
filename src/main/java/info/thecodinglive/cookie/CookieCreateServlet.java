package info.thecodinglive.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/createCookie")
public class CookieCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>쿠키 예제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<a href='/readCookie'>readCookie</a>");
        out.println("</body>");
        out.println("</html>");

        Cookie jcookie = new Cookie("jpub", URLEncoder.encode("뉴 쿠키", "UTF-8"));
        jcookie.setMaxAge(3600);
        resp.addCookie(jcookie);
    }
}
