package com.fy.backstage.user.controller;

import com.fy.backstage.commons.DataGridUtil;
import com.fy.backstage.commons.ResultVO;
import com.fy.backstage.user.entity.UserVO;
import com.fy.backstage.user.service.UserService;
import feign.Param;
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
        return "删除成功";
    }
}
