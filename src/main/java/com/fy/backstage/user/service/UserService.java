package com.fy.backstage.user.service;

import com.fy.backstage.commons.DataGridUtil;
import com.fy.backstage.commons.ResultVO;
import com.fy.backstage.user.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
>>>>>>> Stashed changes

import java.util.List;

/**
<<<<<<< Updated upstream
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
=======
 * Created by 二哥 on 2019/7/15.
 */
@FeignClient(value = "user-server")
public interface UserService {
    @RequestMapping(value = "queryUserList",method = RequestMethod.GET)
    List<UserVO> queryUserList();
>>>>>>> Stashed changes
}
