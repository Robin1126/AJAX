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
 * Date : 13.04.2023
 */
@WebServlet("/ajaxrequest9")
public class AjaxRequest9Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

//        out.print("<font color='red'>hello ajax!</font>");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
//        out.print("<font color='red'>" + username + "</font>");
        // 响应一个json {"username":"bubu"}
        out.print("{\"username\":\"" + username + "\"}");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        out.print("{\"username\" : \"" + username + "\"}");

    }
}
