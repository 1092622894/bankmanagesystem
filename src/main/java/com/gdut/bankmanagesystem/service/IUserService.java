package com.gdut.bankmanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdut.bankmanagesystem.entity.Contacts;
import com.gdut.bankmanagesystem.entity.User;

/**
 * @author honzooban
 * @version 1.0.0
 * @Description
 * @createTime 2021年01月04日 16:29:00
 */
public interface IUserService extends IService<User> {

    /**
     * 用户登录
     * @param client 用户登录信息
     * @return 用户信息
     */
    User login(User client);

    /**
     * 登录时获取用户详细信息
     * @param user 用户登录信息
     * @return 用户详细信息
     */
    Object getUserMessage(User user);

    Long getBankId(Object userMessage);
}
