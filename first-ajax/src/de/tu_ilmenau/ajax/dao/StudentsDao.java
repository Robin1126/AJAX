package de.tu_ilmenau.ajax.dao;

import de.tu_ilmenau.ajax.pojo.Student;

import java.util.List;

/**
 * Author : Binbin Luo
 * Date : 11.04.2023
 */
public interface StudentsDao {
    List<Student> selectAll();
}
