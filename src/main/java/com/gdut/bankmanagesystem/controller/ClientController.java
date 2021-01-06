package com.gdut.bankmanagesystem.controller;


import com.alibaba.fastjson.JSON;
import com.gdut.bankmanagesystem.common.Constants;
import com.gdut.bankmanagesystem.common.anno.JwtTokenIgnore;
import com.gdut.bankmanagesystem.common.anno.Role;
import com.gdut.bankmanagesystem.entity.Client;
import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.entity.User;
import com.gdut.bankmanagesystem.entity.dto.JwtTokenDTO;
import com.gdut.bankmanagesystem.entity.dto.RegisterDTO;
import com.gdut.bankmanagesystem.entity.dto.UpdateClientDTO;
import com.gdut.bankmanagesystem.entity.vo.ListClientVO;
import com.gdut.bankmanagesystem.entity.vo.LoginVo;
import com.gdut.bankmanagesystem.service.IClientService;
import com.gdut.bankmanagesystem.service.IUserService;
import com.gdut.bankmanagesystem.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/api/client")
public class ClientController {

    final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * 获取客户信息列表
     * @return
     */
    @GetMapping("/list/{bankId}")
    @Role(value = Constants.EMPLOYEE_ROLE)
    public JSONResponse listClient(@PathVariable Long bankId) {
        List<ListClientVO> result = clientService.listClientByBankId(bankId);
        return JSONResponse.success("获取客户列表成功", result);
    }

    /**
     * 删除客户信息
     * @param id 客户的用户id
     * @return 响应删除结果
     */
    @GetMapping("/delete/{id}")
    @Role(value = Constants.EMPLOYEE_ROLE)
    public JSONResponse deleteClient(@PathVariable("id") Long id) {
        Boolean result = clientService.deleteClientById(id);
        return result ? JSONResponse.success("删除成功") : JSONResponse.fail("删除失败，请重试");
    }

    /**
     * 修改客户及联系人信息
     * @param updateClientDTO 客户信息和联系人信息
     * @return 响应修改结果
     */
    @PostMapping("/update")
    @Role(value = Constants.EMPLOYEE_ROLE)
    public JSONResponse updateClient(@RequestBody UpdateClientDTO updateClientDTO) {
        Boolean result = clientService.updateClientAndContacts(updateClientDTO);
        return result ? JSONResponse.success("修改成功") : JSONResponse.fail("修改失败，请重试");
    }


}
