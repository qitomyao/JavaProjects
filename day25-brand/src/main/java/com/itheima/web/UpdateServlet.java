package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(value="/updateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> map = request.getParameterMap();
        Brand brand = new Brand();
        try{
            BeanUtils.populate(brand, map);
            BrandService brandService = new BrandService();
            brandService.update(brand);
            response.sendRedirect("selectAllServlet");
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
