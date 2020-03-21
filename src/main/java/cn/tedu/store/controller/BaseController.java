package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author hp
 * @Date 2020/3/21 23:34
 * @Version 1.0
 */
abstract class BaseController {
    /**
     * 响应正确时使用的状态码
     */
    public static final Integer OK = 2000;

    /**
     * 从session中获取当前登录的用户的id
     * @param session  HttpSession对象
     * @return  当前登录的用户id
     */
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 从session中获取当前登录的用户的id
     * @param session  HttpSession对象
     * @return  当前登录的用户名
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();

    }
}