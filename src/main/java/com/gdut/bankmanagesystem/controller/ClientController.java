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


}
