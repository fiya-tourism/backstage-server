package com.fy.backstage.user.service;

import com.fy.backstage.commons.DataGrid;
import com.fy.backstage.commons.PageUtils;
import com.fy.backstage.user.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 武豫
 * @create 2019-07-15 21:44
 * @desc
 **/
@FeignClient(value = "USER-SERVER")
public interface UserService {
    @RequestMapping(value="user/queryUserList",method = RequestMethod.GET)
    DataGrid<UserVO> queryUserList(@RequestBody PageUtils page);

    @RequestMapping(value="user/delete",method = RequestMethod.GET)
    void delete(@RequestParam("id") Integer id);

    @RequestMapping(value="user/add",method = RequestMethod.POST)
    String add(@RequestBody UserVO userVO);

    @RequestMapping(value="user/toUpdate",method = RequestMethod.POST)
    String toUpdate(@RequestParam("userId")Integer userId);


    @RequestMapping(value="user/updateInfo",method = RequestMethod.POST)
    String updateInfo(@RequestBody UserVO userVO);
}
