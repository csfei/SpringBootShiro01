package com.cuisf.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping("logout")
    public String logout(){

        SecurityUtils.getSubject().logout();

        return "redirect:/login.jsp";
    }


    /**
      处理身份认证
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    public String login(String username ,String password){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);

            return "redirect:/index.jsp";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名称错误！！");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误！！");
        }

        return "redirect:/login.jsp";
    }
}
