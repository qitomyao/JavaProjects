package com.itheima.web;

import com.itheima.pojo.Brand;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(value="/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get 请求
        request.setCharacterEncoding("UTF-8");
        //1. 接收Brand数据 封装到Brand对象
        Brand brand = new Brand();
        brand.setBrandName(request.getParameter("brandName"));
        brand.setCompanyName(request.getParameter("companyName"));
        brand.setOrdered(Integer.parseInt(request.getParameter("ordered")));
        brand.setDescription(request.getParameter("description"));
        brand.setStatus(Integer.parseInt(request.getParameter("status")));

        System.out.println(brand);
        //2. 使用BrandService进行数据添加


        //3. 资源跳转 SelectAllServlet
        //addServlet --->  SelectAllServlet 没有携带数据 使用重定向进行资源跳转
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
