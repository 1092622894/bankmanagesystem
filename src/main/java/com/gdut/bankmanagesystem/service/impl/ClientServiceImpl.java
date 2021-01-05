package com.gdut.bankmanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gdut.bankmanagesystem.common.Constants;
import com.gdut.bankmanagesystem.entity.Account;
import com.gdut.bankmanagesystem.entity.Client;
import com.gdut.bankmanagesystem.entity.Contacts;
import com.gdut.bankmanagesystem.entity.User;
import com.gdut.bankmanagesystem.entity.dto.RegisterDTO;
import com.gdut.bankmanagesystem.entity.dto.UpdateClientDTO;
import com.gdut.bankmanagesystem.entity.vo.ListClientVO;
import com.gdut.bankmanagesystem.mapper.AccountMapper;
import com.gdut.bankmanagesystem.mapper.ClientMapper;
import com.gdut.bankmanagesystem.mapper.ContactsMapper;
import com.gdut.bankmanagesystem.mapper.UserMapper;
import com.gdut.bankmanagesystem.service.IClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdut.bankmanagesystem.utils.RandomUtil;
import com.gdut.bankmanagesystem.utils.SnowFlakeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

    @Resource
    UserMapper userMapper;
    @Resource
    ClientMapper clientMapper;
    @Resource
    ContactsMapper contactsMapper;
    @Resource
    AccountMapper accountMapper;

    final SnowFlakeUtil snowFlakeUtil;
    final RandomUtil randomUtil;

    public ClientServiceImpl(RandomUtil randomUtil, SnowFlakeUtil snowFlakeUtil) {
        this.randomUtil = randomUtil;
        this.snowFlakeUtil = snowFlakeUtil;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(RegisterDTO registerDTO, User registerUser) {
        // 为客户和联系人生成唯一id，并连接起来
        registerDTO.getClient().setId(snowFlakeUtil.getNextSnowFlakeId());
        registerDTO.getContacts().setId(snowFlakeUtil.getNextSnowFlakeId());
        registerDTO.getClient().setCId(registerDTO.getContacts().getId());
        // 对密码进行散列处理
        registerDTO.setPassword(new String(DigestUtils.md5Digest(registerDTO.getPassword().getBytes())));
        // 执行client表和contact表的插入操作
        Assert.isTrue(Constants.INSERT_SUCCESS.equals(contactsMapper.insert(registerDTO.getContacts()))
                && Constants.INSERT_SUCCESS.equals(clientMapper.insert(registerDTO.getClient())), "注册失败，请重试");
        // 循环查重，直至在用户表中找不到同样的uid即可
        while (true) {
            Integer uid = randomUtil.generateUID();
            if (userMapper.selectById(uid) == null) {
                registerUser.setId(uid);
                return Constants.INSERT_SUCCESS.equals(userMapper.insert(new User(uid,
                        registerDTO.getPassword(), Integer.valueOf(Constants.CLIENT_ROLE),
                        registerDTO.getClient().getId(), null, null)));
            }
        }
    }

    @Override
    public Boolean deleteClientById(Integer id) {
        return Constants.DELETE_SUCCESS.equals(userMapper.deleteById(id));
    }

    @Override
    public Boolean updateClientAndContacts(UpdateClientDTO updateClientDTO) {
        UpdateWrapper<Client> clientUpdateWrapper = new UpdateWrapper<>();
        clientUpdateWrapper.eq("id", updateClientDTO.getId());
        clientMapper.update(new Client(updateClientDTO.getId(),
                updateClientDTO.getName(), updateClientDTO.getPhone(),
                updateClientDTO.getAddress(), updateClientDTO.getIdentifyCard(),
                updateClientDTO.getContactId()), clientUpdateWrapper);
        UpdateWrapper<Contacts> contactsUpdateWrapper = new UpdateWrapper<>();
        clientUpdateWrapper.eq("id", updateClientDTO.getContactId());
        contactsMapper.update(new Contacts(updateClientDTO.getContactId(),
                updateClientDTO.getContactName(), updateClientDTO.getContactPhone(),
                updateClientDTO.getContactEmail(), updateClientDTO.getContactRelation()),
                contactsUpdateWrapper);
        return true;
    }

    @Override
    public List<ListClientVO> listClientByBankId(Long bankId) {
        List<ListClientVO> result = new ArrayList<>();
        HashMap<String, Object> selectMap = new HashMap<>(1);
        selectMap.put("b_id", bankId);
        HashSet set = new HashSet();
        List<Account> accounts = accountMapper.selectByMap(selectMap);
        for (Account account : accounts) {
            if (set.contains(account.getCId())) {
                continue;
            }
            set.add(account.getCId());
            Client client = clientMapper.selectById(account.getCId());
            Contacts contacts = contactsMapper.selectById(client.getCId());
            result.add(new ListClientVO(client.getId(), client.getName(), client.getPhone(),
                    client.getAddress(), client.getIdentifyCard(), client.getCId(), contacts.getName(),
                    contacts.getPhone(), contacts.getEmail(), contacts.getRelation()));
        }
        return result;
    }

}
