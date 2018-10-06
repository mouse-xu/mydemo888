package com.njbdqn.mydemo888.controller;

import com.njbdqn.mydemo888.services.UserService;
import com.njbdqn.mydemo888.vo.UserInfos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserController {
    public  void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService us = new UserService();
        request.setAttribute("all",us.queryAll() );
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    public  void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String birthdayStr = request.getParameter("birthday");
        String userPhoto = request.getParameter("userPhoto");
        Date birthday = null;
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = formater.parse(birthdayStr );
        } catch (ParseException e) {
            System.out.println("insert方法中birthday转换失败,birthdayStr:"+birthdayStr);
        }
        UserInfos user = new UserInfos(userName,birthday,userPhoto);
        UserService us = new UserService();
        us.insert(user);
        response.sendRedirect("init.do");
    }
    public  void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userIdStr = request.getParameter("userId");
        String userName = request.getParameter("userName");
        String birthdayStr = request.getParameter("birthday");
        String userPhoto = request.getParameter("userPhoto");
        Integer userId = null;
        try {
            userId = Integer.valueOf(userIdStr);
        } catch (NumberFormatException e) {
            System.out.println("update方法中userId转换失败,userIdStr:"+userIdStr);
        }
        Date birthday = null;
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = formater.parse(birthdayStr );
        } catch (ParseException e) {
            System.out.println("update方法中birthday转换失败,birthdayStr:"+birthdayStr);
        }
        UserInfos user = new UserInfos(userId,userName,birthday,userPhoto);
        UserService us = new UserService();
        us.update(user);
        response.sendRedirect("init.do");
    }
    public  void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userIdStr = request.getParameter("userId");
        Integer userId = null;
        try {
            userId = Integer.valueOf(userIdStr);
        } catch (NumberFormatException e) {
            System.out.println("delete方法中userId转换失败,userIdStr:"+userIdStr);
        }
        UserService us = new UserService();
        us.delete(userId);
        response.sendRedirect("init.do");
    }
    public  void single(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr = request.getParameter("userId");
        Integer userId = null;
        try {
            userId = Integer.valueOf(userIdStr);
        } catch (NumberFormatException e) {
            System.out.println("update方法中userId转换失败,userIdStr:"+userIdStr);
        }
        UserService us = new UserService();
        request.setAttribute("one",us.singleQuery(userId) );
        request.getRequestDispatcher("/update.jsp").forward(request,response );
    }
}
