package com.dgyt.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping({"/"})
    public String index() {
        return "login";
    }

    @RequestMapping(value = "login")
    public String login(String userName, String passWord, Model model,String rememberMe) {
        //password = MD5Utils.encrypt(username, password);
        model.addAttribute("userName", userName);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if("rememberMe".equals(rememberMe)){
                token.setRememberMe(true);
            }
            return "redirect:/user";
        } catch (UnknownAccountException e) {
            model.addAttribute("message","invalid username and password.");
            return "error";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("message","invalid username and password.");
            return "error";
        } catch (LockedAccountException e) {
            model.addAttribute("message","user has been  disabled.");
            return "error";
        } catch (AuthenticationException e) {
            return "error";
        }
    }

    @RequestMapping("user")
    public String user(Model model){
        model.addAttribute("user",SecurityUtils.getSubject().getPrincipal());
        return "user";
    }
    @RequestMapping("logout")
    public String logout(Model model){
        model.addAttribute("user",SecurityUtils.getSubject().getPrincipal());
        return "logout";
    }
}
