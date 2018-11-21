package com.yu.example.first_project.dao;

import com.yu.example.first_project.vo.TicketVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TicketDao {
    void insertSelective(TicketVO ticketVO);
    TicketVO selectByTicket(String ticket);
    TicketVO selectByUserName(String userName);
    void updateTicket(TicketVO ticketVO);
}
