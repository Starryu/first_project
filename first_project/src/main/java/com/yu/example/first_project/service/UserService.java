package com.yu.example.first_project.service;


import com.yu.example.first_project.vo.ResponseVO;
import com.yu.example.first_project.vo.UserVO;



public interface UserService {
    /**
     * 添加用户
     * @param userVO
     */
    ResponseVO addUser(UserVO userVO);

    /**
     * 删除用户
     * @param userId
     */
    ResponseVO deleteUser(String userName);

    /**
     * 更新用户
     * @param userVO
     */
    ResponseVO updateUser(UserVO userVO);

    /**
     * 查询用户
     * @param userName
     * @return
     */
    ResponseVO selectUser(String userName);

}
