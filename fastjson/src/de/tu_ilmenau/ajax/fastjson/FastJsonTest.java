package de.tu_ilmenau.ajax.fastjson;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * Author : Binbin Luo
 * Date : 12.04.2023
 */
public class FastJsonTest {
    public static void main(String[] args) {
        // 创建一个user对象
        User user = new User("123","布布",30);

        // 将以上的对象使用fastjson转换成json的字符串
        // fastjson中有一个类，叫做JSON，直接调用
        // JSON中的方法都是静态方法，直接调用
        String jsonStr = JSON.toJSONString(user);

        System.out.println(jsonStr); // {"age":30,"id":"123","username":"布布"}
        // 尝试转换list为json对象
        ArrayList<User> list = new ArrayList<>();
        User user1 = new User("1","yier",30);
        User user2 = new User("2","bubu",30);
        list.add(user1);
        list.add(user2);
        String jsonList = JSON.toJSONString(list);

        System.out.println(jsonList); // [{"age":30,"id":"1","username":"yier"},{"age":30,"id":"2","username":"bubu"}]
    }
}
