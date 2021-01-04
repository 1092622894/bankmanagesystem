package com.gdut.bankmanagesystem.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gdut.bankmanagesystem.common.Constants;
import com.gdut.bankmanagesystem.common.anno.JwtTokenIgnore;
import com.gdut.bankmanagesystem.common.anno.Role;
import com.gdut.bankmanagesystem.entity.Client;
import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.entity.User;
import com.gdut.bankmanagesystem.entity.dto.JwtTokenDTO;
import com.gdut.bankmanagesystem.entity.dto.RegisterDTO;
import com.gdut.bankmanagesystem.service.IClientService;
import com.gdut.bankmanagesystem.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
@RestController
@RequestMapping("client")
public class ClientController {

    final JwtUtil jwtUtil;
    final IClientService clientService;

    public ClientController(IClientService clientService, JwtUtil jwtUtil) {
        this.clientService = clientService;
        this.jwtUtil = jwtUtil;
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
        User result = clientService.login(user);
        String sign = jwtUtil.sign(JSON.toJSONString(new JwtTokenDTO(result.getId(), result.getRole())));
        return JSONResponse.success(sign);
    }

}
