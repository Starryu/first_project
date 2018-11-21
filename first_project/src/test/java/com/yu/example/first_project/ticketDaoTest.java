package com.yu.example.first_project;

import com.alibaba.fastjson.JSONObject;
import com.yu.example.first_project.dao.TicketDao;
import com.yu.example.first_project.util.DateUtil;
import com.yu.example.first_project.vo.TicketVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ticketDaoTest {
    @Autowired
    private TicketDao ticketDao;

    @Test
    public void insert(){
        TicketVO ticketVO = new TicketVO();
        ticketVO.setName("yu");
        ticketVO.setTicket("123");
        ticketVO.setExpired(DateUtil.addMonth(new Date(),1));
        ticketVO.setCreateTime(new Date());
        ticketVO.setValid(true);
        ticketDao.insertSelective(ticketVO);
    }

    @Test
    public void selectByTicketTest(){
        System.out.println(JSONObject.toJSONString(ticketDao.selectByTicket("123")));
    }

    @Test
    public void selectByUserNameTest(){
        System.out.println(JSONObject.toJSONString(ticketDao.selectByUserName("yu")));
    }

    @Test
    public void updateTicketTest(){
        TicketVO ticketVO = new TicketVO();
        ticketVO.setTicket("123");
        ticketVO.setValid(false);
        ticketDao.updateTicket(ticketVO);
    }

}
