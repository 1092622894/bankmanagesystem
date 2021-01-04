package com.gdut.bankmanagesystem.service;

import com.gdut.bankmanagesystem.entity.Client;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gdut.bankmanagesystem.entity.User;
import com.gdut.bankmanagesystem.entity.dto.RegisterDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
public interface IClientService extends IService<Client> {

    /**
     * 客户注册
     * @param registerDTO 客户注册信息
     * @param registerUser
     * @return 注册是否成功
     */
    Boolean register(RegisterDTO registerDTO, User registerUser);

}
