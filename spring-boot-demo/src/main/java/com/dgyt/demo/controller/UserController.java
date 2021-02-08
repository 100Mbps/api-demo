package com.dgyt.demo.controller;

import com.dgyt.demo.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
        GET request to /api/users – 列出所有用户
        GET request to /api/users/1 – 列出ID为1的用户信息
        POST request to /api/users – 创建一个新用户
        PUT request to /api/users/1 – 更新ID为1的用户信息
        DELETE request to /api/users/1 – 删除ID为1的用户信息
*/


//@Controller
@RestController
@RequestMapping("api")
public class UserController {



    @RequestMapping(
            value="users",
            //headers = {"X-Forwarded-For=127.0.0.1"},
            method = RequestMethod.GET,
            consumes ={"text/plain", "application/*"} ,
            produces = {"application/json"}
    )
    public List<User> getUsers(){
        return new ArrayList<>();
    }
    @RequestMapping(
            value="users/{name}",
            method = RequestMethod.GET,
            consumes ={"text/plain", "application/*"} ,
            produces = {"application/json"}
    )
    public ResponseEntity<User> getUser(@PathVariable  String name){
        return new ResponseEntity<>(new User(name,12),HttpStatus.OK);
    }
}
