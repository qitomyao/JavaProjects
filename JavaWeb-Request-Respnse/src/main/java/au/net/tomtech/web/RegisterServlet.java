package au.net.tomtech.web;

import au.net.tomtech.mapper.UserMapper;
import au.net.tomtech.pojo.User;
import au.net.tomtech.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        SqlSession sqlSession = MyBatisUtils.openSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        //判断用户是否存在
        User user = userMapper.selectByName(username);
        if(user!=null)
        {
            writer.write("用户名存在，请重新注册！");
        }
        else
        {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            userMapper.add(newUser);
            sqlSession.commit();
            writer.write("注册成功！");
        }
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
