package com.njbdqn.mydemo888.db;

import java.io.FileInputStream;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private  static  String DRIVER;
    private  static  String URL;
    private  static  String USERNAME;
    private  static  String PASSWORD;
    private  static Connection conn;
    private DbUtil(){};
    static {
        try {
            readDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readDriver()  throws  Exception{
        String path = URLDecoder.decode(DbUtil.class.getResource("/driver.properties").getPath(), "UTF-8");
        Properties pro = new Properties();
        pro.load(new FileInputStream(path));
        DRIVER = pro.getProperty("driver");
        URL = pro.getProperty("url");
        USERNAME = pro.getProperty("userName");
        PASSWORD = pro.getProperty("passWord");
    }
    public  static Connection getConn( ){
        try {
            if(conn==null){
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
