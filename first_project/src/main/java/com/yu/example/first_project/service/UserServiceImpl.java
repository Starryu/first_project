package com.yu.example.first_project.service;


import com.yu.example.first_project.dao.UserDao;
import com.yu.example.first_project.vo.ResponseVO;
import com.yu.example.first_project.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseVO addUser(UserVO userVO) {
        List<String> nameList = userDao.selectUserName();
        if(nameList.contains(userVO.getUserName())){
            return ResponseVO.buildfailure("用户名已存在");
        }
        userDao.addUser(userVO);
        return ResponseVO.buildSuccess("添加用户成功");
    }

    @Override
    public ResponseVO deleteUser(String userName) {
        userDao.deleteUser(userName);
        return ResponseVO.buildSuccess("删除用户成功");
    }

    @Override
    public ResponseVO updateUser(UserVO userVO) {
        List<String> nameList = userDao.selectUserName();
        if(!nameList.contains(userVO.getUserName())){
            return ResponseVO.buildfailure("用户不存在");
        }
        userDao.updateUser(userVO);
        return ResponseVO.buildSuccess("更新成功");
    }

    @Override
    public ResponseVO selectUser(String userName) {
        List<String> nameList = userDao.selectUserName();
        if(!nameList.contains(userName)){
            return ResponseVO.buildfailure("用户不存在");
        }
        return ResponseVO.buildSuccess(userDao.selectUser(userName));
    }
}
