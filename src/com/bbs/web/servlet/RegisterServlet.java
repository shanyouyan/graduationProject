package com.bbs.web.servlet;

import com.bbs.service.UserService;
import com.bbs.service.impl.UserServiceImpl;
import com.bbs.web.utils.ResultInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/register")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取用户注册信息
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userNum = request.getParameter("userNum");

        //调用注册业务
        ResultInfo info = service.register(userName,userPassword,userNum);
        //响应
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
