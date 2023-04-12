package de.tu_ilmenau.ajax.dao;

import de.tu_ilmenau.ajax.pojo.Account;

import java.util.ArrayList;

/**
 * Author : Binbin Luo
 * Date : 11.04.2023
 */
public interface UsernameDao {
    boolean checkUsername(String username);
    ArrayList<Account> selectAll();
}
