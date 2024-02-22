package au.net.tomtech.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
    value/urlPattern 是等价关系, 注意:不能同时存在
 */
@WebServlet(value = "/order/*.do") //扩展名匹配
public class Domo4Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get请求处理逻辑
        System.out.println("demo4 doGet 请求");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4 doPost 请求");
    }
}
