package de.tu_ilmenau.ajax.servlet;

import com.alibaba.fastjson.JSON;
import de.tu_ilmenau.ajax.dao.impl.AreasDaoImpl;
import de.tu_ilmenau.ajax.pojo.Area;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.util.ArrayList;

/**
 * Author : Binbin Luo
 * Date : 13.04.2023
 */
@WebServlet({"/listArea","/listCity"})
public class ListAreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String servletPath = request.getServletPath();

        if ("/listArea".equals(servletPath)) {
            // 连接数据库,获取结果
            ArrayList<Area> list = new AreasDaoImpl().selectAllProv();

            // 转换为json格式的字符串返回
            String jsonList = JSON.toJSONString(list);

            // 返回json对象
            out.print(jsonList);
        }

        if ("/listCity".equals(servletPath)) {
            String pcode = request.getParameter("pcode");
            ArrayList<Area> list = new AreasDaoImpl().selectAllCity(pcode);

            // 转换称为json格式的字符串
            String jsonList = JSON.toJSONString(list);
            // 返回json
            out.print(jsonList);
        }
    }
}
