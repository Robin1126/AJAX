package de.tu_ilmenau.ajax.servlet;

import de.tu_ilmenau.ajax.dao.impl.UsernameDaoImp;
import de.tu_ilmenau.ajax.pojo.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Author : Binbin Luo
 * Date : 12.04.2023
 */
@WebServlet("/xml")
public class XmlResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 这里要注意格式是text/xml
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList<Account> list = new UsernameDaoImp().selectAll();

        // 开始拼串
        StringBuilder xml = new StringBuilder();

        xml.append("<students>");

        for (Account account:list
             ) {
            xml.append("<student>");
            xml.append("<id>" + account.getId() +"</id>");
            xml.append("<username>" + account.getUsername() +"</username>");
            xml.append("<password>" + account.getPassword() +"</password>");
            xml.append("</student>");
        }
        xml.append("</students>");
        out.print(xml);
    }
}
