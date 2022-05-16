package com.example.helloworld.helper;

import java.util.Base64;

public class JwtHelper {

    public static String decodeBase64toString(String jwt){
        String[] token = jwt.split("\\.");
        byte[] payload = Base64.getDecoder().decode(token[1]);
        return new String(payload);
    }
    
}
