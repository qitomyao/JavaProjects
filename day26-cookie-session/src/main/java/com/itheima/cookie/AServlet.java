package com.itheima.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

//发送Cookie 从服务器发送给浏览器
@WebServlet(value="/a")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get 请求
        //1 创建Cookie对象
        String username = "张 三";
        String encode = URLEncoder.encode("username", "UTF-8"); //如果需要存储空格等特殊字符，需要进行URL编码存储，读取后需要进行URL编码
        Cookie cookie = new Cookie("cookiename", "张三"); //创建Cookie
        cookie.setMaxAge(60*60); //设置Cookie过期时间
        response.addCookie(cookie);//发送Cookie给浏览器
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}



