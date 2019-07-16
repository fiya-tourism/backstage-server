package com.fy.backstage.user.service;

import com.fy.backstage.user.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(value = "user-server")
public interface UserService {
    @RequestMapping(value="queryUserList",method = RequestMethod.GET)
    List<UserVO> queryUserList();



}
