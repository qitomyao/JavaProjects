package com.itheima.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;

//获取Cookie 数据
@WebServlet(value="/b")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取Cookie数据，使用request对象
        Cookie[] cookies = request.getCookies();
        //2. 遍历获取每个Cookie
        if(cookies!=null){
            for(Cookie cookie : cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                value = URLDecoder.decode(value, "UTF-8");
                System.out.println(name+" :: "+value);
            }
        }
        else
        {
            System.out.println("没有Cookie");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


