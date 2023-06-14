package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private String uid;
    private String pw;
    private String root="普通用户";
    public Users(String uid,String pw){
        this.uid = uid;
        this.pw = pw;
    }
}
