package com.fy.backstage.user.controller;

import com.fy.backstage.commons.CommonIOUtils;
import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.user.entity.UserVO;
import com.fy.backstage.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    public DataGrid<UserVO> queryUserList(PageUtils page){
        return  userService.queryUserList(page);
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

    @RequestMapping("toAdd")
    @ResponseBody
    public ModelAndView toAdd(){
        ModelAndView mav = new ModelAndView("/backstage/user/userAdd");
        return mav;
    }


    @RequestMapping("toUpdate1")
    @ResponseBody
    public ModelAndView toUpdate1(){
        ModelAndView mav = new ModelAndView("/backstage/user/userUpdate");
        return mav;
    }


    @RequestMapping("toUpdate")
    @ResponseBody
    public String toUpdate(Integer userId){
        return userService.toUpdate(userId);
    }

    @RequestMapping("updateInfo")
    @ResponseBody
    public String updateInfo(UserVO userVO){
        return userService.updateInfo(userVO);
    }


 /*   @RequestMapping("uploadFileInfo")
    @ResponseBody
    public String uploadFileInfo(MultipartFile upfile, HttpServletRequest req){
        String path = CommonIOUtils.uploadFile("D://1810img",req , upfile);
        return path;
    }*/



}
