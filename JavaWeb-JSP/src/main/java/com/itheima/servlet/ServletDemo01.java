package com.itheima.servlet;

import com.itheima.pojo.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/demo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.准备数据
        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(2,"优衣库","优衣库",200,"优衣库，服适人生",0));
        brands.add(new Brand(3,"小米","小米科技有限公司",1000,"为发烧而生",1));
        brands.add(new Brand(5,"华为","华为科技有限公司",1000,"为发烧而生",1));
        brands.add(new Brand(6,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));

        // 2.存储数据到request域中
        request.setAttribute("brands", brands);
        request.setAttribute("username", "zhangsan");
        request.setAttribute("age", 16);

        // 3.转发到jsp
        request.getRequestDispatcher("/04el.jsp").forward(request, response);
        // request.getRequestDispatcher("/05if.jsp").forward(request, response);
        // request.getRequestDispatcher("/06foreach.jsp").forward(request, response);
    }
}

