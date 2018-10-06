package com.njbdqn.mydemo888.dao;

import com.njbdqn.mydemo888.db.SqlTemplate;
import com.njbdqn.mydemo888.vo.UserInfos;

import java.util.List;

public class UserDao {
    public void insert (UserInfos user){
        String sql = "insert into userInfos (userName,birthday,userPhoto)values(?,?,?)  ";
        SqlTemplate.update(sql,user.getUserName(),user.getBirthday(),user.getUserPhoto());
    }
    public void delete(Integer userId){
        String sql = "delete from userInfos where userId = ?";
        SqlTemplate.update(sql,userId);
    }
    public void update(UserInfos user){
        String sql = "update userInfos set userName = ?,birthday = ?,userPhoto = ? where userId = ?";
        SqlTemplate.update(sql, user.getUserName(),user.getBirthday(),user.getUserPhoto(),user.getUserId());
    }
    public List<UserInfos> queryAll(){
        String sql = "select u.*,ifnull(b.money,0) money from userInfos u left join bankCards b on u.userId = b.userId";
        return SqlTemplate.queryAll(UserInfos.class,sql);
    }
    public UserInfos singleQuery(Integer userId){
        String sql = "select u.*,ifnull(b.money,0) money from userInfos u left join bankCards b on u.userId = b.userId where u.userId = ?";
        return (UserInfos)SqlTemplate.queryAll(UserInfos.class, sql, userId).get(0);
    }
}
