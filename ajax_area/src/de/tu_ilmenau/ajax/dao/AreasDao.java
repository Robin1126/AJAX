package de.tu_ilmenau.ajax.dao;

import de.tu_ilmenau.ajax.pojo.Area;

import java.util.ArrayList;

/**
 * Author : Binbin Luo
 * Date : 13.04.2023
 */
public interface AreasDao {
    ArrayList<Area> selectAllProv();
    ArrayList<Area> selectAllCity(String pcode);
}
