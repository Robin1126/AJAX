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
@WebServlet("/ajaxrequest")
public class AjaxRequest1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String s = null;
//        s.toString();

//        Servlet向浏览器响应一段数据
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 响应信息会发送回给XMLHttpRequest对象
        out.print("<font color='red'>welcome to ajax!</font>");
    }
}
