package com.more.cloud.conf;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JWTUtil {
    // 秘钥
    public static final String SECRET_KEY = "erbadagang-123456";
    // token过期时间
    public static final long TOKEN_EXPIRE_TIME = 5 * 60 * 1000;
    // 签发人
    private static final String ISSUER = "issuer";
    // 用户名
    private static final String USER_NAME = "username";

    public static String token(String userName) {
        Date now = new Date();
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        String token = JWT.create().withIssuedAt(now).withIssuer(ISSUER)
            .withExpiresAt(new Date(now.getTime() + TOKEN_EXPIRE_TIME))
            .withClaim(USER_NAME, userName).sign(algorithm);
        log.info("jwt generated user={}", userName);
        return token;
    }

    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
