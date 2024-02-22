package au.net.tomtech.Response;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/resp3")
public class Response3Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取字节输入流
        FileInputStream fileInputStream =
                new FileInputStream("C:\\Users\\Tom\\IdeaProjects\\JavaProjects\\JavaWeb-Request-Respnse\\src\\main\\webapp\\images\\404a.jpg");
        //获取绝对路径的另一个方式
        //String realPath = getServletContext().getRealPath("images\\404a.jpg");
        //2. 获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //3. 写数据
        IOUtils.copy(fileInputStream, outputStream);
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

