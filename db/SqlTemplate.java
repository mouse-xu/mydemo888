package com.njbdqn.mydemo888.db;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlTemplate {
    private  static DbManager dbm= new DbManager();
    private SqlTemplate(){};
    public static int update(String sql,Object...objects){
        return dbm.update(sql, objects);
    }
    public static <T>List<T> queryAll(Class clazz,String sql,Object...objects) {
        List<T> list = new ArrayList<>();
        ResultSet rs = dbm.query(sql, objects);
        try {
            while(rs.next()){
                Object object = clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field:fields){
                    try {
                        field.setAccessible(true);
                        field.set(object, rs.getObject(field.getName()));
                    } catch (SecurityException e) {
                        System.out.println("防止查询属性与视图类属性不一致导致程序中断");
                    }
                }
                list.add((T)object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Object uniqueQuery(String sql,Object...objects){
        ResultSet rs = dbm.query(sql, objects);
        Object object = null;
        try {
            if(rs.next()){
                object = rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }
}
