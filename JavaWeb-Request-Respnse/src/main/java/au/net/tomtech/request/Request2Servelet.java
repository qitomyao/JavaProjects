package au.net.tomtech.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/req03")
public class Request2Servelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get请求
        //1. 获取map集合
        Map<String, String[]> map = request.getParameterMap();
        map.forEach((key, values)->{
            System.out.println(key+"::"+ Arrays.toString(values));
        });
        System.out.println("-----------------------------");
        //2. 根据参数名称获取参数值 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("username: "+username);
        System.out.println("password: "+password);
        System.out.println("hobbies: "+Arrays.toString(hobbies));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数方式get和post是一样的, 因此可以直接调用doGet
        System.out.println("========Post请求==========");
        doGet(request, response);
    }
}

