package com.gdut.bankmanagesystem.controller;

import com.alibaba.fastjson.JSON;
import com.gdut.bankmanagesystem.common.anno.JwtTokenIgnore;
import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.entity.User;
import com.gdut.bankmanagesystem.entity.dto.JwtTokenDTO;
import com.gdut.bankmanagesystem.entity.dto.RegisterDTO;
import com.gdut.bankmanagesystem.entity.vo.LoginVo;
import com.gdut.bankmanagesystem.service.IClientService;
import com.gdut.bankmanagesystem.service.IUserService;
import com.gdut.bankmanagesystem.utils.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author honzooban
 * @version 1.0.0
 * @Description
 * @createTime 2021年01月04日 17:01:00
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    final JwtUtil jwtUtil;
    final IUserService userService;
    final IClientService clientService;

    public UserController(IClientService clientService, JwtUtil jwtUtil, IUserService userService) {
        this.clientService = clientService;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    /**
     * 客户注册
     * @param registerDTO 注册信息
     * @return 响应结果(带有用户注册后的8位数账号)
     */
    @PostMapping("register")
    @JwtTokenIgnore
    public JSONResponse register(@RequestBody RegisterDTO registerDTO) {
        User registerUser = new User();
        Boolean result = clientService.register(registerDTO, registerUser);
        return result ? JSONResponse.success(registerUser) : JSONResponse.fail("注册失败，请重试");
    }

    /**
     * 用户登录
     * @param user 用户登录信息
     * @return 登录结果（成功后会发放token）
     */
    @PostMapping("login")
    @JwtTokenIgnore
    public JSONResponse login(@RequestBody User user) {
        User result = userService.login(user);
        String sign = jwtUtil.sign(JSON.toJSONString(new JwtTokenDTO(result.getId(), result.getRole())));
        Object userMessage = userService.getUserMessage(result);
        Long bankId = userService.getBankId(userMessage);
        return JSONResponse.success("登录成功", new LoginVo(sign, userMessage, bankId));
    }
}
