package com.fy.backstage.user.controller;

import com.fy.backstage.user.entity.UserVO;
import com.fy.backstage.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 武豫
 * @create 2019-07-15 21:44
 * @desc
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("queryUserList")
    @ResponseBody
    public DataGridUtil<UserVO> queryUserList(){
        return  userService.queryUserList();
    }


    @RequestMapping("delete")
    @ResponseBody
    public String delete(Integer id){
         userService.delete(id);
         //test
        return "删除成功";
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(UserVO userVO){
        return userService.add(userVO);
    }

}
