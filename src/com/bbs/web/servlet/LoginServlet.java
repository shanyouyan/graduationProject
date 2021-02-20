package com.bbs.web.servlet;

import com.bbs.pojo.User;
import com.bbs.service.UserService;
import com.bbs.service.impl.UserServiceImpl;
import com.bbs.web.utils.ResultInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet( "/login")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户输入信息
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        System.out.println("用户名是:" + userName);
        System.out.println("用户密码是：" + userPassword);
        UserService  service = new UserServiceImpl();
        Map<String, String[]> map = request.getParameterMap();
        User u = new User();
        try {
            BeanUtils.populate(u,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用登录的业务
        ResultInfo info = service.login(u);
        //设置session
        if (info.getFlag()){
            request.getSession().setAttribute("login_name", info.getData());
        }
        //响应
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), info);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
