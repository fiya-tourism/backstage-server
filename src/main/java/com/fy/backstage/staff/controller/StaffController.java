package com.fy.backstage.staff.controller;


import com.fy.backstage.staff.domain.Staff;
import com.fy.backstage.staff.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Zy on 2019/7/13.
 */
@Controller
@RequestMapping("staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    //查询加
    @RequestMapping("getStaffList")
    @ResponseBody
    public List<Staff> getStaffList(){
        List<Staff> list = staffService.getStaffList();
        return list;
    }

    @RequestMapping("addStaff")
    @ResponseBody
        public String addStaff(Staff staff){
            return staffService.addStaff(staff);

        }
    //逻辑删除
    @RequestMapping("deleteUpdate")
    @ResponseBody
    public void deleteUpdate(Integer staffId) {
        staffService.deleteUpdate(staffId);
    }
    //修改回显
    @RequestMapping("updateStaffById")
    @ResponseBody
    public Staff updateStaffById(Integer staffId){
        return staffService.updateStaffById(staffId);
    }

    //去员工信息页修改
    @RequestMapping(value = "updateStaff")
    @ResponseBody
    public ModelAndView updateStaff(){
        ModelAndView mav = new ModelAndView("/backstage/staff/staffUpdate");
        return mav;
    }
    //修改ok
    @RequestMapping("updateStaffId")
    @ResponseBody
    public String updateStaffId(Staff staff){
        return staffService.updateStaffId(staff);
    }

    //去员工信息页新增
    @RequestMapping(value = "addStaff1")
    @ResponseBody
    public ModelAndView addStaff1(){
        ModelAndView mav = new ModelAndView("/backstage/staff/addStaff");
        return mav;
    }

//    //新增
//    @RequestMapping("addStaff")
//    @RequestBody
//    public void addStaff(Staff staff){
//        staffService.addStaff(staff);
//    }

}
