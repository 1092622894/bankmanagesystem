package com.gdut.bankmanagesystem.service.impl;

import com.gdut.bankmanagesystem.entity.Client;
import com.gdut.bankmanagesystem.Test.mapper.ClientMapper;
import com.gdut.bankmanagesystem.service.IClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements IClientService {

}
