package de.tu_ilmenau.ajax.dao.impl;

import de.tu_ilmenau.ajax.dao.AreasDao;
import de.tu_ilmenau.ajax.pojo.Area;
import de.tu_ilmenau.ajax.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Author : Binbin Luo
 * Date : 13.04.2023
 */
public class AreasDaoImpl implements AreasDao {
    @Override
    public ArrayList<Area> selectAllProv() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Area> list = new ArrayList<>();

        try {
            conn = DBUtil.getConnection();
            String sql = "select code,name,pcode from t_area where pcode is null";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Area area = new Area(rs.getString("code"),rs.getString("name"),rs.getString("pcode"));
                list.add(area);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return list;
    }
}
