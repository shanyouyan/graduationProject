package com.bbs.dao;

import com.bbs.pojo.User;

public interface UserDao {
    /**
     * 查询用户名和密码
     * 登录业务操作
     * @param
     * @param
     * @return  返回记录条数
     */
    String findUserNameByNameAndPwd(User user);


    /**
     * 根据用户名查找用户
     * 注册业务操作
     * @param
     * @return
     */
    int findUserByName(String userName,String userPassword,String userNum);


    /**
     * 保存注册用户
     * 注册业务操作
     * @param
     * @return
     */
    int saveUser(String userName,String userPassword,String userNum);
}
