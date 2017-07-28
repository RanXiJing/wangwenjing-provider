package com.bwei.service.imp;

import com.bwei.bean.User;
import com.bwei.repository.UserRepos;
import com.bwei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 染熙 on 2017/7/28.
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepos userRepos;

    @Override
    public int findUserByUsername(String username){
        User user = userRepos.findUserByUsername(username);
        if(user!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public List<User> loginUser(String username, String password) {
        return userRepos.loginUser(username,password);
    }
}
