package com.more.cloud.control;


import com.more.cloud.utils.AuthResult;
import com.more.cloud.utils.JWTUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("/login")
    public AuthResult login(String userName,String password){
        if ("admin".equals(userName)&&"admin".equals(password)){
            String token = JWTUtil.token("admin");
            return new AuthResult(0,"success",token);
        }else {
            return new AuthResult(1001,"username or password error");
        }

    }
}
