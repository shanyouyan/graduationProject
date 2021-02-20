package com.bbs.dao.impl;

import com.bbs.dao.UserDao;
import com.bbs.dao.utils.JDBCUtils;
import com.bbs.pojo.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    //登录业务操作
    public String findUserNameByNameAndPwd(User user) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String name = null;
        try {
            name = jt.queryForObject("select userName from user where userName = ? and userPassword = ?", String.class, user.getUserName(), user.getUserPassword());
        } catch (DataAccessException e) {

        }
        return name;
    }


    //注册业务操作
    @Override
    public int findUserByName(String userName,String userPassword,String userNum) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

        int len =jt.queryForObject("select count(*) from user where userName=?", Integer.class, userName);
        if (len > 0 ){
            return  len;
        }
        return len;
    }
    @Override
    public int saveUser(String userName,String userPassword,String userNum) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        return  jt.update("insert into user(userName,userPassword,userNum) values(?,?,?)",userName,userPassword,userNum);
    }

}
