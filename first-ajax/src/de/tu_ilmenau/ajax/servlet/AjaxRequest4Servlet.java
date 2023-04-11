package de.tu_ilmenau.ajax.servlet;

import de.tu_ilmenau.ajax.dao.impl.UsernameDaoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author : Binbin Luo
 * Date : 11.04.2023
 */
@WebServlet("/ajaxrequest4")
public class AjaxRequest4Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        if (username != null) {
            boolean flag = new UsernameDaoImp().checkUsername(username);

            if (!flag) {
                out.print("<font color='green'>恭喜！用户名可用！</font>");
            } else {
                out.print("<font color='red'>对不起！用户名已存在</font>");
            }
        }
    }
}
