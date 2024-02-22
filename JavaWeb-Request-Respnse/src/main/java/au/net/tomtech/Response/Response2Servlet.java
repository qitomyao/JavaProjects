package au.net.tomtech.Response;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp2")
public class Response2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8"); //解决中文乱码问题
        //1. 获取响应字符输出流
        PrintWriter writer = response.getWriter();
        writer.write("ddd");
        writer.write("你好");
        writer.write("<h1>Hello World!</h1>");
        writer.write("<script>alert('Hello World')</script>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


