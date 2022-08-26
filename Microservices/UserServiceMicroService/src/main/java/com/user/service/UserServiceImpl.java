package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    //fake user list

    List<User> list=List.of(
            new User(1311L,"Vinisha joshi","8602914383"),
            new User(1312L,"Akshita gupta","7499683715"),
            new User(1313L,"Abhishek shinde","9329445767"));
    @Override
    public User getUser(Long id) {
        return list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
    }
}
