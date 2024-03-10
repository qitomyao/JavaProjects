package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(value = "/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        brand.setBrandName(request.getParameter("brandName"));
//        brand.setCompanyName(request.getParameter("companyName"));
//        brand.setOrdered(Integer.parseInt(request.getParameter("ordered")));
//        brand.setDescription(request.getParameter("description"));
//        brand.setStatus(Integer.parseInt(request.getParameter("status")));
//
//        System.out.println(brand);


        //get 请求
        request.setCharacterEncoding("UTF-8");
        //1. 接收Brand数据 封装到Brand对象
        Brand brand = new Brand();
        Map<String, String[]> map = request.getParameterMap(); //获取到所有数据
        map.forEach((key, values) -> {
            System.out.println(key + "::" + Arrays.toString(values));
        });
        try {
            BeanUtils.populate(brand, map);
            //2. 使用BrandService进行数据添加
            BrandService brandService = new BrandService();
            brandService.add(brand); //添加数据
            //3. 资源跳转 SelectAllServlet
            //addServlet --->  SelectAllServlet 没有携带数据 使用重定向进行资源跳转
            response.sendRedirect("selectAllServlet");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
