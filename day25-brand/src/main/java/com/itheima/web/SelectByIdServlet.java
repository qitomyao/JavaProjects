package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value="/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get请求
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        BrandService brandService = new BrandService();
        Brand brand = brandService.selectById(id);
        request.setAttribute("brand", brand);
        request.getRequestDispatcher("updateBrand.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
