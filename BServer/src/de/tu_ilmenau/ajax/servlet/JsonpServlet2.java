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
 * Date : 14.04.2023
 */
@WebServlet("/jsonp2")
public class JsonpServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // {"username" : "yier"}
        // 这个callback不能随便写，是jQuery规定的
        String fun = request.getParameter("fun");
        // 后端必须生成调用这个callback函数的字符串才行
        out.print(fun + "({\"username\" : \"一二\"})");
    }
}
