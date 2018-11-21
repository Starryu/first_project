package com.yu.example.first_project.service;

import com.yu.example.first_project.vo.ResponseVO;
import com.yu.example.first_project.vo.TicketVO;

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
    void addTicket(String userName, Date expired);

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
}
