package org.ipchina.qqbaby.web;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: wayaya
 * Date: 13-4-20
 * Time: ÏÂÎç2:00
 */
public class WebServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        System.out.println(request.getProtocol());
        System.out.println(request.getServerPort());
        System.out.println(request.getLocalAddr());
        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());
        System.out.println(request.getPathInfo());
        System.out.println(request.getQueryString());
        System.out.println();
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println();
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemotePort());
        super.service(req, res);
    }
}
