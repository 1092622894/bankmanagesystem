package com.gdut.bankmanagesystem.utils;

import com.gdut.bankmanagesystem.common.Constants;
import com.gdut.bankmanagesystem.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * @author honzooban
 * @version 1.0.0
 * @Description 产生随机数的工具类
 * @createTime 2021年01月04日 11:16:00
 */
@Component
public class RandomUtil {

    private static final Integer UID_LENGTH = 8;

    /**
     * 用户获取随机生成的8位账号
     * @return 用户账号
     */
    public Integer generateUID() {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < UID_LENGTH; i++) {
            //首字母不能为0
            result += (random.nextInt(9) + 1);
        }
        return Integer.valueOf(result);
    }

}
