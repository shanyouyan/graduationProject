package com.bbs.service;

import com.bbs.pojo.User;
import com.bbs.web.utils.ResultInfo;

public interface UserService {
    /**
     * 处理登录业务操作
     * @param
     * @param
     * @return
     */
    ResultInfo login(User user);
    /**
     * 处理注册业务操作
     * @param
     * @param
     * @return
     */
    ResultInfo register(String userName,String userPassword,String userNum);
}
