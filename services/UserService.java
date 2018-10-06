package com.njbdqn.mydemo888.services;

import com.njbdqn.mydemo888.dao.UserDao;
import com.njbdqn.mydemo888.db.SqlTemplate;
import com.njbdqn.mydemo888.vo.UserInfos;

import java.util.List;

public class UserService {
    UserDao ud = new UserDao();
    public void insert (UserInfos user){
       ud.insert(user);
    }
    public void delete(Integer userId){
       ud.delete(userId);
    }
    public void update(UserInfos user){
      ud.update(user);
    }
    public List<UserInfos> queryAll(){
       return ud.queryAll();
    }
    public UserInfos singleQuery(Integer userId){
        return ud.singleQuery(userId);
    }
}
