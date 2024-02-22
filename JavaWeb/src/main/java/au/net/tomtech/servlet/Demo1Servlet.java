package au.net.tomtech.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*
WebServlet 表示定义类为Servlet
/demo1 表示的是路径 注意: 要带"/"
 */
@WebServlet("/demo1")
public class Demo1Servlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello World!");
    }
    @Override
    public void destroy() {

    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public String getServletInfo() {
        return null;
    }
}

