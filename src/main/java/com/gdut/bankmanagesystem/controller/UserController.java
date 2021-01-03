package com.gdut.bankmanagesystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdut.bankmanagesystem.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/get")
    public User get() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", "blue");
        return userMapper.selectOne(wrapper);
    }


}
