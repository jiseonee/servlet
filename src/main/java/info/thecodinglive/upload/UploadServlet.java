package info.thecodinglive.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(name = "UploadServlet", urlPatterns = {"/upload"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, //2mb
        maxFileSize = 1024 * 1024 * 10, //10mb
        maxRequestSize = 10424 * 1024 * 50, //50mb
        location = "C:/Dev/spring-boot-web/servlet/src/main/upload"
)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html");

        final String path = req.getParameter("destination");
        final Part filePart = req.getPart("file");
        final String fileName = getFileName(filePart);
        final PrintWriter writer = resp.getWriter();

        try (OutputStream out = new FileOutputStream(new File(path + File.separator + fileName));
            InputStream filecontent = filePart.getInputStream()) {
            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            writer.println("new File: " + fileName + path + "에 생성되었습니다.");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("Part Header = {0}" + partHeader);
        for(String content : part.getHeader("content-disposition").split(";")) {
            if(content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
