package au.net.tomtech.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(value="/req02")
public class Request1Servlet extends HttpServlet {
    //浏览器获取到的请求头
    // GET /JavaWeb_Request_Respnse_war_exploded/req02?username=sdfsdf&password=sdfsdf HTTP/1.1
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("请求方式 = "+request.getMethod()); //String类型
        System.out.println("项目访问路径 = "+request.getContextPath()); //String类型
        System.out.println("获取统一资源标识符(URI):"+request.getRequestURI()); //String类型
        System.out.println("获取统一资源定位符(URL):"+request.getRequestURL()); //StringBuffer类型
        System.out.println("获取请求参数:"+request.getQueryString()); //String类型
        System.out.println("获取特定参数的值:"+request.getParameter("username"));
        System.out.println("获取特定参数的值:"+request.getParameter("password"));
        System.out.println("获取User-Agent(浏览器版本):"+request.getHeader("User-Agent"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Post中也可以通过request.getParameter读取参数
        System.out.println("获取特定参数的值:"+request.getParameter("username"));
        System.out.println("获取特定参数的值:"+request.getParameter("password"));
        /*
        读取参数和读取请求体不能同时使用

        //BefferedReader getReader(获取字符输入流)
        BufferedReader reader = request.getReader();
        //读取数据
        //POST请求参数 = username=sdfsdf&password=sdfsfdsdfsdf&hobby=1
        System.out.println("POST请求参数 = "+reader.readLine());

         */
    }
}


