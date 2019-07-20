package com.fy.backstage.staff.service;
import com.fy.backstage.commons.ResultVo;
import com.fy.backstage.staff.domain.Staff;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Zy on 2019/7/15.
 */
@FeignClient(value = "staff-server")
public interface StaffService {
    @RequestMapping(value = "staff/getStaffList",method = RequestMethod.GET)
    List<Staff> getStaffList();

    //逻辑删除
    @RequestMapping(value = "staff/deleteUpdate",method = RequestMethod.GET)
    void deleteUpdate(@RequestParam("staffId") Integer staffId);

    //修改回显
    @RequestMapping(value = "staff/updateStaffById",method = RequestMethod.GET)
    Staff updateStaffById(@RequestParam("staffId") Integer staffId);
    //修改成功
    @RequestMapping(value = "staff/updateStaffId",method = RequestMethod.POST)
    String updateStaffId(@RequestBody Staff staff);
    //新增
    @RequestMapping(value = "staff/addStaff",method = RequestMethod.POST)
    String addStaff(@RequestBody Staff staff);
    //登陆
    @RequestMapping(value = "staffLogin/getLoing",method = RequestMethod.GET)
    ResultVo getLoing(@RequestParam("staffName") String staffName, @RequestParam("staffPass") String staffPass);


}

