package com.fy.backstage.user.controller;

import com.fy.backstage.user.entity.UserVO;
import com.fy.backstage.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 武豫
 * @create 2019-07-15 21:44
 * @desc
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("queryUserList")
    @ResponseBody
    public List<UserVO> queryUserList(){
        List<UserVO> list = userService.queryUserList();
        return list;
    }
}
