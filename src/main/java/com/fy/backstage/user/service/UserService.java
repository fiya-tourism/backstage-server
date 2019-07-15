package com.fy.backstage.user.service;

import com.fy.backstage.user.entity.UserVO;

import java.util.List;

/**
 * Created by 二哥 on 2019/7/15.
 */
public interface UserService {
    List<UserVO> queryUserList();
}
