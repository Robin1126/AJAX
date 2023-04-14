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
@WebServlet("/jsonp1")
public class JsonpServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("jsonp方式完成跨域访问");

        // 这里也可以响应一段js代码，然后前端相当于在script标签当中执行这段js代码
        // 注意！后端并不调用前端的js代码，只是响应了一段js代码的字符串回去，前端来执行
        PrintWriter out = response.getWriter();
//        out.print("alert('123')");

        // 后端给前端传一个json字符串
//        out.print("sayHello({\"name\" : \"lbb\"})");

        // 动态获取函数名，再加上json字符串
        String fun = request.getParameter("fun");
        out.print(fun + "({\"name\" : \"布布\"})");
    }
}
