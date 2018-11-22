package com.yu.example.first_project.service;

import com.yu.example.first_project.vo.ResponseVO;
import com.yu.example.first_project.vo.UserVO;

public interface LoginService {
    ResponseVO login(UserVO userVO);
}
