package com.yu.example.first_project.service;

import com.yu.example.first_project.dao.TicketDao;
import com.yu.example.first_project.util.CookieUtil;
import com.yu.example.first_project.util.DateUtil;
import com.yu.example.first_project.util.UUIDUtil;
import com.yu.example.first_project.vo.ResponseVO;
import com.yu.example.first_project.vo.TicketVO;
import com.yu.example.first_project.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
@Service
public class TicketServiceImpl implements  TicketService {
    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private TicketService ticketService;

    @Override
    public TicketVO selectTicket(String ticket) {
        return ticketDao.selectByTicket(ticket);

    }

    @Override
    public TicketVO addTicket(String userName, Date expired) {
        TicketVO ticketVO = new TicketVO();
        ticketVO.setValid(true);
        ticketVO.setCreateTime(new Date());
        ticketVO.setExpired(expired);
        ticketVO.setName(userName);
        ticketVO.setTicket(UUIDUtil.uuid().replace("-",""));
        ticketDao.insertSelective(ticketVO);
        return ticketVO;

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

    @Override
    public void addTicketToCookie(HttpServletRequest request, HttpServletResponse response, ResponseVO responseVO) {
        UserVO userVO =(UserVO) responseVO.getContent();
        TicketVO ticketVO = ticketService.addTicket(userVO.getUserName(), DateUtil.addMonth(new Date(),3));
        CookieUtil.addCookies(CookieUtil.LOGIN_TICKET,ticketVO.getTicket(),90,response,request);
    }
}
