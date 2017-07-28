package com.bwei.swagger;

import com.bwei.bean.User;
import com.bwei.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 染熙 on 2017/7/19.
 */
@Service
public class UserService {
    @Autowired
    private UserRepos userRepos;
    /*
    添加
     */
    public void save(User user){
        userRepos.save(user);
    }
    /*
    删除
     */
    public void delete(Integer id){
        userRepos.delete(id);
    }
    /*
    查询所有
     */
    public List<User> findUser(){
        List<User> users = userRepos.findAll();
        return  users;
    }
    /*
    根据id获取
     */
    public User findUserById(Integer id){
        User one = userRepos.findOne(id);
        return one;
    }
    /*
    修改
     */
    public void update(User user){
        userRepos.save(user);
    }
}
