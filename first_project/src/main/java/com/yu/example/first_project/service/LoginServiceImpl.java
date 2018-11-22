package com.yu.example.first_project.service;

import com.yu.example.first_project.dao.UserDao;
import com.yu.example.first_project.vo.ResponseVO;
import com.yu.example.first_project.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseVO login(UserVO userVO) {
        List<String> nameList = userDao.selectUserName();
        if(!nameList.contains(userVO.getUserName())){
            return ResponseVO.buildfailure("用户名错误");
        }
        UserVO userVOIndB = userDao.selectUser(userVO.getUserName());
        if(!(userVOIndB.getUserPassword() == userVO.getUserPassword())){
            return ResponseVO.buildfailure("密码错误");
        }
        return ResponseVO.buildSuccess(userVO);
    }
}
