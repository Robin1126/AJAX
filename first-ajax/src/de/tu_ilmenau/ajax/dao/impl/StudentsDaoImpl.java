package de.tu_ilmenau.ajax.dao.impl;

import de.tu_ilmenau.ajax.dao.StudentsDao;
import de.tu_ilmenau.ajax.pojo.Student;
import de.tu_ilmenau.ajax.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : Binbin Luo
 * Date : 11.04.2023
 */
public class StudentsDaoImpl implements StudentsDao {
    @Override
    public List<Student> selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from t_student";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String addr = rs.getString("addr");
                Student student = new Student(id, name, age, addr);
                list.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return list;
    }
}
