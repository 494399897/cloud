package com.more.cloud;

import com.more.cloud.conf.JWTUtil;

public class Main {
    public static void main(String[] args) {
        // 生成Token
        String token = JWTUtil.token("itbaizhan");
        System.out.println(token);
//验证Token
        boolean verify = JWTUtil.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJpc3N1ZXIiLCJleHAiOjE2NTY5MjQxMjEsImlhdCI6MTY1NjkyMzgyMSwidXNlcm5hbWUiOiJpdGJhaXpoYW4ifQ.Cs-xEh9dXkZr9mN2xqD-Jha2lRkWGa-Yc6ixSCZkzgw");
        System.out.println(verify);
    }
}
