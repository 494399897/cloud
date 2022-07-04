package com.more.cloud.utils;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class AuthResult {
    private int code;
    private String msg;
    private String token;

    public AuthResult(int i, String s) {
        this.code = i;
        this.msg = s;
    }

    public AuthResult(int i, String success, String token) {
        this.code = i;
        this.msg = success;
        this.token = token;
    }
}

