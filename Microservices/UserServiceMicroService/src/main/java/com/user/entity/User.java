package com.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Long userId;
    private String name;
    private String phone;

    List<Contact> contact=new ArrayList<>();

    public User(Long userId,String name, String phone){
        this.userId=userId;
        this.name=name;
        this.phone=phone;
    }
}
