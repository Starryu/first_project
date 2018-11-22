package com.yu.example.first_project.controller;

import com.yu.example.first_project.service.LoginService;
import com.yu.example.first_project.service.TicketService;
import com.yu.example.first_project.vo.ResponseVO;
import com.yu.example.first_project.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseVO login(@RequestBody UserVO userVO, HttpServletRequest request, HttpServletResponse response){
        ResponseVO responseVO = loginService.login(userVO);
        ticketService.addTicketToCookie(request,response,responseVO);
        return responseVO;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public ResponseVO logout(HttpServletRequest request){
        return null;
    }

}
