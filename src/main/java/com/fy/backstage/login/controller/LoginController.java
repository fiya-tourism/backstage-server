package com.fy.backstage.login.controller;

import com.fy.backstage.commons.ResultVo;
import com.fy.backstage.staff.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zy on 2019/7/18.
 */
@Controller
@RequestMapping("staffLogin")
public class LoginController {
    @Autowired
    private StaffService staffService;
    @RequestMapping(value = "getLoing",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getLoing(HttpServletRequest request,String staffName,String staffPass){
        ResultVo resultVo = staffService.getLoing(staffName,staffPass);
        return resultVo;
    }
}
