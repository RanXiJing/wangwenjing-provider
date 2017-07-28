package com.bwei.service;

import com.bwei.bean.User;

import java.util.List;

/**
 * Created by 染熙 on 2017/7/28.
 */
public interface UserService {
    int findUserByUsername(String username);
    List<User> loginUser(String username, String password);
}
