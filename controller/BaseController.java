package com.njbdqn.mydemo888.controller;

import sun.misc.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String url = request.getRequestURI();
        System.out.println("url:"+url);
        String className = url.substring(1,2).toUpperCase()+url.substring(2, url.lastIndexOf("/"))+"Controller";
        System.out.println("className:"+className);
        String methodName = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf(".do"));
        System.out.println("methodName:"+methodName);
        try {
            Class clazz=Class.forName("com.njbdqn.mydemo888.controller."+className);
            Object object = clazz.newInstance();
            Method method = clazz.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(object,request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
