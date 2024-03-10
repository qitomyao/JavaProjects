package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get请求
        //1. 使用BrandService进行数据查询 List<Brand>
        BrandService brandService = new BrandService();
        List<Brand> brands = brandService.selectAll();

        //2. 进行资源跳转

        //2.1 将数据存储到Request域
        request.setAttribute("brands", brands);

        //2.2 转发
        request.getRequestDispatcher("brandList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


