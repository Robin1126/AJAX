package de.tu_ilmenau.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author : Binbin Luo
 * Date : 10.04.2023
 */
@WebServlet("/ajaxrequest2")
public class AjaxRequest2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 从AJAX请求当中获取的信息
        String usercode = request.getParameter("usercode");
        String username = request.getParameter("username");

        out.print("<font size = '20px' color = 'red'>usercode = " + usercode + ", username = " + username + "</font>");
//        out.print("<font color='red'>ajax request received!</font>");
    }
}
