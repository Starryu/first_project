package com.yu.example.first_project.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieUtil {
    public static final String LOGIN_TICKET="ticket";

    /**
     * 添加cookie
     * @param cookiesName
     * @param cookiesValue
     * @param days
     * @param httpServletResponse
     * @param httpServletRequest
     */
    public static void addCookies(String cookiesName, String cookiesValue, Integer days, HttpServletResponse httpServletResponse,
                                  HttpServletRequest httpServletRequest){
        try {
            //新建cookie，注意设置编码
            Cookie cookie =new Cookie(cookiesName, URLEncoder.encode(cookiesValue,"utf-8"));
            //设置路径
            cookie.setPath(httpServletRequest.getContextPath());
            //设置cookie有效期
            if(days == null)
                days=14;
            cookie.setMaxAge(days*24*60*60);
            //将cookie添加到响应头
            httpServletResponse.addCookie(cookie);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取cookie
     * @param httpServletRequest
     * @param cookiesName
     * @return
     */
    public static  String getCookies(HttpServletRequest httpServletRequest, String cookiesName){
        String value = "";
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies!=null&&cookies.length>0){
            for (int i = 0; i <cookies.length ; i++) {
                Cookie cookie =cookies[i];
                if(cookiesName.equals(cookie.getName())){
                    try {
                        value=URLDecoder.decode(cookie.getValue(),"utf-8");

                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return value;
    }

    /**
     * 删除cookie
     * @param name
     * @param httpServletRequest
     * @param httpServletResponse
     */
    public static void deleteCookies(String name, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Cookie cookie =new Cookie(name,"");
        cookie.setMaxAge(-1);
        cookie.setPath(httpServletRequest.getContextPath());
        httpServletResponse.addCookie(cookie);
    }


}
