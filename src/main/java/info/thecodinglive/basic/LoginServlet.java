package info.thecodinglive.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost 메서드 호출");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        resp.setContentType("text/html");

        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");

        writer.println("<html>");
        writer.println("<haed><title>Login Servlet</title></head>");
        writer.println("<body>");
        writer.println("user: " + user + "<br>" + "pwd: " + pwd);
        writer.println("</body>");
        writer.println("</html>");
    }
}
