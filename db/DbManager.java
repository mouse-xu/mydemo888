package com.njbdqn.mydemo888.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DbManager {
    private Connection conn=DbUtil.getConn();
    private PreparedStatement pstm;
    private ResultSet rs;
    public int update (String sql,Object...objects){
        int count = 0;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i =0;i<objects.length;i++){
                pstm.setObject(i+1, objects[i]);
            }
            count = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public ResultSet query(String sql,Object...objects){
        try {
            pstm = conn.prepareStatement(sql);
            for (int i =0;i<objects.length;i++){
                pstm.setObject(i+1, objects[i]);
            }
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}

