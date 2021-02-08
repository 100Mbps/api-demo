package com.dgyt.demo.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

   @RequestMapping({"/"})
   public String index(){
       return "index";
   }

   @RequestMapping("login")
   public String login(String name, String password, Model model){
       model.addAttribute("msg","");
       if(StringUtils.isBlank(name) || StringUtils.isBlank(password)){
           model.addAttribute("msg","username or password can not be null.");
           return "login";
       }
       else{
           model.addAttribute("name",name);
         return "user";
       }
   }



}
