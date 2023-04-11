package de.tu_ilmenau.ajax.dao.impl;

import de.tu_ilmenau.ajax.dao.UsernameDao;
import de.tu_ilmenau.ajax.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
