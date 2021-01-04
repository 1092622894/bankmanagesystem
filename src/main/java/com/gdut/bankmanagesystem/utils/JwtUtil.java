package com.gdut.bankmanagesystem.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author honzooban
 * @version 1.0.0
 * @ClassName JwtUtil.java
 * @Description
 * @createTime 2021年01月03日 19:57:00
 */

@Component
public class JwtUtil {

    /**
     * EXPIRE_TIME 过期时间
     * PRIVATE_SECRET 密钥
     */
    private static final long EXPIRE_TIME = 5 * 60 * 1000;
    private static final String PRIVATE_SECRET = "216yyds";

    /**
     * 生成签名
     * @param message 信息
     * @return 签名
     */
    public String sign(String message) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(PRIVATE_SECRET);
        return JWT.create()
                .withAudience(message)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 检查token合法性
     * @param token token
     * @return token是否合法
     */
    public boolean checkSign(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(PRIVATE_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            throw new RuntimeException("token无效，请重新获取");
        }
    }

    /**
     * 将token载荷中的数据转换到具体的对象中
     * @param token token
     * @param object 指定的对象
     * @param <T> 指定对象的类型
     * @return 附带数据的指定对象
     */
    public <T> T getMessage(String token, T object) {
        String message = JWT.decode(token).getAudience().get(0);
        return (T) JSON.parseObject(message, object.getClass());
    }

}
