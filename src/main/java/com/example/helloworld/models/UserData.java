package com.example.helloworld.models;

import java.util.Base64;

public class UserData {

    private String email;
    private String id;
    private String encodedJWT;
    private String decodedJWT;

    public UserData(String email, String id, String jwt) {
        this.email = email;
        this.id = id;
        this.encodedJWT = jwt;
        this.decodedJWT = decodeJWT(jwt);
    }
    
    private String decodeJWT(String jwt){
      String[] token = jwt.split("\\.");
      byte[] payload = Base64.getDecoder().decode(token[1]);
      return new String(payload);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getEncodedJWT() {
        return encodedJWT;
    }

    public String getDecodedJWT() {
        return decodedJWT;
    }

    public void setJwt(String jwt) {
        this.encodedJWT = jwt;
        this.decodedJWT = decodeJWT(jwt);
    }

}
 
