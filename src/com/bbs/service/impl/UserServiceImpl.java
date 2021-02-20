package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.dao.impl.UserDaoImpl;
import com.bbs.pojo.User;
import com.bbs.service.UserService;
import com.bbs.web.utils.ResultInfo;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    /**
     * 用户登录
     * @param
     * @return
     */
    @Override
    public ResultInfo login(User user) {
        //处理用户登录
        String name = dao.findUserNameByNameAndPwd(user);
        ResultInfo info = new ResultInfo();
        if (name == null){
            info.setFlag(false);
            info.setMsg("用户名或者密码错误！");
        }else {
            info.setFlag(true);
            info.setData(name);
        }
        return info;
    }

    /**
     *用户注册
     * @param
     * @return
     */
    @Override
    public ResultInfo register(String userName,String userPassword,String userNum) {
        UserDao dao = new UserDaoImpl();
        ResultInfo info = new ResultInfo();
        int count = dao.findUserByName(userName,userPassword,userNum);
        if (count > 0){
            //查询到重复用户
            info.setFlag(false);
            info.setData(count);
            info.setMsg("用户名已存在！");
        }else {
            //没有查询到用户，保存添加用户
            int len =  dao.saveUser(userName,userPassword,userNum);
            if (len > 0 ){
                info.setFlag(true);
            }else {
                info.setFlag(false);
                info.setMsg("对不起，注册失败，请联系管理员！");
            }
        }
        return info;
    }

}
