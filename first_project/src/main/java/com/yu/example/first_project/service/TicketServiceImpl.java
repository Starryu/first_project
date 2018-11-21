package com.yu.example.first_project.service;

import com.yu.example.first_project.dao.TicketDao;
import com.yu.example.first_project.util.UUIDUtil;
import com.yu.example.first_project.vo.TicketVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class TicketServiceImpl implements  TicketService {
    @Autowired
    private TicketDao ticketDao;
    @Override
    public TicketVO selectTicket(String ticket) {
        return ticketDao.selectByTicket(ticket);

    }

    @Override
    public void addTicket(String userName, Date expired) {
        TicketVO ticketVO = new TicketVO();
        ticketVO.setValid(true);
        ticketVO.setCreateTime(new Date());
        ticketVO.setExpired(expired);
        ticketVO.setName(userName);
        ticketVO.setTicket(UUIDUtil.uuid().replace("-",""));
        ticketDao.insertSelective(ticketVO);

    }

    @Override
    public boolean isValid(String ticket) {
        return ticketDao.selectByTicket(ticket).isValid();
    }

    @Override
    public void inValidTicket(String ticket) {
        TicketVO ticketVO = ticketDao.selectByTicket(ticket);
        ticketVO.setValid(false);
        ticketDao.updateTicket(ticketVO);

    }
}
