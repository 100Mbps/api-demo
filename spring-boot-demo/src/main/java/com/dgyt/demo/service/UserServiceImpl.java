package com.dgyt.demo.service;

import com.dgyt.demo.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService{

    private Map<String,Set<String>> roleSet = new HashMap<>();
    private Map<String,Set<String>> permisonSet = new HashMap<>();
    private Map<String,User> userMap = new HashMap<>();

    @PostConstruct
    public void init(){
        User zhangsan = new User();
        zhangsan.setAge(12);
        zhangsan.setPassWord("123456");
        zhangsan.setStatus("1");
        zhangsan.setUserName("zhangsan");
        userMap.put("zhangsan",zhangsan);
    }



    @Override
    public Set<String> getUserRolesSet(String name) {
        return null;
    }

    @Override
    public Set<String> getUserPermissionsSet(String username) {
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        return userMap.get(userName);
    }
}
