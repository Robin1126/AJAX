package de.tu_ilmenau.ajax.servlet;

import de.tu_ilmenau.ajax.dao.impl.StudentsDaoImpl;
import de.tu_ilmenau.ajax.pojo.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : Binbin Luo
 * Date : 11.04.2023
 */
@WebServlet("/ajaxrequest5")
public class AjaxRequest5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<Student> list = new ArrayList<>();
        list = new StudentsDaoImpl().selectAll();

        // 能不能后端不写html代码，只是返回数据呢？
        // 可以，使用json或者xml进行数据交换，前端来负责绘制表格
        for (Student s : list
        ) {
            out.print("<tr align='center'>");
            out.print("    <td> " + s.getId() + "</td>");
            out.print("    <td> " + s.getName() + "</td>");
            out.print("    <td>" + s.getAge() + "</td>");
            out.print(" <td>" + s.getAddr() + " </td>");
            out.print("  </tr>");
        }
    }
}