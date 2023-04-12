package de.tu_ilmenau.ajax.servlet;

import com.alibaba.fastjson.JSON;
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
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        List<Student> list = new StudentsDaoImpl().selectAll();

        // 使用fastjson来转换成json字符串
        String str = JSON.toJSONString(list);


        // 能不能后端不写html代码，只是返回数据呢？
        // 可以，使用json或者xml进行数据交换，前端来负责绘制表格
 /*       StringBuilder jsonStr = new StringBuilder();
        jsonStr.append("[");
        for (Student s : list
        ) {
           *//*out.print("<tr align='center'>");
            out.print("    <td> " + s.getId() + "</td>");
            out.print("    <td> " + s.getName() + "</td>");
            out.print("    <td>" + s.getAge() + "</td>");
            out.print(" <td>" + s.getAddr() + " </td>");
            out.print("  </tr>");*//*
            // 拼接HTML
            // 格式大概是[{属性名：属性值},{属性名：属性值},{属性名：属性值}...]
            jsonStr.append("{\"id\":" + s.getId() + ",\"name\":\"" + s.getName() + "\",\"age\":" + s.getAge() + ",\"addr\":\"" + s.getAddr() + "\"}");
            jsonStr.append(",");
        }
        jsonStr.deleteCharAt(jsonStr.length() - 1);
        jsonStr.append("]");
//       out.print(jsonStr);*/
       out.print(str);
    }
}
