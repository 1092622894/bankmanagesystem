package com.gdut.bankmanagesystem.service;

import com.gdut.bankmanagesystem.entity.Client;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gdut.bankmanagesystem.entity.User;
import com.gdut.bankmanagesystem.entity.dto.RegisterDTO;
import com.gdut.bankmanagesystem.entity.dto.UpdateClientDTO;
import com.gdut.bankmanagesystem.entity.vo.ListClientVO;

import java.util.List;

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
     * @param registerUser 存放某些用户信息
     * @return 注册是否成功
     */
    Boolean register(RegisterDTO registerDTO, User registerUser);

    /**
     * 通过用户id删除客户信息
     * @param id 用户id
     * @return 删除是否成功
     */
    Boolean deleteClientById(Long id);

    /**
     * 修改客户信息及联系人信息
     * @param updateClientDTO 修改信息
     * @return 修改是否成功
     */
    Boolean updateClientAndContacts(UpdateClientDTO updateClientDTO);

    /**
     * 获取客户信息列表
     * @param bankId 支行id
     * @return 客户信息列表
     */
    List<ListClientVO> listClientByBankId(Long bankId);
}
