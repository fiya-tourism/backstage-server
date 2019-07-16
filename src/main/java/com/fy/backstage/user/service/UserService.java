package com.fy.backstage.user.service;

import com.fy.backstage.commons.DataGridUtil;
import com.fy.backstage.commons.ResultVO;
import com.fy.backstage.user.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 武豫
 * @create 2019-07-15 21:44
 * @desc
 **/
@FeignClient(value = "USER-SERVER")
public interface UserService {
    @RequestMapping(value="user/queryUserList",method = RequestMethod.GET)
    DataGridUtil<UserVO> queryUserList();

    @RequestMapping(value="user/delete",method = RequestMethod.GET)
    void delete(@RequestParam("id") Integer id);
}
