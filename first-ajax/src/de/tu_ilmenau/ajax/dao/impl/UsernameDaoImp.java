package de.tu_ilmenau.ajax.dao.impl;

import de.tu_ilmenau.ajax.dao.UsernameDao;
import de.tu_ilmenau.ajax.pojo.Account;
import de.tu_ilmenau.ajax.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Author : Binbin Luo
 * Date : 11.04.2023
 */
public class UsernameDaoImp implements UsernameDao {
    @Override
    public boolean checkUsername(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;

        try {
            conn = DBUtil.getConnection();
            String sql = "select id, username, password from t_user where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return flag;
    }

    @Override
    public ArrayList<Account> selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Account> list = new ArrayList<>();

        try {
            conn = DBUtil.getConnection();
            String sql = "select id, username, password from t_user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                list.add(new Account(id, username, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return list;
    }
}
