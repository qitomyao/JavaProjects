package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //输出中文乱码解决
        resp.setContentType("text/html;charset=utf8");
        //获取输出流
        PrintWriter writer = resp.getWriter();
        //输出
        writer.write("<html>");
        writer.write("<head>");
        writer.write("      <title>JSP</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("      <h1>你好 黑马</h1>");
        System.out.println("你好黑马");
        writer.write("</body>");
        writer.write("</html>");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        doGet(req, resp);
    }
}
