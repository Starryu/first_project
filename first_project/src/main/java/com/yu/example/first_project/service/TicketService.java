package com.yu.example.first_project.service;

import com.yu.example.first_project.vo.ResponseVO;
import com.yu.example.first_project.vo.TicketVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public interface TicketService {
    /**
     * 根据查询ticket
     * @param ticket
     * @return
     */
    TicketVO selectTicket(String ticket);

    /**
     *
     * @param userName
     * @param expired
     */
    TicketVO addTicket(String userName, Date expired);

    /**
     * 判断ticket是否有效
     * @param ticket
     * @return
     */
    boolean isValid(String ticket);

    /**
     * 将ticket设置为失效
     * @param ticket
     */
    void inValidTicket(String ticket);

    /**
     * 将ticket添加到cookie
     * @param request
     * @param response
     * @param responseVO
     */
    void addTicketToCookie(HttpServletRequest request, HttpServletResponse response, ResponseVO responseVO);
}
