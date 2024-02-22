package au.net.tomtech.web;

import au.net.tomtech.mapper.UserMapper;
import au.net.tomtech.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import au.net.tomtech.pojo.*;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        SqlSession sqlSession = MyBatisUtils.openSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.select(username, password);
        //解决中文响应
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(user == null)
        {
            writer.write("登陆失败！");
        }
        else
        {
            writer.write("登陆成功！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
