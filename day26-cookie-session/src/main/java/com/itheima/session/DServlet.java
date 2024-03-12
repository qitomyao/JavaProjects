package com.itheima.session;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = "/d")
public class DServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("是否是新创建的Session: "+session.isNew());
        System.out.println("Session的id: "+session.getId());

        // 获取Session过期时间 session默认30分钟不操作就会过期
        int maxInactiveIntervel = session.getMaxInactiveInterval();
        System.out.println("过期时间 = "+maxInactiveIntervel);

        // session立即过期(用于网站的退出操作)
        // session.invalidate();

        Object username = session.getAttribute("username");
        System.out.println("username = "+username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

